package kalle.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Wall extends BlockWall {
  public static final PropertyBool UP = PropertyBool.create("up");
  public static final PropertyBool NORTH = PropertyBool.create("north");
  public static final PropertyBool EAST = PropertyBool.create("east");
  public static final PropertyBool SOUTH = PropertyBool.create("south");
  public static final PropertyBool WEST = PropertyBool.create("west");

  public Wall(CreativeTabs tab, Block modelBlock, String unlocalizedName) {
    super(modelBlock);
    this.setDefaultState(blockState.getBaseState().withProperty(UP, Boolean.valueOf(false))
        .withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false))
        .withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
    this.setHardness(1);
    this.setResistance(1);
    this.setCreativeTab(tab);
    this.setUnlocalizedName(unlocalizedName);
  }

  @Override
  public boolean isFullCube(IBlockState state) {
    return false;
  }

  @Override
  public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
    return false;
  }

  @Override
  public boolean isFullyOpaque(IBlockState state) {
    return false;
  }

  /**
   * Get the damage value that this Block should drop
   */
  @Override
  public int damageDropped(IBlockState state) {
    // TODO get damage
    return state.getBlock().damageDropped(state);
  }
}
