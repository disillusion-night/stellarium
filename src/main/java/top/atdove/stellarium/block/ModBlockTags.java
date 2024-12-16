package top.atdove.stellarium.block;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static top.atdove.stellarium.Stellarium.getRL;

public class ModBlockTags {
    public static final TagKey<Block> CARBONIZED_WOOD = BlockTags.create(getRL("carbonized_wood"));
}
