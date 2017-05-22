package kalle.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class SmallBlock extends BlockBase {
    public SmallBlock() {
        super("smallBlock", Material.ROCK);
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullyOpaque(IBlockState state) {
        return false;
    }
}
