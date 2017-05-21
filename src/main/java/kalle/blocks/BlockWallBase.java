package kalle.blocks;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;

public class BlockWallBase extends BlockWall {
    public BlockWallBase(String name, Block model) {
        super(model);
        setRegistryName(Basis.MOD_PREFIX, name);
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(Tabs.tab);
    }
}
