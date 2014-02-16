package kalle;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToolBasis extends ItemTool {

	/** Array of blocks the tool has extra effect against. */
	private Set<Block> blocksEffectiveAgainst;
	public float efficiencyOnProperMaterial = 4.0F;

	/** Damage versus entities. */
	public float damageVsEntity;

	/** The material this tool is made from. */
	protected Item.ToolMaterial toolMaterial;

	protected ItemToolBasis(float p_i45333_1_, ToolMaterial p_i45333_2_,
			Set p_i45333_3_) {
		super(p_i45333_1_, p_i45333_2_, p_i45333_3_);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns the strength of the stack against a given Blocks. 1.0F base,
	 * (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {
		return blocksEffectiveAgainst.contains(par2Block) ? efficiencyOnProperMaterial : 1.0F;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	public boolean isFull3D() {
		return true;
	}

	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	public int getItemEnchantability() {
		return this.toolMaterial.getEnchantability();
	}

	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName() {
		return this.toolMaterial.toString();
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return this.toolMaterial.func_150995_f() == par2ItemStack.getItem() ? true
				: super.getIsRepairable(par1ItemStack, par2ItemStack);
	}

	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage
				.getAttributeUnlocalizedName(), new AttributeModifier(
				field_111210_e, "Tool modifier", (double) this.damageVsEntity,
				0));
		return multimap;
	}
}
