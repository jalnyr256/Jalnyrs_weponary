package net.jalnyr.jalnyrsweaponary.event;


import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.entity.client.EliteKnightModel;
import net.jalnyr.jalnyrsweaponary.entity.client.KnightModel;
import net.jalnyr.jalnyrsweaponary.entity.client.ModModelLayers;
import net.jalnyr.jalnyrsweaponary.entity.client.OldManModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JalnyrsWeaponary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.OLD_MAN_LAYER, OldManModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.KNIGHT_LAYER, KnightModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ELITE_KNIGHT_LAYER, EliteKnightModel::createBodyLayer);
    }


}
