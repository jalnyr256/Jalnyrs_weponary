package net.jalnyr.jalnyrsweaponary.Item;

import net.jalnyr.jalnyrsweaponary.Item.custom.*;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.minecraft.world.item.ArmorItem;
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
    public static final RegistryObject<Item> FLAMEMETAL_INGOT = ITEMS.register("flamemetal_ingot",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROZEN_STICK = ITEMS.register("frozen_stick",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_FROSTSTEEL = ITEMS.register("raw_froststeel",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_FLAMEMETAL = ITEMS.register("raw_flamemetal",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FROSTSTEEL_SWORD = ITEMS.register("froststeel_sword",
            ()-> new FroststeelSwordItem(ModToolTiers.FROSTSTEEL, 5, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> FLAMEMETAL_SWORD = ITEMS.register("flamemetal_sword",
            ()-> new FlamemetalSwordItem(ModToolTiers.FLAMEMETAL, 5, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> FLAMEMETAL_KNIFE = ITEMS.register("flamemetal_knife",
            ()-> new FlamemetalSwordItem(ModToolTiers.FLAMEMETAL, 2, -1.6F, new Item.Properties()));
    public static final RegistryObject<Item> FLAMEMETAL_KATANA = ITEMS.register("flamemetal_katana",
            ()-> new FlamemetalSwordItem(ModToolTiers.FLAMEMETAL, 4, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> FLAMEMETAL_SPEAR = ITEMS.register("flamemetal_spear",
            ()-> new FlamemetalSwordItem(ModToolTiers.FLAMEMETAL, 3, -1.7F, new Item.Properties()));

    public static final RegistryObject<Item> FROSTSTEEL_KATANA = ITEMS.register("froststeel_katana",
            ()-> new FroststeelSwordItem(ModToolTiers.FROSTSTEEL, 4, -2.0F, new Item.Properties()));
    public static final RegistryObject<Item> FROSTSTEEL_KNIFE = ITEMS.register("froststeel_knife",
            ()-> new FroststeelSwordItem(ModToolTiers.FROSTSTEEL, 2, -1.6F, new Item.Properties()));
    public static final RegistryObject<Item> FROSTSTEEL_SPEAR = ITEMS.register("froststeel_spear",
            ()-> new FroststeelSwordItem(ModToolTiers.FROSTSTEEL, 3, -1.7F, new Item.Properties()));
    public static final RegistryObject<Item> FROSTSTEEL_GREATSWORD = ITEMS.register("froststeel_greatsword",
            ()-> new FroststeelSwordItem(ModToolTiers.FROSTSTEEL, 9, -3F, new Item.Properties()));
    public static final RegistryObject<Item> DUAL_FROSTSTEEL_SWORD = ITEMS.register("dual_froststeel_sword",
            ()-> new FroststeelSwordItem(ModToolTiers.FROSTSTEEL, 11, -3F, new Item.Properties()));


    public static final RegistryObject<Item> SIMPLE_KNIGHT_SWORD = ITEMS.register("simple_knight_sword",
            ()-> new KnightSwordItem(ModToolTiers.KNIGHT, 1, -2.2F, new Item.Properties()));

    public static final RegistryObject<Item> FROSTY_KNIGHT_SWORD = ITEMS.register("frosty_knight_sword",
            ()-> new FrostyKnightSwordItem(ModToolTiers.KNIGHT, 1, -2.2F, new Item.Properties()));
    public static final RegistryObject<Item> BLOODY_KNIGHT_SWORD = ITEMS.register("bloody_knight_sword",
            ()-> new BloodyKnightSwordItem(ModToolTiers.KNIGHT, 1, -2.2F, new Item.Properties()));


    public static final RegistryObject<Item> SIMPLE_KNIGHT_HELMET = ITEMS.register("simple_knight_helmet",
            ()-> new ModArmorItem(ModArmorMaterials.SIMPLE_KNIGHT_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SIMPLE_KNIGHT_CHESTPLATE = ITEMS.register("simple_knight_chestplate",
            ()-> new ModArmorItem(ModArmorMaterials.SIMPLE_KNIGHT_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SIMPLE_KNIGHT_LEGGINGS = ITEMS.register("simple_knight_leggings",
            ()-> new ModArmorItem(ModArmorMaterials.SIMPLE_KNIGHT_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SIMPLE_KNIGHT_BOOTS = ITEMS.register("simple_knight_boots",
            ()-> new ModArmorItem(ModArmorMaterials.SIMPLE_KNIGHT_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> FIERY_GEMSTONE = ITEMS.register("fiery_gemstone",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOODY_GEMSTONE = ITEMS.register("bloody_gemstone",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPEEDY_GEMSTONE = ITEMS.register("speedy_gemstone",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FROSTY_GEMSTONE = ITEMS.register("frosty_gemstone",
            ()-> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
