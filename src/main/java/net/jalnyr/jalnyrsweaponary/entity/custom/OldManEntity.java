package net.jalnyr.jalnyrsweaponary.entity.custom;

import net.jalnyr.jalnyrsweaponary.Item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class OldManEntity extends AgeableMob {
    public OldManEntity(EntityType<? extends AgeableMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public boolean sentMessage = false;
    public boolean sentMessage2 = true;
    public boolean sentMessage3 = true;
    public boolean sentMessage4 = true;
    public boolean sentMessage5 = true;
    public boolean sentMessage6 = true;
    public boolean sentMessage7 = true;
    public boolean sentMessage8 = true;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
    }

    public static AttributeSupplier.Builder CreateAttributes() {
        return createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 500D)
                .add(Attributes.FOLLOW_RANGE, 1);
    }
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        if (!sentMessage) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.1.message"));
                if (level().isClientSide) {
                    sentMessage = true;
                }
            }
            sentMessage2 = false;
        }
        else if (!sentMessage2) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.2.message"));
                if (level().isClientSide) {
                    sentMessage2 = true;
                }
            }
            sentMessage3 = false;
        }
        else if (!sentMessage3) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.3.message"));
                if (level().isClientSide) {
                    sentMessage3 = true;
                }
            }
            sentMessage4 = false;
        }
        else if (!sentMessage4) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.4.message"));
                if (level().isClientSide) {
                    sentMessage4 = true;
                }
            }
            sentMessage5 = false;
        }
        else if (!sentMessage5) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.5.message"));
                if (level().isClientSide) {
                    sentMessage5 = true;
                }
            }
            sentMessage6 = false;
        }
        else if (!sentMessage6) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.6.message"));
                if (level().isClientSide) {
                    sentMessage6 = true;
                }
            }
            sentMessage7 = false;
        }
        else if (!sentMessage7) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.7.message"));
                if (level().isClientSide) {
                    sentMessage7 = true;
                }
            }
            sentMessage8 = false;
        }
        else if (!sentMessage8) {
            if (level().isClientSide) {
                pPlayer.sendSystemMessage(Component.translatable("message.jalnyrsweaponary.8.message"));
                if (level().isClientSide) {
                    sentMessage8 = true;
                }
            }
        }
        else {
            return super.mobInteract(pPlayer, pHand);
        }
        return super.mobInteract(pPlayer, pHand);
    }
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return null;
    }
}
