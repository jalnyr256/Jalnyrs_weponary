package net.jalnyr.jalnyrsweaponary.worldgen.biome;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(JalnyrsWeaponary.MOD_ID, "overworld"), 3));
    }
}

