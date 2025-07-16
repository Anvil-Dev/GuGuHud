package dev.anvilcraft.rg.hud;

import com.mojang.logging.LogUtils;
import dev.anvilcraft.rg.hud.row.HudRowManager;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Mod(GuGuHud.MODID)
public class GuGuHud {
    public static final String MODID = "gugu_hud";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GuGuHud(IEventBus modEventBus, ModContainer modContainer) {
        HudRowManager.HUD_ROW_DEFERRED_REGISTER.register(modEventBus);
    }

    public static @NotNull ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(GuGuHud.MODID, path);
    }
}
