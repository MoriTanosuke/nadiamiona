package kalle.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeEmerald extends ItemPickaxe {

  public ItemPickaxeEmerald(String unlocalizedName) {
    super(Item.ToolMaterial.EMERALD);
    setUnlocalizedName(unlocalizedName);
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}
