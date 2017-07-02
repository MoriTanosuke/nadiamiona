package kalle.proxies;

import kalle.blocks.Blocks;
import kalle.blocks.walls.LeaveWall;
import kalle.events.RenderEvents;
import kalle.events.ToolEvents;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BasisClientProxy extends BasisCommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
        LOG.info("Registering color handlers...");
        registerColors(Blocks.all);
        LOG.info("Color handlers registered.");

        LOG.info("Registering tool event handlers...");
        final ToolEvents toolEvents = new ToolEvents();
        MinecraftForge.EVENT_BUS.register(toolEvents);

        RenderEvents renderEvents = new RenderEvents();
        MinecraftForge.EVENT_BUS.register(renderEvents);
        LOG.info("Tool event handlers registered.");
    }

    @SideOnly(Side.CLIENT)
    private void registerColors(Block... blocks) {
        // register color handlers for foliage blocks
        for (Block block : blocks) {
            if (block instanceof LeaveWall) {
                registerColor(block);
            }
        }
    }

    /**
     * Registers a color handler for the given block.
     *
     * @param foliageBlock block to color as foliage
     */
    private static void registerColor(final Block foliageBlock) {
        FMLLog.getLogger().debug("Registering color for block " + foliageBlock);
        final BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
        blockColors.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess blockAccess, @Nullable BlockPos pos, int tintIndex) {
                return blockAccess != null && pos != null ? BiomeColorHelper.getFoliageColorAtPos(blockAccess, pos) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, foliageBlock);
        final ItemColors itemColors = Minecraft.getMinecraft().getItemColors();
        itemColors.registerItemColorHandler(new IItemColor() {
            @Override
            public int getColorFromItemstack(ItemStack stack, int tintIndex) {
                IBlockState iblockstate = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                return blockColors.colorMultiplier(iblockstate, (IBlockAccess) null, (BlockPos) null, tintIndex);
            }
        }, foliageBlock);
    }

    @Override
    public void postInit() {
        super.postInit();
    }

}