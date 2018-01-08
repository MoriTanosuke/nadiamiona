package kalle.recipes;

import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PotionRecipe extends ShapedRecipes {
    public PotionRecipe(int width, int height, NonNullList<Ingredient> ingredientsIn, ItemStack output) {
        super("", width, height, ingredientsIn, output);
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
                        itemstack = this.recipeItems.get(this.recipeWidth - k - 1 + l * this.recipeWidth).getMatchingStacks()[0];
                    } else {
                        itemstack = this.recipeItems.get(k + l * this.recipeWidth).getMatchingStacks()[0];
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
        for (Ingredient ingredient : recipeItems) {
            if (isPotion(ingredient)) {
                // remember this potion from the recipe
                recipePotions.add(PotionUtils.getPotionFromItem(ingredient.getMatchingStacks()[0]));
            }
        }

        // get all potions from inventory
        for (int i = 0; i < inv.getWidth(); i++) {
            for (int j = 0; j < inv.getHeight(); j++) {
                ItemStack itemstack = inv.getStackInRowAndColumn(i, j);
                if (isPotion(Ingredient.fromItem(itemstack.getItem()))) {
                    // remember this potion type from the inventory
                    craftingPotions.add(PotionUtils.getPotionFromItem(itemstack));
                }
            }
        }

        // compare remembered potions with inventory
        return craftingPotions.containsAll(recipePotions);
    }

    private boolean isPotion(Ingredient itemstack) {
        PotionType potion = PotionUtils.getPotionFromItem(itemstack.getMatchingStacks()[0]);
        boolean isPotion = potion != null &&
                potion != PotionTypes.EMPTY &&
                potion != PotionTypes.WATER;
        return isPotion;
    }
}
