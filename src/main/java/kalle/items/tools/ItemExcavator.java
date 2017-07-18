package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;

public class ItemExcavator extends ItemPickaxe {

    private static final List<Block> blocks = Arrays.asList(
            Blocks.OBSIDIAN,
            Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE,
            Blocks.EMERALD_BLOCK, Blocks.EMERALD_ORE,
            Blocks.GOLD_BLOCK, Blocks.GOLD_ORE,
            Blocks.IRON_BLOCK, Blocks.IRON_ORE,
            Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE,
            Blocks.REDSTONE_ORE, Blocks.LIT_REDSTONE_ORE);

    public ItemExcavator() {
        super(ToolMaterial.DIAMOND);
        this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "Excavator"));
        this.setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(Tabs.tab);
        // double diamond durability
        setMaxDamage(ToolMaterial.DIAMOND.getMaxUses() * 2);
    }

    @Override
    public RayTraceResult rayTrace(World worldIn, EntityPlayer playerIn, boolean useLiquids) {
        return super.rayTrace(worldIn, playerIn, useLiquids);
    }

    public int getAoeWidth() {
        return 3;
    }

    public int getAoeHeight() {
        return 3;
    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {
        Block block = blockIn.getBlock();
        Material material = blockIn.getMaterial();
        return blocks.contains(block) || (material == Material.ROCK || material == Material.IRON);
    }

    public int getAoeDepth() {
        return 3;
    }
}
