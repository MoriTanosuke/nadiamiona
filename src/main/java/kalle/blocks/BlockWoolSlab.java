package kalle.blocks;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

public abstract class BlockWoolSlab extends BlockSlab {
    public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.<EnumDyeColor>create("color", EnumDyeColor.class);

    public BlockWoolSlab(final CreativeTabs tab, final BlockState blockState, final String unlocalizedName) {
        super(blockState.getBlock().getMaterial());
        this.setCreativeTab(tab);
        this.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public String getUnlocalizedName(final int meta) {
        return super.getUnlocalizedName() + "." + BlockPlanks.EnumType.byMetadata(meta).getUnlocalizedName();
    }

    @Override
    public IProperty<?> getVariantProperty()
    {
        return COLOR;
    }

    @Override
    public Object getVariant(final ItemStack stack) {
        return EnumDyeColor.byMetadata(stack.getMetadata());
    }
}
