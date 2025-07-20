package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.ChatFormatting;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class MemoryHudRow extends HudRow{
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showMemory;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        ChatFormatting memoryColor = heatmapColor(usedMemory, maxMemory);

        return this.drawString(Component.translatable("gugu_hud.memory_hud.memory_usage",
            Component.literal("%s%%".formatted(usedMemory* 100L /maxMemory)).withStyle(memoryColor),
            byteTOMB(usedMemory),
            byteTOMB(maxMemory),
            totalMemory * 100L / maxMemory,
            byteTOMB(totalMemory)));
    }

    static ChatFormatting heatmapColor(long actual, long reference) {
        ChatFormatting color = ChatFormatting.GREEN;
        if (actual > 0.5D * reference) color = ChatFormatting.YELLOW;
        if (actual > 0.8D * reference) color = ChatFormatting.RED;
        return color;
    }

    public long byteTOMB(long bytes){
        return bytes / 1024 / 1024;
    }

}
