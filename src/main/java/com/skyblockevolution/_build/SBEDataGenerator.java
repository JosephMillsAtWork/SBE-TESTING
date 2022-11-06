package com.skyblockevolution._build;

import com.skyblockevolution.world.level.levelgen.presets.SBEWorldPreset;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.tags.WorldPresetTags;

public class SBEDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(
                new FabricTagProvider.DynamicRegistryTagProvider<>(
                        fabricDataGenerator,
                        BuiltinRegistries.WORLD_PRESET.key()
                ) {
            @Override
            protected void generateTags() {
                getOrCreateTagBuilder(WorldPresetTags.NORMAL).add(SBEWorldPreset.SBE_KEY);
            }
        });
    }
}


