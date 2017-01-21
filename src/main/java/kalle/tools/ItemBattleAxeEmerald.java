package kalle.tools;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemBattleAxeEmerald extends ItemTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder});

    public ItemBattleAxeEmerald(CreativeTabs tab, String unlocalizedName) {
        super(3.0F, ToolMaterial.EMERALD, EFFECTIVE_ON);
        setCreativeTab(tab);
        setUnlocalizedName(unlocalizedName);
        setMaxDamage(1561 * 4);
        // TODO need to set efficiencyOnProperMaterial?
        efficiencyOnProperMaterial = 4.0f;
    }

    public float getStrVsBlock(ItemStack stack, Block state) {
        return state.getMaterial() != Material.wood && state.getMaterial() != Material.plants && state.getMaterial() != Material.vine ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }
}