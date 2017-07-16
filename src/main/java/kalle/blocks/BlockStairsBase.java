package kalle.blocks;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockStairsBase extends BlockStairs {
    protected BlockStairsBase(String name, IBlockState modelState) {
        super(modelState);
        setRegistryName(Basis.MOD_PREFIX, name);
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(Tabs.tab);
    }
}
