package kalle.recipes;

import kalle.Basis;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;

public class Recipes {
    public static void register() {
        net.minecraftforge.oredict.RecipeSorter.register(Basis.MOD_PREFIX + ".potionRecipe", PotionRecipe.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");

        // --- tool recipes ---------------------------------------------------------
        /* TODO fix registering of PotionRecipe for ItemExcavator
        ItemStack swiftness = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.STRONG_SWIFTNESS);
        ItemStack strength = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.STRONG_STRENGTH);
        GameRegistry.addRecipe(new PotionRecipe(3, 3,
                new ItemStack[]{
                        // first row
                        new ItemStack(net.minecraft.init.Blocks.EMERALD_BLOCK),
                        new ItemStack(net.minecraft.init.Blocks.EMERALD_BLOCK),
                        new ItemStack(net.minecraft.init.Blocks.EMERALD_BLOCK),
                        // second row
                        swiftness,
                        new ItemStack(net.minecraft.init.Blocks.DIAMOND_BLOCK),
                        strength,
                        // third row
                        ItemStack.EMPTY,
                        new ItemStack(net.minecraft.init.Blocks.DIAMOND_BLOCK),
                        ItemStack.EMPTY,
                },
                new ItemStack(kalle.items.Items.EXCAVATOR)
        ));
        */

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
