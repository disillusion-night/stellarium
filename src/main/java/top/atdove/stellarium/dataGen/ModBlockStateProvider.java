package top.atdove.stellarium.dataGen;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.atdove.stellarium.block.ModBlocks;

import static top.atdove.stellarium.Stellarium.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {

        this.simpleBlock(ModBlocks.SCORCHED_SAND.get());
        this.simpleBlock(ModBlocks.SCORCHED_DIRT.get());
        this.simpleBlock(ModBlocks.CARBONIZED_PLANKS.get());
        //simple block

        simpleButtonBlock(ModBlocks.CARBONIZED_BUTTON, ModBlocks.CARBONIZED_PLANKS);
        //button

        simpleFenceBlock(ModBlocks.CARBONIZED_FENCE, ModBlocks.CARBONIZED_PLANKS);
        //fence

        simpleFenceGateBlock(ModBlocks.CARBONIZED_FENCE_GATE, ModBlocks.CARBONIZED_PLANKS);
        //fence gate

        //simpleSlabBlock(ModBlocks.CARBONIZED_SLAB, ModBlocks.CARBONIZED_PLANKS);
        //slabs

        simpleStairsBlock(ModBlocks.CARBONIZED_STAIRS, ModBlocks.CARBONIZED_PLANKS);
        //stairs

        //
    }
    private void simpleStairsBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.stairsBlock((StairBlock) deferredBlock.get(), getRL("block/" + texture.getId().getPath()));
    }
    private void simpleStairsBlock(DeferredBlock<Block> block){
        simpleStairsBlock(block, block);
    }
    /*
    private void simpleSlabBlock(Block block, Block doubleSlabTexture){
        simpleSlabBlock(block, getRL(doubleSlabTexture));
    }*/

    /*
    private void simpleSlabBlock(Block block, String doubleSlabId){
        this.slabBlock((SlabBlock) block, getRL(block), );
    }*/

    private void simpleButtonBlock(DeferredBlock<Block> deferredBlock){
        simpleButtonBlock(deferredBlock, deferredBlock);
    }

    private void simpleButtonBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.buttonBlock((ButtonBlock) deferredBlock.get(), getRL("block/" + texture.getId().getPath()));
    }

    private void simpleFenceBlock(DeferredBlock<Block> deferredBlock){
        simpleFenceBlock(deferredBlock, deferredBlock);
    }

    private void simpleFenceBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.fenceBlock((FenceBlock) deferredBlock.get(), getRL("block/" + texture.getId().getPath()));
    }

    private void simpleFenceGateBlock(DeferredBlock<Block> deferredBlock){
        simpleFenceGateBlock(deferredBlock, deferredBlock);
    }

    private void simpleFenceGateBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.fenceGateBlock((FenceGateBlock) deferredBlock.get(), getRL("block/" + texture.getId().getPath()));
    }


}
