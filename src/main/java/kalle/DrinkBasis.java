package kalle;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DrinkBasis extends ItemFood {

	public DrinkBasis(int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat) {
		super(healAmount, saturationModifier, isWolfsFavoriteMeat);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.drink;
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		--par1ItemStack.stackSize;
		par3EntityPlayer.getFoodStats().addStats(func_150905_g(par1ItemStack), func_150906_h(par1ItemStack));
		par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);

		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			if (par1ItemStack.stackSize <= 0) {
				return new ItemStack(Items.glass_bottle);
			}

			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
		}

		return par1ItemStack;
	}

}
