package kalle.tools;

import kalle.Basis;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemHoeEmerald extends ItemHoe {

  public ItemHoeEmerald(CreativeTabs tab, String unlocalizedName) {
    super(ToolMaterial.DIAMOND);
    setCreativeTab(tab);
    setRegistryName(Basis.MOD_PREFIX, unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
  }
}
