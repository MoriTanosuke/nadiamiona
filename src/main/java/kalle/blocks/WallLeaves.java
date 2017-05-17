package kalle.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

import java.util.List;

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
  public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
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
