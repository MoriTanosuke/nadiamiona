package kalle.tools;

import net.minecraft.item.ItemAxe;

public class ItemAxeEmerald extends ItemAxe {

  public ItemAxeEmerald() {
    super(ToolMaterial.DIAMOND);
    setUnlocalizedName("EmeraldAxe");
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}