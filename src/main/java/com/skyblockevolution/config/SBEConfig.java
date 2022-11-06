package com.skyblockevolution.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "skyblockevolution" )
public class SBEConfig implements ConfigData {
    @Comment("Where to spawn the player")
    public String[] spawnCords  = {"0","64","0"};
    public static int mainIslandRadius = 8;
    public static boolean GEN_ANCIENT_CITY            = true;
    public static boolean GEN_BASTION_REMNANT         = true;
    public static boolean GEN_BURIED_TREASURE         = false; // TODO
    public static boolean GEN_DESERT_PYRAMID          = false; // TODO
    public static boolean GEN_END_CITY                = true;  // TODO
    public static boolean GEN_FORTRESS                = true;
    public static boolean GEN_IGLOO                   = true;
    public static boolean GEN_JUNGLE_TEMPLE           = true;
    public static boolean GEN_MINESHAFT               = true;
    public static boolean GEN_MINESHAFT_MESA          = false; // TODO
    public static boolean GEN_NETHER_FOSSIL           = true;
    public static boolean GEN_OCEAN_MONUMENT          = true;
    public static boolean GEN_OCEAN_RUIN_COLD         = true;
    public static boolean GEN_OCEAN_RUIN_WARM         = true;
    public static boolean GEN_PILLAGER_OUTPOST        = true;
    public static boolean GEN_RUINED_PORTAL_DESERT    = true;
    public static boolean GEN_RUINED_PORTAL_JUNGLE    = true;
    public static boolean GEN_RUINED_PORTAL_MOUNTAIN  = true;
    public static boolean GEN_RUINED_PORTAL_NETHER    = true;
    public static boolean GEN_RUINED_PORTAL_OCEAN     = true;
    public static boolean GEN_RUINED_PORTAL_STANDARD  = true;
    public static boolean GEN_RUINED_PORTAL_SWAMP     = true;
    public static boolean GEN_SHIPWRECK               = false; // TODO
    public static boolean GEN_SHIPWRECK_BEACHED       = false; // TODO
    public static boolean GEN_STRONGHOLD              = true;  // TODO
    public static boolean GEN_SWAMP_HUT               = true;
    public static boolean GEN_VILLAGE_DESERT          = false; // TODO
    public static boolean GEN_VILLAGE_PLAINS          = false; // TODO
    public static boolean GEN_VILLAGE_SAVANNA         = false; // TODO
    public static boolean GEN_VILLAGE_SNOWY           = false; // TODO
    public static boolean GEN_VILLAGE_TAIGA           = false; // TODO
    public static boolean GEN_WOODLAND_MANSION        = true;
}
