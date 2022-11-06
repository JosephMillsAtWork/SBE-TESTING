package com.skyblockevolution.world.level.levelgen;


import blue.endless.jankson.Comment;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Predicate;

import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.Mth;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.DensityFunctions.BeardifierMarker;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;

public class SBEChunkGenerator extends ChunkGenerator {
    public static final Codec<SBEChunkGenerator> CODEC = RecordCodecBuilder.create((instance) -> {
        return commonCodec(instance)
                .and(
                        instance.group(
                                RegistryOps.retrieveRegistry(Registry.NOISE_REGISTRY).forGetter( (SBEChunkGenerator) -> {
                                    return SBEChunkGenerator.noises;
                                }),
                                BiomeSource.CODEC.fieldOf("biome_source")
                                        .forGetter( (SBEChunkGenerator) -> {
                                            return SBEChunkGenerator.biomeSource;
                                        }),
                                NoiseGeneratorSettings.CODEC.fieldOf("settings")
                                        .forGetter( (SBEChunkGenerator) -> {
                                            return SBEChunkGenerator.settings;
                                        })
                        )
                ).apply( instance, instance.stable( SBEChunkGenerator::new ));
    });

    private static final BlockState AIR;
    protected final BlockState defaultBlock;
    private final Registry<NormalNoise.NoiseParameters> noises;
    protected final Holder<NoiseGeneratorSettings> settings;

    public SBEChunkGenerator(Registry<StructureSet> registry,
                             Registry<NormalNoise.NoiseParameters> registry2,
                             BiomeSource biomeSource,
                             Holder<NoiseGeneratorSettings> holder)
    {
        super(registry, Optional.empty(), biomeSource);
        this.noises = registry2;
        this.settings = holder;
        NoiseGeneratorSettings noiseGeneratorSettings = this.settings.value();
        this.defaultBlock = noiseGeneratorSettings.defaultBlock();

    }

    @Override
    public int getGenDepth() {
        return this.settings.value().noiseSettings().height();
    }

    @Override
    public int getSeaLevel() {
        return this.settings.value().seaLevel();
    }

    @Override
    public int getMinY() {
        return this.settings.value().noiseSettings().minY();
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void addDebugScreenInfo(List<String> list, RandomState randomState, BlockPos blockPos) {
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        NoiseRouter noiseRouter = randomState.router();
        DensityFunction.SinglePointContext singlePointContext = new DensityFunction.SinglePointContext(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        double d = noiseRouter.ridges().compute(singlePointContext);
        list.add("SBEGenerator"
                + " T: " + decimalFormat.format(noiseRouter.temperature().compute(singlePointContext))
                + " V: "  + decimalFormat.format(noiseRouter.vegetation().compute(singlePointContext))
                + " C: "  + decimalFormat.format(noiseRouter.continents().compute(singlePointContext))
                + " E: "  + decimalFormat.format(noiseRouter.erosion().compute(singlePointContext))
                + " D: "  + decimalFormat.format(noiseRouter.depth().compute(singlePointContext))
                + " W: "  + decimalFormat.format(d)
                + " PV: " + decimalFormat.format((double) NoiseRouterData.peaksAndValleys((float) d))
                + " AS: " + decimalFormat.format(noiseRouter.initialDensityWithoutJaggedness().compute(singlePointContext))
                + " N: "  + decimalFormat.format(noiseRouter.finalDensity().compute(singlePointContext)));
    }


    ///////////////////////////////
    // NOISE AND HEIGHTMAP || MIGHT CAUSE ISSUES TEST
    ///////////////////////////////
    @Override
    public int getBaseHeight(int i, int j, Types types, LevelHeightAccessor levelHeightAccessor, RandomState randomState) {
        return this.settings.value().noiseSettings().height();
    }
    @Override
    public NoiseColumn getBaseColumn(int i, int j, LevelHeightAccessor levelHeightAccessor, RandomState randomState) {
        return new NoiseColumn(0, new BlockState[0]);
    }

    ////////////////////////////
    // CAVES (DO NOTHING)
    ////////////////////////
    @Override
    public void applyCarvers(WorldGenRegion worldGenRegion, long l, RandomState randomState, BiomeManager biomeManager,
                             StructureManager structureManager, ChunkAccess chunkAccess, GenerationStep.Carving carving) {
    }

    ///////////////////////////////
    // SURFACE (DO NOTHING)
    ///////////////////////////////
    @Override
    public void buildSurface(WorldGenRegion worldGenRegion, StructureManager structureManager, RandomState randomState, ChunkAccess chunkAccess) {}


    ////////////////////////////////
    // FILL HEIGHTMAP (DO ALMOST NOTHING)
    ///////////////////////////////
    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState randomState,
                                                        StructureManager structureManager, ChunkAccess chunkAccess)
    {
        return CompletableFuture.completedFuture(chunkAccess);
    }

    ///////////////////////////////
    // MOBS
    ///////////////////////////////
    @Override
    public void spawnOriginalMobs(WorldGenRegion worldGenRegion) {
        if (!((NoiseGeneratorSettings) this.settings.value()).disableMobGeneration()) {
            ChunkPos chunkPos = worldGenRegion.getCenter();
            Holder<Biome> holder = worldGenRegion.getBiome(chunkPos.getWorldPosition().atY(worldGenRegion.getMaxBuildHeight() - 1));
            WorldgenRandom worldgenRandom = new WorldgenRandom(new LegacyRandomSource(RandomSupport.generateUniqueSeed()));
            worldgenRandom.setDecorationSeed(worldGenRegion.getSeed(), chunkPos.getMinBlockX(), chunkPos.getMinBlockZ());
            NaturalSpawner.spawnMobsForChunkGeneration(worldGenRegion, holder, chunkPos, worldgenRandom);
        }
    }


    static {
        AIR = Blocks.AIR.defaultBlockState();
    }

    public Holder<NoiseGeneratorSettings> generatorSettings() {
        return this.settings;
    }

}


