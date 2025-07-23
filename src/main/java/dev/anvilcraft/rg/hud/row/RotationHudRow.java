package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class RotationHudRow extends HudRow{
    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showRotationYaw||GuGuHudRgRules.showRotationPitch;
    }

    @Override
    public int render(GuiGraphics guiGraphics, DeltaTracker partialTick) {
        Entity cameraEntity = this.mc().cameraEntity;
        if (cameraEntity == null) return 0;
        MutableComponent result = Component.empty();
        boolean flag = false;
        if(GuGuHudRgRules.showRotationYaw){
            flag = true;
            result.append(
                Component.translatable(
                    "gugu_hud.rotation_hud.rotation_yaw",
                    "%.2f".formatted(Mth.wrapDegrees(cameraEntity.getYRot()))
                )
            );
        }
        if(GuGuHudRgRules.showRotationPitch){
            if(flag) result.append(" | ");
            result.append(
                Component.translatable(
                    "gugu_hud.rotation_hud.rotation_pitch",
                    "%.2f".formatted(cameraEntity.getXRot())
                )
            );
        }
        return this.drawString(result);
    }
}
