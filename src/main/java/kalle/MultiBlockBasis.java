package kalle;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MultiBlockBasis extends Block {

	private String texturebottom, texturetop, texturenorth, texturesouth, texturewest, textureeast;

	private IIcon bottomTexture;
	private IIcon topTexture;
	private IIcon northTexture;
	private IIcon southTexture;
	private IIcon westTexture;
	private IIcon eastTexture;

	public MultiBlockBasis(Material mat) {
		super(mat);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		this.bottomTexture = reg.registerIcon(texturebottom);
		this.topTexture = reg.registerIcon(texturetop);
		this.northTexture = reg.registerIcon(texturenorth);
		this.southTexture = reg.registerIcon(texturesouth);
		this.westTexture = reg.registerIcon(texturewest);
		this.eastTexture = reg.registerIcon(textureeast);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {

		switch (side) {
		case 0:
			return this.bottomTexture;
		case 1:
			return this.topTexture;
		case 2:
			return this.northTexture;
		case 3:
			return this.southTexture;
		case 4:
			return this.westTexture;
		case 5:
			return this.eastTexture;
		default:
			return this.topTexture;
		}
	}

	public void setBlockTextureName(String bottom, String top, String north, String south, String west, String east) {
		texturebottom = bottom;
		texturetop = top;
		texturenorth = north;
		texturesouth = south;
		texturewest = west;
		textureeast = east;
	}
}