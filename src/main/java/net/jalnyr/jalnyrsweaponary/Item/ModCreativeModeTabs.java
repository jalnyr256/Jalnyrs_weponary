package net.jalnyr.jalnyrsweaponary.Item;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JalnyrsWeaponary.MOD_ID);

    public static final RegistryObject<CreativeModeTab> JALNYRSWEAPONARY = CREATIVE_MODE_TABS.register("jalnyrsweaponary",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FROSTSTEEL_SWORD.get()))
                    .title(Component.translatable("creativetab.jalnyrsweaponary"))
                    .displayItems((pParametres, pOutput) -> {
                        pOutput.accept(ModItems.FROSTSTEEL_SWORD.get());
                        pOutput.accept(ModItems.FROSTSTEEL_GREATSWORD.get());
                        pOutput.accept(ModItems.DUAL_FROSTSTEEL_SWORD.get());
                        pOutput.accept(ModItems.FROSTSTEEL_KATANA.get());
                        pOutput.accept(ModItems.FROSTSTEEL_KNIFE.get());
                        pOutput.accept(ModItems.FROSTSTEEL_SPEAR.get());

                        pOutput.accept(ModItems.FLAMEMETAL_SWORD.get());
                        pOutput.accept(ModItems.FLAMEMETAL_KNIFE.get());
                        pOutput.accept(ModItems.FLAMEMETAL_KATANA.get());
                        pOutput.accept(ModItems.FLAMEMETAL_SPEAR.get());

                        pOutput.accept(ModItems.FLAMEMETAL_INGOT.get());
                        pOutput.accept(ModItems.RAW_FLAMEMETAL.get());
                        pOutput.accept(ModItems.SIMPLE_KNIGHT_HELMET.get());
                        pOutput.accept(ModItems.SIMPLE_KNIGHT_CHESTPLATE.get());
                        pOutput.accept(ModItems.SIMPLE_KNIGHT_LEGGINGS.get());
                        pOutput.accept(ModItems.SIMPLE_KNIGHT_BOOTS.get());
                        pOutput.accept(ModItems.SIMPLE_KNIGHT_SWORD.get());
                        pOutput.accept(ModItems.FROSTY_KNIGHT_SWORD.get());
                        pOutput.accept(ModItems.BLOODY_KNIGHT_SWORD.get());
                        pOutput.accept(ModItems.SPEEDY_KNIGHT_SWORD.get());
                        pOutput.accept(ModItems.FIERY_GEMSTONE.get());
                        pOutput.accept(ModItems.FROSTY_GEMSTONE.get());
                        pOutput.accept(ModItems.BLOODY_GEMSTONE.get());
                        pOutput.accept(ModItems.SPEEDY_GEMSTONE.get());

                        pOutput.accept(ModItems.FROSTSTEEL_INGOT.get());
                        pOutput.accept(ModItems.RAW_FROSTSTEEL.get());
                        pOutput.accept(ModItems.FROZEN_STICK.get());

                        pOutput.accept(ModBlocks.FROZEN_WOOD.get());
                        pOutput.accept(ModBlocks.FROSTSTEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.FROSTSTEEL_ORE.get());
                        pOutput.accept(ModBlocks.FLAMEMETAl_ORE.get());
                        pOutput.accept(ModBlocks.FROZEN_LOG.get());
                        pOutput.accept(ModBlocks.FROZEN_LEAVES.get());
                        pOutput.accept(ModBlocks.STRIPPED_FROZEN_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_FROZEN_LOG.get());
                        pOutput.accept(ModBlocks.FROZEN_PLANKS.get());
                        pOutput.accept(ModBlocks.FROZEN_SAPLING.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
