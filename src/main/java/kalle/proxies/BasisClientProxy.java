package kalle.proxies;

public class BasisClientProxy extends BasisCommonProxy {

  @Override
  public void preInit() {
    super.preInit();
    LOG.info("Pre-Initializing client proxy...");
  }

  @Override
  public void load() {
    super.load();
    LOG.info("Loading client proxy...");
  }

  @Override
  public void postInit() {
    super.postInit();
    LOG.info("Post-Initializing client proxy...");
  }

}