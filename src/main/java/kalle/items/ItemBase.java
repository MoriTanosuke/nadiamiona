package kalle.items;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item {
    ItemBase(String name) {
        this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(Tabs.tab);
    }
}