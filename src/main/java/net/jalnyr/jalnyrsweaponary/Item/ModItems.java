package net.jalnyr.jalnyrsweaponary.Item;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JalnyrsWeaponary.MOD_ID);

    public static final RegistryObject<Item> FROSTSTEEL_INGOT = ITEMS.register("froststeel_ingot",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_FROSTSTEEL = ITEMS.register("raw_froststeel",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROSTSTEEL_SWORD = ITEMS.register("froststeel_sword",
            ()-> new SwordItem(ModToolTiers.FROSTSTEEL, 5, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> FROSTSTEEL_GREATSWORD = ITEMS.register("froststeel_greatsword",
            ()-> new SwordItem(ModToolTiers.FROSTSTEEL, 7, -3.4F, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
