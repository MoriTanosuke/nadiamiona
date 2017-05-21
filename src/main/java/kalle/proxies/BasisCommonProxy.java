package kalle.proxies;

import kalle.Basis;
import kalle.recipes.Recipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

public class BasisCommonProxy {
    static final Logger LOG = FMLLog.getLogger();

    public void preInit() {
        LOG.info("Pre-Initializing common proxy...");
        // TODO what to do on both sides?

        LOG.debug("Adding crafting recipes...");
        //TODO is there another event to register recipes?
        Recipes.register();

        LOG.info("All done.");
    }

    public void load() {
        // TODO what to do on both sides?
    }

    public void postInit() {
        // TODO what to do on both sides?
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
