package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;

public class ItemSpadeEmerald extends ItemSpade {

  public ItemSpadeEmerald() {
    super(ToolMaterial.DIAMOND);
      this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "ItemSpadeEmerald"));
    this.setUnlocalizedName(this.getRegistryName().toString());
    setCreativeTab(Tabs.tab);
    // double diamond durability
    setMaxDamage(ToolMaterial.DIAMOND.getMaxUses() * 2);
  }
}