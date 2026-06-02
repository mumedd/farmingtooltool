package com.github.mumedd.farmingtooltool;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.mumedd.farmingtooltool.config.ModConfig;
import com.github.mumedd.farmingtooltool.features.CactiBreaker;
import com.github.mumedd.farmingtooltool.features.ToolWarner;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class FarmingToolTool implements ClientModInitializer {
	public static final String MOD_ID = "farmingtooltool";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
		CactiBreaker.init();
		ToolWarner.init();
	}
}