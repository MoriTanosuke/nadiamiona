package kalle;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DrinkBasis extends ItemFood {

	private String filename;
	
	public DrinkBasis(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
	}

	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.drink;
	    }

	 public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        --par1ItemStack.stackSize;
	        par3EntityPlayer.getFoodStats().addStats(this);
	        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
	        
	        if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            if (par1ItemStack.stackSize <= 0)
	            {
	                return new ItemStack(Item.glassBottle);
	            }

	            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle));
	        }
	        
	        
	        return par1ItemStack;
	    }
	 
	 
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.itemIcon = reg.registerIcon(filename);
	}
	
	public void setIconFile(String name){
		filename = name;
	}

}
