package kalle.events;

import kalle.dimensions.NadiamionaWorldProvider;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

@SideOnly(Side.SERVER)
public class DimensionEvents {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onDimensionUnload(WorldEvent.Unload event) {
        FMLLog.getLogger().debug("Dimension with provider {} unloaded", event.getWorld().provider);
        if(event.getWorld().provider instanceof NadiamionaWorldProvider) {
            FMLLog.getLogger().debug("Custom dimension unloaded, removing now...");
            final String saveFolder = event.getWorld().provider.getSaveFolder();
            if (saveFolder != null && !"".equals(saveFolder)) {
                try {
                    File directory = new File(saveFolder);
                    FMLLog.getLogger().debug("Removing directory {}", directory);
                    FileUtils.deleteDirectory(directory);
                    FMLLog.getLogger().debug("Custom dimension removed.");
                } catch (IOException e) {
                    FMLLog.getLogger().error("Can not remove dimension data files", e);
                }
            }
        }
    }
}
