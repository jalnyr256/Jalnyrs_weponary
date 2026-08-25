package net.jalnyr.jalnyrsweaponary.entity.custom;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.entity.ai.EliteKnightAttackGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.checkerframework.checker.units.qual.A;

import javax.annotation.Nullable;
import java.security.cert.CertPathBuilder;

import static net.jalnyr.jalnyrsweaponary.Config.entityDamageMultiplier;

public class EliteKnightEntity extends Monster{
    public AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attack2AnimationState = new AnimationState();
    public AnimationState attack3AnimationState = new AnimationState();
    public int attackDamageModifier = 8;
    private int attackDelay = 40;
    private int ticksUntilNextAttack = 80;

    public EliteKnightEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new EliteKnightAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D, 80));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SnowGolem.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    public static AttributeSupplier.Builder CreateAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.ATTACK_DAMAGE, 8D)
                .add(Attributes.MAX_HEALTH, 100D)
                .add(Attributes.ARMOR, 12)
                .add(Attributes.ATTACK_SPEED, 0.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.05);
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }


    public AnimationState getAnimationState(String input) {
        if (input == "attack") {
            return this.attackAnimationState;
        } else if (input == "attack2") {
            return this.attack2AnimationState;
        } else if (input == "attack3") {
            return this.attack3AnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        }else {
            return new AnimationState();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }




    public void stopAllAnimationStates() {
        this.attackAnimationState.stop();
        this.attack2AnimationState.stop();
        this.attack3AnimationState.stop();

    }


    public void handleEntityEvent(byte p_219360_) {
        if (p_219360_ == 4) {
            if(random.nextBoolean()) {
                this.attackAnimationState.start(this.tickCount);
            }else if (random.nextBoolean()){
                this.attack2AnimationState.start(this.tickCount);
            }else {
                this.attack3AnimationState.start(this.tickCount);
            }
        } else {
            super.handleEntityEvent(p_219360_);
        }
    }

    public boolean doHurtTarget(Entity p_219472_) {
        this.level().broadcastEntityEvent(this, (byte) 4);
        p_219472_.hurt(p_219472_.damageSources().generic(), (this.attackDamageModifier));
        return super.doHurtTarget(p_219472_);

    }


    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(true, this.tickCount);
        }
    }

    public void aiStep() {
        super.aiStep();

    }

    class EliteKnightMeleeGoal extends MeleeAttackGoal {
        public EliteKnightMeleeGoal() {
            super(EliteKnightEntity.this, 1.0D, true);
        }
    }
}
