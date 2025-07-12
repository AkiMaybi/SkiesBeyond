package net.akis.skiesbeyond;

import net.akis.skiesbeyond.block.ModBlocks;
import net.akis.skiesbeyond.item.ModItemGroups;
import net.akis.skiesbeyond.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
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


		FuelRegistry.INSTANCE.add(ModItems.COMBUSTED_ESSENCE, 3200);
	}
}