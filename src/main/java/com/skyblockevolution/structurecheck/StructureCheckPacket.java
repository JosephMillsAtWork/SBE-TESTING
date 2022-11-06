package com.skyblockevolution.structurecheck;

import com.skyblockevolution.SBE;
import com.skyblockevolution.network.AbstractPacket;
import com.skyblockevolution.network.PacketHander;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.advancements.critereon.LocationPredicate;

public class StructureCheckPacket extends AbstractPacket {
    private static final ResourceLocation ID = new ResourceLocation(SBE.MOD_NAME + ":structurecheck");

    @Override
    public ResourceLocation getIdentifier() {
        return ID;
    }

    @Override
    public void executeOnClient( Minecraft client,
                                ClientGamePacketListener handler,
                                FriendlyByteBuf buf,
                                PacketSender responseSender) {
        final ClientStructureTracker.SupportedStructures structure = buf.readEnum(ClientStructureTracker.SupportedStructures.class);
        client.execute(() -> {
            ClientStructureTracker.structure = structure;
        });
    }

    @Override
    public void executeOnServer(
            MinecraftServer server, ServerPlayer player, ServerGamePacketListenerImpl handler,
            FriendlyByteBuf buf, PacketSender responseSender )
    {
        server.execute(() -> {
            ClientStructureTracker.SupportedStructures structure = LocationPredicate.inStructure(BuiltinStructures.FORTRESS)
                    .matches( (ServerLevel) player.level, player.position().x, player.position().y, player.position().z ) ?
                    ClientStructureTracker.SupportedStructures.FORTRESS :
                    ClientStructureTracker.SupportedStructures.NONE;

            if (structure == ClientStructureTracker.SupportedStructures.NONE) {
                structure = LocationPredicate.inStructure(BuiltinStructures.OCEAN_MONUMENT).matches(
                        (ServerLevel)player.level, player.position().x, player.position().y, player.position().z) ?
                        ClientStructureTracker.SupportedStructures.OCEAN_MONUMENT :
                        ClientStructureTracker.SupportedStructures.NONE;

                if (structure == ClientStructureTracker.SupportedStructures.NONE) {
                    structure = LocationPredicate.inStructure(BuiltinStructures.SWAMP_HUT).matches(
                            (ServerLevel) player.level, player.position().x, player.position().y, player.position().z) ?
                            ClientStructureTracker.SupportedStructures.SWAMP_HUT :
                            ClientStructureTracker.SupportedStructures.NONE;

                    if (structure == ClientStructureTracker.SupportedStructures.NONE) {
                        structure = LocationPredicate.inStructure(BuiltinStructures.PILLAGER_OUTPOST).matches(
                                (ServerLevel) player.level,player.position().x, player.position().y, player.position().z) ?
                                ClientStructureTracker.SupportedStructures.PILLAGER_OUTPOST :
                                ClientStructureTracker.SupportedStructures.NONE;

                        if (structure == ClientStructureTracker.SupportedStructures.NONE) {
                            structure = LocationPredicate.inStructure(BuiltinStructures.ANCIENT_CITY).matches(
                                    (ServerLevel) player.level,player.position().x, player.position().y, player.position().z) ?
                                    ClientStructureTracker.SupportedStructures.ANCIENT_CITY :
                                    ClientStructureTracker.SupportedStructures.NONE;

                            if (structure == ClientStructureTracker.SupportedStructures.NONE) {
                                structure = LocationPredicate.inStructure(BuiltinStructures.RUINED_PORTAL_OCEAN).matches(
                                        (ServerLevel) player.level, player.position().x, player.position().y, player.position().z) ?
                                        ClientStructureTracker.SupportedStructures.RUINED_PORTAL_OCEAN :
                                        ClientStructureTracker.SupportedStructures.NONE;



//                                WOODLAND_MANSION

                            } //RUINED_PORTAL_OCEAN
                        } // ANCIENT_CITY
                    } // PILLAGER_OUTPOST
                } // SWAMP_HUT
            }//OCEAN_MONUMENT

            FriendlyByteBuf responseBuffer = PacketByteBufs.create();
            responseBuffer.writeEnum(structure);
            PacketHander.sendTo(player, getIdentifier(), responseBuffer);
        });
    }
}
