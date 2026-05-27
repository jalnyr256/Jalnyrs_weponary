package net.jalnyr.jalnyrsweaponary.util;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_FROSTSTEEL_TOOL = tag("needs_froststeel_tool");
        public static final TagKey<Block> NEEDS_FLAMEMETAL_TOOL = tag("needs_flamemetal_tool");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(JalnyrsWeaponary.MOD_ID, name));
        }
    }
    public static class Items {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(JalnyrsWeaponary.MOD_ID, name));
        }
    }
}
