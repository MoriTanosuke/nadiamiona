package kalle.items.foods;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemDrink extends ItemFoodBase {

  public ItemDrink(String name, int healAmount, float saturationModifier) {
    super(name, healAmount, saturationModifier, false);
  }

  @Override
  public EnumAction getItemUseAction(ItemStack par1ItemStack) {
    return EnumAction.DRINK;
  }

  @Nullable
  @Override
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
    stack = super.onItemUseFinish(stack, worldIn, entityLiving);

    if(entityLiving instanceof EntityPlayer) {
      if (!((EntityPlayer) entityLiving).capabilities.isCreativeMode) {
        if (stack.getMaxStackSize() <= 0) {
          return new ItemStack(Items.GLASS_BOTTLE);
        }

        ((EntityPlayer) entityLiving).inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
      }
    }

    return stack;
  }
}
