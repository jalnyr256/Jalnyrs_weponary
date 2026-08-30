package net.jalnyr.jalnyrsweaponary.fluid;

import net.jalnyr.jalnyrsweaponary.Item.ModItems;
import net.jalnyr.jalnyrsweaponary.JalnyrsWeaponary;
import net.jalnyr.jalnyrsweaponary.block.ModBlocks;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, JalnyrsWeaponary.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_ACID = FLUIDS.register("source_acid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SOAP_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ACID = FLUIDS.register("flowing_acid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SOAP_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties SOAP_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ACID_WATER_FLUID_TYPE, SOURCE_ACID, FLOWING_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.ACID_FLUID_BLOCK).bucket(ModItems.ACID_BUCKET);


    public static void register(IEventBus eventBus)  {
        FLUIDS.register(eventBus);
    }
}
