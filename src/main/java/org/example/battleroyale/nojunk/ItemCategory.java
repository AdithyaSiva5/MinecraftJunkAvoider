package org.example.battleroyale.nojunk.managers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;


import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public enum ItemCategory {
    SEEDS_SAPLINGS_FLOWERS(Arrays.asList(
            // Seeds
            Material.WHEAT_SEEDS, Material.PUMPKIN_SEEDS, Material.MELON_SEEDS, Material.BEETROOT_SEEDS,
            Material.TORCHFLOWER_SEEDS, Material.PITCHER_POD,

            // Saplings
            Material.OAK_SAPLING, Material.SPRUCE_SAPLING, Material.BIRCH_SAPLING,
            Material.JUNGLE_SAPLING, Material.ACACIA_SAPLING, Material.DARK_OAK_SAPLING,
            Material.CHERRY_SAPLING, Material.MANGROVE_PROPAGULE,

            // Flowers
            Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM,
            Material.AZURE_BLUET, Material.RED_TULIP, Material.ORANGE_TULIP, Material.WHITE_TULIP,
            Material.PINK_TULIP, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY,
            Material.SUNFLOWER, Material.LILAC, Material.ROSE_BUSH, Material.PEONY,
            Material.TORCHFLOWER, Material.PITCHER_PLANT,

            // Mushrooms and Fungi
            Material.RED_MUSHROOM, Material.BROWN_MUSHROOM, Material.CRIMSON_FUNGUS,
            Material.WARPED_FUNGUS, Material.MUSHROOM_STEM, Material.RED_MUSHROOM_BLOCK,
            Material.BROWN_MUSHROOM_BLOCK,

            // Nether Vegetation
            Material.NETHER_SPROUTS, Material.WARPED_ROOTS, Material.CRIMSON_ROOTS,
            Material.WEEPING_VINES, Material.TWISTING_VINES, Material.VINE,

            // Other Plants
            Material.BAMBOO, Material.SUGAR_CANE, Material.CACTUS, Material.LILY_PAD,
            Material.SEA_PICKLE, Material.KELP, Material.SEAGRASS, Material.GRASS,
            Material.TALL_GRASS, Material.FERN, Material.LARGE_FERN, Material.DEAD_BUSH,
            Material.SWEET_BERRY_BUSH
    )),


    MOB_DROPS(Arrays.asList(
            Material.ROTTEN_FLESH, Material.BONE, Material.STRING,
            Material.SPIDER_EYE, Material.GUNPOWDER, Material.SLIME_BALL
    )),

    RAW_FOOD(Arrays.asList(
            Material.BEEF, Material.CHICKEN, Material.PORKCHOP,
            Material.MUTTON, Material.RABBIT, Material.COD
    )),

    RAW_ORES(Arrays.asList(
            Material.RAW_IRON, Material.RAW_GOLD, Material.RAW_COPPER,
            Material.IRON_ORE, Material.GOLD_ORE, Material.COPPER_ORE
    )),

    WOOD_ITEMS(Arrays.asList(
            // Stairs
            Material.OAK_STAIRS, Material.SPRUCE_STAIRS, Material.BIRCH_STAIRS,
            Material.JUNGLE_STAIRS, Material.ACACIA_STAIRS, Material.DARK_OAK_STAIRS,
            Material.CRIMSON_STAIRS, Material.WARPED_STAIRS, Material.MANGROVE_STAIRS,
            Material.CHERRY_STAIRS, Material.BAMBOO_STAIRS,

            // Slabs
            Material.OAK_SLAB, Material.SPRUCE_SLAB, Material.BIRCH_SLAB,
            Material.JUNGLE_SLAB, Material.ACACIA_SLAB, Material.DARK_OAK_SLAB,
            Material.CRIMSON_SLAB, Material.WARPED_SLAB, Material.MANGROVE_SLAB,
            Material.CHERRY_SLAB, Material.BAMBOO_SLAB,

            // Fences
            Material.OAK_FENCE, Material.SPRUCE_FENCE, Material.BIRCH_FENCE,
            Material.JUNGLE_FENCE, Material.ACACIA_FENCE, Material.DARK_OAK_FENCE,
            Material.CRIMSON_FENCE, Material.WARPED_FENCE, Material.MANGROVE_FENCE,
            Material.CHERRY_FENCE, Material.BAMBOO_FENCE,

            // Fence Gates
            Material.OAK_FENCE_GATE, Material.SPRUCE_FENCE_GATE, Material.BIRCH_FENCE_GATE,
            Material.JUNGLE_FENCE_GATE, Material.ACACIA_FENCE_GATE, Material.DARK_OAK_FENCE_GATE,
            Material.CRIMSON_FENCE_GATE, Material.WARPED_FENCE_GATE, Material.MANGROVE_FENCE_GATE,
            Material.CHERRY_FENCE_GATE, Material.BAMBOO_FENCE_GATE,

            // Trapdoors
            Material.OAK_TRAPDOOR, Material.SPRUCE_TRAPDOOR, Material.BIRCH_TRAPDOOR,
            Material.JUNGLE_TRAPDOOR, Material.ACACIA_TRAPDOOR, Material.DARK_OAK_TRAPDOOR,
            Material.CRIMSON_TRAPDOOR, Material.WARPED_TRAPDOOR, Material.MANGROVE_TRAPDOOR,
            Material.CHERRY_TRAPDOOR, Material.BAMBOO_TRAPDOOR,

            // Signs
            Material.OAK_SIGN, Material.SPRUCE_SIGN, Material.BIRCH_SIGN,
            Material.JUNGLE_SIGN, Material.ACACIA_SIGN, Material.DARK_OAK_SIGN,
            Material.CRIMSON_SIGN, Material.WARPED_SIGN, Material.MANGROVE_SIGN,
            Material.CHERRY_SIGN, Material.BAMBOO_SIGN,

            // Wall Signs
            Material.OAK_WALL_SIGN, Material.SPRUCE_WALL_SIGN, Material.BIRCH_WALL_SIGN,
            Material.JUNGLE_WALL_SIGN, Material.ACACIA_WALL_SIGN, Material.DARK_OAK_WALL_SIGN,
            Material.CRIMSON_WALL_SIGN, Material.WARPED_WALL_SIGN, Material.MANGROVE_WALL_SIGN,
            Material.CHERRY_WALL_SIGN, Material.BAMBOO_WALL_SIGN,

            // Pressure Plates
            Material.OAK_PRESSURE_PLATE, Material.SPRUCE_PRESSURE_PLATE, Material.BIRCH_PRESSURE_PLATE,
            Material.JUNGLE_PRESSURE_PLATE, Material.ACACIA_PRESSURE_PLATE, Material.DARK_OAK_PRESSURE_PLATE,
            Material.CRIMSON_PRESSURE_PLATE, Material.WARPED_PRESSURE_PLATE, Material.MANGROVE_PRESSURE_PLATE,
            Material.CHERRY_PRESSURE_PLATE, Material.BAMBOO_PRESSURE_PLATE,

            // Doors
            Material.OAK_DOOR, Material.SPRUCE_DOOR, Material.BIRCH_DOOR,
            Material.JUNGLE_DOOR, Material.ACACIA_DOOR, Material.DARK_OAK_DOOR,
            Material.CRIMSON_DOOR, Material.WARPED_DOOR, Material.MANGROVE_DOOR,
            Material.CHERRY_DOOR, Material.BAMBOO_DOOR,

            // Buttons
            Material.OAK_BUTTON, Material.SPRUCE_BUTTON, Material.BIRCH_BUTTON,
            Material.JUNGLE_BUTTON, Material.ACACIA_BUTTON, Material.DARK_OAK_BUTTON,
            Material.CRIMSON_BUTTON, Material.WARPED_BUTTON, Material.MANGROVE_BUTTON,
            Material.CHERRY_BUTTON, Material.BAMBOO_BUTTON
    )),


    STONES(Arrays.asList(
            // Basic Stone Types
            Material.STONE, Material.COBBLESTONE, Material.MOSSY_COBBLESTONE,
            Material.GRANITE, Material.DIORITE, Material.ANDESITE,
            Material.DEEPSLATE, Material.COBBLED_DEEPSLATE, Material.TUFF,
            Material.CALCITE, Material.DRIPSTONE_BLOCK,

            // Stairs
            Material.STONE_STAIRS, Material.COBBLESTONE_STAIRS, Material.MOSSY_COBBLESTONE_STAIRS,
            Material.GRANITE_STAIRS, Material.DIORITE_STAIRS, Material.ANDESITE_STAIRS,
            Material.COBBLED_DEEPSLATE_STAIRS,
            Material.STONE_BRICK_STAIRS, Material.MOSSY_STONE_BRICK_STAIRS,
            Material.BLACKSTONE_STAIRS, Material.POLISHED_BLACKSTONE_STAIRS,
            Material.POLISHED_BLACKSTONE_BRICK_STAIRS,

            // Slabs
            Material.STONE_SLAB, Material.COBBLESTONE_SLAB, Material.MOSSY_COBBLESTONE_SLAB,
            Material.GRANITE_SLAB, Material.DIORITE_SLAB, Material.ANDESITE_SLAB,
            Material.COBBLED_DEEPSLATE_SLAB,
            Material.STONE_BRICK_SLAB, Material.MOSSY_STONE_BRICK_SLAB,
            Material.BLACKSTONE_SLAB, Material.POLISHED_BLACKSTONE_SLAB,
            Material.POLISHED_BLACKSTONE_BRICK_SLAB,

            // Walls
            Material.COBBLESTONE_WALL, Material.MOSSY_COBBLESTONE_WALL,
            Material.GRANITE_WALL, Material.DIORITE_WALL, Material.ANDESITE_WALL,
            Material.COBBLED_DEEPSLATE_WALL,
            Material.STONE_BRICK_WALL, Material.MOSSY_STONE_BRICK_WALL,
            Material.BLACKSTONE_WALL, Material.POLISHED_BLACKSTONE_WALL,
            Material.POLISHED_BLACKSTONE_BRICK_WALL,

            // Polished Variants
            Material.POLISHED_GRANITE, Material.POLISHED_DIORITE, Material.POLISHED_ANDESITE,
            Material.POLISHED_DEEPSLATE, Material.POLISHED_BLACKSTONE,

            // Stone Bricks
            Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.CRACKED_STONE_BRICKS,
            Material.CHISELED_STONE_BRICKS, Material.DEEPSLATE_BRICKS, Material.CRACKED_DEEPSLATE_BRICKS,
            Material.DEEPSLATE_TILES, Material.CRACKED_DEEPSLATE_TILES,
            Material.POLISHED_BLACKSTONE_BRICKS, Material.CRACKED_POLISHED_BLACKSTONE_BRICKS,

            // Nether Stone Types
            Material.BLACKSTONE, Material.GILDED_BLACKSTONE, Material.CHISELED_POLISHED_BLACKSTONE,
            Material.BASALT, Material.SMOOTH_BASALT, Material.POLISHED_BASALT,

            // Pressure Plates
            Material.STONE_PRESSURE_PLATE, Material.POLISHED_BLACKSTONE_PRESSURE_PLATE,

            // Buttons
            Material.STONE_BUTTON, Material.POLISHED_BLACKSTONE_BUTTON
    )),

    NO_BLOCKS,
    NO_ITEMS;

    private final List<Material> materials;

    ItemCategory(List<Material> materials) {
        this.materials = materials;
    }

    ItemCategory() {
        this.materials = null;
    }

    public boolean contains(ItemStack item) {
        if (this == NO_BLOCKS) {
            return item.getType().isBlock();
        }
        if (this == NO_ITEMS) {
            return !item.getType().isBlock();
        }
        return materials != null && materials.contains(item.getType());
    }
}
