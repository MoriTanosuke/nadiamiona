package kalle.proxies;

import kalle.dimensions.Dimensions;
import kalle.events.ToolEvents;
import kalle.recipes.Recipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Logger;

public class BasisCommonProxy {
    static final Logger LOG = FMLLog.getLogger();

    public void preInit() {
        // register all recipes in pre-init phase
        Recipes.register();
        Dimensions.register();
    }

    public void init() {
        LOG.info("Registering tool event handlers...");
        final ToolEvents toolEvents = new ToolEvents();
        MinecraftForge.EVENT_BUS.register(toolEvents);
    }

    public void postInit() {
        // nothing to do here yet
    }
}
