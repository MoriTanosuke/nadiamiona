package kalle;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MultiBlockBasis extends Block {

	public MultiBlockBasis(Material mat) {
		super(mat);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}