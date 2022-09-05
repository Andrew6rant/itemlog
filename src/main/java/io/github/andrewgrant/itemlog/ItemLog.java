package io.github.andrewgrant.itemlog;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemLog implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("itemlog");

	@Override
	public void onInitialize() {
		registryLoop("Registered");
		ServerLifecycleEvents.END_DATA_PACK_RELOAD.register((server, resourceManager, success) -> registryLoop("Reloaded"));
	}

	public static void registryLoop(String loggerMsg) {
		for (Item item : Registry.ITEM) {
			LOGGER.info(loggerMsg + ": " + item.getTranslationKey());
		}
	}
}
