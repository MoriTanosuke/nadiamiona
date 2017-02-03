package kalle.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class ItemAxeEmerald extends ItemAxe {

  public ItemAxeEmerald(CreativeTabs tab, String unlocalizedName) {
    super(ToolMaterial.DIAMOND);
    setCreativeTab(tab);
    setUnlocalizedName(unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}