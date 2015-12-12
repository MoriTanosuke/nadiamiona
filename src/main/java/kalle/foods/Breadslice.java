package kalle.foods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Breadslice extends ItemFood {

  public Breadslice(CreativeTabs tab) {
    super(1, 0.1F, false);
    setUnlocalizedName("Breadslice");
    setCreativeTab(tab);
  }

}
