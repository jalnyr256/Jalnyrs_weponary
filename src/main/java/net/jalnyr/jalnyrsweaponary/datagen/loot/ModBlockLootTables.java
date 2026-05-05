package net.jalnyr.jalnyrsweaponary.datagen.loot;

import net.jalnyr.jalnyrsweaponary.Item.ModItems;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FROZEN_PLANKS.get());
        this.dropSelf(ModBlocks.FROZEN_LOG.get());
        this.dropSelf(ModBlocks.FROZEN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_FROZEN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_FROZEN_WOOD.get());
        this.add(ModBlocks.FROZEN_LEAVES.get(), block->
                createLeavesDrops(block, ModBlocks.FROZEN_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}