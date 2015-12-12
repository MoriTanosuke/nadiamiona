package kalle;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Sets;

public class ItemAxeBasis extends ItemToolBasis {
  /** an array of the blocks this axe is effective against */
  public static final Set<Block> blocksEffectiveAgainst = Sets
      .newHashSet(new Block[] { Blocks.planks, Blocks.bookshelf, Blocks.chest, Blocks.stone_slab, Blocks.pumpkin });

  public ItemAxeBasis(Item.ToolMaterial par2EnumToolMaterial) {
    super(3.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
  }

  /**
   * Returns the strength of the stack against a given Blocks. 1.0F base,
   * (Quality+1)*2 if correct blocktype, 1.5F if sword
   */
  public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
    return par2Block != null && (par2Block.getMaterial() == Material.wood || par2Block.getMaterial() == Material.plants
        || par2Block.getMaterial() == Material.vine) ? this.efficiencyOnProperMaterial
            : super.getStrVsBlock(par1ItemStack, par2Block);
  }
}
