package kalle.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;

public class Wall extends BlockWall {

  public Wall(CreativeTabs tab, Block modelBlock, String unlocalizedName) {
    super(modelBlock);
    this.setCreativeTab(tab);
    this.setUnlocalizedName(unlocalizedName);
    this.setRegistryName(unlocalizedName);
  }
}
