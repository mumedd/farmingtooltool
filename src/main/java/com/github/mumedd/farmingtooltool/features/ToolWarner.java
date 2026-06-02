package com.github.mumedd.farmingtooltool.features;

import java.util.Map;

import com.github.mumedd.farmingtooltool.config.ModConfig;
import com.github.mumedd.farmingtooltool.features.utils.ToolType;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;

public class ToolWarner {

    public static final Map<Block, ToolType> REQUIRED_TOOL = Map.ofEntries(

            Map.entry(Blocks.WHEAT, ToolType.WHEAT_HOE),
            Map.entry(Blocks.CARROTS, ToolType.CARROT_HOE),
            Map.entry(Blocks.POTATOES, ToolType.POTATO_HOE),
            Map.entry(Blocks.PUMPKIN, ToolType.PUMPKIN_DICER),
            Map.entry(Blocks.MELON, ToolType.MELON_DICER),
            Map.entry(Blocks.RED_MUSHROOM, ToolType.FUNGI_CUTTER),
            Map.entry(Blocks.BROWN_MUSHROOM, ToolType.FUNGI_CUTTER),
            Map.entry(Blocks.CACTUS, ToolType.CACTUS_KNIFE),
            Map.entry(Blocks.SUGAR_CANE, ToolType.SUGAR_CANE_HOE),
            Map.entry(Blocks.NETHER_WART, ToolType.NETHER_WART_HOE),
            Map.entry(Blocks.COCOA, ToolType.COCOA_CHOPPER)

    );
    
    public static void init() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!AutoConfig.getConfigHolder(ModConfig.class).getConfig().toolwarner) return ActionResult.PASS;
            Block block = world.getBlockState(pos).getBlock();

            if (!REQUIRED_TOOL.containsKey(block)) return ActionResult.PASS;
            ToolType required = REQUIRED_TOOL.get(block);
            ToolType held = ToolType.from(player.getMainHandStack());

            if (held!=required) player.sendMessage(Text.literal("[FTT] You are using the wrong farming tool!").formatted(Formatting.RED), false);
            return ActionResult.PASS;
        });
    }
}
