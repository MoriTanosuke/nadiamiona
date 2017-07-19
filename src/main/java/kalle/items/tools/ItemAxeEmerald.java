package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;

public class ItemAxeEmerald extends ItemAxe {

  public ItemAxeEmerald() {
    super(ToolMaterial.DIAMOND);
      this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "ItemAxeEmerald"));
    this.setUnlocalizedName(this.getRegistryName().toString());
    setCreativeTab(Tabs.tab);
    // double diamond durability
    setMaxDamage(ToolMaterial.DIAMOND.getMaxUses() * 2);
  }
}