package kalle.proxies;

import kalle.Basis;
import kalle.blocks.BlockBar;
import kalle.blocks.BlockParkett;
import kalle.blocks.Wall;
import kalle.blocks.WallLeaves;
import kalle.blocks.WoolStairs;
import kalle.foods.ItemDrink;
import kalle.tools.ItemAxeEmerald;
import kalle.tools.ItemBattleAxeEmerald;
import kalle.tools.ItemHoeEmerald;
import kalle.tools.ItemPickaxeEmerald;
import kalle.tools.ItemSpadeEmerald;
import kalle.tools.ItemSwordEmerald;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;
import org.apache.logging.log4j.Logger;

public class BasisCommonProxy {
    static final Logger LOG = FMLLog.getLogger();

    public void preInit() {
        LOG.info("Pre-Initializing common proxy...");
        // TODO what to do on both sides?

        LOG.debug("Creating objects...");
        // initialize EmeraldPickaxe first, to use as creative tab icon
        final ItemPickaxeEmerald emeraldPickaxe = new ItemPickaxeEmerald("EmeraldPickaxe");
        GameRegistry.addRecipe(new ItemStack(emeraldPickaxe), "###", "0*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(emeraldPickaxe, "EmeraldPickaxe");

        final CreativeTabs tabKalle = new CreativeTabs("tabKalle") {
            @Override
            public ItemStack getIconItemStack() {
                return new ItemStack(emeraldPickaxe, 1, 0);
            }

            @Override
            public Item getTabIconItem() {
                return emeraldPickaxe;
            }
        };
        emeraldPickaxe.setCreativeTab(tabKalle);

        LOG.debug("Registering objects...");
        registerFoods(tabKalle);
        registerUtilities(tabKalle);
        registerBlocks(tabKalle);
        registerTools(tabKalle);

        LOG.debug("Adding crafting recipes...");
        initCraftingRecipes();

        LOG.info("All done.");
    }

    ;

    public void load() {
        // TODO what to do on both sides?
    }

    ;

    public void postInit() {
        // TODO what to do on both sides?
    }

    ;

    private void registerUtilities(final CreativeTabs tabKalle) {
        final Item ketten_glieder = new Item().setUnlocalizedName("Kettenglieder").setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(ketten_glieder, 6), "0#0", "#0#", "0#0", '#', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_BOOTS), "000", "#0#", "#0#", '#', ketten_glieder);
        GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_HELMET), "###", "#0#", "000", '#', ketten_glieder);
        GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_LEGGINGS), "###", "#0#", "#0#", '#', ketten_glieder);
        GameRegistry.addRecipe(new ItemStack(Items.CHAINMAIL_CHESTPLATE), "#0#", "###", "###", '#', ketten_glieder);
        registerItem(ketten_glieder, "Kettenglieder");

        // To build spawners for specific mobs, use the meta value from http://minecraft.gamepedia.com/Data_values/Entity_IDs

        // zombie egg
        final ItemStack zombieEggStack = new ItemStack(Items.SPAWN_EGG, 1, 54);
        final Item zombieEgg = zombieEggStack.getItem();
        GameRegistry.addRecipe(zombieEggStack, "AAA", "AAA", "AAA", 'A', Items.ROTTEN_FLESH);
        // TODO zombie head
        GameRegistry.addRecipe(new ItemStack(buildSkull(SkullType.ZOMBIE), 1, 54), "AAA", "AAA", "AAA", 'A', zombieEgg);
        // zombie spawner
        GameRegistry.addRecipe(new ItemStack(Blocks.MOB_SPAWNER, 1, 54), "ABA", "ACA", "ADA", 'A', ketten_glieder, 'B', Items.ENDER_EYE, 'C', buildSkull(SkullType.ZOMBIE), 'D', Blocks.REDSTONE_BLOCK);
        // skeleton egg
        final ItemStack skeletonEggStack = new ItemStack(Items.SPAWN_EGG, 1, 51);
        final Item skeletonEgg = skeletonEggStack.getItem();
        GameRegistry.addRecipe(skeletonEggStack, "AAA", "AAA", "AAA", 'A', Items.BONE);
        // TODO skeleton head
        // skeleton spawner
        GameRegistry.addRecipe(new ItemStack(Blocks.MOB_SPAWNER, 1, 51), "ABA", "ACA", "ADA", 'A', ketten_glieder, 'B', Items.ENDER_EYE, 'C', buildSkull(SkullType.SKELETON), 'D', Blocks.REDSTONE_BLOCK);
        // spider egg
        final ItemStack spiderEggStack = new ItemStack(Items.SPAWN_EGG, 1, 52);
        final Item spiderEgg = spiderEggStack.getItem();
        GameRegistry.addRecipe(spiderEggStack, "AAA", "AAA", "AAA", 'A', Items.SPIDER_EYE);
        // TODO wither skeleton head
        // TODO wither skeleton spawner
        GameRegistry.addRecipe(new ItemStack(Blocks.MOB_SPAWNER, 1, 52), "ABA", "ACA", "ADA", 'A', ketten_glieder, 'B', Items.ENDER_EYE, 'C', buildSkull(SkullType.WITHER_SKELETON), 'D', Blocks.REDSTONE_BLOCK);
    }

    private Item buildSkull(SkullType skullType) {
        final int datavalue = 1;
        return new ItemStack(Items.SKULL, datavalue, skullType.getMeta()).getItem();
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

    private void registerFoods(final CreativeTabs tabKalle) {
        // Food
        final Item breadslice = new ItemFood(1, 0.1F, false).setUnlocalizedName("Breadslice")
                .setCreativeTab(tabKalle);
        GameRegistry.addShapelessRecipe(new ItemStack(breadslice, 4), new ItemStack(Items.BREAD));
        registerItem(breadslice, "Breadslice");
        // toast
        final Item toast = new ItemFood(1, 0.2F, false).setUnlocalizedName("Toast")
                .setCreativeTab(tabKalle);
        GameRegistry.addSmelting(breadslice, new ItemStack(toast), 0.25f);
        registerItem(toast, "Toast");
        // TODO replace with variants?
        final Item sandwich_chicken = new ItemFood(8, 0.66F, false).setUnlocalizedName("Chickensandwich")
                .setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(sandwich_chicken), "#", "*", "#", '#', toast, '*',
                Items.COOKED_CHICKEN);
        registerItem(sandwich_chicken, "Chickensandwich");
        final Item sandwich_fish = new ItemFood(7, 0.66F, false).setUnlocalizedName("Fischsandwich")
                .setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(sandwich_fish), "#", "*", "#", '#', toast, '*', new ItemStack(Items.COOKED_FISH, 1, 0));
        registerItem(sandwich_fish, "Fischsandwich");
        final Item sandwich_salmon = new ItemFood(7, 0.66F, false).setUnlocalizedName("Lachssandwich")
                .setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(sandwich_salmon), "#", "*", "#", '#', toast, '*', new ItemStack(Items.COOKED_FISH, 1, 1));
        registerItem(sandwich_salmon, "Lachssandwich");
        final Item sandwich_bacon = new ItemFood(10, 0.75F, false).setUnlocalizedName("Schinkensandwich")
                .setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(sandwich_bacon), "#", "*", "#", '#', toast, '*',
                Items.COOKED_PORKCHOP);
        registerItem(sandwich_bacon, "Schinkensandwich");
        final Item sandwich_beef = new ItemFood(10, 0.75F, false).setUnlocalizedName("Roastbeefsandwich")
                .setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(sandwich_beef), "#", "*", "#", '#', toast, '*', Items.COOKED_BEEF);
        registerItem(sandwich_beef, "Roastbeefsandwich");

        final Item cookedEgg = new ItemFood(2, 0.1F, false).setUnlocalizedName("CookedEgg").setCreativeTab(tabKalle);
        GameRegistry.addSmelting(Items.EGG, new ItemStack(cookedEgg), 0.25f);
        registerItem(cookedEgg, "CookedEgg");

        final Item eiertoast = new ItemFood(5, 0.5F, false).setUnlocalizedName("Eiertoast").setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(eiertoast), "*", "#", '#', toast, '*', cookedEgg);
        registerItem(eiertoast, "Eiertoast");

        // Drinks
        final Item milch = new Item().setUnlocalizedName("Milchflasche").setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(milch, 3), "0#0", "***", '#', Items.MILK_BUCKET, '*', Items.GLASS_BOTTLE);
        registerItem(milch, "Milchflasche");

        final Item bier = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Bier").setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(bier), "A", "B", 'A', Items.WHEAT_SEEDS, 'B', Items.POTIONITEM);
        GameRegistry.addRecipe(new ItemStack(bier, 3), "0A0", "BBB", "CCC", 'A', Items.WATER_BUCKET, 'B', Items.WHEAT_SEEDS,
                'C', Items.GLASS_BOTTLE);
        registerItem(bier, "Bier");
        final Item kakao = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Kakao").setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(kakao), "A", "B", "C", 'A', new ItemStack(Items.DYE, 1, 3), 'B', Items.SUGAR,
                'C', milch);
        GameRegistry.addRecipe(new ItemStack(kakao, 3), "DAD", "BBB", "CCC", 'A', Items.MILK_BUCKET, 'B',
                new ItemStack(Items.DYE, 1, 3), 'C', Items.GLASS_BOTTLE, 'D', Items.SUGAR);
        registerItem(kakao, "Schokomilch");
        final Item saft = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Saft").setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(saft), "A", "B", "C", 'A', Items.APPLE, 'B', Items.CARROT, 'C',
                Items.GLASS_BOTTLE);
        GameRegistry.addRecipe(new ItemStack(saft, 3), "AAA", "BBB", "CCC", 'A', Items.APPLE, 'B', Items.CARROT, 'C',
                Items.GLASS_BOTTLE);
        registerItem(saft, "Saft");

        final Item schnaps = new ItemDrink(1, 0.1F, false).setUnlocalizedName("Schnaps").setCreativeTab(tabKalle);
        GameRegistry.addSmelting(Items.REEDS, new ItemStack(schnaps), 0.25f);
        registerItem(schnaps, "Schnaps");
        final Item likoer = new ItemDrink(5, 0.3F, false).setUnlocalizedName("Eierlikoer").setCreativeTab(tabKalle);
        GameRegistry.addRecipe(new ItemStack(likoer), "A", "B", "C", 'A', cookedEgg, 'B', schnaps, 'C', Items.GLASS_BOTTLE);
        registerItem(likoer, "Eierlikoer");
    }

    private void registerBlocks(final CreativeTabs tab) {
        final BlockBar theke = new BlockBar(tab);
        registerBlock(theke, "Theke");
        GameRegistry.addRecipe(new ItemStack(theke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 0), 'B',
                new ItemStack(Blocks.WOODEN_SLAB, 1, 0));
        final BlockBar spruceTheke = new BlockBar(tab, "SpruceTheke");
        registerBlock(spruceTheke, "SpruceTheke");
        GameRegistry.addRecipe(new ItemStack(spruceTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 1),
                'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 1));
        final BlockBar jungleTheke = new BlockBar(tab, "JungleTheke");
        registerBlock(jungleTheke, "JungleTheke");
        GameRegistry.addRecipe(new ItemStack(jungleTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 3),
                'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 3));
        final BlockBar acaciaTheke = new BlockBar(tab, "AcaciaTheke");
        registerBlock(acaciaTheke, "AcaciaTheke");
        GameRegistry.addRecipe(new ItemStack(acaciaTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 4),
                'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 4));
        final BlockBar birchTheke = new BlockBar(tab, "BirchTheke");
        registerBlock(birchTheke, "BirchTheke");
        GameRegistry.addRecipe(new ItemStack(birchTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 2), 'B',
                new ItemStack(Blocks.WOODEN_SLAB, 1, 2));
        final BlockBar darkOakTheke = new BlockBar(tab, "DarkOakTheke");
        registerBlock(darkOakTheke, "DarkOakTheke");
        GameRegistry.addRecipe(new ItemStack(darkOakTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 5),
                'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 5));

        final BlockParkett parkettOak = new BlockParkett(tab, "ParkettOak");
        registerBlock(parkettOak, "ParkettOak");
        GameRegistry.addRecipe(new ItemStack(parkettOak, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 0));
        final BlockParkett parkettSpruce = new BlockParkett(tab, "ParkettSpruce");
        registerBlock(parkettSpruce, "ParkettSpruce");
        GameRegistry.addRecipe(new ItemStack(parkettSpruce, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 1));
        final BlockParkett parkettBirch = new BlockParkett(tab, "ParkettBirke");
        registerBlock(parkettBirch, "ParkettBirke");
        GameRegistry.addRecipe(new ItemStack(parkettBirch, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 2));
        final BlockParkett parkettDjungle = new BlockParkett(tab, "ParkettDschungel");
        registerBlock(parkettDjungle, "ParkettDschungel");
        GameRegistry.addRecipe(new ItemStack(parkettDjungle, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 3));
        final BlockParkett parkettAkazie = new BlockParkett(tab, "ParkettAkazie");
        registerBlock(parkettAkazie, "ParkettAkazie");
        GameRegistry.addRecipe(new ItemStack(parkettAkazie, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 4));
        final BlockParkett parkettDarkoak = new BlockParkett(tab, "ParkettDarkOak");
        registerBlock(parkettDarkoak, "ParkettDarkOak");
        GameRegistry.addRecipe(new ItemStack(parkettDarkoak, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 5));

        final Block booksSpruce = new Block(Material.WOOD).setUnlocalizedName("BooksSpruce").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(booksSpruce, "BooksSpruce");
        GameRegistry.addRecipe(new ItemStack(booksSpruce), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 1),
                '*', Items.BOOK);
        final Block booksJungle = new Block(Material.WOOD).setUnlocalizedName("BooksJungle").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(booksJungle, "BooksJungle");
        GameRegistry.addRecipe(new ItemStack(booksJungle), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 3),
                '*', Items.BOOK);
        final Block booksBirch = new Block(Material.WOOD).setUnlocalizedName("BooksBirch").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(booksBirch, "BooksBirch");
        GameRegistry.addRecipe(new ItemStack(booksBirch), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 2), '*',
                Items.BOOK);
        final Block booksAcacia = new Block(Material.WOOD).setUnlocalizedName("BooksAcacia").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(booksAcacia, "BooksAcacia");
        GameRegistry.addRecipe(new ItemStack(booksAcacia), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 4), '*',
                Items.BOOK);
        final Block booksDarkOak = new Block(Material.WOOD).setUnlocalizedName("BooksDarkOak").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(booksDarkOak, "BooksDarkOak");
        GameRegistry.addRecipe(new ItemStack(booksDarkOak), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 5), '*',
                Items.BOOK);

        // Kisten
        final Block kiste = new Block(Material.WOOD).setUnlocalizedName("Kiste").setCreativeTab(tab).setHardness(2.0F)
                .setResistance(5.0F);
        registerBlock(kiste, "Kiste");
        GameRegistry.addRecipe(new ItemStack(kiste), "#0#", "#0#", "###", '#', Blocks.PLANKS);

        final Block kisteKohle = new Block(Material.WOOD).setUnlocalizedName("Kohlekiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteKohle, "Kohlekiste");
        GameRegistry.addRecipe(new ItemStack(kisteKohle), "*", "#", '*', Items.COAL, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteKohle), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.COAL);

        final Block kisteEisen = new Block(Material.WOOD).setUnlocalizedName("Eisenkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteEisen, "Eisenkiste");
        GameRegistry.addRecipe(new ItemStack(kisteEisen), "*", "#", '*', Items.IRON_INGOT, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteEisen), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.IRON_INGOT);

        final Block kisteGold = new Block(Material.WOOD).setUnlocalizedName("Goldkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteGold, "Goldkiste");
        GameRegistry.addRecipe(new ItemStack(kisteGold), "*", "#", '*', Items.GOLD_INGOT, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteGold), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.GOLD_INGOT);

        final Block kisteDiamant = new Block(Material.WOOD).setUnlocalizedName("Diamantkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteDiamant, "Diamantkiste");
        GameRegistry.addRecipe(new ItemStack(kisteDiamant), "*", "#", '*', Items.DIAMOND, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteDiamant), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.DIAMOND);

        final Block kisteEmerald = new Block(Material.WOOD).setUnlocalizedName("Edelsteinkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteEmerald, "Edelsteinkiste");
        GameRegistry.addRecipe(new ItemStack(kisteEmerald), "*", "#", '*', Items.EMERALD, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteEmerald), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.EMERALD);

        final Block kisteLapis = new Block(Material.WOOD).setUnlocalizedName("Lapiskiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteLapis, "Lapiskiste");
        // check out dye meta IDs at http://minecraft.gamepedia.com/Data_values#Dyes
        GameRegistry.addRecipe(new ItemStack(kisteLapis), "*", "#", '*', new ItemStack(Items.DYE, 1, 4), '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteLapis), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', new ItemStack(Items.DYE, 1, 4));

        final Block kisteApfel = new Block(Material.WOOD).setUnlocalizedName("Apfelkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteApfel, "Apfelkiste");
        GameRegistry.addRecipe(new ItemStack(kisteApfel), "*", "#", '*', Items.APPLE, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteApfel), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.APPLE);

        final Block kisteCookie = new Block(Material.WOOD).setUnlocalizedName("Keksekiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteCookie, "Keksekiste");
        GameRegistry.addRecipe(new ItemStack(kisteCookie), "*", "#", '*', Items.COOKIE, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteCookie), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.COOKIE);

        final Block kisteKartoffel = new Block(Material.WOOD).setUnlocalizedName("Kartoffelkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteKartoffel, "Kartoffelkiste");
        GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "*", "#", '*', Items.POTATO, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.POTATO);

        final Block kisteFisch = new Block(Material.WOOD).setUnlocalizedName("Fischkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteFisch, "Fischkiste");
        GameRegistry.addRecipe(new ItemStack(kisteFisch), "*", "#", '*', new ItemStack(Items.FISH, 1, 0), '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteFisch), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', new ItemStack(Items.FISH, 1, 0));

        final Block kisteLachs = new Block(Material.WOOD).setUnlocalizedName("Lachskiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteLachs, "Lachskiste");
        GameRegistry.addRecipe(new ItemStack(kisteLachs), "*", "#", '*', new ItemStack(Items.FISH, 1, 1), '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteLachs), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', new ItemStack(Items.FISH, 1, 1));

        final Block kisteKarotte = new Block(Material.WOOD).setUnlocalizedName("Karottenkiste").setCreativeTab(tab)
                .setHardness(2.0F).setResistance(5.0F);
        registerBlock(kisteKarotte, "Karottenkiste");
        GameRegistry.addRecipe(new ItemStack(kisteKarotte), "*", "#", '*', Items.CARROT, '#', kiste);
        GameRegistry.addRecipe(new ItemStack(kisteKarotte), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.CARROT);

        // walls
        final Wall stoneWall = new Wall(tab, Blocks.STONE, "stone_wall");
        registerBlock(stoneWall, "stone_wall");
        GameRegistry.addRecipe(new ItemStack(stoneWall, 6), "###", "AAA", "AAA", 'A', Blocks.STONE);
        final Wall brickWall = new Wall(tab, Blocks.BRICK_BLOCK, "brick_wall");
        registerBlock(brickWall, "brick_wall");
        GameRegistry.addRecipe(new ItemStack(brickWall, 6), "###", "AAA", "AAA", 'A', Blocks.BRICK_BLOCK);
        final Wall stonebrickWall = new Wall(tab, Blocks.STONEBRICK, "stonebrick_wall");
        registerBlock(stonebrickWall, "stonebrick_wall");
        GameRegistry.addRecipe(new ItemStack(stonebrickWall, 6), "###", "AAA", "AAA", 'A', Blocks.STONEBRICK);
        final Wall sandstoneWall = new Wall(tab, Blocks.SANDSTONE, "sandstone_wall");
        registerBlock(sandstoneWall, "sandstone_wall");
        GameRegistry.addRecipe(new ItemStack(sandstoneWall, 6), "###", "AAA", "AAA", 'A', Blocks.SANDSTONE);
        final Wall redSandstoneWall = new Wall(tab, Blocks.RED_SANDSTONE, "red_sandstone_wall");
        registerBlock(redSandstoneWall, "red_sandstone_wall");
        GameRegistry.addRecipe(new ItemStack(redSandstoneWall, 6), "###", "AAA", "AAA", 'A', Blocks.RED_SANDSTONE);
        final Wall woolWall = new Wall(tab, Blocks.WOOL, "wool_wall");
        registerBlock(woolWall, "wool_wall");
        GameRegistry.addRecipe(new ItemStack(woolWall, 6), "###", "AAA", "AAA", 'A', Blocks.WOOL);

        final Wall leaveWall = new WallLeaves(tab, Blocks.LEAVES2, "leave_wall");
        registerBlock(leaveWall, "leave_wall");
        GameRegistry.addRecipe(new ItemStack(leaveWall, 6), "###", "AAA", "AAA", 'A', Blocks.LEAVES);

        for (int color = 0; color <= 15; color++) {
            final BlockStairs woolStairs = new WoolStairs(tab, Blocks.WOOL.getDefaultState(), "wool_stairs_" + color);
            registerBlock(woolStairs, "wool_stairs_" + color);
            GameRegistry.addRecipe(new ItemStack(woolStairs, 4), "A##", "AA#", "AAA", 'A', new ItemStack(Blocks.WOOL, 1, color));
        }
        //TODO add wool slabs
    }

    private void registerTools(final CreativeTabs tabKalle) {
        final Item emeraldAxe = new ItemAxeEmerald(tabKalle, "EmeraldAxe");
        GameRegistry.addRecipe(new ItemStack(emeraldAxe), "##0", "#*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(emeraldAxe, "EmeraldAxe");
        final ItemBattleAxeEmerald emeraldBattleAxe = new ItemBattleAxeEmerald(tabKalle, "EmeraldBattleAxe");
        GameRegistry.addRecipe(new ItemStack(emeraldBattleAxe), "###", "#*#", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(emeraldBattleAxe, "EmeraldBattleAxe");
        final Item emeraldSpade = new ItemSpadeEmerald(tabKalle, "EmeraldSpade");
        GameRegistry.addRecipe(new ItemStack(emeraldSpade), "0#0", "0*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(emeraldSpade, "EmeraldSpade");
        final Item emeraldHoe = new ItemHoeEmerald(tabKalle, "EmeraldHoe");
        GameRegistry.addRecipe(new ItemStack(emeraldHoe), "##0", "0*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(emeraldHoe, "EmeraldHoe");
        final Item emeraldSword = new ItemSwordEmerald(tabKalle, "EmeraldSword");
        GameRegistry.addRecipe(new ItemStack(emeraldSword), "0#0", "0#0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(emeraldSword, "EmeraldSword");
    }

    // ----- Methoden -----
    private void initCraftingRecipes() {
        // some additional smelting recipes
        GameRegistry.addSmelting(Items.POISONOUS_POTATO, new ItemStack(Items.POTATO), 0.25f);
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BEEF), 0.25f);
        GameRegistry.addSmelting(Blocks.QUARTZ_BLOCK, new ItemStack(Items.QUARTZ, 8), 0.25f);

        // add old book recipe
        GameRegistry.addRecipe(new ItemStack(Items.BOOK), "#", "#", "#", '#', Items.PAPER);

        // conversions
        GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND, 1), new ItemStack(Items.EMERALD),
                new ItemStack(Items.EMERALD), new ItemStack(Items.EMERALD));
        GameRegistry.addShapelessRecipe(new ItemStack(Items.EMERALD, 3), new ItemStack(Items.DIAMOND));

        // TODO what is this for?
        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 0), "#0#", "000", "#0#", '#',
                new ItemStack(Blocks.PLANKS, 1, 0));
        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 1), "#0#", "000", "#0#", '#',
                new ItemStack(Blocks.PLANKS, 1, 1));
        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 2), "#0#", "000", "#0#", '#',
                new ItemStack(Blocks.PLANKS, 1, 2));
        GameRegistry.addRecipe(new ItemStack(Blocks.PLANKS, 1, 3), "#0#", "000", "#0#", '#',
                new ItemStack(Blocks.PLANKS, 1, 3));

        // mossy cobblestone
        GameRegistry.addRecipe(new ItemStack(Blocks.MOSSY_COBBLESTONE, 1, 3), "000", "0AB", "000", 'A', Blocks.COBBLESTONE, '#',
                Items.WHEAT_SEEDS);

        // chiseled stone bricks
        GameRegistry.addRecipe(new ItemStack(Blocks.STONEBRICK, 1, 3), "+++", "+#+", "+++", '+', Items.FLINT, '#',
                Blocks.STONEBRICK);

        // add recipes for non-craftable items
        GameRegistry.addRecipe(new ItemStack(Items.SADDLE), "###", "#0#", "*0*", '#', Items.LEATHER, '*', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), "00*", "*#*", "***", '#', Blocks.WOOL, '*',
                Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR), "00*", "*#*", "***", '#', Blocks.WOOL, '*',
                Items.GOLD_INGOT);
        GameRegistry.addRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR), "00*", "*#*", "***", '#', Blocks.WOOL, '*',
                Items.DIAMOND);
        GameRegistry.addRecipe(new ItemStack(Items.NAME_TAG), "00#", "**0", "**0", '#', Items.STRING, '*', Items.PAPER);
        GameRegistry.addRecipe(new ItemStack(Items.LEAD), "##0", "##0", "00#", '#', Items.STRING);
    }

    /**
     * Registers a {@link Block} in the {@link GameRegistry} and registers a
     * {@link ModelResourceLocation} using the {@link Basis#MOD_PREFIX} and given
     * blockname.
     *
     * @param block        new {@link Block} to register
     * @param blockname    name to use for block and inventory resource
     * @param variantNames additional variants for the block
     */
    private void registerBlock(final Block block, final String blockname, String... variantNames) {
        LOG.debug("Registering block " + blockname);
        GameRegistry.registerBlock(block, blockname);
        final Item itemBlockSimple = GameRegistry.findItem(Basis.MOD_PREFIX, blockname);
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Basis.MOD_PREFIX + ":" + blockname,
                "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE,
                itemModelResourceLocation);
        for (String variant : variantNames) {
            LOG.debug("Adding variant " + variant);
            ModelResourceLocation itemModelVariantResourceLocation = new ModelResourceLocation(Basis.MOD_PREFIX + ":" + blockname + "_" + variant,
                    "inventory");
            ModelBakery.registerItemVariants(itemBlockSimple, itemModelVariantResourceLocation);
        }
    }

    /**
     * Registers an {@link Item} in the {@link GameRegistry} and registers a
     * {@link ModelResourceLocation} using the {@link Basis#MOD_PREFIX} and given
     * itemName.
     *
     * @param item     new {@link Item} to register
     * @param itemName name to use for item and inventory resource
     */
    private void registerItem(final Item item, final String itemName) {
        LOG.debug("Registering item " + itemName);
        // required in order for the renderer to know how to render your item.
        // Likely to change in the near future.
        final ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Basis.MOD_PREFIX + ":" + itemName,
                "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE,
                itemModelResourceLocation);
        GameRegistry.registerItem(item, itemName);
    }

}
