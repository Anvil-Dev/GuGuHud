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
    public static boolean showGameDayTime = false;
    @Rule(
        categories = GuGuHud.MODID
    )
    public static String gameDayTimeFormat = "{Days} days-{Hours}:{Minutes}";
}
