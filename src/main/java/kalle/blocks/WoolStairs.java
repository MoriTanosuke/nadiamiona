package kalle.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class WoolStairs extends BlockStairs {
    public WoolStairs(final CreativeTabs tab, final IBlockState modelState, final String unlocalizedName) {
        super(modelState);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setCreativeTab(tab);
    }
}
