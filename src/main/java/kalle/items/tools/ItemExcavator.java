package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemExcavator extends ItemPickaxe {

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

    public int getAoeDepth() {
        return 3;
    }
}
