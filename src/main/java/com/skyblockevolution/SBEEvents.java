package com.skyblockevolution;

import com.skyblockevolution.network.PacketHander;
import com.skyblockevolution.world.level.levelgen.SBEChunkGenerator;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.structures.OceanRuinStructure;

public class SBEEvents {
    public static boolean isServerSBE = false;
    public static boolean isClientSBE = false;

    public static void init() {
        onServerWorldLoad();
        onServerPlayerJoin();
    }

    private static void onServerWorldLoad() {
        ServerWorldEvents.LOAD.register((server, level) -> {
            ChunkGenerator chunkGenerator = level.getChunkSource().getGenerator();
            isServerSBE = chunkGenerator instanceof SBEChunkGenerator;
            if (SBE.isLogicalServer(level) && isServerSBE) {
                PacketHander.registerServerListener();
            }
        });
    }

    private static void onServerPlayerJoin() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            if (server.overworld().getChunkSource().getGenerator() instanceof SBEChunkGenerator) {
                PacketHander.sendTo(handler.getPlayer(), PacketHander.WORLDTYPE_PACKET.getIdentifier(), PacketByteBufs.empty());
                spawnPlayer(handler.getPlayer());
            }
        });

    }

    private static void spawnPlayer(ServerPlayer player) {
        SBESavedData savedData = SBESavedData.get((ServerLevel)player.level );
//        if (!savedData.generated && !SBE.CONFIGS.GENERAL.spwanCords.equals("0,64,0")) {
//            String spawnPos =  SBE.CONFIGS.GENERAL.spwanCords;
//            String[] configPos = spawnPos.split(",");
//            double[] pos = new double[3];
//            try {
//                pos[0] = Double.parseDouble(configPos[0]);
//                pos[1] = Double.parseDouble(configPos[1]);
//                pos[2] = Double.parseDouble(configPos[2]);
//            } catch (Exception ex) {
        double[] pos = new double[] { 0, 64, 0 };
//            }

            player.teleportTo(pos[0]+0.5, pos[1]+1.6, pos[2]+0.5);
            player.setRespawnPosition(
                    player.level.dimension(),
                    new BlockPos(
                            pos[0]+0.5,
                            pos[1]+1.6,
                            pos[2]+0.5
                    ),
                    0,
                    true,
                    false
            );
        }
    }
//}
