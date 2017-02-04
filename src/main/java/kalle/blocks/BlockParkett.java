package kalle.blocks;

import kalle.Basis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockParkett extends Block {

  public BlockParkett(CreativeTabs tab, String unlocalizedName) {
    super(Material.WOOD);
    setRegistryName(Basis.MOD_PREFIX, unlocalizedName);
    setCreativeTab(tab);
    setHardness(2.0F);
    setResistance(5.0F);
  }

}
