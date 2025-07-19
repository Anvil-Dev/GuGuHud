package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("resource")
public class MoonPhaseHudRow extends HudRow {
    public static final Component MOON_PHASE = Component.translatable("gugu_hud.moon_phase_hud.moon_phase");
    public static final ArrayList<Component> MOON_PHASES = new ArrayList<>(Arrays.asList(
            Component.translatable("gugu_hud.moon_phase_hud.new_moon"),
            Component.translatable("gugu_hud.moon_phase_hud.waxing_crescent"),
            Component.translatable("gugu_hud.moon_phase_hud.waxing_half"),
            Component.translatable("gugu_hud.moon_phase_hud.waxing_gibbous"),
            Component.translatable("gugu_hud.moon_phase_hud.full_moon"),
            Component.translatable("gugu_hud.moon_phase_hud.waning_gibbous"),
            Component.translatable("gugu_hud.moon_phase_hud.waning_half"),
            Component.translatable("gugu_hud.moon_phase_hud.waning_crescent")
            ));

    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showMoonPhase;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        ClientLevel level = this.mc().level;
        if (level == null) return 0;
        long dayTime = level.getDayTime();
        int moonPhase = (int) (dayTime / 24000) % 8;
        return this.drawString(MOON_PHASE.getString() + ": " + MOON_PHASES.get(moonPhase).getString());
    }
}
