package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHudRgRules;
import dev.anvilcraft.rg.hud.mixin.PlayerTabOverlayAccessor;
import net.minecraft.ChatFormatting;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerTickRateManager;
import net.minecraft.util.TimeUtil;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("resource")
public class TPSHudRow extends HudRow {
    public static final Component NO_DATA = Component.translatable("gugu_hud.tps_hud.no_data");

    @Override
    public boolean isVisible() {
        return GuGuHudRgRules.showTPS;
    }

    @Override
    public int render(@NotNull GuiGraphics guiGraphics, DeltaTracker partialTick) {
        boolean singleplayer = this.mc().isSingleplayer();
        Component text = singleplayer ? singleplayerTPS() : multiplayerTPS();
        return this.drawString(text);
    }

    private Component singleplayerTPS() {
        MinecraftServer server = this.mc().getSingleplayerServer();
        if (server == null) return NO_DATA;
        double MSPT = ((double) server.getAverageTickTimeNanos()) / TimeUtil.NANOSECONDS_PER_MILLISECOND;
        ServerTickRateManager trm = server.tickRateManager();
        double TPS = 1000.0D / Math.max(trm.isSprinting() ? 0.0 : trm.millisecondsPerTick(), MSPT);
        ChatFormatting tpsColor = TPSHudRow.heatmapColor(MSPT, trm.millisecondsPerTick());
        return Component.translatable(
            "gugu_hud.tps_hud.format",
            Component.literal("%.1f".formatted(TPS)).withStyle(tpsColor),
            Component.literal("%.1f".formatted(MSPT)).withStyle(tpsColor)
        );
    }

    private Component multiplayerTPS() {
        Component footer = ((PlayerTabOverlayAccessor) this.mc().gui.getTabList()).getFooter();
        for (Component sibling : footer.getSiblings()) {
            if (!(sibling instanceof MutableComponent mutableComponent)) continue;
            ComponentContents contents = mutableComponent.getContents();
            if (!(contents instanceof TranslatableContents contents1)) continue;
            if (!"tab.bettertab.tps".contains(contents1.getKey()) || !"TPS: %s MSPT: %s".equals(contents1.getFallback())) continue;
            return Component.translatable(
                "gugu_hud.tps_hud.format",
                contents1.getArgs()[0],
                contents1.getArgs()[1]
            );
        }
        return NO_DATA;
    }

    static ChatFormatting heatmapColor(double actual, double reference) {
        ChatFormatting color = ChatFormatting.GRAY;
        if (actual >= 0.0D) color = ChatFormatting.DARK_GREEN;
        if (actual > 0.5D * reference) color = ChatFormatting.YELLOW;
        if (actual > 0.8D * reference) color = ChatFormatting.RED;
        if (actual > reference) color = ChatFormatting.LIGHT_PURPLE;
        return color;
    }
}
