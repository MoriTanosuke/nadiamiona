package kalle;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class EatBasis extends ItemFood {

	public EatBasis(int par1, float par3, boolean par4) {
		super(par1, par3, par4);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.eat;
	}

}
