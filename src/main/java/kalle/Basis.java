package kalle;

import org.apache.logging.log4j.Logger;

import kalle.proxies.BasisCommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

//TODO replace with build.gradle properties
@Mod(modid = "kalle", name = "Kalle's Mod Compilation", version = "0.0.1")
public class Basis {
	private static final String MOD_PREFIX = "kalle";

	private static final Logger LOG = FMLLog.getLogger();

	@Instance(MOD_PREFIX)
	public static Basis instance;

	@SidedProxy(clientSide = "kalle.proxies.BasisClientProxy", serverSide = "kalle.proxies.BasisCommonProxy")
	public static BasisCommonProxy proxy;

	// items
	private static Item bier;

	private static Item kakao;

	private static Item saft;

	private static Item breadslicetoast;

	private static Item coockedEgg;

	private static Item sandwich_chicken;

	private static Item sandwich_fish;

	private static Item sandwich_bacon;

	private static Item sandwich_beef;

	private static Item eiertoast;

	private static Item schnaps;

	private static Item likoer;

	private static Item ketten_glieder;

	private static Item milch;

	// blocks
	private static MultiBlockBasis unobtanium;

	private static MultiBlockBasis theke;

	private static MultiBlockBasis parkettHell;

	private static MultiBlockBasis parkettDunkel;

	private static MultiBlockBasis lamp;

	private static MultiBlockBasis booksSpruce;

	private static MultiBlockBasis booksJungle;

	private static MultiBlockBasis booksBirch;

	private static MultiBlockBasis fensterNS;

	private static MultiBlockBasis fensterSN;

	private static MultiBlockBasis fensterWO;

	private static MultiBlockBasis fensterOW;

	// tools
	private static Item emeraldPickaxe;

	private static Item emeraldAxe;

	private static Item emeraldSpade;

	private static Item emeraldHoe;

	@EventHandler
	public void preInit(FMLInitializationEvent event) {
		LOG.debug("Creating objects...");
		// Nahrung
		bier = new ItemDrink(5, 0.5F, false).setUnlocalizedName("bier").setCreativeTab(tabKalle);
		kakao = new ItemDrink(5, 0.5F, false).setUnlocalizedName("kakao").setCreativeTab(tabKalle);
		saft = new ItemDrink(5, 0.5F, false).setUnlocalizedName("saft").setCreativeTab(tabKalle);

		breadslicetoast = new ItemFood(1, 0.1F, false).setUnlocalizedName("breadslice").setCreativeTab(tabKalle);
		coockedEgg = new ItemFood(2, 0.1F, false).setUnlocalizedName("coockedEgg").setCreativeTab(tabKalle);

		sandwich_chicken = new ItemFood(8, 0.66F, false).setUnlocalizedName("sandwich_c").setCreativeTab(tabKalle);
		sandwich_fish = new ItemFood(7, 0.66F, false).setUnlocalizedName("sandwich_f").setCreativeTab(tabKalle);
		sandwich_bacon = new ItemFood(10, 0.75F, false).setUnlocalizedName("sandwich_p").setCreativeTab(tabKalle);
		sandwich_beef = new ItemFood(10, 0.75F, false).setUnlocalizedName("sandwich_b").setCreativeTab(tabKalle);

		eiertoast = new ItemFood(5, 0.5F, false).setUnlocalizedName("Eiertoast").setCreativeTab(tabKalle);
		schnaps = (ItemDrink) new ItemDrink(1, 0.1F, false).setUnlocalizedName("Schnaps").setCreativeTab(tabKalle);
		likoer = (ItemDrink) new ItemDrink(5, 0.3F, false).setUnlocalizedName("Eierlikoer").setCreativeTab(tabKalle);

		// Teile zum Craften
		ketten_glieder = new Item().setUnlocalizedName("Kettenglieder").setCreativeTab(tabKalle);
		milch = new Item().setUnlocalizedName("Milchflasche").setCreativeTab(tabKalle);

		// Specialblock
		unobtanium = (MultiBlockBasis) new MultiBlockBasis(Material.rock).setUnlocalizedName("Unobtanium").setCreativeTab(tabKalle).setBlockUnbreakable().setResistance(65535.0F);

		// Moebel
		theke = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setUnlocalizedName("Theke").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		parkettHell = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setUnlocalizedName("ParkettHell").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		parkettDunkel = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setUnlocalizedName("ParkettDunkel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);

		lamp = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setUnlocalizedName("Lamp").setCreativeTab(tabKalle).setHardness(0.5F).setLightLevel(1.0F);

		booksSpruce = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setUnlocalizedName("BooksSpruce").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		booksJungle = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setUnlocalizedName("BooksJungle").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		booksBirch = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setUnlocalizedName("BooksBirch").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);

		fensterNS = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setUnlocalizedName("FensterNS").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);
		fensterSN = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setUnlocalizedName("FensterSN").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);

		fensterWO = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setUnlocalizedName("FensterWO").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);
		fensterOW = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setUnlocalizedName("FensterOW").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);

		// Kisten
		final Block kiste = new Block(Material.wood).setUnlocalizedName("Kiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kiste, "Kiste");

		final Block kisteKohle = new Block(Material.wood).setUnlocalizedName("Kohlekiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteKohle, "Kohlekiste");
		final Block kisteEisen = new Block(Material.wood).setUnlocalizedName("Eisenkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteEisen, "Eisenkiste");
		final Block kisteGold = new Block(Material.wood).setUnlocalizedName("Goldkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteGold, "Goldkiste");
		final Block kisteDiamant = new Block(Material.wood).setUnlocalizedName("Diamantkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteDiamant, "Diamantkiste");
		final Block kisteEmerald = new Block(Material.wood).setUnlocalizedName("Edelsteinkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteEmerald, "Edelsteinkiste");
		final Block kisteLapis = new Block(Material.wood).setUnlocalizedName("Lapiskiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteLapis, "Lapiskiste");

		final Block kisteApfel = new Block(Material.wood).setUnlocalizedName("Apfelkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteApfel, "Apfelkiste");
		final Block kisteCookie = new Block(Material.wood).setUnlocalizedName("Keksekiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteCookie, "Keksekiste");
		final Block kisteKartoffel = new Block(Material.wood).setUnlocalizedName("Kartoffelkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteKartoffel, "Kartoffelkiste");
		final Block kisteFisch = new Block(Material.wood).setUnlocalizedName("Fischkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteFisch, "Fischkiste");
		final Block kisteKarotte = new Block(Material.wood).setUnlocalizedName("Karottenkiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteKarotte, "Karottenkiste");

		// Tools
		emeraldPickaxe = new ItemPickaxeEmerald().setUnlocalizedName("EmeraldPickaxe").setCreativeTab(tabKalle);
		emeraldAxe = new ItemAxeEmerald().setUnlocalizedName("EmeraldAxe").setCreativeTab(tabKalle);
		emeraldSpade = new ItemSpadeEmerald().setUnlocalizedName("EmeraldSpade").setCreativeTab(tabKalle);
		emeraldHoe = new ItemHoeEmerald().setUnlocalizedName("EmeraldHoe").setCreativeTab(tabKalle);

		// Weapon
		// Ammo = (ItemBasis) new
		// ItemBasis(AmmoID).setUnlocalizedName("Ammo").setCreativeTab(tabTest);
		// Ammo.setTextureName(ASSETS_PREFIX + "Ammo");
		// Revolver = (ItemWeapon) new
		// ItemWeapon(RevolverID).setUnlocalizedName("Revolver").setCreativeTab(tabTest);
		// Revolver.setTextureName(ASSETS_PREFIX + "Weapon");

		// Zauberstab = (ItemRod) new
		// ItemRod(ZauberstabID).setUnlocalizedName("Zauberstab").setCreativeTab(tabTest);
		// Zauberstab.setTextureName(ASSETS_PREFIX + "magic_rod");
		// Krawams = (ItemBomb) new
		// ItemBomb(KrawamsID).setUnlocalizedName("Krawams").setCreativeTab(tabTest);
		// Krawams.setTextureName(ASSETS_PREFIX + "Bomb");

		LOG.info("Registering items...");
		registerItems();
		LOG.info("Registering blocks...");
		registerBlocks();
		LOG.info("Adding crafting recipes...");
		initCraftingRecipes();
		LOG.info("Adding smelting recipes...");
		initSmeltingRecipes();
		LOG.info("All done.");
	}

	// ----- Methoden -----
	private void initCraftingRecipes() {
		// Fixes
		GameRegistry.addRecipe(new ItemStack(Items.book), "#", "#", "#", '#', Items.paper);

		// Block-Rezepte
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Blocks.cobblestone), new ItemStack(Items.wheat_seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new ItemStack(Blocks.stonebrick), new ItemStack(Items.wheat_seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new ItemStack(Items.emerald), new ItemStack(Items.emerald), new ItemStack(Items.emerald));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 3), new ItemStack(Items.diamond));

		// TODO what is this for?
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 0), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 0));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 1), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 2), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 2));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 3), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), "+++", "+#+", "+++", '+', Items.flint, '#', Blocks.stonebrick);

		// Tools
		GameRegistry.addRecipe(new ItemStack(emeraldPickaxe), "###", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
		GameRegistry.addRecipe(new ItemStack(emeraldAxe), "##0", "#*0", "0*0", '#', Items.emerald, '*', Items.stick);
		GameRegistry.addRecipe(new ItemStack(emeraldSpade), "0#0", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
		GameRegistry.addRecipe(new ItemStack(emeraldHoe), "##0", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);

		// Drink-Rezepte-Drink
		GameRegistry.addRecipe(new ItemStack(bier), "A", "B", 'A', Items.wheat_seeds, 'B', Items.potionitem);
		GameRegistry.addRecipe(new ItemStack(bier, 3), "0A0", "BBB", "CCC", 'A', Items.water_bucket, 'B', Items.wheat_seeds, 'C', Items.glass_bottle);

		GameRegistry.addRecipe(new ItemStack(kakao), "A", "B", "C", 'A', new ItemStack(Items.dye, 1, 3), 'B', Items.sugar, 'C', milch);
		GameRegistry.addRecipe(new ItemStack(kakao, 3), "DAD", "BBB", "CCC", 'A', Items.milk_bucket, 'B', new ItemStack(Items.dye, 1, 3), 'C', Items.glass_bottle, 'D', Items.sugar);

		GameRegistry.addRecipe(new ItemStack(saft), "A", "B", "C", 'A', Items.apple, 'B', Items.carrot, 'C', Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(saft, 3), "AAA", "BBB", "CCC", 'A', Items.apple, 'B', Items.carrot, 'C', Items.glass_bottle);

		GameRegistry.addRecipe(new ItemStack(likoer), "A", "B", "C", 'A', coockedEgg, 'B', schnaps, 'C', Items.glass_bottle);

		// Food-Rezepte-Eat
		GameRegistry.addShapelessRecipe(new ItemStack(breadslicetoast, 4), new ItemStack(Items.bread));

		GameRegistry.addRecipe(new ItemStack(sandwich_chicken), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_chicken);
		GameRegistry.addRecipe(new ItemStack(sandwich_fish), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_fish);
		GameRegistry.addRecipe(new ItemStack(sandwich_bacon), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_porkchop);
		GameRegistry.addRecipe(new ItemStack(sandwich_beef), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_beef);

		GameRegistry.addRecipe(new ItemStack(eiertoast), "*", "#", '#', breadslicetoast, '*', coockedEgg);

		// Items
		GameRegistry.addRecipe(new ItemStack(Items.saddle), "###", "#0#", "*0*", '#', Items.leather, '*', Items.iron_ingot);
		// GameRegistry.addRecipe(new ItemStack(Items.lead), "0#0", "#0#",
		// "0#0", '#', Items.silk);
		// GameRegistry.addRecipe(new ItemStack(Items.name_tag), "00#", "**0",
		// "**0", '#', Items.silk, '*', Items.paper);
		GameRegistry.addRecipe(new ItemStack(ketten_glieder, 6), "0#0", "#0#", "0#0", '#', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(milch, 3), "0#0", "***", '#', Items.milk_bucket, '*', Items.glass_bottle);

		// Horse Armor Iron, Gold, Diamant
		// GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), "00#",
		// "#*#", "###", '#', Items.iron_ingot, '*', new ItemStack(Blocks.cloth,
		// 1, 15));
		// GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor),
		// "00#", "#*#", "###", '#', Items.gold_ingot, '*', new
		// ItemStack(Blocks.cloth, 1, 14));
		// GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor),
		// "00#", "#*#", "###", '#', Items.diamond, '*', new
		// ItemStack(Blocks.cloth, 1, 11));

		// Armor Chain
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots), "000", "#0#", "#0#", '#', ketten_glieder);
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet), "###", "#0#", "000", '#', ketten_glieder);
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings), "###", "#0#", "#0#", '#', ketten_glieder);
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate), "#0#", "###", "###", '#', ketten_glieder);

		// Spawner
		// GameRegistry.addRecipe(new ItemStack(Blocks.mobSpawner, 1, 2), "#",
		// "#", "#", '#', Kettenglieder);

		// Ammo
		// GameRegistry.addRecipe(new ItemStack(Ammo, 16), "###", "#0#", "###",
		// '#', Blocks.stone);
	}

	// Ofen-Rezepte
	private void initSmeltingRecipes() {
		GameRegistry.addSmelting(Items.egg, new ItemStack(coockedEgg), 0.25f);
		GameRegistry.addSmelting(Items.poisonous_potato, new ItemStack(Items.potato), 0.25f);
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.beef), 0.25f);
		GameRegistry.addSmelting(Items.reeds, new ItemStack(schnaps), 0.25f);
	}

	private void registerItems() {
		GameRegistry.registerItem(bier, "Bier");
		GameRegistry.registerItem(kakao, "Schokomilch");
		GameRegistry.registerItem(saft, "Multivitaminsaft");
		GameRegistry.registerItem(milch, "Milchflasche");

		GameRegistry.registerItem(breadslicetoast, "Toastbrotscheibe");
		GameRegistry.registerItem(coockedEgg, "gekochtes Ei");

		GameRegistry.registerItem(sandwich_chicken, "Chickensandwich");
		GameRegistry.registerItem(sandwich_fish, "Lachssandwich");
		GameRegistry.registerItem(sandwich_bacon, "Schickensandwich");
		GameRegistry.registerItem(sandwich_beef, "Roastbeefsandwich");

		GameRegistry.registerItem(eiertoast, "Eiertoast");
		GameRegistry.registerItem(schnaps, "Schnaps");
		GameRegistry.registerItem(likoer, "Eierlikoer");

		GameRegistry.registerItem(ketten_glieder, "Kettenglieder");

		GameRegistry.registerItem(emeraldPickaxe, "EmeraldPickaxe");
		GameRegistry.registerItem(emeraldAxe, "EmeraldAxe");
		GameRegistry.registerItem(emeraldSpade, "EmeraldSpade");
		GameRegistry.registerItem(emeraldHoe, "EmeraldHoe");

		// GameRegistry.registerItem(Ammo, "Munition");
		// GameRegistry.registerItem(Revolver, "Revolver");

		// GameRegistry.registerItem(Zauberstab, "Zauberstab der Zeit");
		// GameRegistry.registerItem(Krawams, "Krawams");
	}

	private void registerBlocks() {
		GameRegistry.registerBlock(unobtanium, "Unobtanium");
		GameRegistry.registerBlock(theke, "Theke");
	    
		GameRegistry.registerBlock(parkettHell, "ParkettHell");
		GameRegistry.registerBlock(parkettDunkel, "ParkettDunkel");

		GameRegistry.registerBlock(booksSpruce, "Fichtenholzregal");
		GameRegistry.registerBlock(booksJungle, "Jungelholzregal");
		GameRegistry.registerBlock(booksBirch, "Birkenholzregal");

		GameRegistry.registerBlock(lamp, "Lightstone-Lampe");

		GameRegistry.registerBlock(fensterNS, "Fenster Nord-Sued");
		GameRegistry.registerBlock(fensterSN, "Fenster Sued-Nord");
		GameRegistry.registerBlock(fensterWO, "Fenster West-Ost");
		GameRegistry.registerBlock(fensterOW, "Fenster Ost-West");
	}

	private void registerBlock(final Block block, final String blockname) {
		GameRegistry.registerBlock(block, blockname);
	    final Item itemBlockSimple = GameRegistry.findItem(MOD_PREFIX, blockname);
	    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MOD_PREFIX + ":" + blockname, "inventory");
	    final int DEFAULT_ITEM_SUBTYPE = 0;
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}

	private void registerItem(Block kiste, String itemName) {
		final Item itemSimple = new Item().setUnlocalizedName(itemName);
		// required in order for the renderer to know how to render your item.
		// Likely to change in the near future.
		final ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MOD_PREFIX + ":" + itemName,
				"inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemSimple, DEFAULT_ITEM_SUBTYPE,
				itemModelResourceLocation);
		GameRegistry.registerItem(itemSimple, itemName);
	}

	public static CreativeTabs tabKalle = new CreativeTabs("tabKalle") {
		public ItemStack getIconItemStack() {
			return new ItemStack(emeraldPickaxe, 1, 0);
		}

		@Override
		public Item getTabIconItem() {
			return emeraldPickaxe;
		}
	};
}