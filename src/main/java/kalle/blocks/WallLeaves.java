package kalle.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockWall;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

public class WallLeaves extends Wall implements IShearable {

  @SideOnly(Side.CLIENT)
  private boolean isTransparent;

  public WallLeaves(CreativeTabs tab, Block modelBlock, String unlocalizedName) {
    super(tab, modelBlock, unlocalizedName);
    setHardness(0.2F);
    setLightOpacity(1);
    setGraphicsLevel(true);
  }

  @SideOnly(Side.CLIENT)
  public void setGraphicsLevel(boolean fancy) {
    isTransparent = fancy;
  }

  @Override
  public boolean isLeaves(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
    return true;
  }

  @Override
  public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
    return true;
  }

  @Override
  public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
    return Arrays.asList(new Object[] { new ItemStack(this) });
  }
}
