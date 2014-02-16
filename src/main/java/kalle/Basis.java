package kalle;

import kalle.Proxies.BasisCommonProxy;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "kalle", name = "Kalle's Mod Commpilation", version = "0.0.1")
public class Basis {

	@Instance("kalle")
	public static Basis instance;

	@SidedProxy(clientSide = "kalle.Proxies.BasisClientProxy", serverSide = "kalle.Proxies.BasisCommonProxy")
	public static BasisCommonProxy proxy;

	private static MultiBlockBasis unobtanium;

	private static ItemFood bier;

	private static ItemFood kakao;

	private static ItemFood saft;

	private static ItemFood breadslicetoast;

	private static ItemFood coockedEgg;

	private static ItemFood sandwich_c;

	private static ItemFood sandwich_f;

	private static ItemFood sandwich_p;

	private static ItemFood sandwich_b;

	private static ItemFood eiertoast;

	private static ItemFood schnaps;

	private static ItemFood likoer;

	private static ItemBasis ketten_glieder;

	private static ItemBasis milch;

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

	private static MultiBlockBasis kiste;

	private static MultiBlockBasis kisteKohle;

	private static MultiBlockBasis kisteEisen;

	private static MultiBlockBasis kisteGold;

	private static MultiBlockBasis kisteDiamant;

	private static MultiBlockBasis kisteEmerald;

	private static MultiBlockBasis kisteLapis;

	private static MultiBlockBasis kisteCookie;

	private static MultiBlockBasis kisteKartoffel;

	private static MultiBlockBasis kisteApfel;

	private static MultiBlockBasis kisteFisch;

	private static MultiBlockBasis kisteKarotte;

	private static Item emeraldPickaxe;

	private static Item emeraldAxe;

	private static Item emeraldSpade;

	private static Item emeraldHoe;

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		// Nahrung
		bier = (DrinkBasis) new DrinkBasis(5, 0.5F, false).setUnlocalizedName("bier").setCreativeTab(tabKalle).setTextureName("kalle:Bier");
		kakao = (DrinkBasis) new DrinkBasis(5, 0.5F, false).setUnlocalizedName("kakao").setCreativeTab(tabKalle).setTextureName("kalle:Kakao");
		saft = (DrinkBasis) new DrinkBasis(5, 0.5F, false).setUnlocalizedName("saft").setCreativeTab(tabKalle).setTextureName("kalle:Saft");

		breadslicetoast = (EatBasis) new EatBasis(1, 0.1F, false).setUnlocalizedName("breadslice").setCreativeTab(tabKalle).setTextureName("kalle:Toast");
		coockedEgg = (EatBasis) new EatBasis(2, 0.1F, false).setUnlocalizedName("coockedEgg").setCreativeTab(tabKalle).setTextureName("kalle:Egg");

		sandwich_c = (EatBasis) new EatBasis(8, 0.66F, false).setUnlocalizedName("sandwich_c").setCreativeTab(tabKalle).setTextureName("kalle:Chickensandwich");
		sandwich_f = (EatBasis) new EatBasis(7, 0.66F, false).setUnlocalizedName("sandwich_f").setCreativeTab(tabKalle).setTextureName("kalle:Lachssandwich");
		sandwich_p = (EatBasis) new EatBasis(10, 0.75F, false).setUnlocalizedName("sandwich_p").setCreativeTab(tabKalle).setTextureName("kalle:Schinkensandwich");
		sandwich_b = (EatBasis) new EatBasis(10, 0.75F, false).setUnlocalizedName("sandwich_b").setCreativeTab(tabKalle).setTextureName("kalle:Roastbeefsandwich");

		eiertoast = (EatBasis) new EatBasis(5, 0.5F, false).setUnlocalizedName("Eiertoast").setCreativeTab(tabKalle).setTextureName("kalle:Eiertoast");
		schnaps = (DrinkBasis) new DrinkBasis(1, 0.1F, false).setUnlocalizedName("Schnaps").setCreativeTab(tabKalle).setTextureName("kalle:Schnaps");
		likoer = (DrinkBasis) new DrinkBasis(5, 0.3F, false).setUnlocalizedName("Eierlikoer").setCreativeTab(tabKalle).setTextureName("kalle:Likoer");

		// Teile zum Craften
		ketten_glieder = (ItemBasis) new ItemBasis().setUnlocalizedName("Kettenglieder").setCreativeTab(tabKalle).setTextureName("kalle:Kettenglieder");
		milch = (ItemBasis) new ItemBasis().setUnlocalizedName("Milchflasche").setCreativeTab(tabKalle).setTextureName("kalle:Milchflasche");

		// Specialblock
		unobtanium = (MultiBlockBasis) new MultiBlockBasis(Material.rock).setBlockName("Unobtanium").setCreativeTab(tabKalle).setBlockUnbreakable().setResistance(65535.0F);
		unobtanium.setBlockTextureName("kalle:Unobtanium_bottom", "kalle:Unobtanium_top", "kalle:Unobtanium_north", "kalle:Unobtanium_south", "kalle:Unobtanium_west", "kalle:Unobtanium_east");

		// Moebel
		theke = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("Theke").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		theke.setBlockTextureName("kalle:Theke", "kalle:Theke_top", "kalle:Theke", "kalle:Theke", "kalle:Theke", "kalle:Theke");
		parkettHell = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("ParkettHell").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		parkettHell.setBlockTextureName("kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell");
		parkettDunkel = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("ParkettDunkel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		parkettDunkel.setBlockTextureName("kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel");

		lamp = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setBlockName("Lamp").setCreativeTab(tabKalle).setHardness(0.5F).setLightLevel(1.0F);
		lamp.setBlockTextureName("kalle:Lamp", "kalle:Lamp", "kalle:Lamp", "kalle:Lamp", "kalle:Lamp", "kalle:Lamp");

		booksSpruce = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("BooksSpruce").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		booksSpruce.setBlockTextureName("kalle:books_spruce", "kalle:books_spruce", "kalle:books_spruce_side", "kalle:books_spruce_side", "kalle:books_spruce_side", "kalle:books_spruce_side");
		booksJungle = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("BooksJungle").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		booksJungle.setBlockTextureName("kalle:books_jungle", "kalle:books_jungle", "kalle:books_jungle_side", "kalle:books_jungle_side", "kalle:books_jungle_side", "kalle:books_jungle_side");
		booksBirch = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("BooksBirch").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		booksBirch.setBlockTextureName("kalle:books_birch", "kalle:books_birch", "kalle:books_birch_side", "kalle:books_birch_side", "kalle:books_birch_side", "kalle:books_birch_side");

		fensterNS = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setBlockName("FensterNS").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);
		fensterNS.setBlockTextureName("kalle:Kiste", "kalle:Kiste", "kalle:vorhang", "kalle:fensterladen", "kalle:Kiste", "kalle:Kiste");
		fensterSN = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setBlockName("FensterSN").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);
		fensterSN.setBlockTextureName("kalle:Kiste", "kalle:Kiste", "kalle:fensterladen", "kalle:vorhang", "kalle:Kiste", "kalle:Kiste");

		fensterWO = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setBlockName("FensterWO").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);
		fensterWO.setBlockTextureName("kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:vorhang", "kalle:fensterladen");
		fensterOW = (MultiBlockBasis) new MultiBlockBasis(Material.glass).setBlockName("FensterOW").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F);
		fensterOW.setBlockTextureName("kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:fensterladen", "kalle:vorhang");

		// Kisten
		kiste = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("Kiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kiste.setBlockTextureName("kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteKohle = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteKohle").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteKohle.setBlockTextureName("kalle:Kiste", "kalle:KisteKohle", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteEisen = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteEisen").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteEisen.setBlockTextureName("kalle:Kiste", "kalle:KisteEisen", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteGold = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteGold").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteGold.setBlockTextureName("kalle:Kiste", "kalle:KisteGold", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteDiamant = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteDiamant").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteDiamant.setBlockTextureName("kalle:Kiste", "kalle:KisteDiamant", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteEmerald = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteEmerald").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteEmerald.setBlockTextureName("kalle:Kiste", "kalle:KisteEmerald", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteLapis = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteLapis").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteLapis.setBlockTextureName("kalle:Kiste", "kalle:KisteLapis", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");

		kisteCookie = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteCookie").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteCookie.setBlockTextureName("kalle:Kiste", "kalle:KisteCookie", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteKartoffel = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteKartoffel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteKartoffel.setBlockTextureName("kalle:Kiste", "kalle:KisteKartoffel", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteApfel = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteApfel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteApfel.setBlockTextureName("kalle:Kiste", "kalle:KisteApfel", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteFisch = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteFisch").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteFisch.setBlockTextureName("kalle:Kiste", "kalle:KisteFisch", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		kisteKarotte = (MultiBlockBasis) new MultiBlockBasis(Material.wood).setBlockName("KisteKarotte").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		kisteKarotte.setBlockTextureName("kalle:Kiste", "kalle:KisteKarotte", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");

		// Tools
		emeraldPickaxe = new ItemPickaxeEmerald(Item.ToolMaterial.EMERALD).setUnlocalizedName("EmeraldPickaxe").setCreativeTab(tabKalle);
		emeraldAxe = new ItemAxeEmerald(Item.ToolMaterial.EMERALD).setUnlocalizedName("EmeraldAxe").setCreativeTab(tabKalle);
		emeraldSpade = new ItemSpadeEmerald(Item.ToolMaterial.EMERALD).setUnlocalizedName("EmeraldSpade").setCreativeTab(tabKalle);
		emeraldHoe = new ItemHoeEmerald(Item.ToolMaterial.EMERALD).setUnlocalizedName("EmeraldHoe").setCreativeTab(tabKalle);

		// Weapon
		// Ammo = (ItemBasis) new
		// ItemBasis(AmmoID).setUnlocalizedName("Ammo").setCreativeTab(tabTest);
		// Ammo.setTextureName("kalle:Ammo");
		// Revolver = (ItemWeapon) new
		// ItemWeapon(RevolverID).setUnlocalizedName("Revolver").setCreativeTab(tabTest);
		// Revolver.setTextureName("kalle:Weapon");

		// Zauberstab = (ItemRod) new
		// ItemRod(ZauberstabID).setUnlocalizedName("Zauberstab").setCreativeTab(tabTest);
		// Zauberstab.setTextureName("kalle:magic_rod");
		// Krawams = (ItemBomb) new
		// ItemBomb(KrawamsID).setUnlocalizedName("Krawams").setCreativeTab(tabTest);
		// Krawams.setTextureName("kalle:Bomb");

		// Intit-Aufrufe
		registerItems();
		registerBlocks();
		updateLanguage();
		initCraftingRecipes();
		initSmeltingRecipes();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
	}

	// ----- Methoden -----
	private static void initCraftingRecipes() {
		// Fixes
		GameRegistry.addRecipe(new ItemStack(Items.book), "#", "#", "#", '#', Items.paper);

		// Block-Rezepte
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Blocks.cobblestone), new ItemStack(Items.wheat_seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new ItemStack(Blocks.stonebrick), new ItemStack(Items.wheat_seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new ItemStack(Items.emerald), new ItemStack(Items.emerald), new ItemStack(Items.emerald));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald, 3), new ItemStack(Items.diamond));

		GameRegistry.addRecipe(new ItemStack(theke, 2), "000", "***", "###", '#', Blocks.planks, '*', Blocks.wooden_slab);
		GameRegistry.addRecipe(new ItemStack(kiste), "#0#", "#0#", "###", '#', Blocks.planks);
		GameRegistry.addRecipe(new ItemStack(parkettHell, 4), "#0#", "0#0", "#0#", '#', new ItemStack(Blocks.planks, 1, 0));
		GameRegistry.addRecipe(new ItemStack(parkettDunkel, 4), "#0#", "0#0", "#0#", '#', new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 0), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 0));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 1), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 2), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 2));
		GameRegistry.addRecipe(new ItemStack(Blocks.planks, 1, 3), "#0#", "000", "#0#", '#', new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(kisteKohle), "*", "#", '*', Items.coal, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteEisen), "*", "#", '*', Items.iron_ingot, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteGold), "*", "#", '*', Items.gold_ingot, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteDiamant), "*", "#", '*', Items.diamond, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteEmerald), "*", "#", '*', Items.emerald, '#', kiste);

		GameRegistry.addRecipe(new ItemStack(kisteCookie), "*", "#", '*', Items.cookie, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "*", "#", '*', Items.potato, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteApfel), "*", "#", '*', Items.apple, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteFisch), "*", "#", '*', Items.fish, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteKarotte), "*", "#", '*', Items.carrot, '#', kiste);

		GameRegistry.addRecipe(new ItemStack(kisteKohle), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.coal);
		GameRegistry.addRecipe(new ItemStack(kisteEisen), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(kisteGold), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.gold_ingot);
		GameRegistry.addRecipe(new ItemStack(kisteDiamant), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(kisteEmerald), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.emerald);

		GameRegistry.addRecipe(new ItemStack(kisteCookie), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.cookie);
		GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.potato);
		GameRegistry.addRecipe(new ItemStack(kisteApfel), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.apple);
		GameRegistry.addRecipe(new ItemStack(kisteFisch), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.fish);
		GameRegistry.addRecipe(new ItemStack(kisteKarotte), "#0#", "#*#", "###", '#', Blocks.planks, '*', Items.carrot);

		GameRegistry.addRecipe(new ItemStack(booksSpruce), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 1), '*', Items.book);
		GameRegistry.addRecipe(new ItemStack(booksJungle), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 3), '*', Items.book);
		GameRegistry.addRecipe(new ItemStack(booksBirch), "###", "#*#", "###", '#', new ItemStack(Blocks.planks, 1, 2), '*', Items.book);

		GameRegistry.addRecipe(new ItemStack(lamp), "#+#", "+*+", "#+#", '#', Blocks.fence, '*', Blocks.glowstone, '+', Blocks.glass);
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

		GameRegistry.addRecipe(new ItemStack(sandwich_c), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_chicken);
		GameRegistry.addRecipe(new ItemStack(sandwich_f), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_fished);
		GameRegistry.addRecipe(new ItemStack(sandwich_p), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_porkchop);
		GameRegistry.addRecipe(new ItemStack(sandwich_b), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_beef);

		GameRegistry.addRecipe(new ItemStack(eiertoast), "*", "#", '#', breadslicetoast, '*', coockedEgg);

		// Items
		GameRegistry.addRecipe(new ItemStack(Items.saddle), "###", "#0#", "*0*", '#', Items.leather, '*', Items.iron_ingot);
//		GameRegistry.addRecipe(new ItemStack(Items.lead), "0#0", "#0#", "0#0", '#', Items.silk);
//		GameRegistry.addRecipe(new ItemStack(Items.name_tag), "00#", "**0", "**0", '#', Items.silk, '*', Items.paper);
		GameRegistry.addRecipe(new ItemStack(ketten_glieder, 6), "0#0", "#0#", "0#0", '#', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(milch, 3), "0#0", "***", '#', Items.milk_bucket, '*', Items.glass_bottle);

		// Horse Armor Iron, Gold, Diamant
//		GameRegistry.addRecipe(new ItemStack(Items.iron_horse_armor), "00#", "#*#", "###", '#', Items.iron_ingot, '*', new ItemStack(Blocks.cloth, 1, 15));
//		GameRegistry.addRecipe(new ItemStack(Items.golden_horse_armor), "00#", "#*#", "###", '#', Items.gold_ingot, '*', new ItemStack(Blocks.cloth, 1, 14));
//		GameRegistry.addRecipe(new ItemStack(Items.diamond_horse_armor), "00#", "#*#", "###", '#', Items.diamond, '*', new ItemStack(Blocks.cloth, 1, 11));

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
	private static void initSmeltingRecipes() {
		GameRegistry.addSmelting(Items.egg, new ItemStack(coockedEgg), 0.25f);
		GameRegistry.addSmelting(Items.poisonous_potato, new ItemStack(Items.potato), 0.25f);
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.beef), 0.25f);
		GameRegistry.addSmelting(Items.reeds, new ItemStack(schnaps), 0.25f);
	}

	private static void registerItems() {
		GameRegistry.registerItem(bier, "Bier");
		GameRegistry.registerItem(kakao, "Schokomilch");
		GameRegistry.registerItem(saft, "Multivitaminsaft");
		GameRegistry.registerItem(milch, "Milchflasche");

		GameRegistry.registerItem(breadslicetoast, "Toastbrotscheibe");
		GameRegistry.registerItem(coockedEgg, "gekochtes Ei");

		GameRegistry.registerItem(sandwich_c, "Chickensandwich");
		GameRegistry.registerItem(sandwich_f, "Lachssandwich");
		GameRegistry.registerItem(sandwich_p, "Schickensandwich");
		GameRegistry.registerItem(sandwich_b, "Roastbeefsandwich");

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

	private static void registerBlocks() {
		GameRegistry.registerBlock(unobtanium, "Unobtanium");
		GameRegistry.registerBlock(theke, "Theke");
		GameRegistry.registerBlock(kiste, "Kiste");
		GameRegistry.registerBlock(parkettHell, "ParkettHell");
		GameRegistry.registerBlock(parkettDunkel, "ParkettDunkel");

		GameRegistry.registerBlock(kisteKohle, "Kohlekiste");
		GameRegistry.registerBlock(kisteEisen, "Eisenkiste");
		GameRegistry.registerBlock(kisteGold, "GoldKiste");
		GameRegistry.registerBlock(kisteDiamant, "Diamantkiste");
		GameRegistry.registerBlock(kisteEmerald, "Edelsteinkiste");
		GameRegistry.registerBlock(kisteLapis, "Lapiskiste");

		GameRegistry.registerBlock(kisteCookie, "Keksekiste");
		GameRegistry.registerBlock(kisteKartoffel, "Kartoffelkiste");
		GameRegistry.registerBlock(kisteApfel, "Apfelkiste");
		GameRegistry.registerBlock(kisteFisch, "Fischkiste");
		GameRegistry.registerBlock(kisteKarotte, "Karottenkiste");

		GameRegistry.registerBlock(booksSpruce, "Fichtenholzregal");
		GameRegistry.registerBlock(booksJungle, "Jungelholzregal");
		GameRegistry.registerBlock(booksBirch, "Birkenholzregal");

		GameRegistry.registerBlock(lamp, "Lightstone-Lampe");

		GameRegistry.registerBlock(fensterNS, "Fenster Nord-Sued");
		GameRegistry.registerBlock(fensterSN, "Fenster Sued-Nord");
		GameRegistry.registerBlock(fensterWO, "Fenster West-Ost");
		GameRegistry.registerBlock(fensterOW, "Fenster Ost-West");
	}

	private static void updateLanguage() {
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabKalle", "Kalles Modding");

		LanguageRegistry.addName(bier, "Bier");
		LanguageRegistry.addName(kakao, "Schokomilch");
		LanguageRegistry.addName(saft, "Multivitaminsaft");
		LanguageRegistry.addName(milch, "Milchflasche");

		LanguageRegistry.addName(breadslicetoast, "getoastete Brotscheibe");
		LanguageRegistry.addName(coockedEgg, "gekochtes Ei");

		LanguageRegistry.addName(sandwich_c, "Chickensandwich");
		LanguageRegistry.addName(sandwich_f, "Lachssandwich");
		LanguageRegistry.addName(sandwich_p, "Schinkensandwich");
		LanguageRegistry.addName(sandwich_b, "Roastbeefsandwich");

		LanguageRegistry.addName(eiertoast, "Eiertoast");
		LanguageRegistry.addName(schnaps, "Schnaps");
		LanguageRegistry.addName(likoer, "Eierlikoer");

		LanguageRegistry.addName(ketten_glieder, "Kettenglieder");

		LanguageRegistry.addName(unobtanium, "Unobtanium");
		LanguageRegistry.addName(theke, "Theke");
		LanguageRegistry.addName(kiste, "Kiste");
		LanguageRegistry.addName(parkettHell, "helles Parkett");
		LanguageRegistry.addName(parkettDunkel, "dunkles Parkett");

		LanguageRegistry.addName(kisteKohle, "Kohlekiste");
		LanguageRegistry.addName(kisteEisen, "Eisenkiste");
		LanguageRegistry.addName(kisteGold, "Goldkiste");
		LanguageRegistry.addName(kisteDiamant, "Diamantenkiste");
		LanguageRegistry.addName(kisteEmerald, "Edelsteinkiste");
		LanguageRegistry.addName(kisteLapis, "Lapiskiste");

		LanguageRegistry.addName(kisteCookie, "Keksekiste");
		LanguageRegistry.addName(kisteKartoffel, "Kartoffelkiste");
		LanguageRegistry.addName(kisteApfel, "Apfelkiste");
		LanguageRegistry.addName(kisteFisch, "Fischkiste");
		LanguageRegistry.addName(kisteKarotte, "Karottenkiste");

		LanguageRegistry.addName(booksSpruce, "Fichtenholzregal");
		LanguageRegistry.addName(booksJungle, "Jungelholzregal");
		LanguageRegistry.addName(booksBirch, "Birkenholzregal");

		LanguageRegistry.addName(lamp, "Lightstone-Lampe");

		LanguageRegistry.addName(fensterNS, "Fenster Nord-Sued");
		LanguageRegistry.addName(fensterSN, "Fenster Sued-Nord");
		LanguageRegistry.addName(fensterWO, "Fenster West-Ost");
		LanguageRegistry.addName(fensterOW, "Fenster Ost-West");

		LanguageRegistry.addName(emeraldPickaxe, "Edelsteinspitzhacke");
		LanguageRegistry.addName(emeraldAxe, "Edelsteinaxt");
		LanguageRegistry.addName(emeraldSpade, "Edelsteinschaufel");
		LanguageRegistry.addName(emeraldHoe, "Edelsteinhacke");

		// LanguageRegistry.addName(Ammo, "Munition");
		// LanguageRegistry.addName(Revolver, "Revolver");

		// LanguageRegistry.addName(Zauberstab, "Zauberstab der Zeit");
		// LanguageRegistry.addName(Krawams, "Krawams");
	}

	// ----- met-end -----

	public static CreativeTabs tabKalle = new CreativeTabs("tabKalle") {
		public ItemStack getIconItemStack() {
			return new ItemStack(unobtanium, 1, 0);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			// TODO Auto-generated method stub
			return null;
		}
	};
}