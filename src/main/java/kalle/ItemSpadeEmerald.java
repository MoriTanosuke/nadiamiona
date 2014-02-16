package kalle;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpadeEmerald extends ItemSpade {

	public ItemSpadeEmerald() {
		super(Item.ToolMaterial.EMERALD);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		this.itemIcon = reg.registerIcon("kalle:emerald_spade");
	}
}