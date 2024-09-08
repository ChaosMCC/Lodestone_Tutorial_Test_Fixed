package net.chaosmcc.tutorialmod.custome.packets;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;

import java.awt.*;

public class ParticleSpawnPacket {
    private final Vec3d position;
    private final int startingColor;
    private final int endingColor;

    public ParticleSpawnPacket(Vec3d position, int startingColor, int endingColor) {
        this.position = position;
        this.startingColor = startingColor;
        this.endingColor = endingColor;
    }

    public ParticleSpawnPacket(PacketByteBuf buf) {
        this.position = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
        this.startingColor = buf.readInt();
        this.endingColor = buf.readInt();
    }

    public void toBytes(PacketByteBuf buf) {
        buf.writeDouble(position.x);
        buf.writeDouble(position.y);
        buf.writeDouble(position.z);
        buf.writeInt(startingColor);
        buf.writeInt(endingColor);
    }

    public void handle(MinecraftClient client) {
        client.execute(() -> {
            World level = client.world;
            if (level != null) {
                Color startColor = new Color(startingColor);
                Color endColor = new Color(endingColor);
                spawnExampleParticles(level, position, startColor, endColor);
            }
        });
    }

    public static void spawnExampleParticles(World level, Vec3d pos, Color startingColor, Color endingColor) {
        WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
                .setScaleData(GenericParticleData.create(2f, 1f,0f).build())
                .setTransparencyData(GenericParticleData.create(2f).build())
                .setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.ELASTIC_IN).build())
                .setLifetime(20)
                .addMotion(0, 0.01f, 0)
                .enableNoClip()
                .spawn(level, pos.x, pos.y +1 , pos.z);


    }
}