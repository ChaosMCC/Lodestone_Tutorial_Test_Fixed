package net.chaosmcc.tutorialmod.custome.packets;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier PARTICLE_SPAWN_ID = new Identifier("tutorialmod", "particle_spawn");

    public static void registerPackets() {
        ServerPlayNetworking.registerGlobalReceiver(PARTICLE_SPAWN_ID, (server, player, handler, buf, responseSender) -> {
            ParticleSpawnPacket packet = new ParticleSpawnPacket(buf);
            server.execute(() -> {
                // Server-side handling if needed
            });
        });
    }
}

