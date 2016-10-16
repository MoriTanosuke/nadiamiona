package kalle.proxies;

import kalle.Basis;
import kalle.blocks.BlockBar;
import kalle.blocks.BlockParkett;
import kalle.blocks.Wall;
import kalle.blocks.WallLeaves;
import kalle.foods.ItemDrink;
import kalle.tools.ItemAxeEmerald;
import kalle.tools.ItemHoeEmerald;
import kalle.tools.ItemPickaxeEmerald;
import kalle.tools.ItemSpadeEmerald;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

public class BasisCommonProxy {
  static final Logger LOG = FMLLog.getLogger();

  public void preInit() {
    LOG.info("Pre-Initializing common proxy...");
    // TODO what to do on both sides?

    LOG.debug("Creating objects...");
    // initialize EmeraldPickaxe first, to use as creative tab icon
    final ItemPickaxeEmerald emeraldPickaxe = new ItemPickaxeEmerald("EmeraldPickaxe");
    GameRegistry.addRecipe(new ItemStack(emeraldPickaxe), "###", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
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

    // try to create a block with custom shape
    final Block customBlock = new Block(Material.wood) {
      @Override
      public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {
        setBlockBounds(0.25f, 0f, 0.25f, 0.75f, 0.5f, 0.75f);
      }

      @Override
      public boolean isFullCube() {
        return false;
      }

      @Override
      public boolean isOpaqueCube() {
        return false;
      }
    };
    customBlock.setUnlocalizedName("smallBlock").setCreativeTab(tabKalle);
    registerBlock(customBlock, "smallBlock");

    LOG.info("All done.");
  };

  public void load() {
    // TODO what to do on both sides?
  };

  public void postInit() {
    // TODO what to do on both sides?
  };

  private void registerUtilities(final CreativeTabs tabKalle) {
    final Item ketten_glieder = new Item().setUnlocalizedName("Kettenglieder").setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(ketten_glieder, 6), "0#0", "#0#", "0#0", '#', Items.iron_ingot);
    GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots), "000", "#0#", "#0#", '#', ketten_glieder);
    GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet), "###", "#0#", "000", '#', ketten_glieder);
    GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings), "###", "#0#", "#0#", '#', ketten_glieder);
    GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate), "#0#", "###", "###", '#', ketten_glieder);
    registerItem(ketten_glieder, "Kettenglieder");

    // Spawner
    GameRegistry.addRecipe(new ItemStack(Blocks.mob_spawner, 1, 2), "#", "#", "#", '#', ketten_glieder);
  }

  private void registerFoods(final CreativeTabs tabKalle) {
    // Food
    final Item breadslice = new ItemFood(1, 0.1F, false).setUnlocalizedName("Breadslice")
            .setCreativeTab(tabKalle);
    GameRegistry.addShapelessRecipe(new ItemStack(breadslice, 4), new ItemStack(Items.bread));
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
        Items.cooked_chicken);
    registerItem(sandwich_chicken, "Chickensandwich");
    final Item sandwich_fish = new ItemFood(7, 0.66F, false).setUnlocalizedName("Lachssandwich")
        .setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(sandwich_fish), "#", "*", "#", '#', toast, '*', Items.cooked_fish);
    registerItem(sandwich_fish, "Lachssandwich");
    final Item sandwich_bacon = new ItemFood(10, 0.75F, false).setUnlocalizedName("Schinkensandwich")
        .setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(sandwich_bacon), "#", "*", "#", '#', toast, '*',
        Items.cooked_porkchop);
    registerItem(sandwich_bacon, "Schinkensandwich");
    final Item sandwich_beef = new ItemFood(10, 0.75F, false).setUnlocalizedName("Roastbeefsandwich")
        .setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(sandwich_beef), "#", "*", "#", '#', toast, '*', Items.cooked_beef);
    registerItem(sandwich_beef, "Roastbeefsandwich");

    final Item cookedEgg = new ItemFood(2, 0.1F, false).setUnlocalizedName("CookedEgg").setCreativeTab(tabKalle);
    GameRegistry.addSmelting(Items.egg, new ItemStack(cookedEgg), 0.25f);
    registerItem(cookedEgg, "CookedEgg");

    final Item eiertoast = new ItemFood(5, 0.5F, false).setUnlocalizedName("Eiertoast").setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(eiertoast), "*", "#", '#', toast, '*', cookedEgg);
    registerItem(eiertoast, "Eiertoast");

    // Drinks
    final Item milch = new Item().setUnlocalizedName("Milchflasche").setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(milch, 3), "0#0", "***", '#', Items.milk_bucket, '*', Items.glass_bottle);
    registerItem(milch, "Milchflasche");

    final Item bier = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Bier").setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(bier), "A", "B", 'A', Items.wheat_seeds, 'B', Items.potionitem);
    GameRegistry.addRecipe(new ItemStack(bier, 3), "0A0", "BBB", "CCC", 'A', Items.water_bucket, 'B', Items.wheat_seeds,
        'C', Items.glass_bottle);
    registerItem(bier, "Bier");
    final Item kakao = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Kakao").setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(kakao), "A", "B", "C", 'A', new ItemStack(Items.dye, 1, 3), 'B', Items.sugar,
        'C', milch);
    GameRegistry.addRecipe(new ItemStack(kakao, 3), "DAD", "BBB", "CCC", 'A', Items.milk_bucket, 'B',
        new ItemStack(Items.dye, 1, 3), 'C', Items.glass_bottle, 'D', Items.sugar);
    registerItem(kakao, "Schokomilch");
    final Item saft = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Saft").setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(saft), "A", "B", "C", 'A', Items.apple, 'B', Items.carrot, 'C',
        Items.glass_bottle);
    GameRegistry.addRecipe(new ItemStack(saft, 3), "AAA", "BBB", "CCC", 'A', Items.apple, 'B', Items.carrot, 'C',
        Items.glass_bottle);
    registerItem(saft, "Saft");

    final Item schnaps = new ItemDrink(1, 0.1F, false).setUnlocalizedName("Schnaps").setCreativeTab(tabKalle);
    GameRegistry.addSmelting(Items.reeds, new ItemStack(schnaps), 0.25f);
    registerItem(schnaps, "Schnaps");
    final Item likoer = new ItemDrink(5, 0.3F, false).setUnlocalizedName("Eierlikoer").setCreativeTab(tabKalle);
    GameRegistry.addRecipe(new ItemStack(likoer), "A", "B", "C", 'A', cookedEgg, 'B', schnaps, 'C', Items.glass_bottle);
    registerItem(likoer, "Eierlikoer");
  }

  private void registerBlocks(final CreativeTabs tab) {
    final BlockBar theke = new BlockBar(tab);
    registerBlock(theke, "Theke");
    GameRegistry.addRecipe(new ItemStack(theke), "0000", "BBB", "AAA", 'A', new ItemStack(Blocks.planks, 1, 0), 'B',
        new ItemStack(Blocks.wooden_slab, 1, 0));
    final BlockBar spruceTheke = new BlockBar(tab, "SpruceTheke");
    registerBlock(spruceTheke, "SpruceTheke");
    GameRegistry.addRecipe(new ItemStack(spruceTheke), "0000", "BBB", "AAA", 'A', new ItemStack(Blocks.planks, 1, 1),
        'B', new ItemStack(Blocks.wooden_slab, 1, 1));
    final BlockBar jungleTheke = new BlockBar(tab, "JungleTheke");
    registerBlock(jungleTheke, "JungleTheke");
    GameRegistry.addRecipe(new ItemStack(jungleTheke), "0000", "BBB", "AAA", 'A', new ItemStack(Blocks.planks, 1, 2),
        'B', new ItemStack(Blocks.wooden_slab, 1, 2));
    final BlockBar acaciaTheke = new BlockBar(tab, "AcaciaTheke");
    registerBlock(acaciaTheke, "AcaciaTheke");
    GameRegistry.addRecipe(new ItemStack(acaciaTheke), "0000", "BBB", "AAA", 'A', new ItemStack(Blocks.planks, 1, 3),
        'B', new ItemStack(Blocks.wooden_slab, 1, 3));
    final BlockBar birchTheke = new BlockBar(tab, "BirchTheke");
    registerBlock(birchTheke, "BirchTheke");
    GameRegistry.addRecipe(new ItemStack(birchTheke), "0000", "BBB", "AAA", 'A', new ItemStack(Blocks.planks, 1, 3), 'B',
        new ItemStack(Blocks.wooden_slab, 1, 4));
    final BlockBar darkOakTheke = new BlockBar(tab, "DarkOakTheke");
    registerBlock(darkOakTheke, "DarkOakTheke");
    GameRegistry.addRecipe(new ItemStack(darkOakTheke), "0000", "BBB", "AAA", 'A', new ItemStack(Blocks.planks, 1, 3),
        'B', new ItemStack(Blocks.wooden_slab, 1, 5));

    final BlockParkett parkettHell = new BlockParkett(tab, "ParkettHell");
    registerBlock(parkettHell, "ParkettHell");
    final BlockParkett parkettDunkel = new BlockParkett(tab, "ParkettDunkel");
    registerBlock(parkettDunkel, "ParkettDunkel");
    final BlockParkett parkettAkazie = new BlockParkett(tab, "ParkettAkazie");
    registerBlock(parkettAkazie, "ParkettAkazie");
    final BlockParkett parkettBirch = new BlockParkett(tab, "ParkettBirke");
    registerBlock(parkettBirch, "ParkettBirke");
    final BlockParkett parkettDjungle = new BlockParkett(tab, "ParkettDschungel");
    registerBlock(parkettDjungle, "ParkettDschungel");
    final BlockParkett parkettDarkoak = new BlockParkett(tab, "ParkettDarkOak");
    registerBlock(parkettDarkoak, "ParkettDarkOak");
    final BlockParkett parkettOak = new BlockParkett(tab, "ParkettOak");
    registerBlock(parkettOak, "ParkettOak");
    final BlockParkett parkettSpruce = new BlockParkett(tab, "ParkettSpruce");
    registerBlock(parkettSpruce, "ParkettSpruce");

    final Block booksSpruce = new Block(Material.wood).setUnlocalizedName("BooksSpruce").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(booksSpruce, "BooksSpruce");
    GameRegistry.addRecipe(new ItemStack(booksSpruce), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 1),
        '*', Items.book);
    final Block booksJungle = new Block(Material.wood).setUnlocalizedName("BooksJungle").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(booksJungle, "BooksJungle");
    GameRegistry.addRecipe(new ItemStack(booksJungle), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 3),
        '*', Items.book);
    final Block booksBirch = new Block(Material.wood).setUnlocalizedName("BooksBirch").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(booksBirch, "BooksBirch");
    GameRegistry.addRecipe(new ItemStack(booksBirch), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 2), '*',
        Items.book);
    final Block booksAcacia = new Block(Material.wood).setUnlocalizedName("BooksAcacia").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(booksAcacia, "BooksAcacia");
    GameRegistry.addRecipe(new ItemStack(booksAcacia), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 2), '*',
        Items.book);
    final Block booksDarkOak = new Block(Material.wood).setUnlocalizedName("BooksDarkOak").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(booksDarkOak, "BooksDarkOak");
    GameRegistry.addRecipe(new ItemStack(booksDarkOak), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 2), '*',
        Items.book);

    // Kisten
    final Block kiste = new Block(Material.wood).setUnlocalizedName("Kiste").setCreativeTab(tab).setHardness(2.0F)
        .setResistance(5.0F);
    registerBlock(kiste, "Kiste");
    GameRegistry.addRecipe(new ItemStack(kiste), "#0#", "#0#", "###", '#', Blocks.planks);

    final Block kisteKohle = new Block(Material.wood).setUnlocalizedName("Kohlekiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteKohle, "Kohlekiste");
    GameRegistry.addRecipe(new ItemStack(kisteKohle), "*", "#", '*', Items.coal, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteKohle), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.coal);

    final Block kisteEisen = new Block(Material.wood).setUnlocalizedName("Eisenkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteEisen, "Eisenkiste");
    GameRegistry.addRecipe(new ItemStack(kisteEisen), "*", "#", '*', Items.iron_ingot, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteEisen), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.iron_ingot);

    final Block kisteGold = new Block(Material.wood).setUnlocalizedName("Goldkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteGold, "Goldkiste");
    GameRegistry.addRecipe(new ItemStack(kisteGold), "*", "#", '*', Items.gold_ingot, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteGold), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.gold_ingot);

    final Block kisteDiamant = new Block(Material.wood).setUnlocalizedName("Diamantkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteDiamant, "Diamantkiste");
    GameRegistry.addRecipe(new ItemStack(kisteDiamant), "*", "#", '*', Items.diamond, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteDiamant), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.diamond);

    final Block kisteEmerald = new Block(Material.wood).setUnlocalizedName("Edelsteinkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteEmerald, "Edelsteinkiste");
    GameRegistry.addRecipe(new ItemStack(kisteEmerald), "*", "#", '*', Items.emerald, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteEmerald), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.emerald);

    final Block kisteLapis = new Block(Material.wood).setUnlocalizedName("Lapiskiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteLapis, "Lapiskiste");
    GameRegistry.addRecipe(new ItemStack(kisteLapis), "*", "#", '*', Items.dye, '#', kiste);

    final Block kisteApfel = new Block(Material.wood).setUnlocalizedName("Apfelkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteApfel, "Apfelkiste");
    GameRegistry.addRecipe(new ItemStack(kisteApfel), "*", "#", '*', Items.apple, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteApfel), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.apple);

    final Block kisteCookie = new Block(Material.wood).setUnlocalizedName("Keksekiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteCookie, "Keksekiste");
    GameRegistry.addRecipe(new ItemStack(kisteCookie), "*", "#", '*', Items.cookie, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteCookie), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.cookie);

    final Block kisteKartoffel = new Block(Material.wood).setUnlocalizedName("Kartoffelkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteKartoffel, "Kartoffelkiste");
    GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "*", "#", '*', Items.potato, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.potato);

    final Block kisteFisch = new Block(Material.wood).setUnlocalizedName("Fischkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteFisch, "Fischkiste");
    GameRegistry.addRecipe(new ItemStack(kisteFisch), "*", "#", '*', Items.fish, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteFisch), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.fish);

    final Block kisteKarotte = new Block(Material.wood).setUnlocalizedName("Karottenkiste").setCreativeTab(tab)
        .setHardness(2.0F).setResistance(5.0F);
    registerBlock(kisteKarotte, "Karottenkiste");
    GameRegistry.addRecipe(new ItemStack(kisteKarotte), "*", "#", '*', Items.carrot, '#', kiste);
    GameRegistry.addRecipe(new ItemStack(kisteKarotte), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.carrot);

    // walls
    final Wall brickWall = new Wall(tab, Blocks.brick_block, "brick_wall");
    registerBlock(brickWall, "brick_wall");
    final Wall stonebrickWall = new Wall(tab, Blocks.stonebrick, "stonebrick_wall");
    registerBlock(stonebrickWall, "stonebrick_wall");
    final Wall leaveWall = new WallLeaves(tab, Blocks.leaves2, "leave_wall");
    registerBlock(leaveWall, "leave_wall");
  }

  private void registerTools(final CreativeTabs tabKalle) {
    final Item emeraldAxe = new ItemAxeEmerald(tabKalle, "EmeraldAxe");
    GameRegistry.addRecipe(new ItemStack(emeraldAxe), "##0", "#*0", "0*0", '#', Items.emerald, '*', Items.stick);
    registerItem(emeraldAxe, "EmeraldAxe");
    final Item emeraldSpade = new ItemSpadeEmerald(tabKalle, "EmeraldSpade");
    GameRegistry.addRecipe(new ItemStack(emeraldSpade), "0#0", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
    registerItem(emeraldSpade, "EmeraldSpade");
    final Item emeraldHoe = new ItemHoeEmerald(tabKalle, "EmeraldHoe");
    GameRegistry.addRecipe(new ItemStack(emeraldHoe), "##0", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
    registerItem(emeraldHoe, "EmeraldHoe");
    final Item emeraldSword = new ItemHoeEmerald(tabKalle, "EmeraldSword");
    GameRegistry.addRecipe(new ItemStack(emeraldSword), "0#0", "0#0", "0*0", '#', Items.emerald, '*', Items.diamond);
    registerItem(emeraldSword, "EmeraldSword");
  }

  // ----- Methoden -----
  private void initCraftingRecipes() {
    // some additional smelting recipes
    GameRegistry.addSmelting(Items.poisonous_potato, new ItemStack(Items.potato), 0.25f);
    GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.beef), 0.25f);

    // add old book recipe
    GameRegistry.addRecipe(new ItemStack(Items.book), "#", "#", "#", '#', Items.paper);

    // conversions
    GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new ItemStack(Items.emerald),
        new ItemStack(Items.emerald), new ItemStack(Items.emerald));
    GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 3), new ItemStack(Items.diamond));

    // TODO what is this for?
    GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 0), "#0#", "000", "#0#", '#',
        new ItemStack(Blocks.planks, 1, 0));
    GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 1), "#0#", "000", "#0#", '#',
        new ItemStack(Blocks.planks, 1, 1));
    GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 2), "#0#", "000", "#0#", '#',
        new ItemStack(Blocks.planks, 1, 2));
    GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 3), "#0#", "000", "#0#", '#',
        new ItemStack(Blocks.planks, 1, 3));

    // chiseled stone bricks
    GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), "+++", "+#+", "+++", '+', Items.flint, '#',
        Blocks.stonebrick);

    // add recipes for non-craftable items
    GameRegistry.addRecipe(new ItemStack(Items.saddle), "###", "#0#", "*0*", '#', Items.leather, '*', Items.iron_ingot);
    GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), "00*", "*#*", "***", '#', Blocks.wool, '*',
        Items.iron_ingot);
    GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor), "00*", "*#*", "***", '#', Blocks.wool, '*',
        Items.gold_ingot);
    GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor), "00*", "*#*", "***", '#', Blocks.wool, '*',
        Items.diamond);
    GameRegistry.addRecipe(new ItemStack(Items.name_tag), "00#", "**0", "**0", '#', Items.string, '*', Items.paper);
    GameRegistry.addRecipe(new ItemStack(Items.lead), "##0", "##0", "00#", '#', Items.string);
  }

  /**
   * Registers a {@link Block} in the {@link GameRegistry} and registers a
   * {@link ModelResourceLocation} using the {@link Basis#MOD_PREFIX} and given
   * blockname.
   * 
   * @param block
   *          new {@link Block} to register
   * @param blockname
   *          name to use for block and inventory resource
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
      ModelBakery.addVariantName(itemBlockSimple, variant);
    }
  }

  /**
   * Registers an {@link Item} in the {@link GameRegistry} and registers a
   * {@link ModelResourceLocation} using the {@link Basis#MOD_PREFIX} and given
   * itemName.
   * 
   * @param item
   *          new {@link Item} to register
   * @param itemName
   *          name to use for item and inventory resource
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
