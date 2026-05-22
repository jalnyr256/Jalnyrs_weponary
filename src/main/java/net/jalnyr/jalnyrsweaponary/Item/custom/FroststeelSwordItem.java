package net.jalnyr.jalnyrsweaponary.Item.custom;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

import java.util.function.Consumer;

import static net.minecraft.world.item.CrossbowItem.isCharged;

public class FroststeelSwordItem extends SwordItem {

    public FroststeelSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), Potions.STRONG_HARMING);
    }
    public boolean hurtEnemy(ItemStack stack, LivingEntity entity, LivingEntity player) {
        if(player instanceof Player player1) {
            PotionUtils.setPotion(super.getDefaultInstance(), Potions.STRONG_HARMING);
        }
        stack.hurtAndBreak(1, player, (p_43414_) -> {
            p_43414_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
        });

        return true;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return super.onEntitySwing(getDefaultInstance(), entity);
    }
}
