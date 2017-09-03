package kalle.dimensions;

import kalle.blocks.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLLog;

import java.util.Random;

public class NadiamionaTeleporter extends Teleporter {
    private final Random random;
    private final WorldServer worldServer;

    public NadiamionaTeleporter(WorldServer worldServer) {
        super(worldServer);
        this.worldServer = worldServer;
        this.random = new Random(worldServer.getSeed());
    }

    @Override
    public boolean makePortal(Entity entityIn) {
        BlockPos topBlock = worldServer.getTopSolidOrLiquidBlock(entityIn.getPosition()).down();
        FMLLog.getLogger().info("Creating new Teleporter at {}", topBlock);
        worldServer.setBlockState(topBlock, Blocks.TELEPORTER.getDefaultState());
        worldServer.setBlockState(topBlock.up(), net.minecraft.init.Blocks.AIR.getDefaultState());
        worldServer.setBlockState(topBlock.up().up(), net.minecraft.init.Blocks.AIR.getDefaultState());

        return true;
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        FMLLog.getLogger().info("Placing player in portal");
        makePortal(entityIn);
        placeInExistingPortal(entityIn, rotationYaw);
    }

    @Override
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
        BlockPos topBlock = worldServer.getTopSolidOrLiquidBlock(entityIn.getPosition()).down();
        BlockPos playerPosition = topBlock.up();
        FMLLog.getLogger().info("Placing player at {}", playerPosition);
        ((EntityPlayerMP) entityIn).connection.setPlayerLocation(
                playerPosition.getX(),
                playerPosition.getY(),
                playerPosition.getZ(),
                entityIn.rotationYaw, entityIn.rotationPitch);
        return true;
    }
}