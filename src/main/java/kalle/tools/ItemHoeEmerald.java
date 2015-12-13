package kalle.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ItemHoeEmerald extends ItemHoe {

  public ItemHoeEmerald(CreativeTabs tab, String unlocalizedName) {
    super(Item.ToolMaterial.EMERALD);
    setCreativeTab(tab);
    setUnlocalizedName(unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
  }
}
