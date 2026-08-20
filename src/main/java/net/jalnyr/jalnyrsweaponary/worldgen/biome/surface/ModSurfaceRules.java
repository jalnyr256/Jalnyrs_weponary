package net.jalnyr.jalnyrsweaponary.worldgen.biome.surface;

import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.jalnyr.jalnyrsweaponary.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(ModBlocks.DRIED_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource FLAMEMETAL = makeStateRule(ModBlocks.FLAMEMETAl_ORE.get());
    private static final SurfaceRules.RuleSource FROSTSTEEL = makeStateRule(ModBlocks.FROSTSTEEL_ORE.get());


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);


        return SurfaceRules.sequence(


                // Default to a grass and dirt surface
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
