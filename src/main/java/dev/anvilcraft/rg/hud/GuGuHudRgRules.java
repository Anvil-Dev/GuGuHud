package dev.anvilcraft.rg.hud;

import dev.anvilcraft.rg.api.Rule;
import dev.anvilcraft.rg.api.client.RGClientRules;

@RGClientRules
public class GuGuHudRgRules {
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showHud = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean alwaysShow = false;
    @Rule(
        categories = GuGuHud.MODID,
        min = "1",
        max = "20"
    )
    public static int fontSize = 8;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showFPS = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showTPS = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showMoonPhase = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showMemory = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showGameDayTime = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static String gameDayTimeFormat = "{Days} Day(s)-{Hours}:{Minutes}";
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showRealTime = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static String realTimeFormat = "yyyy-MM-dd hh:mm:ss";
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showGameTime = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showPlayerPosition = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showPlayerPositionScaled = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showDimensionID = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showBlockPosition = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showChunkPosition = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showBlockInChunkPosition = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showPlayerFacing = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showRotationYaw = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showRotationPitch = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static boolean showPlayerExperience = false;
}
