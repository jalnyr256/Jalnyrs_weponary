package net.jalnyr.jalnyrsweaponary.Item;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;
import java.util.function.Supplier;

public class ModToolTiers {
    public static final Tier FROSTSTEEL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_FROSTSTEEL_TOOL, () -> Ingredient.of(ModItems.FROSTSTEEL_INGOT.get())),
            new ResourceLocation(JalnyrsWeaponary.MOD_ID, "froststeel"), List.of(Tiers.NETHERITE), List.of());


}
