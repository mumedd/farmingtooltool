package com.github.mumedd.farmingtooltool.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ModConfigScreen {
    public static Screen create(Screen parent) {
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent).setTitle(Text.literal("FarmingToolTool Config"));
        ConfigCategory general = builder.getOrCreateCategory(Text.literal("General"));
        ConfigEntryBuilder entries = builder.entryBuilder();

        general.addEntry(entries.startBooleanToggle(Text.literal("Break Cactus Instantly"), config.cactusBreak)
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.cactusBreak = value)
            .build()
        );

        general.addEntry(entries.startBooleanToggle(Text.literal("Warn when using wrong farming tool"), config.toolwarner)
            .setDefaultValue(true)
            .setSaveConsumer(value -> config.toolwarner = value)
            .build()
        );

        builder.setSavingRunnable(() -> AutoConfig.getConfigHolder(ModConfig.class).save());

        return builder.build();
    }
}
