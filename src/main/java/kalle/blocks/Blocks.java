package kalle.blocks;

import kalle.blocks.bars.*;
import kalle.blocks.bookshelves.*;
import kalle.blocks.crates.*;
import kalle.blocks.floors.*;
import kalle.blocks.walls.*;
import net.minecraft.block.Block;

public class Blocks {
    public static final Block BAR = new OakBar();
    public static final Block SPRUCE_BAR = new SpruceBar();
    public static final Block JUNGLE_BAR = new JungleBar();
    public static final Block ACACIA_BAR = new AcaciaBar();
    public static final Block BIRCH_BAR = new BirchBar();
    public static final Block DARK_OAK_BAR = new DarkOakBar();
    public static final Block OAK_PARQUET = new OakParquet();
    public static final Block SPRUCE_PARQUET = new SpruceParquet();
    public static final Block BIRCH_PARQUET = new BirchParquet();
    public static final Block JUNGLE_PARQUET = new JungleParquet();
    public static final Block ACACIA_PARQUET = new AcaciaParquet();
    public static final Block DARK_OAK_PARQUET = new DarkOakParquet();
    public static final Block SPRUCE_BOOK_SHELVES = new SpruceBookShelves();
    public static final Block JUNGLE_BOOK_SHELVES = new JungleBookShelves();
    public static final Block BIRCH_BOOK_SHELVES = new BirchBookShelves();
    public static final Block ACACIA_BOOK_SHELVES = new AcaciaBookShelves();
    public static final Block DARK_OAK_BOOK_SHELVES = new DarkOakBookShelves();
    public static final Block OAK_CRATE = new OakCrate();
    public static final Block COAL_CRATE = new CoalCrate();
    public static final Block IRON_CRATE = new IronCrate();
    public static final Block GOLD_CRATE = new GoldCrate();
    public static final Block DIAMOND_CRATE = new DiamondCrate();
    public static final Block EMERALD_CRATE = new EmeraldCrate();
    public static final Block LAPISLAZULI_CRATE = new LapislazuliCrate();
    public static final Block APPLE_CRATE = new AppleCrate();
    public static final Block COOKIE_CRATE = new CookieCrate();
    public static final Block POTATO_CRATE = new PotatoCrate();
    public static final Block FISH_CRATE = new FishCrate();
    public static final Block SALMON_CRATE = new SalmonCrate();
    public static final Block CARROT_CRATE = new CarrotCrate();
    public static final Block STONE_WALL = new StoneWall();
    public static final Block BRICK_WALL = new BrickWall();
    public static final Block STONEBRICK_WALL = new StoneBrickWall();
    public static final Block SANDSTONE_WALL = new SandstoneWall();
    public static final Block RED_SANDSTONE_WALL = new RedSandstoneWall();
    public static final Block WOOL_WALL = new WoolWall();
    public static final Block LEAVE_WALL = new LeaveWall();

    public static Block[] all = new Block[]{
            BAR,
            SPRUCE_BAR,
            JUNGLE_BAR,
            ACACIA_BAR,
            BIRCH_BAR,
            DARK_OAK_BAR,
            OAK_PARQUET,
            SPRUCE_PARQUET,
            BIRCH_PARQUET,
            JUNGLE_PARQUET,
            ACACIA_PARQUET,
            DARK_OAK_PARQUET,
            SPRUCE_BOOK_SHELVES,
            JUNGLE_BOOK_SHELVES,
            BIRCH_BOOK_SHELVES,
            ACACIA_BOOK_SHELVES,
            DARK_OAK_BOOK_SHELVES,
            OAK_CRATE,
            COAL_CRATE,
            IRON_CRATE,
            GOLD_CRATE,
            DIAMOND_CRATE,
            EMERALD_CRATE,
            LAPISLAZULI_CRATE,
            APPLE_CRATE,
            COOKIE_CRATE,
            POTATO_CRATE,
            FISH_CRATE,
            SALMON_CRATE,
            CARROT_CRATE,
            STONE_WALL,
            BRICK_WALL,
            STONEBRICK_WALL,
            SANDSTONE_WALL,
            RED_SANDSTONE_WALL,
            WOOL_WALL,
            LEAVE_WALL
    };
}
