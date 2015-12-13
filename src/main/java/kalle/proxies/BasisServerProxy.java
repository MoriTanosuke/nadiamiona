package kalle.proxies;

public class BasisServerProxy extends BasisCommonProxy {

  @Override
  public void preInit() {
    super.preInit();
    LOG.info("Pre-Initializing server proxy...");
  }

  @Override
  public void load() {
    super.load();
    LOG.info("Loading server proxy...");

  }

  @Override
  public void postInit() {
    super.postInit();
    LOG.info("Post-Initializing server proxy...");
  }

}
