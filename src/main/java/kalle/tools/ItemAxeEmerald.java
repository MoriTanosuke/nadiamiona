package kalle.tools;

import kalle.Basis;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemAxeEmerald extends ItemAxe {
  //public static final ToolMaterial ironMaterial = EnumHelper.addToolMaterial(Basis.MOD_PREFIX + ":emerald", 2, 200, 0.1F, 2.0F, 1) ;

  public ItemAxeEmerald(CreativeTabs tab, String unlocalizedName) {
    super(ToolMaterial.DIAMOND);
    setCreativeTab(tab);
    setRegistryName(Basis.MOD_PREFIX, unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}