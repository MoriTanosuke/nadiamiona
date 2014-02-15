package kalle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockBasis extends Block{
	

private String textureName;
	
	@SideOnly(Side.CLIENT)
	private Icon blockIcon;
	
	
	public BlockBasis(int id, Material mat){
		super(id, mat);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.blockIcon = reg.registerIcon(textureName);		
	}
	
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta){
		return this.blockIcon;
	}

	public void setIconFile(String name){
		textureName = name;
	}
}