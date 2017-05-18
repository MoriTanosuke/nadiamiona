package kalle.tools;

import net.minecraft.item.ItemSword;

public class ItemSwordEmerald extends ItemSword {

    public ItemSwordEmerald() {
        super(ToolMaterial.DIAMOND);
        setUnlocalizedName("EmeraldSword");
        // double diamond durability
        setMaxDamage(1561 * 2);
    }
}