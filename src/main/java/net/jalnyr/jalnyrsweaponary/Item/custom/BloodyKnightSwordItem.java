package net.jalnyr.jalnyrsweaponary.Item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.DamageCommand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class BloodyKnightSwordItem extends SwordItem {
    public BloodyKnightSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity player) {
        if (player.getHealth() < 18D){
            entity.hurt(entity.damageSources().generic(), 2.0F);
        }
        if (player.getHealth() < 16D){
            entity.hurt(entity.damageSources().generic(), 4.0F);
        }
        if (player.getHealth() < 14D){
            entity.hurt(entity.damageSources().generic(), 6.0F);
        }
        if (player.getHealth() < 12D){
            entity.hurt(entity.damageSources().generic(), 8.0F);
        }
        if (player.getHealth() < 10D){
            entity.hurt(entity.damageSources().generic(), 10.0F);
        }
        if (player.getHealth() < 8D){
            entity.hurt(entity.damageSources().generic(), 16.0F);
        }
        if (player.getHealth() < 6D){
            entity.hurt(entity.damageSources().generic(), 24.0F);
        }
        if (player.getHealth() < 4D){
            entity.hurt(entity.damageSources().generic(), 30.0F);
        }
        if (player.getHealth() < 2D){
            entity.hurt(entity.damageSources().generic(), 40.0F);
        }
        if (player.getHealth() < 1D){
            entity.hurt(entity.damageSources().generic(), 50.0F);
        }
        return true;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.jalnyrsweaponary.bloody_knight_sword.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public Rarity getRarity(ItemStack pStack) {
        return Rarity.EPIC;
    }
}
