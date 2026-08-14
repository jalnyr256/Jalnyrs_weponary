package net.jalnyr.jalnyrsweaponary.entity.client;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation OLD_MAN_LAYER = new ModelLayerLocation(
            new ResourceLocation(JalnyrsWeaponary.MOD_ID, "old_man_layer"), "main");
    public static final ModelLayerLocation KNIGHT_LAYER = new ModelLayerLocation(
            new ResourceLocation(JalnyrsWeaponary.MOD_ID, "knight_layer"), "main");
    public static final ModelLayerLocation ELITE_KNIGHT_LAYER = new ModelLayerLocation(
            new ResourceLocation(JalnyrsWeaponary.MOD_ID, "elite_knight_layer"), "main");

}