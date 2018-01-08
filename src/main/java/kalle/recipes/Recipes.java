package kalle.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
    public static void register() {
        // --- food recipes ---------------------------------------------------------
        GameRegistry.addSmelting(net.minecraft.init.Items.EGG, new ItemStack(kalle.items.Items.COOKED_EGG), 0.25f);
        GameRegistry.addSmelting(kalle.items.Items.BREADSLICE, new ItemStack(kalle.items.Items.TOAST), 0.25f);
        GameRegistry.addSmelting(net.minecraft.init.Items.REEDS, new ItemStack(kalle.items.Items.BOOZE), 0.25f);
        // some additional smelting recipes
        GameRegistry.addSmelting(Items.POISONOUS_POTATO, new ItemStack(Items.POTATO), 0.25f);
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BEEF), 0.25f);
        GameRegistry.addSmelting(net.minecraft.init.Blocks.QUARTZ_BLOCK, new ItemStack(Items.QUARTZ, 8), 0.25f);
    }
}
