package net.jalnyr.jalnyrsweaponary.datagen;

import net.jalnyr.jalnyrsweaponary.Item.ModItems;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, JalnyrsWeaponary.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.FROZEN_LOG.get().asItem())
                .add(ModBlocks.FROZEN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_FROZEN_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_FROZEN_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.FROZEN_PLANKS.get().asItem());
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.SIMPLE_KNIGHT_BOOTS.get(),
                        ModItems.SIMPLE_KNIGHT_LEGGINGS.get(),
                        ModItems.SIMPLE_KNIGHT_CHESTPLATE.get(),
                        ModItems.SIMPLE_KNIGHT_HELMET.get());
    }
}