package top.atdove.stellarium.block;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.atdove.stellarium.dataGen.BasicBlockState;
import top.atdove.stellarium.item.ModItems;

import java.util.*;
import java.util.function.Supplier;

public class ExtendedBlock {
    String id;
    DeferredBlock<? extends Block> deferredBlock;
    Supplier<BlockItem> blockItemSupplier;
    BasicBlockState basicBlockState;
    ArrayList<TagKey<Block>> blockTagKeys;

    public ExtendedBlock (String id, BasicBlockState basicBlockState, DeferredBlock<? extends Block> deferredBlock){
        this.id = id;
        this.deferredBlock = deferredBlock;
        this.basicBlockState = basicBlockState;
        this.blockItemSupplier = ModItems.createBlockItem(id, deferredBlock);
    }

    public DeferredBlock<? extends Block> getDeferredBlock() {
        return deferredBlock;
    }

    public String getId() {
        return id;
    }

    public Supplier<BlockItem> getBlockItemSupplier() {
        return blockItemSupplier;
    }
    public Block get(){
        return deferredBlock.get();
    }

    public BlockItem getBlockItem(){
        return blockItemSupplier.get();
    }

    public BasicBlockState getBasicBlockState() {
        return basicBlockState;
    }
    public ExtendedBlock addBlockTag(TagKey<Block> blockTagKey){
        if(this.blockTagKeys == null){
            this.blockTagKeys = new ArrayList<TagKey<Block>>();
        }
        this.blockTagKeys.add(blockTagKey);
        return this;
    }
    public ArrayList<TagKey<Block>> getBlockTagKeys(){
        if(this.blockTagKeys == null){
            return new ArrayList<TagKey<Block>>();
        }
        return this.blockTagKeys;
    }
}