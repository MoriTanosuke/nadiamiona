package kalle.items.tools;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public class ItemBattleAxeEmerald extends ItemSword {

    private static final ToolMaterial material = ToolMaterial.DIAMOND;
    /**
     * Effective blocks for this weapon/tool.
     */
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{
            // TODO add own custom blocks?
            Blocks.PLANKS,
            Blocks.BOOKSHELF,
            Blocks.LOG,
            Blocks.LOG2,
            Blocks.CHEST,
            Blocks.PUMPKIN,
            Blocks.LIT_PUMPKIN,
            Blocks.MELON_BLOCK,
            Blocks.LADDER});
    /**
     * Tool efficiency on effective blocks. This axe is double efficient.
     */
    private static final float EFFICIENCY_ON_EFFECTIVE_BLOCKS = 2F;
    private final float attackDamage;

    public ItemBattleAxeEmerald() {
        super(material);
        this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "EmeraldBattleAxe"));
        this.setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(Tabs.tab);
        setMaxDamage((int) (material.getMaxUses() * 1.5));
        setMaxStackSize(1);
        attackDamage = 10F; // 10 damage == 5 hearts
    }

    public float getDamageVsEntity() {
        return attackDamage;
    }

    // methods taken from ItemSword

    public float getStrVsBlock(ItemStack stack, IBlockState state) {
        Block block = state.getBlock();

        if (block == Blocks.WEB)
        {
            return 15.0F;
        }
        else
        {
            return EFFECTIVE_ON.contains(block) ? EFFICIENCY_ON_EFFECTIVE_BLOCKS : 1.0F;
        }
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
        ItemStack mat = new ItemStack(Items.EMERALD);
        if (mat != null && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            // remove old values
            multimap.removeAll(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
            // add own values
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.attackDamage, 0));
        }

        return multimap;
    }
}
