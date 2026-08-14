package net.jalnyr.jalnyrsweaponary.event;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.entity.ModEntities;
import net.jalnyr.jalnyrsweaponary.entity.custom.EliteKnightEntity;
import net.jalnyr.jalnyrsweaponary.entity.custom.KnightEntity;
import net.jalnyr.jalnyrsweaponary.entity.custom.OldManEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JalnyrsWeaponary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.OLD_MAN.get(), OldManEntity.CreateAttributes().build());
        event.put(ModEntities.KNIGHT.get(), KnightEntity.CreateAttributes().build());
        event.put(ModEntities.ELITE_KNIGHT.get(), EliteKnightEntity.CreateAttributes().build());
    }
}
