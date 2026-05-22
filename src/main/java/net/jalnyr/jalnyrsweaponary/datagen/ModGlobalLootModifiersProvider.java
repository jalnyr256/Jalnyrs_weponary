package net.jalnyr.jalnyrsweaponary.datagen;

import net.jalnyr.jalnyrsweaponary.Item.ModItems;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, JalnyrsWeaponary.MOD_ID);
    }

    @Override
    protected void start() {
        add("froststeel_from_plains", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build()}, ModItems.RAW_FROSTSTEEL.get()));
        add("froststeel_wood_from_plains", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build()}, ModItems.FROZEN_STICK.get()));
    }
}
