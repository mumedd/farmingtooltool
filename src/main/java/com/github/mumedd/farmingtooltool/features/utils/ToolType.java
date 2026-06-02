package com.github.mumedd.farmingtooltool.features.utils;

import net.minecraft.item.ItemStack;

public enum ToolType {

    WHEAT_HOE("wheat hoe"),
    CARROT_HOE("carrot hoe"),
    POTATO_HOE("potato hoe"),

    PUMPKIN_DICER("pumpkin dicer"),
    MELON_DICER("melon dicer"),

    FUNGI_CUTTER("fungi cutter"),

    CACTUS_KNIFE("cactus knife"),

    SUGAR_CANE_HOE("sugar cane hoe"),
    NETHER_WART_HOE("nether wart hoe"),
    COCOA_CHOPPER("cocoa chopper"),

    ECLIPSE_HOE("eclipse hoe"),
    WILD_ROSE_HOE("wild rose hoe"),

    UNKNOWN("");

    private final String match;

    ToolType(String match) {
        this.match = match;
    }

    public static ToolType from(ItemStack stack) {
        String name = stack.getName().getString()
                .toLowerCase()
                .replaceAll("\\s+\\d+$", "")
                .trim();

        for (ToolType type : values()) {
            if (type == UNKNOWN) continue;
            if (name.contains(type.match)) {
                return type;
            }
        }

        return UNKNOWN;
    }
}