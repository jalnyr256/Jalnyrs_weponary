package net.jalnyr.jalnyrsweaponary.datagen.loot;

import net.jalnyr.jalnyrsweaponary.Item.ModItems;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FROSTSTEEL_BLOCK.get());
        this.dropSelf(ModBlocks.ANCIENT_STONE_BRICKS.get());
        this.add(ModBlocks.FROSTSTEEL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.FROSTSTEEL_ORE.get(), ModItems.RAW_FROSTSTEEL.get()));
        this.add(ModBlocks.FLAMEMETAl_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.FLAMEMETAl_ORE.get(), ModItems.RAW_FLAMEMETAL.get()));
        this.dropSelf(ModBlocks.FROZEN_LOG.get());
        this.dropSelf(ModBlocks.FROZEN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_FROZEN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_FROZEN_WOOD.get());
        this.dropSelf(ModBlocks.FROZEN_PLANKS.get());
        this.dropSelf(ModBlocks.FROZEN_SAPLING.get());

        this.add(ModBlocks.FROZEN_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.FROZEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to Sapling!
    }
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}