package com.skyblockevolution;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class SBESavedData extends SavedData {
    private static final String NAME =  SBE.MOD_ID;
    private static final String GENERATED_KEY = "generated";

    public boolean generated;

    public SBESavedData() {
        generated = false;
    }

    public static SBESavedData get(ServerLevel world) {
        return world.getServer().overworld().getDataStorage().computeIfAbsent(
                SBESavedData::readNbt,
                SBESavedData::new,
                NAME
        );
    }

    private static SBESavedData readNbt(CompoundTag nbt) {
        SBESavedData savedData = new SBESavedData();
        savedData.generated = nbt.getBoolean(GENERATED_KEY);
        return savedData;
    }

    @Override
    public CompoundTag save(CompoundTag nbt) {
        nbt.putBoolean(GENERATED_KEY, true);
        return nbt;
    }

    public void setGenerated() {
        generated = true;
        this.setDirty();
    }
}
