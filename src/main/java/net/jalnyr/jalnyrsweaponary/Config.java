package net.jalnyr.jalnyrsweaponary;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = JalnyrsWeaponary.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue FROZEN_TREE_SPAWN_AMOUNT = BUILDER
            .comment("Frozen tree spawning")
            .defineInRange("frozenTree", 10, 2, 10);
    private static final ForgeConfigSpec.IntValue BLOODY_SWORD_DAMAGE_MULTIPLIER = BUILDER
            .comment("Bloody sword damage multiplier")
            .defineInRange("entityDamageMultiplier", 3, 1, 20);

    // a list of strings that are treated as resource locations for items
    static final ForgeConfigSpec SPEC = BUILDER.build();
    public static int entityDamageMultiplier;
    public static int frozenTree;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        frozenTree = FROZEN_TREE_SPAWN_AMOUNT.get();
        entityDamageMultiplier = BLOODY_SWORD_DAMAGE_MULTIPLIER.get();
    }
}
