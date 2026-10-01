package dev.anvilcraft.rg.hud.row;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

@SuppressWarnings("resource")
public abstract class HudRow {
    protected GuiGraphicsExtractor guiGraphics;
    protected DeltaTracker deltaTracker;

    public abstract boolean isVisible();

    public abstract int render(GuiGraphicsExtractor guiGraphics, DeltaTracker partialTick);

    protected Font font() {
        return this.mc().font;
    }

    protected Minecraft mc() {
        return Minecraft.getInstance();
    }

    public final void setGuiGraphics(GuiGraphicsExtractor guiGraphics) {
        this.guiGraphics = guiGraphics;
    }

    public final void setDeltaTracker(DeltaTracker partialTick) {
        this.deltaTracker = partialTick;
    }

    public final int drawString(String text) {
        return this.drawString(text, 0xFFFFFFFF);
    }

    public final int drawString(Component text) {
        return this.drawString(text, 0xFFFFFFFF);
    }

    public final int drawString(String text, int color) {
        this.drawBackground(this.font().width(text), this.font().lineHeight, 0x88666666);
        this.guiGraphics.text(this.font(), text, 0, 0, color);
        return this.font().lineHeight;
    }

    public int drawString(Component text, int color) {
        this.drawBackground(this.font().width(text), this.font().lineHeight, 0x88666666);
        this.guiGraphics.text(this.font(), text, 0, 0, color);
        return this.font().lineHeight;
    }

    public void drawBackground(int width, int height, int color) {
        this.guiGraphics.fill(0, 0, width, height, color);
    }
}
