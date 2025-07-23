package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;

public class DimensionIDHudRow extends HudRow {
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showDimensionID;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        ClientLevel level = this.mc().level;
        if (level == null) return 0;
        return this.drawString(
            Component.translatable(
                "gugu_hud.dimension_id_hud.dimension_id",
                level.dimension().location().toString()
            )
        );
    }
}
