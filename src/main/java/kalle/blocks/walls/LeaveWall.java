package kalle.blocks.walls;

import kalle.blocks.BlockWallBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.actors.threadpool.Arrays;

import java.util.List;

public class LeaveWall extends BlockWallBase implements IShearable {

  @SideOnly(Side.CLIENT)
  private boolean isTransparent;

  public LeaveWall() {
    super("leave_wall", net.minecraft.init.Blocks.LEAVES2);
    setHardness(0.2F);
    setLightOpacity(1);
    setGraphicsLevel(true);
  }

  @SideOnly(Side.CLIENT)
  public void setGraphicsLevel(boolean fancy) {
    isTransparent = fancy;
  }

  @SideOnly(Side.CLIENT)
  @Override
  public BlockRenderLayer getBlockLayer()
  {
    return this.isTransparent ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
  }

  /**
   * Used to determine ambient occlusion and culling when rebuilding chunks for render
   */
  @Override
  public boolean isOpaqueCube(IBlockState state)
  {
    return !this.isTransparent;
  }

  @Override
  public boolean isFullyOpaque(IBlockState state) {
    return false;
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

  @SideOnly(Side.CLIENT)
  @Override
  public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
  {
    return !this.isTransparent && blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
  }
}
