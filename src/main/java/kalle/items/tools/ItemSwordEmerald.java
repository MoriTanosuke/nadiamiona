package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ItemSwordEmerald extends ItemSword {

    public ItemSwordEmerald() {
        super(ToolMaterial.DIAMOND);
        this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "EmeraldSword"));
        this.setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(Tabs.tab);
        // double diamond durability
        setMaxDamage(1561 * 2);
    }
}