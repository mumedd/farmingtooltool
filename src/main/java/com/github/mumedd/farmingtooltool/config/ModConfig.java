package com.github.mumedd.farmingtooltool.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "farmingtooltool")
public class ModConfig implements ConfigData {
    public boolean cactusBreak = true;
    public boolean toolwarner = true;
}
