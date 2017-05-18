package kalle.tools;

import net.minecraft.item.ItemSpade;

public class ItemSpadeEmerald extends ItemSpade {

  public ItemSpadeEmerald() {
    super(ToolMaterial.DIAMOND);
    setUnlocalizedName("EmeraldSpade");
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}