package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("resource")
public class PlayerPositionHudRow extends HudRow {
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showPlayerPosition || GuGuHudRgRules.showPlayerPositionScaled;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        Entity entity = this.mc().cameraEntity;
        if (entity == null) return 0;
        Vec3 position = entity.position();
        Component currentPosition = Component.translatable(
            "gugu_hud.player_position_hud.player_position",
            "%.2f".formatted(position.x),
            "%.2f".formatted(position.y),
            "%.2f".formatted(position.z)
        );
        Level level = entity.level();
        ResourceKey<Level> dimension = level.dimension();
        if (!(dimension == Level.OVERWORLD || dimension == Level.NETHER) || !GuGuHudRgRules.showPlayerPositionScaled) {
            return this.drawString(currentPosition);
        }
        double scale = dimension == Level.OVERWORLD ? 0.125 : 8;
        String key = dimension != Level.OVERWORLD ? "flat_world_preset.minecraft.overworld" : "advancements.nether.root.title";
        Component scaledPosition = Component.translatable(
            "gugu_hud.player_position_hud.player_position_scaled",
            Component.translatable(key),
            "%.2f".formatted(position.x * scale),
            "%.2f".formatted(position.y),
            "%.2f".formatted(position.z * scale)
        );
        //noinspection NoTranslation
        return this.drawString(
            Component.translatable(
                "%s | %s",
                currentPosition,
                scaledPosition
            )
        );
    }
}
