package kalle;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import com.google.common.collect.Sets;

public class ItemSpadeBasis extends ItemToolBasis {
	/** an array of the blocks this spade is effective against */
	public static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(new Block[] { Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.gravel, Blocks.snow, Blocks.snow, Blocks.clay, Blocks.soul_sand, Blocks.mycelium });

	public ItemSpadeBasis(Item.ToolMaterial par2EnumToolMaterial) {
		super(1.0F, par2EnumToolMaterial, blocksEffectiveAgainst);
	}

	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	public boolean canHarvestBlock(Block par1Block) {
		return par1Block == Blocks.snow ? true : par1Block == Blocks.snow;
	}
}