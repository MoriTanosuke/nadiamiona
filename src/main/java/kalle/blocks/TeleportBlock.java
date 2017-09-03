package kalle.blocks;

import kalle.dimensions.Dimensions;
import kalle.dimensions.NadiamionaTeleporter;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLLog;

public class TeleportBlock extends BlockBase {
    public TeleportBlock() {
        super("teleporter", Material.GLASS);
    }
    //TODO make the player teleport between NadiamionaDimension and current dimension

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer entityIn) {
        if (!entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && !worldIn.isRemote) {
            FMLLog.getLogger().info("Entity {} is in dimension {}, world is {}remote", entityIn, entityIn.dimension, (worldIn.isRemote ? "" : "not "));
            if (entityIn.dimension == DimensionType.OVERWORLD.getId()) {

                FMLLog.getLogger().info("Teleporting into dimension...");
                MinecraftServer minecraftserver = entityIn.getServer();
                WorldServer worldserver1 = minecraftserver.worldServerForDimension(Dimensions.DIMENSION_ID);
                minecraftserver.getPlayerList().transferPlayerToDimension((EntityPlayerMP) entityIn, Dimensions.DIMENSION_ID, new NadiamionaTeleporter(worldserver1));
            } else {
                MinecraftServer minecraftserver = entityIn.getServer();
                FMLLog.getLogger().info("Returning to overworld...");
                WorldServer worldserver1 = minecraftserver.worldServerForDimension(DimensionType.OVERWORLD.getId());
                minecraftserver.getPlayerList().transferPlayerToDimension((EntityPlayerMP) entityIn, DimensionType.OVERWORLD.getId(), new NadiamionaTeleporter(worldserver1));
            }
        }
    }
}
