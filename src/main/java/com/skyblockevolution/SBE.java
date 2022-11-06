package com.skyblockevolution;

import com.skyblockevolution.config.SBEConfigHelper;
import com.skyblockevolution.network.PacketHander;
import com.skyblockevolution.world.level.levelgen.presets.SBEWorldPreset;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SBE implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("sbe");
	public static String MOD_NAME = "skyblockevolution";
	public static String MOD_ID = "sbe";

	public static SBEConfigHelper CONFIGS = new SBEConfigHelper();

	@Override
	public void onInitialize() {
		if (isPhysicalClient()) {
			PacketHander.registerClientListener();
		}
		CONFIGS.initialize();
		SBEWorldPreset.register();
		SBEEvents.init();
	}

	public static boolean isPhysicalClient() {
		return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
	}

	public static boolean isLogicalClient(Level level) {return level.isClientSide;}

	public static boolean isPhysicalServer() {
		return !isPhysicalClient();
	}

	public static boolean isLogicalServer(Level level) {
		return !isLogicalClient(level);
	}

}