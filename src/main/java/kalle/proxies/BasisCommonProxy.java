package kalle.proxies;

import kalle.events.ToolEvents;
import kalle.recipes.Recipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

public class BasisCommonProxy {
    protected Logger LOG = FMLLog.getLogger();

    @SubscribeEvent()
    public void initialize(FMLPreInitializationEvent event) {
        LOG = event.getModLog();

    }

    public void preInit() {
        // register all recipes in pre-init phase
        Recipes.register();
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
