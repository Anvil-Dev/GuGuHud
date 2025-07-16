package dev.anvilcraft.rg.hud.event;

import com.mojang.blaze3d.vertex.PoseStack;
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

@EventBusSubscriber(modid = GuGuHud.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ClientEventListener {
    @SubscribeEvent
    public static void onGuiLayerRender(@NotNull RenderGuiLayerEvent.Post event) {
        if (event.getName().compareTo(ResourceLocation.withDefaultNamespace("hotbar")) != 0) return;
        if (!GuGuHudRgRules.showHud) return;
        if (Minecraft.getInstance().options.hideGui && !GuGuHudRgRules.alwaysShow) return;
        GuiGraphics graphics = event.getGuiGraphics();
        DeltaTracker partialTick = event.getPartialTick();
        PoseStack pose = graphics.pose();
        int yOffset = 3;
        for (HudRow row : HudRowManager.HUD_ROW_REGISTRY) {
            if (!row.isVisible()) continue;
            row.setGuiGraphics(graphics);
            row.setDeltaTracker(partialTick);
            pose.pushPose();
            pose.scale(GuGuHudRgRules.fontSize / 10f, GuGuHudRgRules.fontSize / 10f, 1);
            pose.translate(3, yOffset, 0);
            yOffset += row.render(graphics, partialTick);
            pose.popPose();
        }
    }
}
