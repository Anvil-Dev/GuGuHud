package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;

@SuppressWarnings("resource")
public class GameDayTimeHudRow extends HudRow {
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showGameDayTime;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        ClientLevel level = this.mc().level;
        if (level == null) return 0;
        long dayTime = level.getDayTime();
        String format = GuGuHudRgRules.gameDayTimeFormat;
        format = format.replace("{Days}", String.valueOf(dayTime / 24000));
        format = format.replace("{Hours}", "%2d".formatted(((dayTime % 24000) + 6000) / 1000 % 24).replace(' ', '0'));
        format = format.replace("{Minutes}", "%2.0f".formatted(Math.floor(((dayTime % 24000) % 1000) / (1000f / 60f))).replace(' ', '0'));
        return this.drawString(format);
    }
}
