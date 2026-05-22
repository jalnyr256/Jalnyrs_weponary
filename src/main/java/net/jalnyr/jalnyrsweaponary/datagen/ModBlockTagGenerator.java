package net.jalnyr.jalnyrsweaponary.datagen;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, JalnyrsWeaponary.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.FROZEN_LOG.get())
                .add(ModBlocks.FROZEN_WOOD.get())
                .add(ModBlocks.STRIPPED_FROZEN_LOG.get())
                .add(ModBlocks.STRIPPED_FROZEN_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.FROZEN_PLANKS.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FROSTSTEEL_BLOCK.get())
                .add(ModBlocks.FROSTSTEEL_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FROSTSTEEL_BLOCK.get())
                .add(ModBlocks.FROSTSTEEL_ORE.get());
    }
}