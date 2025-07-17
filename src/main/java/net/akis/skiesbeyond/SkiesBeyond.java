package net.akis.skiesbeyond;

import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.component.ModDataComponentTypes;
import net.akis.skiesbeyond.effect.ModEffects;
import net.akis.skiesbeyond.enchantment.ModEnchantmentEffects;
import net.akis.skiesbeyond.enchantment.ModEnchantments;
import net.akis.skiesbeyond.item.ModItemGroups;
import net.akis.skiesbeyond.item.ModItems;
import net.akis.skiesbeyond.potion.ModPotions;
import net.akis.skiesbeyond.sound.ModSounds;
import net.akis.skiesbeyond.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkiesBeyond implements ModInitializer {
	public static final String MOD_ID = "skiesbeyond";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEnchantmentEffects.registerEnchantmentEffects();


		FuelRegistry.INSTANCE.add(ModItems.COMBUSTED_ESSENCE, 2000);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());


		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.SOLAR_ESSENCE, ModPotions.SKY_LEAPING_POTION);
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.STARFRUIT_SEEDS, 0.5f);
	}
}