package kalle.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBar extends Block {

  public BlockBar(CreativeTabs tab) {
    this(tab, "Theke");
  }

  public BlockBar(CreativeTabs tab, String unlocalizedName) {
    super(Material.WOOD);
    setUnlocalizedName(unlocalizedName);
    setCreativeTab(tab);
    setHardness(2.0f);
    setResistance(5.0f);
  }

}
