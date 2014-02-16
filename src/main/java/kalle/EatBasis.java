package kalle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class EatBasis extends ItemFood {

	private String filename;
	
	public EatBasis(int par1, float par3, boolean par4) {
		super(par1, par3, par4);
	}

	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.eat;
	    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon(filename);
	}
	
	public void setIconFile(String name){
		filename = name;
	}

}
