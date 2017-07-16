package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;

public class ItemPickaxeEmerald extends ItemPickaxe {

  public ItemPickaxeEmerald() {
    super(ToolMaterial.DIAMOND);
    this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "EmeraldPickaxe"));
    this.setUnlocalizedName(this.getRegistryName().toString());
    setCreativeTab(Tabs.tab);
    // double diamond durability
    setMaxDamage(ToolMaterial.DIAMOND.getMaxUses() * 2);
  }
}
