package net.jalnyr.jalnyrsweaponary.datagen;

import net.jalnyr.jalnyrsweaponary.Item.ModItems;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JalnyrsWeaponary.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {

        trimmedArmorItem(ModItems.SIMPLE_KNIGHT_BOOTS);
        trimmedArmorItem(ModItems.SIMPLE_KNIGHT_CHESTPLATE);
        trimmedArmorItem(ModItems.SIMPLE_KNIGHT_HELMET);
        trimmedArmorItem(ModItems.SIMPLE_KNIGHT_LEGGINGS);

        trimmedArmorItem(ModItems.TRIASSIC_SCALE_BOOTS);
        trimmedArmorItem(ModItems.TRIASSIC_SCALE_CHESTPLATE);
        trimmedArmorItem(ModItems.TRIASSIC_SCALE_LEGGINGS);
        trimmedArmorItem(ModItems.TRIASSIC_SCALE_HELMET);
        basicItem(ModItems.TRIASSIC_SCALE.get());
        basicItem(ModItems.JURASSIC_LEAF.get());
        basicItem(ModItems.RAW_FROSTSTEEL.get());
        basicItem(ModItems.RAW_FLAMEMETAL.get());
        basicItem(ModItems.FROZEN_STICK.get());
        basicItem(ModItems.FLAMEMETAL_INGOT.get());
        basicItem(ModItems.FROSTSTEEL_INGOT.get());

        basicItem(ModItems.SPEEDY_GEMSTONE.get());
        basicItem(ModItems.FIERY_GEMSTONE.get());
        basicItem(ModItems.BLOODY_GEMSTONE.get());
        basicItem(ModItems.FROSTY_GEMSTONE.get());
        handheldItem(ModItems.FLAMEMETAL_KATANA);
        handheldItem(ModItems.FLAMEMETAL_KNIFE);
        handheldItem(ModItems.FLAMEMETAL_SPEAR);
        handheldItem(ModItems.FLAMEMETAL_SWORD);
        handheldItem(ModItems.FROSTSTEEL_KATANA);
        handheldItem(ModItems.FROSTSTEEL_SWORD);
        handheldItem(ModItems.FROSTSTEEL_SPEAR);
        handheldItem(ModItems.FROSTSTEEL_KNIFE);
    }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = JalnyrsWeaponary.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(JalnyrsWeaponary.MOD_ID,"item/" + item.getId().getPath()));
    }
}
