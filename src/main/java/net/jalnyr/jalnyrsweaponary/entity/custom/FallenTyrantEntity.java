package net.jalnyr.jalnyrsweaponary.entity.custom;

import net.jalnyr.jalnyrsweaponary.entity.ai.EliteKnightAttackGoal;
import net.jalnyr.jalnyrsweaponary.entity.ai.FallenTyrantAttackGoal;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FallenTyrantEntity extends Monster{
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(FallenTyrantEntity.class, EntityDataSerializers.BOOLEAN);
    public AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;
    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;
    public AnimationState attack2AnimationState = new AnimationState();
    public AnimationState attack3AnimationState = new AnimationState();
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    private final ServerBossEvent bossEvent  = new ServerBossEvent(Component.literal("Fallen Tyrant"),
            BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.NOTCHED_6);

    public int attackDamageModifier = 8;

    public FallenTyrantEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new FallenTyrantAttackGoal(this, 1.0D, true));
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
                .add(Attributes.ATTACK_SPEED, 2D)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.05);
    }

    public @NotNull MobType getMobType() {
        return MobType.UNDEAD;
    }


    public AnimationState getAnimationState(String input) {
        if (input == "attack") {
            return this.attackAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        } else {
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
        this.attackAnimationState.start(this.tickCount);
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


    @Override
    public void startSeenByPlayer(ServerPlayer pServerPlayer) {
        super.startSeenByPlayer(pServerPlayer);
        this.bossEvent.addPlayer(pServerPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pServerPlayer) {
        super.stopSeenByPlayer(pServerPlayer);
        this.bossEvent.removePlayer(pServerPlayer);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }
    class EliteKnightMeleeGoal extends MeleeAttackGoal {
        public EliteKnightMeleeGoal() {
            super(FallenTyrantEntity.this, 1.0D, true);
        }
    }
}
