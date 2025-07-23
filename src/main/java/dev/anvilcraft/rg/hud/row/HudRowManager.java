package dev.anvilcraft.rg.hud.row;

import dev.anvilcraft.rg.hud.GuGuHud;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = GuGuHud.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HudRowManager {
    public static final ResourceKey<Registry<HudRow>> HUD_ROWS = ResourceKey.createRegistryKey(GuGuHud.of("hud_rows"));
    public static final Registry<HudRow> HUD_ROW_REGISTRY = new RegistryBuilder<>(HUD_ROWS)
        .sync(false)
        .maxId(256)
        .create();

    public static final DeferredRegister<HudRow> HUD_ROW_DEFERRED_REGISTER = DeferredRegister.create(HUD_ROWS, GuGuHud.MODID);

    public static final Supplier<HudRow> MEMORY_HUD_ROW = HUD_ROW_DEFERRED_REGISTER.register("memory", MemoryHudRow::new);
    public static final Supplier<HudRow> FPS_HUD_ROW = HUD_ROW_DEFERRED_REGISTER.register("fps", FPSHudRow::new);
    public static final Supplier<HudRow> TPS_HUD_ROW = HUD_ROW_DEFERRED_REGISTER.register("tps", TPSHudRow::new);
    public static final Supplier<HudRow> MOON_PHASE_ROW = HUD_ROW_DEFERRED_REGISTER.register("moon_phase", MoonPhaseHudRow::new);
    public static final Supplier<HudRow> GAME_DAY_TIME_HUD_ROW = HUD_ROW_DEFERRED_REGISTER.register("game_day_time", GameDayTimeHudRow::new);
    public static final Supplier<HudRow> REAL_TIME_ROW = HUD_ROW_DEFERRED_REGISTER.register("real_time", RealTimeHudRow::new);
    public static final Supplier<HudRow> GAME_TIME_ROW = HUD_ROW_DEFERRED_REGISTER.register("game_time", GameTimeHudRow::new);
    public static final Supplier<HudRow> PLAYER_POSITION_ROW = HUD_ROW_DEFERRED_REGISTER.register("player_position", PlayerPositionHudRow::new);
    public static final Supplier<HudRow> DIMENSION_ID_ROW = HUD_ROW_DEFERRED_REGISTER.register("dimension_id", DimensionIDHudRow::new);
    public static final Supplier<HudRow> BLOCK_POSITION_ROW = HUD_ROW_DEFERRED_REGISTER.register("block_position", BlockPositionHudRow::new);
    public static final Supplier<HudRow> PLAYER_FACING_ROW = HUD_ROW_DEFERRED_REGISTER.register("player_facing", PlayerFacingHudRow::new);

    @SubscribeEvent
    public static void registerRegistries(@NotNull NewRegistryEvent event) {
        event.register(HUD_ROW_REGISTRY);
    }

    public static void register(IEventBus bus) {
        HUD_ROW_DEFERRED_REGISTER.register(bus);
    }
}
