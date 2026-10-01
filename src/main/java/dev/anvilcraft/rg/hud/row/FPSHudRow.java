package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("resource")
public class FPSHudRow extends HudRow {
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showFPS;
    }

    @Override
    public int render(@NotNull GuiGraphicsExtractor guiGraphics, DeltaTracker partialTick) {
        return this.drawString("FPS: %s/%s".formatted(this.mc().getFps(), this.getFramerateLimit()));
    }

    private int getFramerateLimit() {
        Minecraft mc = this.mc();
        return mc.getFramerateLimitTracker().getFramerateLimit();
    }
}
