package dev.anvilcraft.rg.hud;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.lang.reflect.Method;

@Mod(GuGuHud.MODID)
public class GuGuHud {
    public static final String MODID = "gugu_hud";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GuGuHud(IEventBus modEventBus, ModContainer modContainer) throws Exception {
        if (!FMLEnvironment.getDist().isClient()) return;
        Class<?> client = GuGuHud.class.getClassLoader().loadClass("dev.anvilcraft.rg.hud.row.HudRowManager");
        Method method = client.getMethod("register", IEventBus.class);
        method.invoke(null, modEventBus);
    }

    public static @NotNull Identifier of(String path) {
        return Identifier.fromNamespaceAndPath(GuGuHud.MODID, path);
    }
}
