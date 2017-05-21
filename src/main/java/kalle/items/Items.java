package kalle.items;


import kalle.items.foods.*;
import kalle.items.tools.*;
import net.minecraft.item.Item;

public class Items {
    public static final Item EMERALD_PICKAXE = new ItemPickaxeEmerald();
    public static final Item EMERALD_AXE = new ItemAxeEmerald();
    public static final Item EMERALD_BATTLEAXE = new ItemBattleAxeEmerald();
    public static final Item EMERALD_SPADE = new ItemSpadeEmerald();
    public static final Item EMERALD_HOE = new ItemHoeEmerald();
    public static final Item EMERALD_SWORD = new ItemSwordEmerald();
    public static final Item CHAINS = new ItemChain();
    public static final Item BREADSLICE = new ItemBreadslice();
    public static final Item TOAST = new ItemToast();
    public static final Item TOAST_CHICKEN = new ItemToastChicken();
    public static final Item TOAST_FISH = new ItemToastFish();
    public static final Item TOAST_SALMON = new ItemToastSalmon();
    public static final Item TOAST_BACON = new ItemToastBacon();
    public static final Item TOAST_BEEF = new ItemToastBeef();
    public static final Item TOAST_EGG = new ItemToastEgg();
    public static final Item COOKED_EGG = new ItemCookedEgg();
    public static final Item MILK = new ItemMilk();
    public static final Item BEER = new ItemBeer();
    public static final Item COCOA = new ItemCocoa();
    public static final Item JUICE = new ItemJuice();
    public static final Item BOOZE = new ItemBooze();
    public static final Item EGGNOG = new ItemEggnog();

    public static Item[] all = new Item[]{
            EMERALD_PICKAXE,
            EMERALD_AXE,
            EMERALD_BATTLEAXE,
            EMERALD_SPADE,
            EMERALD_HOE,
            EMERALD_SWORD,
            CHAINS,
            BREADSLICE,
            TOAST,
            TOAST_CHICKEN,
            TOAST_FISH,
            TOAST_SALMON,
            TOAST_BACON,
            TOAST_BEEF,
            COOKED_EGG,
            TOAST_EGG,
            MILK,
            BEER,
            COCOA,
            JUICE,
            BOOZE,
            EGGNOG
    };
}
