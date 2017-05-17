package kalle.tools;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public class ItemBattleAxeEmerald extends Item {

    private static final ToolMaterial material = ToolMaterial.EMERALD;
    /**
     * Effective blocks for this weapon/tool.
     */
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER});
    /**
     * Tool efficiency on effective blocks. This axe is double efficient.
     */
    private static final float EFFICIENCY_ON_EFFECTIVE_BLOCKS = 2F;
    private final float attackDamage;

    public ItemBattleAxeEmerald(CreativeTabs tab, String unlocalizedName) {
        super(3.0F, 5.0F, ToolMaterial.DIAMOND, EFFECTIVE_ON);
        setCreativeTab(tab);
        setUnlocalizedName(unlocalizedName);
        setMaxDamage(1561 * 4);
        setMaxStackSize(1);
        attackDamage = 10F; // 10 damage == 5 hearts
    }

    public float getDamageVsEntity() {
        return attackDamage;
    }

    // methods taken from ItemSword

    public float getStrVsBlock(ItemStack stack, Block state) {
        if (state == Blocks.web) {
            return 15.0F;
        } else {
            return EFFECTIVE_ON.contains(state) ? EFFICIENCY_ON_EFFECTIVE_BLOCKS : 1.0F;
        }
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn) {
        if ((double) blockIn.getBlockHardness(worldIn, pos) != 0.0D) {
            stack.damageItem(2, playerIn);
        }

        return true;
    }

    public boolean canHarvestBlock(IBlockState blockIn) {
        return blockIn.getBlock() == Blocks.web;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    public int getItemEnchantability() {
        return this.material.getEnchantability();
    }

    public String getToolMaterialName() {
        //TODO return emerald name
        return material.toString();
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        ItemStack mat = this.material.getRepairItemStack();
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers() {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double) this.attackDamage, 0));
        return multimap;
    }
}
