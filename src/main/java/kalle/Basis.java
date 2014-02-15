package kalle;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import kalle.Proxies.BasisCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "kalle", name = "Kalle's Mod Commpilation", version = "Build #1643")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Basis{


	//----- Variable -----
		// Blocks until ID 4096
		// Do not Touch
		public static MultiBlockBasis Unobtanium;
		public static int UnobtaniumID = 4000;
		
		// Moebel
		public static MultiBlockBasis Theke;
		public static int ThekeID = 4001;
		public static MultiBlockBasis ParkettHell;
		public static int ParkettHellID = 4002;
		public static MultiBlockBasis ParkettDunkel;
		public static int ParkettDunkelID = 4003;
		
		
		// Kisten
		public static MultiBlockBasis Kiste;
		public static int KisteID = 4004;
		
		public static MultiBlockBasis KisteKohle;
		public static int KisteKohleID = 4005;
		public static MultiBlockBasis KisteEisen;
		public static int KisteEisenID = 4006;
		public static MultiBlockBasis KisteGold;
		public static int KisteGoldID = 4007;
		public static MultiBlockBasis KisteDiamant;
		public static int KisteDiamantID = 4008;
		public static MultiBlockBasis KisteEmerald;
		public static int KisteEmeraldID = 4009;
		
		public static MultiBlockBasis KisteCookie;
		public static int KisteCookieID = 4010;
		public static MultiBlockBasis KisteKartoffel;
		public static int KisteKartoffelID = 4011;
		public static MultiBlockBasis KisteApfel;
		public static int KisteApfelID = 4012;
		public static MultiBlockBasis KisteKarotte;
		public static int KisteKarotteID = 4013;
		public static MultiBlockBasis KisteFisch;
		public static int KisteFischID = 4014;
		public static MultiBlockBasis KisteLapis;
		public static int KisteLapisID = 4015;
		
		
		public static MultiBlockBasis BooksSpruce;
		public static int BooksSpruceID = 4030;
		public static MultiBlockBasis BooksJungle;
		public static int BooksJungleID = 4031;
		public static MultiBlockBasis BooksBirch;
		public static int BooksBirchID = 4032;
		
		public static MultiBlockBasis FensterNS;
		public static int FensterNSID = 4050;
		public static MultiBlockBasis FensterSN;
		public static int FensterSNID = 4051;
		public static MultiBlockBasis FensterWO;
		public static int FensterWOID = 4052;
		public static MultiBlockBasis FensterOW;
		public static int FensterOWID = 4053;
		
		public static MultiBlockBasis Lamp;
		public static int LampID = 4054;
		
		//Items until ID 32000
		//drinks
		public static DrinkBasis bier;
		public static int bierID = 31000;
		public static DrinkBasis kakao;
		public static int kakaoID = 31001;
		public static DrinkBasis saft;
		public static int saftID = 31002;
		public static DrinkBasis schnaps;
		public static int schnapsID = 31003;
		public static DrinkBasis likoer;
		public static int likoerID = 31004;
		
		
		
		//food
		public static EatBasis breadslicetoast;
		public static int breadslicetoastID = 31101;
		public static EatBasis coockedEgg;
		public static int coockedEggID = 31102;
		
		public static EatBasis sandwich_c;
		public static int sandwich_cID = 31200;
		public static EatBasis sandwich_f;
		public static int sandwich_fID = 31201;
		public static EatBasis sandwich_p;
		public static int sandwich_pID = 31202;
		public static EatBasis sandwich_b;
		public static int sandwich_bID = 31203;
		
		public static EatBasis Eiertoast;
		public static int EiertoastID = 31210;
		
		//Crafting Items
		public static ItemBasis Kettenglieder;
		public static int KettengliederID = 31300;
		public static ItemBasis Milch;
		public static int MilchID = 31301;
		
		//tools
		public static ItemPickaxeEmerald EmeraldPickaxe;
		public static int EmeraldPickaxeID = 31350;
		public static ItemAxeEmerald EmeraldAxe;
		public static int EmeraldAxeID = 31351;
		public static ItemSpadeEmerald EmeraldSpade;
		public static int EmeraldSpadeID = 31352;
		public static ItemHoeEmerald EmeraldHoe;
		public static int EmeraldHoeID = 31353;
		
		//TestItems
		//public static ItemRod Zauberstab;
		//public static int ZauberstabID = 31400;
		//public static ItemBomb Krawams;
		//public static int KrawamsID = 31401;
		//public static ItemBasis Ammo;
		//public static int AmmoID = 31402;
		//public static ItemWeapon Revolver;
		//public static int RevolverID = 31403;
		
		// ----- variable - end -----
		
		public static CreativeTabs tabKalle = new CreativeTabs("tabKalle"){
			public ItemStack getIconItemStack(){
				return new ItemStack(Unobtanium, 1, 0);
			}
		};
		
		
	//================================================
	
	
	@Instance("tutorial")
	public static Basis instance;
	
	@SidedProxy(clientSide="kalle.Proxies.BasisClientProxy", serverSide="kalle.Proxies.BasisCommonProxy")
	public static BasisCommonProxy proxy;
	
	@EventHandler
	public static void Init(FMLPreInitializationEvent event) {
		
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		//Nahrung		
		bier = (DrinkBasis) new DrinkBasis(bierID, 5, 0.5F, false).setUnlocalizedName("bier").setCreativeTab(tabKalle);
			bier.setIconFile("kalle:Bier");
		kakao = (DrinkBasis) new DrinkBasis(kakaoID, 5, 0.5F, false).setUnlocalizedName("kakao").setCreativeTab(tabKalle);
			kakao.setIconFile("kalle:Kakao");
		saft = (DrinkBasis) new DrinkBasis(saftID, 5, 0.5F, false).setUnlocalizedName("saft").setCreativeTab(tabKalle);
			saft.setIconFile("kalle:Saft");
		
		
		breadslicetoast = (EatBasis) new EatBasis(breadslicetoastID, 1, 0.1F, false).setUnlocalizedName("breadslice").setCreativeTab(tabKalle);
			breadslicetoast.setIconFile("kalle:Toast");
		coockedEgg = (EatBasis) new EatBasis(coockedEggID, 2, 0.1F, false).setUnlocalizedName("coockedEgg").setCreativeTab(tabKalle);
			coockedEgg.setIconFile("kalle:Egg");
			
		sandwich_c = (EatBasis) new EatBasis(sandwich_cID, 8, 0.66F, false).setUnlocalizedName("sandwich_c").setCreativeTab(tabKalle);
			sandwich_c.setIconFile("kalle:Chickensandwich");
		sandwich_f = (EatBasis) new EatBasis(sandwich_fID, 7, 0.66F, false).setUnlocalizedName("sandwich_f").setCreativeTab(tabKalle);
			sandwich_f.setIconFile("kalle:Lachssandwich");
		sandwich_p = (EatBasis) new EatBasis(sandwich_pID, 10, 0.75F, false).setUnlocalizedName("sandwich_p").setCreativeTab(tabKalle);
			sandwich_p.setIconFile("kalle:Schinkensandwich");
		sandwich_b = (EatBasis) new EatBasis(sandwich_bID, 10, 0.75F, false).setUnlocalizedName("sandwich_b").setCreativeTab(tabKalle);
			sandwich_b.setIconFile("kalle:Roastbeefsandwich");
		
		Eiertoast = (EatBasis) new EatBasis(EiertoastID, 5, 0.5F, false).setUnlocalizedName("Eiertoast").setCreativeTab(tabKalle);
			Eiertoast.setIconFile("kalle:Eiertoast");
		schnaps = (DrinkBasis) new DrinkBasis(schnapsID, 1, 0.1F, false).setUnlocalizedName("Schnaps").setCreativeTab(tabKalle);
			schnaps.setIconFile("kalle:Schnaps");
		likoer = (DrinkBasis) new DrinkBasis(likoerID, 5, 0.3F, false).setUnlocalizedName("Eierlikoer").setCreativeTab(tabKalle);
			likoer.setIconFile("kalle:Likoer");
		
		//Teile zum Craften
		Kettenglieder = (ItemBasis) new ItemBasis(KettengliederID).setUnlocalizedName("Kettenglieder").setCreativeTab(tabKalle);
			Kettenglieder.setIconFile("kalle:Kettenglieder");
		Milch = (ItemBasis) new ItemBasis(MilchID).setUnlocalizedName("Milchflasche").setCreativeTab(tabKalle);
			Milch.setIconFile("kalle:Milchflasche");
				
		//Specialblock
		Unobtanium = (MultiBlockBasis) new MultiBlockBasis(UnobtaniumID, Material.rock).setUnlocalizedName("Unobtanium").setCreativeTab(tabKalle).setBlockUnbreakable().setResistance(65535.0F); 
		Unobtanium.setIconFile("kalle:Unobtanium_bottom", "kalle:Unobtanium_top", "kalle:Unobtanium_north", "kalle:Unobtanium_south", "kalle:Unobtanium_west", "kalle:Unobtanium_east");
					
		//Moebel
		Theke = (MultiBlockBasis) new MultiBlockBasis(ThekeID, Material.wood).setUnlocalizedName("Theke").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		Theke.setIconFile("kalle:Theke", "kalle:Theke_top", "kalle:Theke", "kalle:Theke", "kalle:Theke", "kalle:Theke");
		ParkettHell = (MultiBlockBasis) new MultiBlockBasis(ParkettHellID, Material.wood).setUnlocalizedName("ParkettHell").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		ParkettHell.setIconFile("kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell", "kalle:ParkettHell");
		ParkettDunkel = (MultiBlockBasis) new MultiBlockBasis(ParkettDunkelID, Material.wood).setUnlocalizedName("ParkettDunkel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		ParkettDunkel.setIconFile("kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel", "kalle:ParkettDunkel");
		
		Lamp = (MultiBlockBasis) new MultiBlockBasis(LampID, Material.glass).setUnlocalizedName("Lamp").setCreativeTab(tabKalle).setHardness(0.5F).setLightValue(1.0F);
		Lamp.setIconFile("kalle:Lamp", "kalle:Lamp", "kalle:Lamp", "kalle:Lamp", "kalle:Lamp", "kalle:Lamp");
		
		BooksSpruce = (MultiBlockBasis) new MultiBlockBasis(BooksSpruceID, Material.wood).setUnlocalizedName("BooksSpruce").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		BooksSpruce.setIconFile("kalle:books_spruce", "kalle:books_spruce", "kalle:books_spruce_side", "kalle:books_spruce_side", "kalle:books_spruce_side", "kalle:books_spruce_side");
		BooksJungle = (MultiBlockBasis) new MultiBlockBasis(BooksJungleID, Material.wood).setUnlocalizedName("BooksJungle").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		BooksJungle.setIconFile("kalle:books_jungle", "kalle:books_jungle", "kalle:books_jungle_side", "kalle:books_jungle_side", "kalle:books_jungle_side", "kalle:books_jungle_side");
		BooksBirch = (MultiBlockBasis) new MultiBlockBasis(BooksBirchID, Material.wood).setUnlocalizedName("BooksBirch").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		BooksBirch.setIconFile("kalle:books_birch", "kalle:books_birch", "kalle:books_birch_side", "kalle:books_birch_side", "kalle:books_birch_side", "kalle:books_birch_side");
		
		
		FensterNS = (MultiBlockBasis) new MultiBlockBasis(FensterNSID, Material.glass).setUnlocalizedName("FensterNS").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F); 
		FensterNS.setIconFile("kalle:Kiste", "kalle:Kiste", "kalle:vorhang", "kalle:fensterladen", "kalle:Kiste", "kalle:Kiste");
		FensterSN = (MultiBlockBasis) new MultiBlockBasis(FensterSNID, Material.glass).setUnlocalizedName("FensterSN").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F); 
		FensterSN.setIconFile("kalle:Kiste", "kalle:Kiste", "kalle:fensterladen", "kalle:vorhang", "kalle:Kiste", "kalle:Kiste");

		FensterWO = (MultiBlockBasis) new MultiBlockBasis(FensterWOID, Material.glass).setUnlocalizedName("FensterWO").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F); 
		FensterWO.setIconFile("kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:vorhang", "kalle:fensterladen");
		FensterOW = (MultiBlockBasis) new MultiBlockBasis(FensterOWID, Material.glass).setUnlocalizedName("FensterOW").setCreativeTab(tabKalle).setHardness(0.25F).setResistance(1.0F); 
		FensterOW.setIconFile("kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:fensterladen", "kalle:vorhang");

				
		//Kisten
		Kiste = (MultiBlockBasis) new MultiBlockBasis(KisteID, Material.wood).setUnlocalizedName("Kiste").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		Kiste.setIconFile("kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteKohle = (MultiBlockBasis) new MultiBlockBasis(KisteKohleID, Material.wood).setUnlocalizedName("KisteKohle").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteKohle.setIconFile("kalle:Kiste", "kalle:KisteKohle", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteEisen = (MultiBlockBasis) new MultiBlockBasis(KisteEisenID, Material.wood).setUnlocalizedName("KisteEisen").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteEisen.setIconFile("kalle:Kiste", "kalle:KisteEisen", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteGold = (MultiBlockBasis) new MultiBlockBasis(KisteGoldID, Material.wood).setUnlocalizedName("KisteGold").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteGold.setIconFile("kalle:Kiste", "kalle:KisteGold", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteDiamant = (MultiBlockBasis) new MultiBlockBasis(KisteDiamantID, Material.wood).setUnlocalizedName("KisteDiamant").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteDiamant.setIconFile("kalle:Kiste", "kalle:KisteDiamant", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteEmerald = (MultiBlockBasis) new MultiBlockBasis(KisteEmeraldID, Material.wood).setUnlocalizedName("KisteEmerald").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteEmerald.setIconFile("kalle:Kiste", "kalle:KisteEmerald", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteLapis = (MultiBlockBasis) new MultiBlockBasis(KisteLapisID, Material.wood).setUnlocalizedName("KisteLapis").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteLapis.setIconFile("kalle:Kiste", "kalle:KisteLapis", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		
		KisteCookie = (MultiBlockBasis) new MultiBlockBasis(KisteCookieID, Material.wood).setUnlocalizedName("KisteCookie").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteCookie.setIconFile("kalle:Kiste", "kalle:KisteCookie", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteKartoffel = (MultiBlockBasis) new MultiBlockBasis(KisteKartoffelID, Material.wood).setUnlocalizedName("KisteKartoffel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteKartoffel.setIconFile("kalle:Kiste", "kalle:KisteKartoffel", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteApfel = (MultiBlockBasis) new MultiBlockBasis(KisteApfelID, Material.wood).setUnlocalizedName("KisteApfel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteApfel.setIconFile("kalle:Kiste", "kalle:KisteApfel", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteFisch = (MultiBlockBasis) new MultiBlockBasis(KisteFischID, Material.wood).setUnlocalizedName("KisteFisch").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteFisch.setIconFile("kalle:Kiste", "kalle:KisteFisch", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		KisteKarotte = (MultiBlockBasis) new MultiBlockBasis(KisteKarotteID, Material.wood).setUnlocalizedName("KisteKarotte").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F); 
		KisteKarotte.setIconFile("kalle:Kiste", "kalle:KisteKarotte", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste", "kalle:Kiste");
		
		//Tools
		EmeraldPickaxe = (ItemPickaxeEmerald) new ItemPickaxeEmerald(EmeraldPickaxeID, EnumToolMaterialBasis.EMERALD).setUnlocalizedName("EmeraldPickaxe").setCreativeTab(tabKalle);
		EmeraldAxe = (ItemAxeEmerald) new ItemAxeEmerald(EmeraldAxeID, EnumToolMaterialBasis.EMERALD).setUnlocalizedName("EmeraldAxe").setCreativeTab(tabKalle);
		EmeraldSpade = (ItemSpadeEmerald) new ItemSpadeEmerald(EmeraldSpadeID, EnumToolMaterialBasis.EMERALD).setUnlocalizedName("EmeraldSpade").setCreativeTab(tabKalle);
		EmeraldHoe = (ItemHoeEmerald) new ItemHoeEmerald(EmeraldHoeID, EnumToolMaterialBasis.EMERALD).setUnlocalizedName("EmeraldHoe").setCreativeTab(tabKalle);
		
		//Weapon
		//Ammo = (ItemBasis) new ItemBasis(AmmoID).setUnlocalizedName("Ammo").setCreativeTab(tabTest);
		//Ammo.setIconFile("kalle:Ammo");
		//Revolver = (ItemWeapon) new ItemWeapon(RevolverID).setUnlocalizedName("Revolver").setCreativeTab(tabTest);
		//Revolver.setIconFile("kalle:Weapon");
		
		//Zauberstab = (ItemRod) new ItemRod(ZauberstabID).setUnlocalizedName("Zauberstab").setCreativeTab(tabTest);
		//Zauberstab.setIconFile("kalle:magic_rod");
		//Krawams = (ItemBomb) new ItemBomb(KrawamsID).setUnlocalizedName("Krawams").setCreativeTab(tabTest);
		//Krawams.setIconFile("kalle:Bomb");
		
		
		
		//Intit-Aufrufe
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
	private static void initCraftingRecipes(){
		//Fixes
		GameRegistry.addRecipe(new ItemStack(Item.book),   "#", "#", "#", '#', Item.paper);
		
		//Block-Rezepte
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestoneMossy), new ItemStack(Block.cobblestone), new ItemStack(Item.seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(Block.stoneBrick, 1, 1), new ItemStack(Block.stoneBrick), new ItemStack(Item.seeds));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 1), new ItemStack(Item.emerald), new ItemStack(Item.emerald), new ItemStack(Item.emerald));
		GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 3), new ItemStack(Item.diamond));
		
		GameRegistry.addRecipe(new ItemStack(Theke, 2), "000", "***", "###", '#', Block.planks, '*', Block.woodSingleSlab);
		GameRegistry.addRecipe(new ItemStack(Kiste), "#0#", "#0#", "###", '#', Block.planks);
		GameRegistry.addRecipe(new ItemStack(ParkettHell, 4), "#0#", "0#0", "#0#", '#', new ItemStack(Block.planks, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ParkettDunkel, 4), "#0#", "0#0", "#0#", '#', new ItemStack(Block.planks, 1, 1));
		
		GameRegistry.addRecipe(new ItemStack(Block.wood, 1, 0), "#0#", "000", "#0#", '#', new ItemStack(Block.planks, 1, 0));
		GameRegistry.addRecipe(new ItemStack(Block.wood, 1, 1), "#0#", "000", "#0#", '#', new ItemStack(Block.planks, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Block.wood, 1, 2), "#0#", "000", "#0#", '#', new ItemStack(Block.planks, 1, 2));
		GameRegistry.addRecipe(new ItemStack(Block.wood, 1, 3), "#0#", "000", "#0#", '#', new ItemStack(Block.planks, 1, 3));
		
		GameRegistry.addRecipe(new ItemStack(KisteKohle), "*", "#", '*', Item.coal, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteEisen), "*", "#", '*', Item.ingotIron, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteGold), "*", "#", '*', Item.ingotGold, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteDiamant), "*", "#", '*', Item.diamond, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteEmerald), "*", "#", '*', Item.emerald, '#', Kiste);
		
		GameRegistry.addRecipe(new ItemStack(KisteCookie), "*", "#", '*', Item.cookie, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteKartoffel), "*", "#", '*', Item.potato, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteApfel), "*", "#", '*', Item.appleRed, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteFisch), "*", "#", '*', Item.fishRaw, '#', Kiste);
		GameRegistry.addRecipe(new ItemStack(KisteKarotte), "*", "#", '*', Item.carrot, '#', Kiste);
		
		GameRegistry.addRecipe(new ItemStack(KisteKohle), "#0#", "#*#", "###", '#', Block.planks, '*', Item.coal);
		GameRegistry.addRecipe(new ItemStack(KisteEisen), "#0#", "#*#", "###", '#', Block.planks, '*', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(KisteGold), "#0#", "#*#", "###", '#', Block.planks, '*', Item.ingotGold);
		GameRegistry.addRecipe(new ItemStack(KisteDiamant), "#0#", "#*#", "###", '#', Block.planks, '*', Item.diamond);
		GameRegistry.addRecipe(new ItemStack(KisteEmerald), "#0#", "#*#", "###", '#', Block.planks, '*', Item.emerald);
				
		GameRegistry.addRecipe(new ItemStack(KisteCookie), "#0#", "#*#", "###", '#', Block.planks, '*', Item.cookie);
		GameRegistry.addRecipe(new ItemStack(KisteKartoffel), "#0#", "#*#", "###", '#', Block.planks, '*', Item.potato);
		GameRegistry.addRecipe(new ItemStack(KisteApfel), "#0#", "#*#", "###", '#', Block.planks, '*', Item.appleRed);
		GameRegistry.addRecipe(new ItemStack(KisteFisch), "#0#", "#*#", "###", '#', Block.planks, '*', Item.fishRaw);
		GameRegistry.addRecipe(new ItemStack(KisteKarotte), "#0#", "#*#", "###", '#', Block.planks, '*', Item.carrot);
		
		GameRegistry.addRecipe(new ItemStack(BooksSpruce), "###", "#*#", "###", '#', new ItemStack(Block.planks, 1, 1), '*', Item.book);
		GameRegistry.addRecipe(new ItemStack(BooksJungle), "###", "#*#", "###", '#', new ItemStack(Block.planks, 1, 3), '*', Item.book);
		GameRegistry.addRecipe(new ItemStack(BooksBirch), "###", "#*#", "###", '#', new ItemStack(Block.planks, 1, 2), '*', Item.book);
		
		GameRegistry.addRecipe(new ItemStack(Lamp), "#+#", "+*+", "#+#", '#', Block.fenceIron, '*', Block.glowStone, '+', Block.glass);
		GameRegistry.addRecipe(new ItemStack(Block.stoneBrick, 1, 3), "+++", "+#+", "+++", '+', Item.flint, '#', Block.stoneBrick);
		
		//Tools
		GameRegistry.addRecipe(new ItemStack(EmeraldPickaxe), "###", "0*0", "0*0", '#', Item.emerald, '*', Item.stick);
		GameRegistry.addRecipe(new ItemStack(EmeraldAxe), "##0", "#*0", "0*0", '#', Item.emerald, '*', Item.stick);
		GameRegistry.addRecipe(new ItemStack(EmeraldSpade), "0#0", "0*0", "0*0", '#', Item.emerald, '*', Item.stick);
		GameRegistry.addRecipe(new ItemStack(EmeraldHoe), "##0", "0*0", "0*0", '#', Item.emerald, '*', Item.stick);
		
		//Drink-Rezepte-Drink
		GameRegistry.addRecipe(new ItemStack(bier), "A", "B", 'A', Item.seeds, 'B', Item.potion);
		GameRegistry.addRecipe(new ItemStack(bier, 3), "0A0", "BBB", "CCC", 'A', Item.bucketWater, 'B', Item.seeds, 'C', Item.glassBottle);
		
		GameRegistry.addRecipe(new ItemStack(kakao), "A", "B", "C", 'A', new ItemStack(Item.dyePowder, 1, 3), 'B', Item.sugar,'C', Milch);
		GameRegistry.addRecipe(new ItemStack(kakao, 3), "DAD", "BBB", "CCC", 'A', Item.bucketMilk, 'B', new ItemStack(Item.dyePowder, 1, 3), 'C', Item.glassBottle, 'D', Item.sugar);
		
		GameRegistry.addRecipe(new ItemStack(saft), "A", "B", "C", 'A', Item.appleRed, 'B', Item.carrot, 'C', Item.glassBottle);
		GameRegistry.addRecipe(new ItemStack(saft, 3), "AAA", "BBB", "CCC", 'A', Item.appleRed, 'B', Item.carrot, 'C', Item.glassBottle);
		
		GameRegistry.addRecipe(new ItemStack(likoer), "A", "B", "C", 'A', coockedEgg, 'B', schnaps, 'C', Item.glassBottle);
		
		//Food-Rezepte-Eat
		GameRegistry.addShapelessRecipe(new ItemStack(breadslicetoast, 4), new ItemStack(Item.bread));
	
		GameRegistry.addRecipe(new ItemStack(sandwich_c),  "#", "*", "#", '#', breadslicetoast, '*', Item.chickenCooked);
		GameRegistry.addRecipe(new ItemStack(sandwich_f),  "#", "*", "#", '#', breadslicetoast, '*', Item.fishCooked);
		GameRegistry.addRecipe(new ItemStack(sandwich_p),  "#", "*", "#", '#', breadslicetoast, '*', Item.porkCooked);
		GameRegistry.addRecipe(new ItemStack(sandwich_b),  "#", "*", "#", '#', breadslicetoast, '*', Item.beefCooked);
		
		GameRegistry.addRecipe(new ItemStack(Eiertoast), "*", "#", '#', breadslicetoast, '*', coockedEgg);
		

		//Items
		GameRegistry.addRecipe(new ItemStack(Item.saddle), "###", "#0#", "*0*", '#', Item.leather, '*', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(Item.leash), "0#0", "#0#", "0#0", '#', Item.silk);
		GameRegistry.addRecipe(new ItemStack(Item.nameTag), "00#", "**0", "**0", '#', Item.silk, '*', Item.paper);
		GameRegistry.addRecipe(new ItemStack(Kettenglieder, 6), "0#0", "#0#", "0#0", '#', Item.ingotIron);
		GameRegistry.addRecipe(new ItemStack(Milch, 3), "0#0", "***", '#', Item.bucketMilk, '*', Item.glassBottle);
		
		//Horse Armor Iron, Gold, Diamant
		GameRegistry.addRecipe(new ItemStack(Item.horseArmorIron), "00#", "#*#", "###", '#', Item.ingotIron, '*', new ItemStack(Block.cloth, 1, 15));
		GameRegistry.addRecipe(new ItemStack(Item.horseArmorGold), "00#", "#*#", "###", '#', Item.ingotGold, '*', new ItemStack(Block.cloth, 1, 14));
		GameRegistry.addRecipe(new ItemStack(Item.horseArmorDiamond), "00#", "#*#", "###", '#', Item.diamond, '*', new ItemStack(Block.cloth, 1, 11));

		//Armor Chain
		GameRegistry.addRecipe(new ItemStack(Item.bootsChain), "000", "#0#", "#0#", '#', Kettenglieder);
		GameRegistry.addRecipe(new ItemStack(Item.helmetChain), "###", "#0#", "000", '#', Kettenglieder);
		GameRegistry.addRecipe(new ItemStack(Item.legsChain), "###", "#0#", "#0#", '#', Kettenglieder);
		GameRegistry.addRecipe(new ItemStack(Item.plateChain), "#0#", "###", "###", '#', Kettenglieder);
		
		//Spawner
		//GameRegistry.addRecipe(new ItemStack(Block.mobSpawner, 1, 2), "#", "#", "#", '#', Kettenglieder);
		
		//Ammo
		//GameRegistry.addRecipe(new ItemStack(Ammo, 16), "###", "#0#", "###", '#', Block.stone);
	}
	
	//Ofen-Rezepte
	private static void initSmeltingRecipes(){
		
		GameRegistry.addSmelting(Item.egg.itemID, new ItemStack(coockedEgg), 0.25f);
		GameRegistry.addSmelting(Item.poisonousPotato.itemID, new ItemStack(Item.potato), 0.25f);
		GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.beefRaw), 0.25f);
		GameRegistry.addSmelting(Item.reed.itemID, new ItemStack(schnaps), 0.25f);
		}
	
	private static void registerItems(){
		GameRegistry.registerItem(bier, "Bier");
		GameRegistry.registerItem(kakao, "Schokomilch");
		GameRegistry.registerItem(saft, "Multivitaminsaft");
		GameRegistry.registerItem(Milch, "Milchflasche");
		
		GameRegistry.registerItem(breadslicetoast, "Toastbrotscheibe");
		GameRegistry.registerItem(coockedEgg, "gekochtes Ei");
		
		GameRegistry.registerItem(sandwich_c, "Chickensandwich");
		GameRegistry.registerItem(sandwich_f, "Lachssandwich");
		GameRegistry.registerItem(sandwich_p, "Schickensandwich");
		GameRegistry.registerItem(sandwich_b, "Roastbeefsandwich");
		
		GameRegistry.registerItem(Eiertoast, "Eiertoast");
		GameRegistry.registerItem(schnaps, "Schnaps");
		GameRegistry.registerItem(likoer, "Eierlikoer");
		
		GameRegistry.registerItem(Kettenglieder, "Kettenglieder");
		
		GameRegistry.registerItem(EmeraldPickaxe, "EmeraldPickaxe");
		GameRegistry.registerItem(EmeraldAxe, "EmeraldAxe");
		GameRegistry.registerItem(EmeraldSpade, "EmeraldSpade");
		GameRegistry.registerItem(EmeraldHoe, "EmeraldHoe");
		
		
		
		//GameRegistry.registerItem(Ammo, "Munition");
		//GameRegistry.registerItem(Revolver, "Revolver");
		
		//GameRegistry.registerItem(Zauberstab, "Zauberstab der Zeit");
		//GameRegistry.registerItem(Krawams, "Krawams");
		} 
	
	private static void registerBlocks(){
		GameRegistry.registerBlock(Unobtanium, "Unobtanium");
		GameRegistry.registerBlock(Theke, "Theke");
		GameRegistry.registerBlock(Kiste, "Kiste");
		GameRegistry.registerBlock(ParkettHell, "ParkettHell");
		GameRegistry.registerBlock(ParkettDunkel, "ParkettDunkel");
		
		GameRegistry.registerBlock(KisteKohle, "Kohlekiste");
		GameRegistry.registerBlock(KisteEisen, "Eisenkiste");
		GameRegistry.registerBlock(KisteGold, "GoldKiste");
		GameRegistry.registerBlock(KisteDiamant, "Diamantkiste");
		GameRegistry.registerBlock(KisteEmerald, "Edelsteinkiste");
		GameRegistry.registerBlock(KisteLapis, "Lapiskiste");
		
		GameRegistry.registerBlock(KisteCookie, "Keksekiste");
		GameRegistry.registerBlock(KisteKartoffel, "Kartoffelkiste");
		GameRegistry.registerBlock(KisteApfel, "Apfelkiste");
		GameRegistry.registerBlock(KisteFisch, "Fischkiste");
		GameRegistry.registerBlock(KisteKarotte, "Karottenkiste");
		
		GameRegistry.registerBlock(BooksSpruce, "Fichtenholzregal");
		GameRegistry.registerBlock(BooksJungle, "Jungelholzregal");
		GameRegistry.registerBlock(BooksBirch, "Birkenholzregal");
		
		GameRegistry.registerBlock(Lamp, "Lightstone-Lampe");
		
		GameRegistry.registerBlock(FensterNS, "Fenster Nord-Sued");
		GameRegistry.registerBlock(FensterSN, "Fenster Sued-Nord");
		GameRegistry.registerBlock(FensterWO, "Fenster West-Ost");
		GameRegistry.registerBlock(FensterOW, "Fenster Ost-West");
		}
	
	private static void updateLanguage(){
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabKalle", "Kalles Modding");
		
		LanguageRegistry.addName(bier, "Bier");
		LanguageRegistry.addName(kakao, "Schokomilch");
		LanguageRegistry.addName(saft, "Multivitaminsaft");
		LanguageRegistry.addName(Milch, "Milchflasche");
		
		LanguageRegistry.addName(breadslicetoast, "getoastete Brotscheibe");
		LanguageRegistry.addName(coockedEgg, "gekochtes Ei");
		
		LanguageRegistry.addName(sandwich_c, "Chickensandwich");
		LanguageRegistry.addName(sandwich_f, "Lachssandwich");
		LanguageRegistry.addName(sandwich_p, "Schinkensandwich");
		LanguageRegistry.addName(sandwich_b, "Roastbeefsandwich");
		
		LanguageRegistry.addName(Eiertoast, "Eiertoast");
		LanguageRegistry.addName(schnaps, "Schnaps");
		LanguageRegistry.addName(likoer, "Eierlikoer");
		
		LanguageRegistry.addName(Kettenglieder, "Kettenglieder");
		
		LanguageRegistry.addName(Unobtanium, "Unobtanium");
		LanguageRegistry.addName(Theke, "Theke");
		LanguageRegistry.addName(Kiste, "Kiste");
		LanguageRegistry.addName(ParkettHell, "helles Parkett");
		LanguageRegistry.addName(ParkettDunkel, "dunkles Parkett");
		
		LanguageRegistry.addName(KisteKohle, "Kohlekiste");
		LanguageRegistry.addName(KisteEisen, "Eisenkiste");
		LanguageRegistry.addName(KisteGold, "Goldkiste");
		LanguageRegistry.addName(KisteDiamant, "Diamantenkiste");
		LanguageRegistry.addName(KisteEmerald, "Edelsteinkiste");
		LanguageRegistry.addName(KisteLapis, "Lapiskiste");
		
		LanguageRegistry.addName(KisteCookie, "Keksekiste");
		LanguageRegistry.addName(KisteKartoffel, "Kartoffelkiste");
		LanguageRegistry.addName(KisteApfel, "Apfelkiste");
		LanguageRegistry.addName(KisteFisch, "Fischkiste");
		LanguageRegistry.addName(KisteKarotte, "Karottenkiste");
		
		LanguageRegistry.addName(BooksSpruce, "Fichtenholzregal");
		LanguageRegistry.addName(BooksJungle, "Jungelholzregal");
		LanguageRegistry.addName(BooksBirch, "Birkenholzregal");
		
		LanguageRegistry.addName(Lamp, "Lightstone-Lampe");
		
		LanguageRegistry.addName(FensterNS, "Fenster Nord-Sued");
		LanguageRegistry.addName(FensterSN, "Fenster Sued-Nord");
		LanguageRegistry.addName(FensterWO, "Fenster West-Ost");
		LanguageRegistry.addName(FensterOW, "Fenster Ost-West");
		
		LanguageRegistry.addName(EmeraldPickaxe, "Edelsteinspitzhacke");
		LanguageRegistry.addName(EmeraldAxe, "Edelsteinaxt");
		LanguageRegistry.addName(EmeraldSpade, "Edelsteinschaufel");
		LanguageRegistry.addName(EmeraldHoe, "Edelsteinhacke");
		
		//LanguageRegistry.addName(Ammo, "Munition");
		//LanguageRegistry.addName(Revolver, "Revolver");
		
		//LanguageRegistry.addName(Zauberstab, "Zauberstab der Zeit");
		//LanguageRegistry.addName(Krawams, "Krawams");
		}
	// ----- met-end -----
}	