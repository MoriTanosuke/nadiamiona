package kalle.tools;

import kalle.Basis;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemSpadeEmerald extends ItemSpade {

  public ItemSpadeEmerald(CreativeTabs tab, String unlocalizedName) {
    super(ToolMaterial.DIAMOND);
    setCreativeTab(tab);
    setRegistryName(Basis.MOD_PREFIX, unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}