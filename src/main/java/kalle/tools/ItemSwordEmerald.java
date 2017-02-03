package kalle.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemSwordEmerald extends ItemSword {

    public ItemSwordEmerald(CreativeTabs tab, String unlocalizedName) {
        super(ToolMaterial.DIAMOND);
        setCreativeTab(tab);
        setUnlocalizedName(unlocalizedName);
        // double diamond durability
        setMaxDamage(1561 * 2);
    }
}