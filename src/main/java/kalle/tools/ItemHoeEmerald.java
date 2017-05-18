package kalle.tools;

import net.minecraft.item.ItemHoe;

public class ItemHoeEmerald extends ItemHoe {

  public ItemHoeEmerald() {
    super(ToolMaterial.DIAMOND);
    setUnlocalizedName("EmeraldHoe");
    // double diamond durability
    setMaxDamage(1561 * 2);
  }
}
