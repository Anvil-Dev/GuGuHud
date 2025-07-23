package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class PlayerFacingHudRow extends HudRow {
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showPlayerFacing;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        Entity cameraEntity = this.mc().cameraEntity;
        if (cameraEntity == null) return 0;
        Direction direction = cameraEntity.getDirection();
        String facing = direction.getName();
        String facingAxis = (direction.getAxisDirection() == Direction.AxisDirection.NEGATIVE ? "-" : "+") + direction.getAxis().getName();
        return this.drawString(
            Component.translatable(
                "gugu_hud.player_facing_hud.player_facing",
                Component.translatableWithFallback("gugu_hud.player_facing_hud.player_facing." + facing, facing),
                facing.substring(0, 1).toUpperCase(),
                facingAxis.toUpperCase()
            )
        );
    }
}
