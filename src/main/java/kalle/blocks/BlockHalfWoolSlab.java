package kalle.blocks;

import net.minecraft.block.state.BlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHalfWoolSlab extends BlockWoolSlab {
    public BlockHalfWoolSlab(final CreativeTabs tab, final BlockState blockState, final String unlocalizedName) {
        super(tab, blockState, unlocalizedName);
    }

    @Override
    public boolean isDouble() {
        return false;
    }
}
