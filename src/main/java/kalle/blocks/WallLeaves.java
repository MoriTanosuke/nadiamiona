package kalle.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
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
  public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
    Block block = worldIn.getBlockState(pos).getBlock();
    return block instanceof BlockLeaves || super.canConnectTo(worldIn, pos);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public EnumWorldBlockLayer getBlockLayer() {
    return isTransparent ? EnumWorldBlockLayer.CUTOUT_MIPPED : EnumWorldBlockLayer.SOLID;
  }

  @Override
  @SideOnly(Side.CLIENT)
  public int getBlockColor() {
    return ColorizerFoliage.getFoliageColor(0.5D, 1.0D);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public int getRenderColor(IBlockState state) {
    return ColorizerFoliage.getFoliageColorPine();
  }

  @Override
  @SideOnly(Side.CLIENT)
  public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass) {
    return BiomeColorHelper.getFoliageColorAtPos(worldIn, pos);
  }

  @Override
  public boolean isLeaves(IBlockAccess world, BlockPos pos) {
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
