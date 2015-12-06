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

	@EventHandler
	public void preInit(FMLInitializationEvent event) {
		LOG.debug("Creating objects...");
		
		// initialize EmeraldPickaxe first, to use as creative tab icon
		final Item emeraldPickaxe = new ItemPickaxeEmerald().setUnlocalizedName("EmeraldPickaxe");
		GameRegistry.addRecipe(new ItemStack(emeraldPickaxe), "###", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
		registerItem(emeraldPickaxe, "EmeraldPickaxe");
		
		final CreativeTabs tabKalle = new CreativeTabs("tabKalle") {
			public ItemStack getIconItemStack() {
				return new ItemStack(emeraldPickaxe, 1, 0);
			}

			@Override
			public Item getTabIconItem() {
				return emeraldPickaxe;
			}
		};
		emeraldPickaxe.setCreativeTab(tabKalle);
		
		// Food
		final Item breadslicetoast = new ItemFood(1, 0.1F, false).setUnlocalizedName("Breadslice").setCreativeTab(tabKalle);
		GameRegistry.addShapelessRecipe(new ItemStack(breadslicetoast, 4), new ItemStack(Items.bread));
		registerItem(breadslicetoast, "Breadslice");
		//TODO replace with variants?
		final Item sandwich_chicken = new ItemFood(8, 0.66F, false).setUnlocalizedName("Chickensandwich").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(sandwich_chicken), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_chicken);
		registerItem(sandwich_chicken, "Chickensandwich");
		final Item sandwich_fish = new ItemFood(7, 0.66F, false).setUnlocalizedName("Lachssandwich").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(sandwich_fish), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_fish);
		registerItem(sandwich_fish, "Lachssandwich");
		final Item sandwich_bacon = new ItemFood(10, 0.75F, false).setUnlocalizedName("Schinkensandwich").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(sandwich_bacon), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_porkchop);
		registerItem(sandwich_bacon, "Schinkensandwich");
		final Item sandwich_beef = new ItemFood(10, 0.75F, false).setUnlocalizedName("Roastbeefsandwich").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(sandwich_beef), "#", "*", "#", '#', breadslicetoast, '*', Items.cooked_beef);
		registerItem(sandwich_beef, "Roastbeefsandwich");

		final Item cookedEgg = new ItemFood(2, 0.1F, false).setUnlocalizedName("CookedEgg").setCreativeTab(tabKalle);
		GameRegistry.addSmelting(Items.egg, new ItemStack(cookedEgg), 0.25f);
		registerItem(cookedEgg, "CookedEgg");

		final Item eiertoast = new ItemFood(5, 0.5F, false).setUnlocalizedName("Eiertoast").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(eiertoast), "*", "#", '#', breadslicetoast, '*', cookedEgg);
		registerItem(eiertoast, "Eiertoast");
		
		// Drinks
		final Item milch = new Item().setUnlocalizedName("Milchflasche").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(milch, 3), "0#0", "***", '#', Items.milk_bucket, '*', Items.glass_bottle);
		registerItem(milch, "Milchflasche");
		
		final Item bier = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Bier").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(bier), "A", "B", 'A', Items.wheat_seeds, 'B', Items.potionitem);
		GameRegistry.addRecipe(new ItemStack(bier, 3), "0A0", "BBB", "CCC", 'A', Items.water_bucket, 'B', Items.wheat_seeds, 'C', Items.glass_bottle);
		registerItem(bier, "Bier");
		final Item kakao = new ItemDrink(5, 0.5F, false).setUnlocalizedName("Kakao").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(kakao), "A", "B", "C", 'A', new ItemStack(Items.dye, 1, 3), 'B', Items.sugar, 'C', milch);
		GameRegistry.addRecipe(new ItemStack(kakao, 3), "DAD", "BBB", "CCC", 'A', Items.milk_bucket, 'B', new ItemStack(Items.dye, 1, 3), 'C', Items.glass_bottle, 'D', Items.sugar);
		registerItem(kakao, "Schokomilch");
		final Item saft = new ItemDrink(5, 0.5F, false).setUnlocalizedName("saft").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(saft), "A", "B", "C", 'A', Items.apple, 'B', Items.carrot, 'C', Items.glass_bottle);
		GameRegistry.addRecipe(new ItemStack(saft, 3), "AAA", "BBB", "CCC", 'A', Items.apple, 'B', Items.carrot, 'C', Items.glass_bottle);
		registerItem(saft, "Multivitaminsaft");

		final Item schnaps = (ItemDrink) new ItemDrink(1, 0.1F, false).setUnlocalizedName("Schnaps").setCreativeTab(tabKalle);
		GameRegistry.addSmelting(Items.reeds, new ItemStack(schnaps), 0.25f);
		registerItem(schnaps, "Schnaps");
		final Item likoer = (ItemDrink) new ItemDrink(5, 0.3F, false).setUnlocalizedName("Eierlikoer").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(likoer), "A", "B", "C", 'A', cookedEgg, 'B', schnaps, 'C', Items.glass_bottle);
		registerItem(likoer, "Eierlikoer");
		
		// Teile zum Craften
		final Item ketten_glieder = new Item().setUnlocalizedName("Kettenglieder").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(ketten_glieder, 6), "0#0", "#0#", "0#0", '#', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots), "000", "#0#", "#0#", '#', ketten_glieder);
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet), "###", "#0#", "000", '#', ketten_glieder);
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings), "###", "#0#", "#0#", '#', ketten_glieder);
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate), "#0#", "###", "###", '#', ketten_glieder);
		registerItem(ketten_glieder, "Kettenglieder");

		// Moebel
		final Block theke = new Block(Material.wood).setUnlocalizedName("Theke").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(theke, "Theke");
		final Block parkettHell = new Block(Material.wood).setUnlocalizedName("ParkettHell").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(parkettHell, "ParkettHell");
		final Block parkettDunkel = new Block(Material.wood).setUnlocalizedName("ParkettDunkel").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(parkettDunkel, "ParkettDunkel");

		final Block booksSpruce = new Block(Material.wood).setUnlocalizedName("BooksSpruce").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksSpruce, "BooksSpruce");
		final Block booksJungle = new Block(Material.wood).setUnlocalizedName("BooksJungle").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksJungle, "BooksJungle");
		final Block booksBirch = new Block(Material.wood).setUnlocalizedName("BooksBirch").setCreativeTab(tabKalle).setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksBirch, "BooksBirch");

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
		final Item emeraldAxe = new ItemAxeEmerald().setUnlocalizedName("EmeraldAxe").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(emeraldAxe), "##0", "#*0", "0*0", '#', Items.emerald, '*', Items.stick);
		registerItem(emeraldAxe, "EmeraldAxe");
		final Item emeraldSpade = new ItemSpadeEmerald().setUnlocalizedName("EmeraldSpade").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(emeraldSpade), "0#0", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
		registerItem(emeraldSpade, "EmeraldSpade");
		final Item emeraldHoe = new ItemHoeEmerald().setUnlocalizedName("EmeraldHoe").setCreativeTab(tabKalle);
		GameRegistry.addRecipe(new ItemStack(emeraldHoe), "##0", "0*0", "0*0", '#', Items.emerald, '*', Items.stick);
		registerItem(emeraldHoe, "EmeraldHoe");

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
		
		// some additional smelting recipes
		GameRegistry.addSmelting(Items.poisonous_potato, new ItemStack(Items.potato), 0.25f);
		GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.beef), 0.25f);

		LOG.info("Adding crafting recipes...");
		initCraftingRecipes();
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

		// Items
		GameRegistry.addRecipe(new ItemStack(Items.saddle), "###", "#0#", "*0*", '#', Items.leather, '*', Items.iron_ingot);
		// GameRegistry.addRecipe(new ItemStack(Items.lead), "0#0", "#0#",
		// "0#0", '#', Items.silk);
		// GameRegistry.addRecipe(new ItemStack(Items.name_tag), "00#", "**0",
		// "**0", '#', Items.silk, '*', Items.paper);

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

		// Spawner
		// GameRegistry.addRecipe(new ItemStack(Blocks.mobSpawner, 1, 2), "#",
		// "#", "#", '#', Kettenglieder);

		// Ammo
		// GameRegistry.addRecipe(new ItemStack(Ammo, 16), "###", "#0#", "###",
		// '#', Blocks.stone);
	}

	private void registerBlock(final Block block, final String blockname) {
		GameRegistry.registerBlock(block, blockname);
	    final Item itemBlockSimple = GameRegistry.findItem(MOD_PREFIX, blockname);
	    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MOD_PREFIX + ":" + blockname, "inventory");
	    final int DEFAULT_ITEM_SUBTYPE = 0;
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}

	private void registerItem(final Item item, final String itemName) {
		// required in order for the renderer to know how to render your item.
		// Likely to change in the near future.
		final ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MOD_PREFIX + ":" + itemName,
				"inventory");
		final int DEFAULT_ITEM_SUBTYPE = 0;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, DEFAULT_ITEM_SUBTYPE,
				itemModelResourceLocation);
		GameRegistry.registerItem(item, itemName);
	}

}