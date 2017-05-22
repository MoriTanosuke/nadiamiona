package kalle.proxies;

import kalle.recipes.Recipes;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Logger;

public class BasisCommonProxy {
    static final Logger LOG = FMLLog.getLogger();

    public void preInit() {
        LOG.debug("Adding crafting recipes...");
        //TODO is there another event to register recipes?
        Recipes.register();

        LOG.info("All done.");
    }

    public void init() {
        // nothing common to do here yet
    }

    public void postInit() {
        // nothing to do here yet
    }
}
