package kalle;

import kalle.proxies.BasisCommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

//TODO replace with build.gradle properties
@Mod(modid = "kalle", name = "Nadiamiona", version = "1.11.2-1", updateJSON = "https://raw.githubusercontent.com/MoriTanosuke/nadiamiona/master/update.json")
public class Basis {
  public static final String MOD_PREFIX = "kalle";

  @Instance(MOD_PREFIX)
  public static Basis instance;

  @SidedProxy(clientSide = "kalle.proxies.BasisClientProxy", serverSide = "kalle.proxies.BasisServerProxy")
  public static BasisCommonProxy proxy;

  @EventHandler
  public void preInit(FMLInitializationEvent event) {
    proxy.preInit();
  }

  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.load();
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit();
  }
}
