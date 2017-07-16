package kalle.events;

import com.google.common.collect.ImmutableList;
import kalle.items.tools.ItemExcavator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEvents {

    @SubscribeEvent
    public void renderExtraBlockBreak(RenderWorldLastEvent event) {
        PlayerControllerMP controllerMP = Minecraft.getMinecraft().playerController;
        EntityPlayer player = Minecraft.getMinecraft().player;
        World world = player.getEntityWorld();

        ItemStack tool = player.getHeldItemMainhand();

        // AOE preview
        if(!tool.isEmpty()) {
            Entity renderEntity = Minecraft.getMinecraft().getRenderViewEntity();
            if(renderEntity != null) {
                double distance = controllerMP.getBlockReachDistance();
                RayTraceResult mop = renderEntity.rayTrace(distance, event.getPartialTicks());
                if(mop != null) {
                    if(tool.getItem() instanceof ItemExcavator) {
                        ItemExcavator excavator = (ItemExcavator) tool.getItem();
                        int width = excavator.getAoeWidth();
                        int height = excavator.getAoeHeight();
                        int depth = excavator.getAoeDepth();
                        ImmutableList<BlockPos> blocksToBreak = ToolEventHelper.calcAOEBlocks(tool, world, player, mop.getBlockPos(), width, height, depth);
                        for(BlockPos pos : blocksToBreak) {
                            event.getContext().drawSelectionBox(player, new RayTraceResult(new Vec3d(0, 0, 0), null, pos), 0, event.getPartialTicks());
                        }
                    }
                }
            }
        }
    }
}
