package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RealTimeHudRow extends HudRow {
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showRealTime;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        return this.drawString(
            Component.translatable(
                "gugu_hud.real_time_hud.real_time",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(GuGuHudRgRules.realTimeFormat))
            )
        );
    }
}
