package kalle.foods;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDrink extends ItemFood {

  public ItemDrink(int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat) {
    super(healAmount, saturationModifier, isWolfsFavoriteMeat);
  }

  @Override
  public EnumAction getItemUseAction(ItemStack par1ItemStack) {
    return EnumAction.DRINK;
  }

  @Nullable
  @Override
  public ItemStack onItemUseFinish(final ItemStack stack, final World worldIn, final EntityLivingBase entityLiving) {
    final ItemStack s = super.onItemUseFinish(stack, worldIn, entityLiving);

    if(entityLiving instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer) entityLiving;
      if (!player.capabilities.isCreativeMode) {
        if (stack.stackSize <= 0) {
          return new ItemStack(Items.GLASS_BOTTLE);
        }

        player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
      }
    }

    return s;
  }
}
