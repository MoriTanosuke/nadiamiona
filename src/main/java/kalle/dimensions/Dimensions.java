package kalle.dimensions;

import kalle.Basis;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class Dimensions {
    public static final int DIMENSION_ID = DimensionManager.getNextFreeDimId();

    /**
     * Registeres all known dimensions. Must be called in {@link kalle.Basis#preInit}
     */
    public static void register() {
        //TODO keep loaded?
        DimensionType.register(Basis.MOD_PREFIX, NadiamionaWorldProvider.class.getSimpleName(), DIMENSION_ID, NadiamionaWorldProvider.class, false);
        DimensionManager.registerDimension(DIMENSION_ID, NadiamionaWorldProvider.TYPE);
    }

}
