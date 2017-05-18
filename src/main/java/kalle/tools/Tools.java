package kalle.tools;

import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

public class Tools {
    public static Item EMERALD_PICKAXE;
    public static Item EMERALD_AXE;
    public static ItemBattleAxeEmerald EMERALD_BATTLEAXE;
    public static ItemSpadeEmerald EMERALD_SPADE;
    public static ItemHoeEmerald EMERALD_HOE;
    public static ItemSwordEmerald EMERALD_SWORD;

    static {
        EMERALD_PICKAXE = new ItemPickaxeEmerald();
        EMERALD_AXE = new ItemAxeEmerald();
        EMERALD_BATTLEAXE = new ItemBattleAxeEmerald();
        EMERALD_SPADE = new ItemSpadeEmerald();
        EMERALD_HOE = new ItemHoeEmerald();
        EMERALD_SWORD = new ItemSwordEmerald();
    }

    public static List<Item> all() {
        //TODO use reflection?
        return Arrays.asList(EMERALD_PICKAXE, EMERALD_AXE, EMERALD_BATTLEAXE, EMERALD_SPADE, EMERALD_HOE);
    }
}
