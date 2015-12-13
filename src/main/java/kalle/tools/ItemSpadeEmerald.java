package kalle.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ItemSpadeEmerald extends ItemSpade {

  public ItemSpadeEmerald(CreativeTabs tab, String unlocalizedName) {
    super(Item.ToolMaterial.EMERALD);
    setCreativeTab(tab);
    setUnlocalizedName(unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}