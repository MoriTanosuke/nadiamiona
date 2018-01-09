package kalle.recipes;

import kalle.Basis;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

        // --- block recipes ---------------------------------------------------------

        GameRegistry.addRecipe(new ItemStack(Blocks.STONE_WALL, 6),
         "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.STONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.BRICK_WALL, 6),
         "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.BRICK_BLOCK);
        GameRegistry.addRecipe(new ItemStack(Blocks.STONEBRICK_WALL, 6),
         "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.STONEBRICK);
        GameRegistry.addRecipe(new ItemStack(Blocks.SANDSTONE_WALL, 6),
         "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.SANDSTONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.RED_SANDSTONE_WALL, 6),
         "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.RED_SANDSTONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.LEAVE_WALL, 6),
         "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.LEAVES);
        // wool wall is deactivated because of recipe conflicts in other mods
        //GameRegistry.addRecipe(new ItemStack(Blocks.WOOL_WALL, 6),
         "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.WOOL);

        for (int color = 0; color <= 15; color++) {
            //TODO register all variants
            final Block woolStairs = new WoolStairs("wool_stairs_" + color, net.minecraft.init.Blocks.WOOL.getDefaultState());
            GameRegistry.addRecipe(new ItemStack(woolStairs, 4), "A##", "AA#", "AAA", 'A', new ItemStack(net.minecraft.init.Blocks.WOOL, 1, color));
        }
        */

        // --- food recipes ---------------------------------------------------------
        GameRegistry.addSmelting(net.minecraft.init.Items.EGG, new ItemStack(kalle.items.Items.COOKED_EGG), 0.25f);
        GameRegistry.addSmelting(kalle.items.Items.BREADSLICE, new ItemStack(kalle.items.Items.TOAST), 0.25f);
        GameRegistry.addSmelting(net.minecraft.init.Items.REEDS, new ItemStack(kalle.items.Items.BOOZE), 0.25f);
        // some additional smelting recipes
        GameRegistry.addSmelting(Items.POISONOUS_POTATO, new ItemStack(Items.POTATO), 0.25f);
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BEEF), 0.25f);
        GameRegistry.addSmelting(net.minecraft.init.Blocks.QUARTZ_BLOCK, new ItemStack(Items.QUARTZ, 8), 0.25f);

        /*
        // --- additional recipes ---------------------------------------------------------

        // To build spawners for specific mobs, use the meta value from http://minecraft.gamepedia.com/Data_values/Entity_IDs

        // zombie egg
        final ItemStack zombieEggStack = new ItemStack(net.minecraft.init.Items.SPAWN_EGG, 1, 54);
        final Item zombieEgg = zombieEggStack.getItem();
        GameRegistry.addRecipe(zombieEggStack, "AAA", "AAA", "AAA", 'A', net.minecraft.init.Items.ROTTEN_FLESH);
        // TODO zombie head
        GameRegistry.addRecipe(new ItemStack(buildSkull(SkullType.ZOMBIE), 1, 54), "AAA", "AAA", "AAA", 'A', zombieEgg);
        // zombie spawner
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.MOB_SPAWNER, 1, 54), "ABA", "ACA", "ADA", 'A', kalle.items.Items.CHAINS, 'B', net.minecraft.init.Items.ENDER_EYE, 'C', buildSkull(SkullType.ZOMBIE), 'D', net.minecraft.init.Blocks.REDSTONE_BLOCK);
        // skeleton egg
        final ItemStack skeletonEggStack = new ItemStack(net.minecraft.init.Items.SPAWN_EGG, 1, 51);
        final Item skeletonEgg = skeletonEggStack.getItem();
        GameRegistry.addRecipe(skeletonEggStack, "AAA", "AAA", "AAA", 'A', net.minecraft.init.Items.BONE);
        // TODO skeleton head
        // skeleton spawner
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.MOB_SPAWNER, 1, 51), "ABA", "ACA", "ADA", 'A', kalle.items.Items.CHAINS, 'B', net.minecraft.init.Items.ENDER_EYE, 'C', buildSkull(SkullType.SKELETON), 'D', net.minecraft.init.Blocks.REDSTONE_BLOCK);
        // spider egg
        final ItemStack spiderEggStack = new ItemStack(net.minecraft.init.Items.SPAWN_EGG, 1, 52);
        final Item spiderEgg = spiderEggStack.getItem();
        GameRegistry.addRecipe(spiderEggStack, "AAA", "AAA", "AAA", 'A', net.minecraft.init.Items.SPIDER_EYE);
        // TODO wither skeleton head
        // TODO wither skeleton spawner
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.MOB_SPAWNER, 1, 52), "ABA", "ACA", "ADA", 'A', kalle.items.Items.CHAINS, 'B', net.minecraft.init.Items.ENDER_EYE, 'C', buildSkull(SkullType.WITHER_SKELETON), 'D', net.minecraft.init.Blocks.REDSTONE_BLOCK);
        */
    }


    private static Item buildSkull(SkullType skullType) {
        return new ItemStack(net.minecraft.init.Items.SKULL, 1, skullType.getMeta()).getItem();
    }

    enum SkullType {
        ZOMBIE(2),
        SKELETON(0),
        WITHER_SKELETON(1);

        private final int meta;

        private SkullType(int meta) {
            this.meta = meta;
        }

        public int getMeta() {
            return meta;
        }
    }
}
