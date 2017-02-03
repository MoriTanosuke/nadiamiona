package kalle.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.creativetab.CreativeTabs;

public class Wall extends BlockWall {
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");

    public Wall(CreativeTabs tab, Block modelBlock, String unlocalizedName) {
        super(modelBlock);
        this.setCreativeTab(tab);
        this.setUnlocalizedName(unlocalizedName);
    }
}
