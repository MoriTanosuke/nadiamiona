package kalle.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Wall extends Block {
  public static final PropertyBool UP = PropertyBool.create("up");
  public static final PropertyBool NORTH = PropertyBool.create("north");
  public static final PropertyBool EAST = PropertyBool.create("east");
  public static final PropertyBool SOUTH = PropertyBool.create("south");
  public static final PropertyBool WEST = PropertyBool.create("west");

  public Wall(CreativeTabs tab, Block modelBlock, String unlocalizedName) {
    super(modelBlock.getMaterial());
    this.setDefaultState(blockState.getBaseState().withProperty(UP, Boolean.valueOf(false))
        .withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false))
        .withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
    this.setHardness(1);
    this.setResistance(1);
    this.setStepSound(modelBlock.stepSound);
    this.setCreativeTab(tab);
    this.setUnlocalizedName(unlocalizedName);
  }

  @Override
  public boolean isFullCube() {
    return false;
  }

  @Override
  public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
    return false;
  }

  @Override
  public boolean isOpaqueCube() {
    return false;
  }

  @Override
  public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {
    boolean flag = this.canConnectTo(worldIn, pos.north());
    boolean flag1 = this.canConnectTo(worldIn, pos.south());
    boolean flag2 = this.canConnectTo(worldIn, pos.west());
    boolean flag3 = this.canConnectTo(worldIn, pos.east());
    float f = 0.25F;
    float f1 = 0.75F;
    float f2 = 0.25F;
    float f3 = 0.75F;
    float f4 = 1.0F;

    if (flag) {
      f2 = 0.0F;
    }

    if (flag1) {
      f3 = 1.0F;
    }

    if (flag2) {
      f = 0.0F;
    }

    if (flag3) {
      f1 = 1.0F;
    }

    if (flag && flag1 && !flag2 && !flag3) {
      f4 = 0.8125F;
      f = 0.3125F;
      f1 = 0.6875F;
    } else if (!flag && !flag1 && flag2 && flag3) {
      f4 = 0.8125F;
      f2 = 0.3125F;
      f3 = 0.6875F;
    }

    this.setBlockBounds(f, 0.0F, f2, f1, f4, f3);
  }

  @Override
  public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
    this.setBlockBoundsBasedOnState(worldIn, pos);
    this.maxY = 1.5D;
    return super.getCollisionBoundingBox(worldIn, pos, state);
  }

  public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
    Block block = worldIn.getBlockState(pos).getBlock();
    if (block == Blocks.barrier) {
      return false;
    } else if (block != this && !(block instanceof BlockFenceGate) && !(block instanceof Wall)) {
      if (block.getMaterial().isOpaque() && block.isFullCube()) {
        return block.getMaterial() != Material.gourd;
      } else {
        return false;
      }
    } else {
      return true;
    }
  }

  /**
   * Get the damage value that this Block should drop
   */
  @Override
  public int damageDropped(IBlockState state) {
    // TODO get damage
    return state.getBlock().damageDropped(state);
  }

  @Override
  @SideOnly(Side.CLIENT)
  public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
    return side == EnumFacing.DOWN ? super.shouldSideBeRendered(worldIn, pos, side) : true;
  }

  /**
   * Convert the given metadata into a BlockState for this Block
   */
  @Override
  public IBlockState getStateFromMeta(int meta) {
    return this.getDefaultState();
  }

  /**
   * Convert the BlockState into the correct metadata value
   */
  @Override
  public int getMetaFromState(IBlockState state) {
    // TODO how to get meta from BockState?
    return 0;
  }

  /**
   * Get the actual Block state of this Block at the given position. This
   * applies properties not visible in the metadata, such as fence connections.
   */
  @Override
  public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
    return state.withProperty(UP, Boolean.valueOf(!worldIn.isAirBlock(pos.up())))
        .withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north())))
        .withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east())))
        .withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south())))
        .withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
  }

  @Override
  protected BlockState createBlockState() {
    return new BlockState(this, new IProperty[] { UP, NORTH, EAST, WEST, SOUTH });
  }

}
