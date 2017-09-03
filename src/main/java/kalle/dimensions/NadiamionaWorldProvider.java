package kalle.dimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.client.IRenderHandler;

public class NadiamionaWorldProvider extends WorldProvider {
    public static final DimensionType TYPE = DimensionType.OVERWORLD;

    @Override
    public boolean hasNoSky() {
        return true;
    }

    @Override
    public IRenderHandler getSkyRenderer() {
        // no sky renderer
        return null;
    }

    @Override
    public DimensionType getDimensionType() {
        return TYPE;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome";
    }

    @Override
    public String getDepartMessage() {
        return "See you";
    }
}
