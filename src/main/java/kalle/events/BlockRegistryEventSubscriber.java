package kalle.events;

import kalle.blocks.Blocks;
import kalle.items.Items;
import kalle.proxies.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Here we will assign blocks to an ArrayList, and then use said list to
 * register, and later, also render each block.
 * <p>
 * The same functionality can be used for Items.
 * <p>
 * Please do note the Annotation below here. It is required because we will
 * be subscribing to an event, before preInit.
 */
@Mod.EventBusSubscriber
public class BlockRegistryEventSubscriber {

    public static void prepareBlocks() {
        FMLLog.info("Preparing " + Blocks.all.length + " blocks...");

        // TODO get own creative tab
        CreativeTabs tab = Tabs.tab;

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
    }

    //This method will be called without us calling it. This is because
    //Forge calls it -for- us, when the RegistryEvent happens. This is why
    //we had to use the @Mod.EventBusSubscriber at the top of the class.
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        //We make sure that the list gets filled with our blocks.
        prepareBlocks();

        event.getRegistry().registerAll(Blocks.all);
        FMLLog.getLogger().info("All " + Blocks.all.length + " blocks registered");
    }

    //Don't forget to register the ItemBlock variant (When held, or in an inventory, a block is an "item")
    //We do not need to call prepareBlocks() in this method, because Blocks are registered before items.
    //Thus, our registerBlocks method has already happened.
    //ItemBlocks are of course not required to be made for Items.
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(Items.all);
        for (Block block : Blocks.all) {
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }

        FMLLog.getLogger().info("All " + Items.all.length + " items and " + Blocks.all.length + " item blocks registered");
    }

    @SubscribeEvent
    public static void registerBlockRenderer(ModelRegistryEvent event) {
        for (Block block : Blocks.all) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }

        for (Item item : Items.all) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}