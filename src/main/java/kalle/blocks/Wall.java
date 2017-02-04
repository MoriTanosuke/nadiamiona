package kalle.blocks;

import kalle.Basis;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;

public class Wall extends BlockWall {
    public Wall(CreativeTabs tab, Block modelBlock, String registryName) {
        super(modelBlock);
        this.setCreativeTab(tab);
        this.setRegistryName(Basis.MOD_PREFIX, registryName);
    }
}
