package net.jalnyr.jalnyrsweaponary.datagen;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JalnyrsWeaponary.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FROSTSTEEL_BLOCK);
        blockWithItem(ModBlocks.ANCIENT_STONE_BRICKS);

        blockWithItem(ModBlocks.FROSTSTEEL_ORE);
        blockWithItem(ModBlocks.FLAMEMETAl_ORE);
        logBlock(((RotatedPillarBlock) ModBlocks.FROZEN_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.FROZEN_WOOD.get()), blockTexture(ModBlocks.FROZEN_LOG.get()), blockTexture(ModBlocks.FROZEN_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_FROZEN_LOG.get()), blockTexture(ModBlocks.FROZEN_LOG.get()),
                new ResourceLocation(JalnyrsWeaponary.MOD_ID, "block/stripped_frozen_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_FROZEN_WOOD.get()), blockTexture(ModBlocks.STRIPPED_FROZEN_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_FROZEN_LOG.get()));

        blockItem(ModBlocks.FROZEN_LOG);
        blockItem(ModBlocks.FROZEN_WOOD);
        blockItem(ModBlocks.STRIPPED_FROZEN_LOG);
        blockItem(ModBlocks.STRIPPED_FROZEN_WOOD);

        blockWithItem(ModBlocks.FROZEN_PLANKS);

        leavesBlock(ModBlocks.FROZEN_LEAVES);
        saplingBlock(ModBlocks.FROZEN_SAPLING);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(JalnyrsWeaponary.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }



    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}