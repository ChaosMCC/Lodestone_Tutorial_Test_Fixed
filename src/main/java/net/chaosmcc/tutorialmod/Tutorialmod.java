package net.chaosmcc.tutorialmod;

import net.chaosmcc.tutorialmod.custome.packets.ModClientPackets;
import net.chaosmcc.tutorialmod.custome.packets.ModPackets;
import net.chaosmcc.tutorialmod.item.ModItemGroups;
import net.chaosmcc.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorialmod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerItem();
		ModPackets.registerPackets();
		ModClientPackets.registerClientPackets();
		ModItemGroups.registerItemGroups();

		LOGGER.info("Hello Fabric world!");
	}
}