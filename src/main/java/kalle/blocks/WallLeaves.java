package kalle.blocks;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WallLeaves extends Wall implements IShearable {
  private final java.util.Map<net.minecraftforge.fml.common.registry.RegistryDelegate<Block>, IBlockColor> blockColorMap = com.google.common.collect.Maps.newHashMap();

  @SideOnly(Side.CLIENT)
  private boolean isTransparent;

  public WallLeaves(CreativeTabs tab, Block modelBlock, String unlocalizedName) {
    super(tab, modelBlock, unlocalizedName);
    setHardness(0.2F);
    setLightOpacity(1);
    setGraphicsLevel(true);
    setSoundType(SoundType.PLANT);

    // TODO register color
    registerBlockColorHandler(new IBlockColor()
    {
      public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
      {
        return ColorizerFoliage.getFoliageColorBasic();
      }
    }, this);
  }

  @Override
  public boolean isLeaves(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
    return true;
  }

  @SideOnly(Side.CLIENT)
  public void setGraphicsLevel(boolean fancy) {
    isTransparent = fancy;
  }

  @Override
  public boolean isOpaqueCube(IBlockState state)
  {
    return !isTransparent;
  }

  @SideOnly(Side.CLIENT)
  public BlockRenderLayer getBlockLayer()
  {
    return this.isTransparent ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
  }

  public boolean isVisuallyOpaque()
  {
    return false;
  }

  @Override
  public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
    return true;
  }

  @Override
  public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
    return Arrays.asList(new ItemStack[] { new ItemStack(this) });
  }

  public void registerBlockColorHandler(IBlockColor blockColor, Block... blocksIn)
  {
    for (Block block : blocksIn)
    {
      if (block.getRegistryName() == null) throw new IllegalArgumentException("Block must be registered before assigning color handler.");
      FMLLog.getLogger().debug("Registering color " + blockColor + " for block " + block);
      this.blockColorMap.put(block.delegate, blockColor);
    }
  }
}
