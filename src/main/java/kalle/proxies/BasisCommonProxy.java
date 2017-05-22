package kalle.proxies;

import kalle.blocks.walls.LeaveWall;
import kalle.recipes.Recipes;
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
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class BasisCommonProxy {
    static final Logger LOG = FMLLog.getLogger();

    public void preInit() {
        LOG.debug("Adding crafting recipes...");
        //TODO is there another event to register recipes?
        Recipes.register();

        // go through all blocks and register color handlers for foliage
        registerColors(Blocks.all);

        LOG.info("All done.");
    }

    public void load() {
        // nothing to do here yet
    }

    public void postInit() {
        // nothing to do here yet
    }

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
}
