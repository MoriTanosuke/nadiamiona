package kalle.tools;

import kalle.Basis;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeEmerald extends ItemPickaxe {

  public ItemPickaxeEmerald(String unlocalizedName) {
    super(ToolMaterial.DIAMOND);
    setRegistryName(Basis.MOD_PREFIX, unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}
