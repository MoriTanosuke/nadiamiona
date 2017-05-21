package kalle.items.tools;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;

public class ItemSpadeEmerald extends ItemSpade {

  public ItemSpadeEmerald() {
    super(ToolMaterial.DIAMOND);
    this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, "EmeraldSpade"));
    this.setUnlocalizedName(this.getRegistryName().toString());
    setCreativeTab(Tabs.tab);
    // double diamond durability
    setMaxDamage(1561 * 2);
    // TODO need to set efficiencyOnProperMaterial?
    efficiencyOnProperMaterial = 4.0f;
  }
}