package kalle.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ItemHoeEmerald extends ItemHoe {

  public ItemHoeEmerald(CreativeTabs tab, String unlocalizedName) {
    super(ToolMaterial.DIAMOND);
    setCreativeTab(tab);
    setUnlocalizedName(unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
  }
}
