package kalle.blocks;

import kalle.Basis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBar extends Block {

  public BlockBar(CreativeTabs tab) {
    this(tab, "Theke");
  }

  public BlockBar(CreativeTabs tab, String unlocalizedName) {
    super(Material.WOOD);
    setRegistryName(Basis.MOD_PREFIX, unlocalizedName);
    setCreativeTab(tab);
    setHardness(2.0f);
    setResistance(5.0f);
  }

}
