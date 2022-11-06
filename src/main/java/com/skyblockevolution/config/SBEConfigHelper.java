package com.skyblockevolution.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
public class SBEConfigHelper {
    public static SBEConfig GEN;
    public void initialize() {
        AutoConfig.register(SBEConfig.class, GsonConfigSerializer::new);
        this.GEN =  AutoConfig.getConfigHolder(SBEConfig.class).getConfig();
    }
    public static String[] spawnCords(){return GEN.spawnCords;}
    public static int mainIslandRadius(){ return GEN.mainIslandRadius;}
    // overworld
    public static boolean acientCity(){ return GEN.GEN_ANCIENT_CITY; }
    public static boolean igloo(){ return GEN.GEN_IGLOO; }
    public static boolean jungleTemple(){ return GEN.GEN_JUNGLE_TEMPLE; }
    public static boolean mineshaft(){ return GEN.GEN_MINESHAFT; }
    public static boolean oceanMonument(){ return GEN.GEN_OCEAN_MONUMENT; }
    public static boolean oceanRuinCold(){ return GEN.GEN_OCEAN_RUIN_COLD; }
    public static boolean oceanRuinWarm(){ return GEN.GEN_OCEAN_RUIN_WARM; }
    public static boolean pillagerOutpost(){ return GEN.GEN_PILLAGER_OUTPOST; }
    public static boolean ruinedPortalDesert(){ return GEN.GEN_RUINED_PORTAL_DESERT; }
    public static boolean ruinedPortalJungle(){ return GEN.GEN_RUINED_PORTAL_JUNGLE; }
    public static boolean ruinedPortalMountain(){ return GEN.GEN_RUINED_PORTAL_MOUNTAIN; }
    public static boolean ruinedPortalOcean(){ return GEN.GEN_RUINED_PORTAL_OCEAN; }
    public static boolean ruinedPortalStandard(){ return GEN.GEN_RUINED_PORTAL_STANDARD; }
    public static boolean ruinedPortalSwamp(){ return GEN.GEN_RUINED_PORTAL_SWAMP; }
    public static boolean witchHut(){ return GEN.GEN_SWAMP_HUT; }
    public static boolean mansion(){ return GEN.GEN_WOODLAND_MANSION; }

    // nether structures
    public static boolean bastions(){ return GEN.GEN_BASTION_REMNANT; }
    public static boolean fort(){ return GEN.GEN_FORTRESS; }
    public static boolean netherFossil(){ return GEN.GEN_NETHER_FOSSIL; }
    public static boolean ruinedPortalNether(){ return GEN.GEN_RUINED_PORTAL_NETHER; }

    // end structures


}
