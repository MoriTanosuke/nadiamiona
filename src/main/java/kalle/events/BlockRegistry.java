package kalle.events;

import kalle.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;


/**
 * Here we will assign blocks to an ArrayList, and then use said list to
 * register, and later, also render each block.
 * 
 * The same functionality can be used for Items.
 * 
 * Please do note the Annotation below here. It is required because we will
 * be subscribing to an event, before preInit.
 */
@Mod.EventBusSubscriber
public class BlockRegistry {

	//We create a list that holds each and every block we make. When we make a new block,
	//we only need to add the block to this list.
	public static final List<Block> BLOCK_LIST = new ArrayList<Block>();

	public static void prepareBlocks(){

		// TODO get own creative tab
		CreativeTabs tab = CreativeTabs.BUILDING_BLOCKS;

		// try to create a block with custom shape
		final Block customBlock = new Block(Material.WOOD) {
			@Override
			public boolean isFullCube(IBlockState state) {
				return false;
			}

			@Override
			public boolean isFullyOpaque(IBlockState state) {
				return false;
			}
		};
		customBlock.setUnlocalizedName("smallBlock").setRegistryName("smallBlock").setCreativeTab(tab);
		BLOCK_LIST.add(customBlock);

		BlockBar theke = new BlockBar(tab);
		GameRegistry.addRecipe(new ItemStack(theke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 0), 'B',
				new ItemStack(Blocks.WOODEN_SLAB, 1, 0));
		registerBlock(theke);
		final BlockBar spruceTheke = new BlockBar(tab, "SpruceTheke");
		registerBlock(spruceTheke);
		GameRegistry.addRecipe(new ItemStack(spruceTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 1),
				'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 1));
		final BlockBar jungleTheke = new BlockBar(tab, "JungleTheke");
		registerBlock(jungleTheke);
		GameRegistry.addRecipe(new ItemStack(jungleTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 3),
				'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 3));
		final BlockBar acaciaTheke = new BlockBar(tab, "AcaciaTheke");
		registerBlock(acaciaTheke);
		GameRegistry.addRecipe(new ItemStack(acaciaTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 4),
				'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 4));
		final BlockBar birchTheke = new BlockBar(tab, "BirchTheke");
		registerBlock(birchTheke);
		GameRegistry.addRecipe(new ItemStack(birchTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 2), 'B',
				new ItemStack(Blocks.WOODEN_SLAB, 1, 2));
		final BlockBar darkOakTheke = new BlockBar(tab, "DarkOakTheke");
		registerBlock(darkOakTheke);
		GameRegistry.addRecipe(new ItemStack(darkOakTheke, 2), "000", "0BB", "0AA", 'A', new ItemStack(Blocks.PLANKS, 1, 5),
				'B', new ItemStack(Blocks.WOODEN_SLAB, 1, 5));

		final BlockParkett parkettOak = new BlockParkett(tab, "ParkettOak");
		registerBlock(parkettOak);
		GameRegistry.addRecipe(new ItemStack(parkettOak, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 0));
		final BlockParkett parkettSpruce = new BlockParkett(tab, "ParkettSpruce");
		registerBlock(parkettSpruce);
		GameRegistry.addRecipe(new ItemStack(parkettSpruce, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 1));
		final BlockParkett parkettBirch = new BlockParkett(tab, "ParkettBirke");
		registerBlock(parkettBirch);
		GameRegistry.addRecipe(new ItemStack(parkettBirch, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 2));
		final BlockParkett parkettDjungle = new BlockParkett(tab, "ParkettDschungel");
		registerBlock(parkettDjungle);
		GameRegistry.addRecipe(new ItemStack(parkettDjungle, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 3));
		final BlockParkett parkettAkazie = new BlockParkett(tab, "ParkettAkazie");
		registerBlock(parkettAkazie);
		GameRegistry.addRecipe(new ItemStack(parkettAkazie, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 4));
		final BlockParkett parkettDarkoak = new BlockParkett(tab, "ParkettDarkOak");
		registerBlock(parkettDarkoak);
		GameRegistry.addRecipe(new ItemStack(parkettDarkoak, 4), "A#A", "#A#", "A#A", 'A', new ItemStack(Blocks.PLANKS, 1, 5));

		final Block booksSpruce = new Block(Material.WOOD).setUnlocalizedName("BooksSpruce").setRegistryName("BooksSpruce").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksSpruce);
		GameRegistry.addRecipe(new ItemStack(booksSpruce), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 1),
				'*', Items.BOOK);
		final Block booksJungle = new Block(Material.WOOD).setUnlocalizedName("BooksJungle").setRegistryName("BooksJungle").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksJungle);
		GameRegistry.addRecipe(new ItemStack(booksJungle), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 3),
				'*', Items.BOOK);
		final Block booksBirch = new Block(Material.WOOD).setUnlocalizedName("BooksBirch").setRegistryName("BooksBirch").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksBirch);
		GameRegistry.addRecipe(new ItemStack(booksBirch), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 2), '*',
				Items.BOOK);
		final Block booksAcacia = new Block(Material.WOOD).setUnlocalizedName("BooksAcacia").setRegistryName("BooksAcacia").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksAcacia);
		GameRegistry.addRecipe(new ItemStack(booksAcacia), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 4), '*',
				Items.BOOK);
		final Block booksDarkOak = new Block(Material.WOOD).setUnlocalizedName("BooksDarkOak").setRegistryName("BooksDarkOak").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(booksDarkOak);
		GameRegistry.addRecipe(new ItemStack(booksDarkOak), "###", "#*#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 5), '*',
				Items.BOOK);

		// Kisten
		final Block kiste = new Block(Material.WOOD).setUnlocalizedName("Kiste").setRegistryName("Kiste").setCreativeTab(tab).setHardness(2.0F)
				.setResistance(5.0F);
		registerBlock(kiste);
		GameRegistry.addRecipe(new ItemStack(kiste), "#0#", "#0#", "###", '#', Blocks.PLANKS);

		final Block kisteKohle = new Block(Material.WOOD).setUnlocalizedName("Kohlekiste").setRegistryName("Kohlekiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteKohle);
		GameRegistry.addRecipe(new ItemStack(kisteKohle), "*", "#", '*', Items.COAL, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteKohle), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.COAL);

		final Block kisteEisen = new Block(Material.WOOD).setUnlocalizedName("Eisenkiste").setRegistryName("Eisenkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteEisen);
		GameRegistry.addRecipe(new ItemStack(kisteEisen), "*", "#", '*', Items.IRON_INGOT, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteEisen), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.IRON_INGOT);

		final Block kisteGold = new Block(Material.WOOD).setUnlocalizedName("Goldkiste").setRegistryName("Goldkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteGold);
		GameRegistry.addRecipe(new ItemStack(kisteGold), "*", "#", '*', Items.GOLD_INGOT, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteGold), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.GOLD_INGOT);

		final Block kisteDiamant = new Block(Material.WOOD).setUnlocalizedName("Diamantkiste").setRegistryName("Diamantkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteDiamant);
		GameRegistry.addRecipe(new ItemStack(kisteDiamant), "*", "#", '*', Items.DIAMOND, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteDiamant), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.DIAMOND);

		final Block kisteEmerald = new Block(Material.WOOD).setUnlocalizedName("Edelsteinkiste").setRegistryName("Edelsteinkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteEmerald);
		GameRegistry.addRecipe(new ItemStack(kisteEmerald), "*", "#", '*', Items.EMERALD, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteEmerald), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.EMERALD);

		final Block kisteLapis = new Block(Material.WOOD).setUnlocalizedName("Lapiskiste").setRegistryName("Lapiskiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteLapis);
		// check out dye meta IDs at http://minecraft.gamepedia.com/Data_values#Dyes
		GameRegistry.addRecipe(new ItemStack(kisteLapis), "*", "#", '*', new ItemStack(Items.DYE, 1, 4), '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteLapis), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', new ItemStack(Items.DYE, 1, 4));

		final Block kisteApfel = new Block(Material.WOOD).setUnlocalizedName("Apfelkiste").setRegistryName("Apfelkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteApfel);
		GameRegistry.addRecipe(new ItemStack(kisteApfel), "*", "#", '*', Items.APPLE, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteApfel), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.APPLE);

		final Block kisteCookie = new Block(Material.WOOD).setUnlocalizedName("Keksekiste").setRegistryName("Keksekiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteCookie);
		GameRegistry.addRecipe(new ItemStack(kisteCookie), "*", "#", '*', Items.COOKIE, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteCookie), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.COOKIE);

		final Block kisteKartoffel = new Block(Material.WOOD).setUnlocalizedName("Kartoffelkiste").setRegistryName("Kartoffelkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteKartoffel);
		GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "*", "#", '*', Items.POTATO, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteKartoffel), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.POTATO);

		final Block kisteFisch = new Block(Material.WOOD).setUnlocalizedName("Fischkiste").setRegistryName("Fischkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteFisch);
		GameRegistry.addRecipe(new ItemStack(kisteFisch), "*", "#", '*', new ItemStack(Items.FISH, 1, 0), '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteFisch), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', new ItemStack(Items.FISH, 1, 0));

		final Block kisteLachs = new Block(Material.WOOD).setUnlocalizedName("Lachskiste").setRegistryName("Lachskiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteLachs);
		GameRegistry.addRecipe(new ItemStack(kisteLachs), "*", "#", '*', new ItemStack(Items.FISH, 1, 1), '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteLachs), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', new ItemStack(Items.FISH, 1, 1));

		final Block kisteKarotte = new Block(Material.WOOD).setUnlocalizedName("Karottenkiste").setRegistryName("Karottenkiste").setCreativeTab(tab)
				.setHardness(2.0F).setResistance(5.0F);
		registerBlock(kisteKarotte);
		GameRegistry.addRecipe(new ItemStack(kisteKarotte), "*", "#", '*', Items.CARROT, '#', kiste);
		GameRegistry.addRecipe(new ItemStack(kisteKarotte), "#0#", "#*#", "###", '#', Blocks.PLANKS, '*', Items.CARROT);

		// walls
		final Wall stoneWall = new Wall(tab, Blocks.STONE, "stone_wall");
		registerBlock(stoneWall);
		GameRegistry.addRecipe(new ItemStack(stoneWall, 6), "###", "AAA", "AAA", 'A', Blocks.STONE);
		final Wall brickWall = new Wall(tab, Blocks.BRICK_BLOCK, "brick_wall");
		registerBlock(brickWall);
		GameRegistry.addRecipe(new ItemStack(brickWall, 6), "###", "AAA", "AAA", 'A', Blocks.BRICK_BLOCK);
		final Wall stonebrickWall = new Wall(tab, Blocks.STONEBRICK, "stonebrick_wall");
		registerBlock(stonebrickWall);
		GameRegistry.addRecipe(new ItemStack(stonebrickWall, 6), "###", "AAA", "AAA", 'A', Blocks.STONEBRICK);
		final Wall sandstoneWall = new Wall(tab, Blocks.SANDSTONE, "sandstone_wall");
		registerBlock(sandstoneWall);
		GameRegistry.addRecipe(new ItemStack(sandstoneWall, 6), "###", "AAA", "AAA", 'A', Blocks.SANDSTONE);
		final Wall redSandstoneWall = new Wall(tab, Blocks.RED_SANDSTONE, "red_sandstone_wall");
		registerBlock(redSandstoneWall);
		GameRegistry.addRecipe(new ItemStack(redSandstoneWall, 6), "###", "AAA", "AAA", 'A', Blocks.RED_SANDSTONE);
		final Wall woolWall = new Wall(tab, Blocks.WOOL, "wool_wall");
		registerBlock(woolWall);
		GameRegistry.addRecipe(new ItemStack(woolWall, 6), "###", "AAA", "AAA", 'A', Blocks.WOOL);

		final Wall leaveWall = new WallLeaves(tab, Blocks.LEAVES2, "leave_wall");
		registerBlock(leaveWall);
		GameRegistry.addRecipe(new ItemStack(leaveWall, 6), "###", "AAA", "AAA", 'A', Blocks.LEAVES);

		for (int color = 0; color <= 15; color++) {
			final BlockStairs woolStairs = new WoolStairs(tab, Blocks.WOOL.getDefaultState(), "wool_stairs_" + color);
			registerBlock(woolStairs);
			GameRegistry.addRecipe(new ItemStack(woolStairs, 4), "A##", "AA#", "AAA", 'A', new ItemStack(Blocks.WOOL, 1, color));
		}

	}

	private static void registerBlock(Block block) {
		BLOCK_LIST.add(block);
	}

	//This method will be called without us calling it. This is because 
	//Forge calls it -for- us, when the RegistryEvent happens. This is why
	//we had to use the @Mod.EventBusSubscriber at the top of the class.
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		
		//We make sure that the list gets filled with our blocks.
		prepareBlocks();
		
		//For-each-loop. Essentially, for each and every block we find in the BLOCK_LIST, 
		//we will call it "block", and register it.
		for(Block block : BLOCK_LIST){
			event.getRegistry().register(block);
		}
	}
	
	//Don't forget to register the ItemBlock variant (When held, or in an inventory, a block is an "item")
	//We do not need to call prepareBlocks() in this method, because Blocks are registered before items.
	//Thus, our registerBlocks method has already happened.
	//ItemBlocks are of course not required to be made for Items.
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		for(Block block : BLOCK_LIST){
			ItemBlock iblock = new ItemBlock(block);
			iblock.setRegistryName(block.getRegistryName());
			event.getRegistry().register(iblock);
		}
	}

	@SubscribeEvent
	public static void registerBlockRenderer(ModelRegistryEvent event){
		//Time for another for-loop. Like last time, we will loop
		//through the same loop we used to register the blocks
		for(Block block : BlockRegistry.BLOCK_LIST){

			/**
			 * DO NOT USE Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
			 * It is *incredibly* prone to issues. The only reason Vanilla rendering works, is because of the extensive knowledge of the system, and the years
			 * of expertice the coders of Mojang have.
			 *
			 * Instead, use this; It is provided by forge, and has to be called in before or during preInit: V
			 */
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

			/**
			 * If you use modid + ":" + getUnlocalizedName().substring() for the ModelResourceLocation, I swear I will find you, and
			 * bash your head with 1000 printed papers of this page.
			 * It is *completely* redundant, moronic, atrocious and gratuitous to manually create the ModelResourceLocation, when
			 * getRegistryName() DOES THAT FOR YOU! IT CREATES THE PATH USING MODID:NAME! THATS ALL YOU NEED!
			 *
			 * Not to mention, unLocalizedName, should be used SOLELY to render the NAME of the item/block. It should not in any damned way
			 * have anything to do with unique identifiers.
			 * </rage>
			 */
		}
	}
}