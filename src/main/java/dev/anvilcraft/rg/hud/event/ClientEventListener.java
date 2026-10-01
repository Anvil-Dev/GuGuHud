package dev.anvilcraft.rg.hud.event;

import org.joml.Matrix3x2fStack;
import dev.anvilcraft.rg.hud.GuGuHud;
import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import dev.anvilcraft.rg.hud.row.HudRow;
import dev.anvilcraft.rg.hud.row.HudRowManager;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber(modid = GuGuHud.MODID)
public class ClientEventListener {
    @SubscribeEvent
    public static void onGuiLayerRender(@NotNull RenderGuiLayerEvent.Post event) {
        if (event.getName().compareTo(ResourceLocation.withDefaultNamespace("hotbar")) != 0) return;
        if (!GuGuHudRgRules.showHud) return;
        if (Minecraft.getInstance().options.hideGui && !GuGuHudRgRules.alwaysShow) return;
        GuiGraphics graphics = event.getGuiGraphics();
        DeltaTracker partialTick = event.getPartialTick();
        Matrix3x2fStack pose = graphics.pose();
        int yOffset = 3;
        for (HudRow row : HudRowManager.HUD_ROW_REGISTRY) {
            if (!row.isVisible()) continue;
            row.setGuiGraphics(graphics);
            row.setDeltaTracker(partialTick);
            pose.pushMatrix();
            pose.scale(GuGuHudRgRules.fontSize / 10f, GuGuHudRgRules.fontSize / 10f);
            pose.translate(3, yOffset);
            yOffset += row.render(graphics, partialTick);
            pose.popMatrix();
        }
    }
}
