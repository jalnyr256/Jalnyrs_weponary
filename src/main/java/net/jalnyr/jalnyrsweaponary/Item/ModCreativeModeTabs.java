package net.jalnyr.jalnyrsweaponary.Item;

import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.DIAMOND))
                    .title(Component.translatable("creativetab.jalnyrsweaponary"))
                    .displayItems((pParametres, pOutput) -> {
                        pOutput.accept(ModItems.FROSTSTEEL_SWORD.get());
                        pOutput.accept(ModItems.FROSTSTEEL_GREATSWORD.get());
                        pOutput.accept(ModItems.FROSTSTEEL_INGOT.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
