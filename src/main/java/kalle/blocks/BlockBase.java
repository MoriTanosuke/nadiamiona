package kalle.blocks;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        setRegistryName(Basis.MOD_PREFIX, name);
        setUnlocalizedName(getRegistryName().toString());
        setCreativeTab(Tabs.tab);
        // default hardness, resistance for all our blocks
        setHardness(2.0F);
        setResistance(5.0F);
    }
}
