package kalle.recipes;

import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.world.World;
import net.minecraftforge.oredict.RecipeSorter;

import java.util.ArrayList;
import java.util.List;

public class PotionRecipe extends ShapedRecipes {
    public PotionRecipe(int width, int height, ItemStack[] ingredientsIn, ItemStack output) {
        super(width, height, ingredientsIn, output);
        RecipeSorter.register("holovm:vmadv", PotionRecipe.class, RecipeSorter.Category.SHAPED, "after:minecraft:shaped");
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        for (int width = 0; width <= 3 - this.recipeWidth; ++width) {
            for (int height = 0; height <= 3 - this.recipeHeight; ++height) {
                if (this.checkMatch(inv, width, height, true) && hasAllPotions(inv)) {
                    return true;
                }

                if (this.checkMatch(inv, width, height, false) && hasAllPotions(inv)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Checks if the region of a crafting inventory is match for the recipe.
     */
    private boolean checkMatch(InventoryCrafting inv, int width, int height, boolean strict) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int k = i - width;
                int l = j - height;
                ItemStack itemstack = ItemStack.EMPTY;

                if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight) {
                    if (strict) {
                        itemstack = this.recipeItems[this.recipeWidth - k - 1 + l * this.recipeWidth];
                    } else {
                        itemstack = this.recipeItems[k + l * this.recipeWidth];
                    }
                }

                ItemStack itemstack1 = inv.getStackInRowAndColumn(i, j);

                if (!itemstack1.isEmpty() || !itemstack.isEmpty()) {
                    if (itemstack1.isEmpty() != itemstack.isEmpty()) {
                        return false;
                    }

                    if (itemstack.getItem() != itemstack1.getItem()) {
                        return false;
                    }

                    if (itemstack.getMetadata() != 32767 && itemstack.getMetadata() != itemstack1.getMetadata()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Checks if crafting inventory has all the potions from the recipe.
     */
    private boolean hasAllPotions(InventoryCrafting inv) {
        List<PotionType> recipePotions = new ArrayList<PotionType>();
        List<PotionType> craftingPotions = new ArrayList<PotionType>();
        for (ItemStack ingredient : recipeItems) {
            if (isPotion(ingredient)) {
                // remember this potion from the recipe
                recipePotions.add(PotionUtils.getPotionFromItem(ingredient));
            }
        }

        // get all potions from inventory
        for (int i = 0; i < inv.getWidth(); i++) {
            for (int j = 0; j < inv.getHeight(); j++) {
                ItemStack itemstack = inv.getStackInRowAndColumn(i, j);
                if (isPotion(itemstack)) {
                    // remember this potion type from the inventory
                    craftingPotions.add(PotionUtils.getPotionFromItem(itemstack));
                }
            }
        }

        // compare remembered potions with inventory
        return craftingPotions.containsAll(recipePotions);
    }

    private boolean isPotion(ItemStack itemstack) {
        PotionType potion = PotionUtils.getPotionFromItem(itemstack);
        boolean isPotion = potion != null &&
                potion != PotionTypes.EMPTY &&
                potion != PotionTypes.WATER;
        return isPotion;
    }
}
