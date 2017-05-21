package kalle.items.foods;

import kalle.Basis;
import kalle.proxies.Tabs;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class ItemFoodBase extends ItemFood {
    public ItemFoodBase(String name, int amount, float saturation) {
        this(name, amount, saturation, false);
    }

    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(new ResourceLocation(Basis.MOD_PREFIX, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        setCreativeTab(Tabs.tab);
    }
}
