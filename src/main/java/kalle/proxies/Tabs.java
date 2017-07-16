package kalle.proxies;

import kalle.items.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tabs {
    public static CreativeTabs tab;

    static {
        tab = new CreativeTabs("tabKalle") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.EMERALD_PICKAXE);
            }
        };
    }
}
