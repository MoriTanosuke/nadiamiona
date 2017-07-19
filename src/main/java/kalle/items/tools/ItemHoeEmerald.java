package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.util.ResourceLocation;

public class ItemHoeEmerald extends ItemHoe {

  public ItemHoeEmerald() {
    super(ToolMaterial.DIAMOND);
    this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "ItemHoeEmerald"));
    this.setUnlocalizedName(this.getRegistryName().toString());
    setCreativeTab(Tabs.tab);
    // double diamond durability
    setMaxDamage(ToolMaterial.DIAMOND.getMaxUses() * 2);
  }
}
