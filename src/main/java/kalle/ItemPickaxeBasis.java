package kalle;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Sets;

public class ItemPickaxeBasis extends ItemToolBasis {
  /** an array of the blocks this pickaxe is effective against */
  public static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(
      new Block[] { Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone,
          Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block,
          Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore,
          Blocks.lapis_block, Blocks.redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.activator_rail });

  public ItemPickaxeBasis(Item.ToolMaterial par2EnumToolMaterial) {
    super(2.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
  }

  /**
   * Returns if the item (tool) can harvest results from the block type.
   */
  public boolean canHarvestBlock(Block par1Block) {
    return par1Block == Blocks.obsidian ? this.toolMaterial.getHarvestLevel() == 3
        : (par1Block != Blocks.diamond_block && par1Block != Blocks.diamond_ore
            ? (par1Block != Blocks.emerald_ore && par1Block != Blocks.emerald_block
                ? (par1Block != Blocks.gold_block && par1Block != Blocks.gold_ore
                    ? (par1Block != Blocks.iron_block && par1Block != Blocks.iron_ore
                        ? (par1Block != Blocks.lapis_block && par1Block != Blocks.lapis_ore
                            ? (par1Block != Blocks.redstone_ore && par1Block != Blocks.lit_redstone_ore
                                ? (par1Block.getMaterial() == Material.rock ? true
                                    : (par1Block.getMaterial() == Material.iron ? true
                                        : par1Block.getMaterial() == Material.anvil))
                                : this.toolMaterial.getHarvestLevel() >= 2)
                            : this.toolMaterial.getHarvestLevel() >= 1)
                        : this.toolMaterial.getHarvestLevel() >= 1)
                    : this.toolMaterial.getHarvestLevel() >= 2)
                : this.toolMaterial.getHarvestLevel() >= 2)
            : this.toolMaterial.getHarvestLevel() >= 2);
  }

  /**
   * Returns the strength of the stack against a given Blocks. 1.0F base,
   * (Quality+1)*2 if correct blocktype, 1.5F if sword
   */
  public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
    return par2Block != null && (par2Block.getMaterial() == Material.iron || par2Block.getMaterial() == Material.anvil
        || par2Block.getMaterial() == Material.rock) ? this.efficiencyOnProperMaterial
            : super.getStrVsBlock(par1ItemStack, par2Block);
  }
}
