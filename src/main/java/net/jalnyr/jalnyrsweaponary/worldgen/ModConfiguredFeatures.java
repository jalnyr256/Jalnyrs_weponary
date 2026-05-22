package net.jalnyr.jalnyrsweaponary.worldgen;

import io.netty.util.Constant;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_FROSTSTEEL_ORE_KEY = registerKey("froststeel_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FROZEN_KEY = registerKey("frozen");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldFroststeelOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.FROSTSTEEL_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_FROSTSTEEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldFroststeelOres, 9));

        register(context, FROZEN_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.FROZEN_LOG.get()),
                new StraightTrunkPlacer(4, 3, 2),
                BlockStateProvider.simple(ModBlocks.FROZEN_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(4), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(1, 0, 3)).build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JalnyrsWeaponary.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}