package kalle.recipes;

import kalle.blocks.Blocks;
import kalle.blocks.WoolStairs;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
    public static void register() {
        // --- tool recipes ---------------------------------------------------------
        GameRegistry.addShapelessRecipe(new ItemStack(kalle.items.Items.EXCAVATOR), kalle.items.Items.EMERALD_PICKAXE, kalle.items.Items.EMERALD_SPADE);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.EMERALD_PICKAXE), "###", "0*0", "0*0", '#', net.minecraft.init.Items.EMERALD, '*', net.minecraft.init.Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.EMERALD_AXE), "##0", "#*0", "0*0", '#', net.minecraft.init.Items.EMERALD, '*', net.minecraft.init.Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.EMERALD_BATTLEAXE), "###", "#*#", "0*0", '#', net.minecraft.init.Items.EMERALD, '*', net.minecraft.init.Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.EMERALD_SPADE), "0#0", "0*0", "0*0", '#', net.minecraft.init.Items.EMERALD, '*', net.minecraft.init.Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.EMERALD_HOE), "##0", "0*0", "0*0", '#', net.minecraft.init.Items.EMERALD, '*', net.minecraft.init.Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.EMERALD_SWORD), "0#0", "0#0", "0*0", '#', net.minecraft.init.Items.EMERALD, '*', net.minecraft.init.Items.DIAMOND);

        // --- block recipes ---------------------------------------------------------
        GameRegistry.addRecipe(new ItemStack(Blocks.BAR, 2), "000", "0BB", "0AA", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 0), 'B',
                new ItemStack(net.minecraft.init.Blocks.WOODEN_SLAB, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Blocks.SPRUCE_BAR, 2), "000", "0BB", "0AA", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 1),
                'B', new ItemStack(net.minecraft.init.Blocks.WOODEN_SLAB, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Blocks.JUNGLE_BAR, 2), "000", "0BB", "0AA", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 3),
                'B', new ItemStack(net.minecraft.init.Blocks.WOODEN_SLAB, 1, 3));
        GameRegistry.addRecipe(new ItemStack(Blocks.ACACIA_BAR, 2), "000", "0BB", "0AA", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 4),
                'B', new ItemStack(net.minecraft.init.Blocks.WOODEN_SLAB, 1, 4));
        GameRegistry.addRecipe(new ItemStack(Blocks.BIRCH_BAR, 2), "000", "0BB", "0AA", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 2), 'B',
                new ItemStack(net.minecraft.init.Blocks.WOODEN_SLAB, 1, 2));
        GameRegistry.addRecipe(new ItemStack(Blocks.DARK_OAK_BAR, 2), "000", "0BB", "0AA", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 5),
                'B', new ItemStack(net.minecraft.init.Blocks.WOODEN_SLAB, 1, 5));

        GameRegistry.addRecipe(new ItemStack(Blocks.OAK_PARQUET, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Blocks.SPRUCE_PARQUET, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Blocks.BIRCH_PARQUET, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 2));
        GameRegistry.addRecipe(new ItemStack(Blocks.JUNGLE_PARQUET, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 3));
        GameRegistry.addRecipe(new ItemStack(Blocks.ACACIA_PARQUET, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 4));
        GameRegistry.addRecipe(new ItemStack(Blocks.DARK_OAK_PARQUET, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 5));

        GameRegistry.addRecipe(new ItemStack(Blocks.SPRUCE_BOOK_SHELVES), "###", "#*#", "###", '#', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 1),
                '*', Items.BOOK);
        GameRegistry.addRecipe(new ItemStack(Blocks.JUNGLE_BOOK_SHELVES), "###", "#*#", "###", '#', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 3),
                '*', Items.BOOK);
        GameRegistry.addRecipe(new ItemStack(Blocks.BIRCH_BOOK_SHELVES), "###", "#*#", "###", '#', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 2), '*',
                Items.BOOK);
        GameRegistry.addRecipe(new ItemStack(Blocks.ACACIA_BOOK_SHELVES), "###", "#*#", "###", '#', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 4), '*',
                Items.BOOK);
        GameRegistry.addRecipe(new ItemStack(Blocks.DARK_OAK_BOOK_SHELVES), "###", "#*#", "###", '#', new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 5), '*',
                Items.BOOK);

        GameRegistry.addRecipe(new ItemStack(Blocks.OAK_CRATE), "#0#", "#0#", "###", '#', net.minecraft.init.Blocks.PLANKS);
        GameRegistry.addRecipe(new ItemStack(Blocks.COAL_CRATE), "*", "#", '*', Items.COAL, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.COAL_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.COAL);
        GameRegistry.addRecipe(new ItemStack(Blocks.IRON_CRATE), "*", "#", '*', Items.IRON_INGOT, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.IRON_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Blocks.GOLD_CRATE), "*", "#", '*', Items.GOLD_INGOT, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.GOLD_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.GOLD_INGOT);
        GameRegistry.addRecipe(new ItemStack(Blocks.DIAMOND_CRATE), "*", "#", '*', Items.DIAMOND, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.DIAMOND_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(Blocks.EMERALD_CRATE), "*", "#", '*', Items.EMERALD, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.EMERALD_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.EMERALD);
        // check out dye meta IDs at http://minecraft.gamepedia.com/Data_values#Dyes
        GameRegistry.addRecipe(new ItemStack(Blocks.LAPISLAZULI_CRATE), "*", "#", '*', new ItemStack(Items.DYE, 1, 4), '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.LAPISLAZULI_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addRecipe(new ItemStack(Blocks.APPLE_CRATE), "*", "#", '*', Items.APPLE, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.APPLE_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.APPLE);
        GameRegistry.addRecipe(new ItemStack(Blocks.COOKIE_CRATE), "*", "#", '*', Items.COOKIE, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.COOKIE_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.COOKIE);
        GameRegistry.addRecipe(new ItemStack(Blocks.POTATO_CRATE), "*", "#", '*', Items.POTATO, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.POTATO_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.POTATO);
        //TODO replace with meta recipes?!
        GameRegistry.addRecipe(new ItemStack(Blocks.FISH_CRATE), "*", "#", '*', new ItemStack(Items.FISH, 1, 0), '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.FISH_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', new ItemStack(Items.FISH, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Blocks.SALMON_CRATE), "*", "#", '*', new ItemStack(Items.FISH, 1, 1), '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.SALMON_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', new ItemStack(Items.FISH, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Blocks.CARROT_CRATE), "*", "#", '*', Items.CARROT, '#', Blocks.OAK_CRATE);
        GameRegistry.addRecipe(new ItemStack(Blocks.CARROT_CRATE), "#0#", "#*#", "###", '#', net.minecraft.init.Blocks.PLANKS, '*', Items.CARROT);

        GameRegistry.addRecipe(new ItemStack(Blocks.STONE_WALL, 6), "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.STONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.BRICK_WALL, 6), "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.BRICK_BLOCK);
        GameRegistry.addRecipe(new ItemStack(Blocks.STONEBRICK_WALL, 6), "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.STONEBRICK);
        GameRegistry.addRecipe(new ItemStack(Blocks.SANDSTONE_WALL, 6), "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.SANDSTONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.RED_SANDSTONE_WALL, 6), "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.RED_SANDSTONE);
        GameRegistry.addRecipe(new ItemStack(Blocks.WOOL_WALL, 6), "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.WOOL);
        GameRegistry.addRecipe(new ItemStack(Blocks.LEAVE_WALL, 6), "###", "AAA", "AAA", 'A', net.minecraft.init.Blocks.LEAVES);

        for (int color = 0; color <= 15; color++) {
            //TODO register all variants
            final Block woolStairs = new WoolStairs("wool_stairs_" + color, net.minecraft.init.Blocks.WOOL.getDefaultState());
            GameRegistry.addRecipe(new ItemStack(woolStairs, 4), "A##", "AA#", "AAA", 'A', new ItemStack(net.minecraft.init.Blocks.WOOL, 1, color));
        }

        // --- food recipes ---------------------------------------------------------
        GameRegistry.addSmelting(net.minecraft.init.Items.EGG, new ItemStack(kalle.items.Items.COOKED_EGG), 0.25f);
        // toast
        GameRegistry.addShapelessRecipe(new ItemStack(kalle.items.Items.BREADSLICE, 4), new ItemStack(net.minecraft.init.Items.BREAD));
        GameRegistry.addSmelting(kalle.items.Items.BREADSLICE, new ItemStack(kalle.items.Items.TOAST), 0.25f);
        // TODO replace with variants?
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.TOAST_CHICKEN), "#", "*", "#", '#', kalle.items.Items.TOAST, '*', net.minecraft.init.Items.COOKED_CHICKEN);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.TOAST_FISH), "#", "*", "#", '#', kalle.items.Items.TOAST, '*', new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0));
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.TOAST_SALMON), "#", "*", "#", '#', kalle.items.Items.TOAST, '*', new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 1));
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.TOAST_BACON), "#", "*", "#", '#', kalle.items.Items.TOAST, '*', net.minecraft.init.Items.COOKED_PORKCHOP);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.TOAST_BEEF), "#", "*", "#", '#', kalle.items.Items.TOAST, '*', net.minecraft.init.Items.COOKED_BEEF);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.TOAST_EGG), "*", "#", '#', kalle.items.Items.TOAST, '*', kalle.items.Items.COOKED_EGG);

        // Drinks
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.MILK, 3), "0#0", "***", '#', net.minecraft.init.Items.MILK_BUCKET, '*', net.minecraft.init.Items.GLASS_BOTTLE);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.BEER), "A", "B", 'A', net.minecraft.init.Items.WHEAT_SEEDS, 'B', net.minecraft.init.Items.POTIONITEM);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.BEER, 3), "0A0", "BBB", "CCC", 'A', net.minecraft.init.Items.WATER_BUCKET, 'B', net.minecraft.init.Items.WHEAT_SEEDS, 'C', net.minecraft.init.Items.GLASS_BOTTLE);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.COCOA), "A", "B", "C", 'A', new ItemStack(net.minecraft.init.Items.DYE, 1, 3), 'B', net.minecraft.init.Items.SUGAR, 'C', kalle.items.Items.MILK);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.COCOA, 3), "DAD", "BBB", "CCC", 'A', net.minecraft.init.Items.MILK_BUCKET, 'B', new ItemStack(net.minecraft.init.Items.DYE, 1, 3), 'C', net.minecraft.init.Items.GLASS_BOTTLE, 'D', net.minecraft.init.Items.SUGAR);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.JUICE), "A", "B", "C", 'A', net.minecraft.init.Items.APPLE, 'B', net.minecraft.init.Items.CARROT, 'C', net.minecraft.init.Items.GLASS_BOTTLE);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.JUICE, 3), "AAA", "BBB", "CCC", 'A', net.minecraft.init.Items.APPLE, 'B', net.minecraft.init.Items.CARROT, 'C', net.minecraft.init.Items.GLASS_BOTTLE);
        GameRegistry.addSmelting(net.minecraft.init.Items.REEDS, new ItemStack(kalle.items.Items.BOOZE), 0.25f);
        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.EGGNOG), "A", "B", "C", 'A', kalle.items.Items.COOKED_EGG, 'B', kalle.items.Items.BOOZE, 'C', net.minecraft.init.Items.GLASS_BOTTLE);

        // --- additional recipes ---------------------------------------------------------

        // some additional smelting recipes
        GameRegistry.addSmelting(Items.POISONOUS_POTATO, new ItemStack(Items.POTATO), 0.25f);
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BEEF), 0.25f);
        GameRegistry.addSmelting(net.minecraft.init.Blocks.QUARTZ_BLOCK, new ItemStack(Items.QUARTZ, 8), 0.25f);

        // add old book recipe
        GameRegistry.addRecipe(new ItemStack(Items.BOOK), "#", "#", "#", '#', Items.PAPER);

        // conversions
        GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND, 1), new ItemStack(Items.EMERALD),
                new ItemStack(Items.EMERALD), new ItemStack(Items.EMERALD));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.EMERALD, 3), new ItemStack(Items.DIAMOND));

        // TODO what is this for?
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 0), "#0#", "000", "#0#", '#',
                new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 0));
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 1), "#0#", "000", "#0#", '#',
                new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 1));
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 2), "#0#", "000", "#0#", '#',
                new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 2));
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 3), "#0#", "000", "#0#", '#',
                new ItemStack(net.minecraft.init.Blocks.PLANKS, 1, 3));

        // chiseled stone bricks
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Blocks.STONEBRICK, 1, 3), "+++", "+#+", "+++", '+', Items.FLINT, '#',
                net.minecraft.init.Blocks.STONEBRICK);

        // add recipes for non-craftable items
        GameRegistry.addRecipe(new ItemStack(Items.SADDLE), "###", "#0#", "*0*", '#', Items.LEATHER, '*', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), "00*", "*#*", "***", '#', net.minecraft.init.Blocks.WOOL, '*',
                Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR), "00*", "*#*", "***", '#', net.minecraft.init.Blocks.WOOL, '*',
                Items.GOLD_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR), "00*", "*#*", "***", '#', net.minecraft.init.Blocks.WOOL, '*',
                Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(Items.NAME_TAG), "00#", "**0", "**0", '#', Items.STRING, '*', Items.PAPER);
        GameRegistry.addRecipe(new ItemStack(Items.LEAD), "##0", "##0", "00#", '#', Items.STRING);

        GameRegistry.addRecipe(new ItemStack(kalle.items.Items.CHAINS, 6), "0#0", "#0#", "0#0", '#', net.minecraft.init.Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Items.CHAINMAIL_BOOTS), "000", "#0#", "#0#", '#', kalle.items.Items.CHAINS);
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Items.CHAINMAIL_HELMET), "###", "#0#", "000", '#', kalle.items.Items.CHAINS);
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Items.CHAINMAIL_LEGGINGS), "###", "#0#", "#0#", '#', kalle.items.Items.CHAINS);
        GameRegistry.addRecipe(new ItemStack(net.minecraft.init.Items.CHAINMAIL_CHESTPLATE), "#0#", "###", "###", '#', kalle.items.Items.CHAINS);
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
