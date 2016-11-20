package kalle.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class Stairs extends BlockStairs {
    public Stairs(CreativeTabs tab, Block blockModel, String unlocalizedName) {
        super(blockModel.getDefaultState());
        this.setCreativeTab(tab);
        this.setUnlocalizedName(unlocalizedName);
    }
}
