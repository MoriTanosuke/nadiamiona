package kalle;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBasis extends Block {

	private String textureName;

	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;

	public BlockBasis(Material mat) {
		super(mat);

	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		this.blockIcon = reg.registerIcon(textureName);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.blockIcon;
	}

	@Override
	public Block setBlockTextureName(String name) {
		textureName = name;
		return this;
	}
}