package com.skyblockevolution.network;

import com.skyblockevolution.SBE;
import com.skyblockevolution.SBEEvents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

public class SBEPacket extends AbstractPacket {
    private static final ResourceLocation IDENTIFIER = new ResourceLocation(SBE.MOD_NAME + ":worldtype");

    @Override
    public ResourceLocation getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void executeOnClient(Minecraft client,
                                ClientGamePacketListener handler,
                                FriendlyByteBuf buf,
                                PacketSender responseSender)
    {
        client.execute(() -> {
            SBEEvents.isClientSBE = true;
        });
    }

    @Override
    public void executeOnServer(MinecraftServer server,
                                ServerPlayer player,
                                ServerGamePacketListenerImpl handler,
                                FriendlyByteBuf buf,
                                PacketSender responseSender)
    {

    }
}
