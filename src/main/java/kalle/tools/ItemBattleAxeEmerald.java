package kalle.tools;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public class ItemBattleAxeEmerald extends ItemSword {

    /**
     * Effective blocks for this weapon/tool.
     */
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder});
    /**
     * Tool efficiency on effective blocks. This axe is double efficient.
     */
    private static final float EFFICIENCY_ON_EFFECTIVE_BLOCKS = 2F;
    private final float attackDamage;

    public ItemBattleAxeEmerald(CreativeTabs tab, String unlocalizedName) {
        super(ToolMaterial.EMERALD);
        setCreativeTab(tab);
        setUnlocalizedName(unlocalizedName);
        setMaxDamage((int) (ToolMaterial.EMERALD.getMaxUses() * 1.5));
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

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = new ItemStack(Items.emerald);
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers()
    {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers();
        // make sure the original attack damage is removed
        multimap.removeAll(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName());
        // add our own
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double)this.attackDamage, 0));
        return multimap;
    }
}
