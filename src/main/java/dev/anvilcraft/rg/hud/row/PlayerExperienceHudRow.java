package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class PlayerExperienceHudRow extends HudRow{
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showPlayerExperience;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        Player player = this.mc().player;
        if(player == null)  return 0;
        return this.drawString(
            Component.translatable(
                "gugu_hud.player_experience_hud.player_experience",
                player.experienceLevel,
                "%.2f".formatted(player.experienceProgress*100),
                player.totalExperience
            )
        );
    }
}
