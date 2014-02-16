package kalle;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpadeEmerald extends ItemSpadeBasis {

	public ItemSpadeEmerald(Item.ToolMaterial Material) {
		super(Material);
	}

	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("kalle:emerald_spade");
	}
}