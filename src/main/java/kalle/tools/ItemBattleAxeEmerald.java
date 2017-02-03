package kalle.tools;

import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemBattleAxeEmerald extends ItemTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER});

    public ItemBattleAxeEmerald(CreativeTabs tab, String unlocalizedName) {
        super(3.0F, 3.0F, ToolMaterial.DIAMOND, EFFECTIVE_ON);
        setCreativeTab(tab);
        setUnlocalizedName(unlocalizedName);
        setMaxDamage(1561 * 4);
        // TODO need to set efficiencyOnProperMaterial?
        efficiencyOnProperMaterial = 4.0f;
    }

    @Override
    public float getStrVsBlock(final ItemStack stack, final IBlockState state) {
        return state.getMaterial() != Material.WOOD && state.getMaterial() != Material.PLANTS && state.getMaterial() != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }
}