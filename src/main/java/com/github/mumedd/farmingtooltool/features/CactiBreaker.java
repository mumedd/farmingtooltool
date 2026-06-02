package com.github.mumedd.farmingtooltool.features;

import com.github.mumedd.farmingtooltool.config.ModConfig;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;

public class CactiBreaker {

    public static boolean isCactusKnife(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return false;

        String nameString = stack.getName().getString();

        return nameString.contains("Cactus Knife");
    }

    public static void init() {
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (!AutoConfig.getConfigHolder(ModConfig.class).getConfig().cactusBreak) return ActionResult.PASS;
            
            BlockState state = world.getBlockState(pos);

            if (!state.isOf(Blocks.CACTUS) || !isCactusKnife(player.getMainHandStack())) return ActionResult.PASS;

            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            return ActionResult.PASS;
        });
    }
}
