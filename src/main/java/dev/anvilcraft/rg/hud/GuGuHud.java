package dev.anvilcraft.rg.hud;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.lang.reflect.Method;

@Mod(GuGuHud.MODID)
public class GuGuHud {
    public static final String MODID = "gugu_hud";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GuGuHud(IEventBus modEventBus, ModContainer modContainer) throws Exception {
        if (FMLLoader.getDist() != Dist.CLIENT) return;
        Class<?> client = GuGuHud.class.getClassLoader().loadClass("dev.anvilcraft.rg.hud.row.HudRowManager");
        Method method = client.getMethod("register", IEventBus.class);
        method.invoke(null, modEventBus);
    }

    public static @NotNull ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(GuGuHud.MODID, path);
    }
}
