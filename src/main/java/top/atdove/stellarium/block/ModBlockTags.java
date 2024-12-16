package top.atdove.stellarium.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModBlockTags {
    public static final TagKey<Block> CARBONIZED_WOOD = BlockTags.create(ResourceLocation.fromNamespaceAndPath(MODID, "carbonized_wood"));
}
