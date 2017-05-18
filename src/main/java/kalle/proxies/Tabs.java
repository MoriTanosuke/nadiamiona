package kalle.proxies;

import kalle.tools.Tools;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tabs {
    public static CreativeTabs tab;

    static {
        tab = new CreativeTabs("tabKalle") {
            @Override
            public Item getTabIconItem() {
                return Tools.EMERALD_PICKAXE;
            }
        };
    }
}