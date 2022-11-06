package com.skyblockevolution.world.level.levelgen.presets;

import com.skyblockevolution.SBE;
import com.skyblockevolution.world.level.levelgen.SBEChunkGenerator;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPreset;


import java.util.Map;
// FABRIC CLASS
public class SBEWorldPreset {

    public static final ResourceKey<WorldPreset> SBE_KEY = ResourceKey.create(
            Registry.WORLD_PRESET_REGISTRY, new ResourceLocation(SBE.MOD_NAME, SBE.MOD_ID )
    );

    public static void register() {
        // register the preset
        BuiltinRegistries.register(
                BuiltinRegistries.WORLD_PRESET,
                SBE_KEY,
                build()
        );
        Registry.register(
                Registry.CHUNK_GENERATOR,
                new ResourceLocation( SBE.MOD_NAME, "sbegenerator" ),
                SBEChunkGenerator.CODEC
        );
    }

    private static WorldPreset build() {
        return new WorldPreset(
                Map.of(
                        LevelStem.OVERWORLD, new LevelStem(
                                BuiltinRegistries.DIMENSION_TYPE.getOrCreateHolderOrThrow(BuiltinDimensionTypes.OVERWORLD ),
                                overworldChunkGenerator()
                        ),
                        LevelStem.NETHER, new LevelStem(
                                BuiltinRegistries.DIMENSION_TYPE.getOrCreateHolderOrThrow(BuiltinDimensionTypes.NETHER),
                                netherChunkGenerator()
                        ),
                        LevelStem.END, new LevelStem(
                                BuiltinRegistries.DIMENSION_TYPE.getOrCreateHolderOrThrow(BuiltinDimensionTypes.END),
                                endChunkGenerator()
                        )
                )
        );
    }

    private static ChunkGenerator overworldChunkGenerator() {
        boolean CUSTOM_OVERWORLD = true;
        return CUSTOM_OVERWORLD ? new SBEChunkGenerator(
                BuiltinRegistries.STRUCTURE_SETS,
                BuiltinRegistries.NOISE,
                MultiNoiseBiomeSource.Preset.OVERWORLD.biomeSource(BuiltinRegistries.BIOME),
                BuiltinRegistries.NOISE_GENERATOR_SETTINGS.getOrCreateHolderOrThrow(NoiseGeneratorSettings.OVERWORLD )
        ) : new NoiseBasedChunkGenerator(
                BuiltinRegistries.STRUCTURE_SETS,
                BuiltinRegistries.NOISE,
                MultiNoiseBiomeSource.Preset.OVERWORLD.biomeSource(BuiltinRegistries.BIOME),
                BuiltinRegistries.NOISE_GENERATOR_SETTINGS.getOrCreateHolderOrThrow(NoiseGeneratorSettings.OVERWORLD )
        );
    }

    private static ChunkGenerator netherChunkGenerator() {
        boolean CUSTOM_NETHER = true; //SBEConfigHelper.customNetherGenerator();
        return CUSTOM_NETHER ? new SBEChunkGenerator(
                BuiltinRegistries.STRUCTURE_SETS,
                BuiltinRegistries.NOISE,
                MultiNoiseBiomeSource.Preset.NETHER.biomeSource(BuiltinRegistries.BIOME),
                BuiltinRegistries.NOISE_GENERATOR_SETTINGS.getOrCreateHolderOrThrow(NoiseGeneratorSettings.NETHER )
        ) : new NoiseBasedChunkGenerator(
                BuiltinRegistries.STRUCTURE_SETS,
                BuiltinRegistries.NOISE,
                MultiNoiseBiomeSource.Preset.NETHER.biomeSource(BuiltinRegistries.BIOME),
                BuiltinRegistries.NOISE_GENERATOR_SETTINGS.getOrCreateHolderOrThrow( NoiseGeneratorSettings.NETHER)
        );
    }

    // FIXME figure out what to do with the end lol
    private static ChunkGenerator endChunkGenerator() {
        boolean CUSTOM_END = false;
        return CUSTOM_END ? new SBEChunkGenerator(
                BuiltinRegistries.STRUCTURE_SETS,
                BuiltinRegistries.NOISE,
                new TheEndBiomeSource(BuiltinRegistries.BIOME),
                BuiltinRegistries.NOISE_GENERATOR_SETTINGS.getOrCreateHolderOrThrow( NoiseGeneratorSettings.END )
        ) : new NoiseBasedChunkGenerator(
                BuiltinRegistries.STRUCTURE_SETS,
                BuiltinRegistries.NOISE,
                new TheEndBiomeSource(BuiltinRegistries.BIOME), // FIX THIS
                BuiltinRegistries.NOISE_GENERATOR_SETTINGS.getOrCreateHolderOrThrow(NoiseGeneratorSettings.END)
        );
    }
}
