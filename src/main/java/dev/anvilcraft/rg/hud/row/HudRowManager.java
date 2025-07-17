package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHud;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@EventBusSubscriber(modid = GuGuHud.MODID, bus = EventBusSubscriber.Bus.MOD)
public class HudRowManager {
    public static final ResourceKey<Registry<HudRow>> HUD_ROWS = ResourceKey.createRegistryKey(GuGuHud.of("hud_rows"));
    public static final Registry<HudRow> HUD_ROW_REGISTRY = new RegistryBuilder<>(HUD_ROWS)
        .sync(false)
        .maxId(256)
        .create();

    public static final DeferredRegister<HudRow> HUD_ROW_DEFERRED_REGISTER = DeferredRegister.create(HUD_ROWS, GuGuHud.MODID);

    public static final Supplier<HudRow> FPS_HUD_ROW = HUD_ROW_DEFERRED_REGISTER.register("fps", FPSHudRow::new);
    public static final Supplier<HudRow> TPS_HUD_ROW = HUD_ROW_DEFERRED_REGISTER.register("tps", TPSHudRow::new);
    public static final Supplier<HudRow> GAME_DAY_TIME_HUD_ROW = HUD_ROW_DEFERRED_REGISTER.register("game_day_time", GameDayTimeHudRow::new);
    public static final Supplier<HudRow> MOON_PHASE_ROW = HUD_ROW_DEFERRED_REGISTER.register("moon_phase",MoonPhaseHudRow::new);

    @SubscribeEvent
    public static void registerRegistries(@NotNull NewRegistryEvent event) {
        event.register(HUD_ROW_REGISTRY);
    }
}
