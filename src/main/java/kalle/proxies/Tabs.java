package kalle.proxies;

import kalle.items.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tabs {
    public static CreativeTabs tab;

    static {
        tab = new CreativeTabs("tabKalle") {
            @Override
            public Item getTabIconItem() {
                return Items.EMERALD_PICKAXE;
            }
        };
    }
}
