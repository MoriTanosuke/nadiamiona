package kalle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeEmerald extends ItemPickaxeBasis {

	public ItemPickaxeEmerald(int ID, EnumToolMaterialBasis Material) {
		super(ID, Material);
	}

	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon("kalle:emerald_pickaxe");
	}
}
