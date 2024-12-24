package top.atdove.stellarium.dataGen;


import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
        //this.
        //simple block

        simpleBottomTopBlock(ModBlocks.SCORCHED_SANDSTONE);
        //column block

        simpleLogBlock(ModBlocks.CARBONIZED_LOG);
        //log

        simpleWoodBlock(ModBlocks.CARBONIZED_WOOD, ModBlocks.CARBONIZED_LOG);
        //wood
        simpleButtonBlock(ModBlocks.CARBONIZED_BUTTON, ModBlocks.CARBONIZED_PLANKS);
        //button

        simpleFenceBlock(ModBlocks.CARBONIZED_FENCE, ModBlocks.CARBONIZED_PLANKS);
        //fence

        simpleFenceGateBlock(ModBlocks.CARBONIZED_FENCE_GATE, ModBlocks.CARBONIZED_PLANKS);
        //fence gate

        simpleSlabBlock(ModBlocks.CARBONIZED_SLAB, ModBlocks.CARBONIZED_PLANKS);
        //slabs

        simpleStairsBlock(ModBlocks.CARBONIZED_STAIRS, ModBlocks.CARBONIZED_PLANKS);
        //stairs

        simplePressurePlateBlock(ModBlocks.CARBONIZED_PRESSURE_PLATE, ModBlocks.CARBONIZED_PLANKS);
        //pressure plate
    }

    private void simplePressurePlateBlock(DeferredBlock<Block> deferredBlock){
        simplePressurePlateBlock(deferredBlock, deferredBlock);
    }

    private void simplePressurePlateBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.pressurePlateBlock((PressurePlateBlock) deferredBlock.get(), getBlockTextureRL(texture));
    }

    private void simpleBlockWithTop(DeferredBlock<Block> deferredBlock){
        this.horizontalBlock(deferredBlock.get(), models().cubeTop(getRL(deferredBlock).getPath(), getBlockTextureRL(deferredBlock, "top"), getBlockTextureRL(deferredBlock)));
    }

    private void simpleBottomTopBlock(DeferredBlock<Block> deferredBlock){
        this.simpleBlock(deferredBlock.get(), models().cubeBottomTop(getRL(deferredBlock).getPath(), getBlockTextureRL(deferredBlock, "side"), getBlockTextureRL(deferredBlock, "bottom"), getBlockTextureRL(deferredBlock, "top")));
    }

    private void simpleLogBlock(DeferredBlock<Block> deferredBlock){
        this.axisBlock((RotatedPillarBlock) deferredBlock.get(), getBlockTextureRL(deferredBlock, "side"), getBlockTextureRL(deferredBlock, "end"));
    }

    private void simpleWoodBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> logBlock){
        this.simpleBlock(deferredBlock.get(), models().cubeAll(deferredBlock.getId().getPath(), getBlockTextureRL(logBlock, "side")));
    }

    private void simpleStairsBlock(DeferredBlock<Block> deferredBlock){
        simpleStairsBlock(deferredBlock, deferredBlock);
    }

    private void simpleStairsBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.stairsBlock((StairBlock) deferredBlock.get(), getBlockTextureRL(texture));
    }
    private void simpleSlabBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> doubleSlabTexture){
        simpleSlabBlock(deferredBlock, doubleSlabTexture, doubleSlabTexture);
    }
    private void simpleSlabBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture, DeferredBlock<Block> doubleSlabTexture){
        this.slabBlock((SlabBlock) deferredBlock.get(), getBlockTextureRL(texture), getBlockTextureRL(doubleSlabTexture));
    }


    /*
    private void simpleSlabBlock(Block block, String doubleSlabId){
        this.slabBlock((SlabBlock) block, getRL(block), );
    }*/

    private void simpleButtonBlock(DeferredBlock<Block> deferredBlock){
        simpleButtonBlock(deferredBlock, deferredBlock);
    }

    private void simpleButtonBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.buttonBlock((ButtonBlock) deferredBlock.get(), getBlockTextureRL(texture));
    }

    private void simpleFenceBlock(DeferredBlock<Block> deferredBlock){
        simpleFenceBlock(deferredBlock, deferredBlock);
    }

    private void simpleFenceBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.fenceBlock((FenceBlock) deferredBlock.get(), getBlockTextureRL(texture));
    }

    private void simpleFenceGateBlock(DeferredBlock<Block> deferredBlock){
        simpleFenceGateBlock(deferredBlock, deferredBlock);
    }

    private void simpleFenceGateBlock(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        this.fenceGateBlock((FenceGateBlock) deferredBlock.get(), getBlockTextureRL(texture));
    }

    public static ResourceLocation getBlockTextureRL(DeferredBlock<Block> block){
        return getRL("block/" + block.getId().getPath());
    }

    public static ResourceLocation getBlockTextureRL(DeferredBlock<Block> block, String tag){
        return getRL("block/" + block.getId().getPath() + "_" + tag);
    }

}
