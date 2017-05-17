package kalle.foods;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nullable;

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
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
    stack = super.onItemUseFinish(stack, worldIn, entityLiving);

    if(entityLiving instanceof EntityPlayer) {
      if (!((EntityPlayer) entityLiving).capabilities.isCreativeMode) {
        if (stack.stackSize <= 0) {
          return new ItemStack(Items.GLASS_BOTTLE);
        }

        ((EntityPlayer) entityLiving).inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
      }
    }

    return stack;
  }
}
