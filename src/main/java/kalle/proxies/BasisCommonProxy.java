package kalle.proxies;

import kalle.Basis;
import kalle.foods.ItemDrink;
import kalle.tools.Tools;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

public class BasisCommonProxy {
    static final Logger LOG = FMLLog.getLogger();

    public void preInit() {
        LOG.info("Pre-Initializing common proxy...");
        // TODO what to do on both sides?

        LOG.debug("Registering objects...");
        registerFoods(Tabs.tab);
        registerUtilities(Tabs.tab);
        registerTools();

        LOG.debug("Registering all tools in creative tab...");
        // register in creative tab
        for (Item tool : Tools.all()) {
            tool.setCreativeTab(Tabs.tab);
        }

        LOG.debug("Adding crafting recipes...");
        initCraftingRecipes();

        LOG.info("All done.");
    }

    public void load() {
        // TODO what to do on both sides?
    }

    public void postInit() {
        // TODO what to do on both sides?
    }

    private void registerUtilities(final CreativeTabs tab) {
        final Item ketten_glieder = new Item().setUnlocalizedName("Kettenglieder").setCreativeTab(tab);
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

    private void registerFoods(final CreativeTabs tab) {
        // Food
        final Item breadslice = new ItemFood(1, 0.1F, false).setUnlocalizedName("Breadslice")
                .setCreativeTab(tab);
        GameRegistry.addShapelessRecipe(new ItemStack(breadslice, 4), new ItemStack(Items.BREAD));
        registerItem(breadslice, "Breadslice");
        // toast
        final Item toast = new ItemFood(1, 0.2F, false).setUnlocalizedName("Toast")
                .setCreativeTab(tab);
        GameRegistry.addSmelting(breadslice, new ItemStack(toast), 0.25f);
        registerItem(toast, "Toast");
        // TODO replace with variants?
        final Item sandwich_chicken = new ItemFood(8, 0.66F, false).setUnlocalizedName("Chickensandwich")
                .setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(sandwich_chicken), "#", "*", "#", '#', toast, '*',
                Items.COOKED_CHICKEN);
        registerItem(sandwich_chicken, "Chickensandwich");
        final Item sandwich_fish = new ItemFood(7, 0.66F, false).setUnlocalizedName("Fischsandwich")
                .setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(sandwich_fish), "#", "*", "#", '#', toast, '*', new ItemStack(Items.COOKED_FISH, 1, 0));
        registerItem(sandwich_fish, "Fischsandwich");
        final Item sandwich_salmon = new ItemFood(7, 0.66F, false).setUnlocalizedName("Lachssandwich")
                .setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(sandwich_salmon), "#", "*", "#", '#', toast, '*', new ItemStack(Items.COOKED_FISH, 1, 1));
        registerItem(sandwich_salmon, "Lachssandwich");
        final Item sandwich_bacon = new ItemFood(10, 0.75F, false).setUnlocalizedName("Schinkensandwich")
                .setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(sandwich_bacon), "#", "*", "#", '#', toast, '*',
                Items.COOKED_PORKCHOP);
        registerItem(sandwich_bacon, "Schinkensandwich");
        final Item sandwich_beef = new ItemFood(10, 0.75F, false).setUnlocalizedName("Roastbeefsandwich")
                .setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(sandwich_beef), "#", "*", "#", '#', toast, '*', Items.COOKED_BEEF);
        registerItem(sandwich_beef, "Roastbeefsandwich");

        final Item cookedEgg = new ItemFood(2, 0.1F, false).setUnlocalizedName("CookedEgg").setCreativeTab(tab);
        GameRegistry.addSmelting(Items.EGG, new ItemStack(cookedEgg), 0.25f);
        registerItem(cookedEgg, "CookedEgg");

        final Item eiertoast = new ItemFood(5, 0.5F, false).setUnlocalizedName("Eiertoast").setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(eiertoast), "*", "#", '#', toast, '*', cookedEgg);
        registerItem(eiertoast, "Eiertoast");

        // Drinks
        final Item milch = new Item().setUnlocalizedName("Milchflasche").setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(milch, 3), "0#0", "***", '#', Items.MILK_BUCKET, '*', Items.GLASS_BOTTLE);
        registerItem(milch, "Milchflasche");

        final Item bier = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Bier").setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(bier), "A", "B", 'A', Items.WHEAT_SEEDS, 'B', Items.POTIONITEM);
        GameRegistry.addRecipe(new ItemStack(bier, 3), "0A0", "BBB", "CCC", 'A', Items.WATER_BUCKET, 'B', Items.WHEAT_SEEDS,
                'C', Items.GLASS_BOTTLE);
        registerItem(bier, "Bier");
        final Item kakao = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Kakao").setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(kakao), "A", "B", "C", 'A', new ItemStack(Items.DYE, 1, 3), 'B', Items.SUGAR,
                'C', milch);
        GameRegistry.addRecipe(new ItemStack(kakao, 3), "DAD", "BBB", "CCC", 'A', Items.MILK_BUCKET, 'B',
                new ItemStack(Items.DYE, 1, 3), 'C', Items.GLASS_BOTTLE, 'D', Items.SUGAR);
        registerItem(kakao, "Schokomilch");
        final Item saft = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Saft").setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(saft), "A", "B", "C", 'A', Items.APPLE, 'B', Items.CARROT, 'C',
                Items.GLASS_BOTTLE);
        GameRegistry.addRecipe(new ItemStack(saft, 3), "AAA", "BBB", "CCC", 'A', Items.APPLE, 'B', Items.CARROT, 'C',
                Items.GLASS_BOTTLE);
        registerItem(saft, "Saft");

        final Item schnaps = new ItemDrink(1, 0.1F, false).setUnlocalizedName("Schnaps").setCreativeTab(tab);
        GameRegistry.addSmelting(Items.REEDS, new ItemStack(schnaps), 0.25f);
        registerItem(schnaps, "Schnaps");
        final Item likoer = new ItemDrink(5, 0.3F, false).setUnlocalizedName("Eierlikoer").setCreativeTab(tab);
        GameRegistry.addRecipe(new ItemStack(likoer), "A", "B", "C", 'A', cookedEgg, 'B', schnaps, 'C', Items.GLASS_BOTTLE);
        registerItem(likoer, "Eierlikoer");
    }

    private void registerTools() {
        GameRegistry.addRecipe(new ItemStack(Tools.EMERALD_PICKAXE), "###", "0*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(Tools.EMERALD_PICKAXE, "EmeraldPickaxe");
        GameRegistry.addRecipe(new ItemStack(Tools.EMERALD_AXE), "##0", "#*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(Tools.EMERALD_AXE, "EmeraldAxe");
        GameRegistry.addRecipe(new ItemStack(Tools.EMERALD_BATTLEAXE), "###", "#*#", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(Tools.EMERALD_BATTLEAXE, "EmeraldBattleAxe");
        GameRegistry.addRecipe(new ItemStack(Tools.EMERALD_SPADE), "0#0", "0*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(Tools.EMERALD_SPADE, "EmeraldSpade");
        GameRegistry.addRecipe(new ItemStack(Tools.EMERALD_HOE), "##0", "0*0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(Tools.EMERALD_HOE, "EmeraldHoe");
        GameRegistry.addRecipe(new ItemStack(Tools.EMERALD_SWORD), "0#0", "0#0", "0*0", '#', Items.EMERALD, '*', Items.DIAMOND);
        registerItem(Tools.EMERALD_SWORD, "EmeraldSword");
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
        //TODO fix ModelResourceLocation for items
        final ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Basis.MOD_PREFIX + ":" + itemName,
                "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE,
                itemModelResourceLocation);
        GameRegistry.registerItem(item, itemName);
    }
}
