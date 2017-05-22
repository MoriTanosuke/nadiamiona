package kalle.events;

import kalle.blocks.Blocks;
import kalle.items.Items;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(Blocks.all);
        FMLLog.getLogger().info("All " + Blocks.all.length + " blocks registered");
    }

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
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "normal"));
        }

        for (Item item : Items.all) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
        }
    }
}