package top.atdove.stellarium.dataGen;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.atdove.stellarium.block.ModBlocks;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        ModBlocks.customBlocks.forEach(customBlock -> {
            switch (customBlock.getBasicBlockState()){
                case CUBE_ALL -> this.simpleBlockWithItem(customBlock.get(), cubeAll(customBlock.get()));
                case CUBE_COLUMN -> this.simpleBlockWithItem(
                        customBlock.get(),
                        models().cubeColumn(customBlock.getId(),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()+"_side"),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()+"_end")
                        ));
                case CUBE_TOP -> this.simpleBlockWithItem(
                        customBlock.get(),
                        models().cubeBottomTop(customBlock.getId(),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()+"_top")
                        ));

                case CUBE_BOTTOM_TOP -> this.simpleBlockWithItem(
                        customBlock.get(),
                        models().cubeBottomTop(customBlock.getId(),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()+"_side"),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()+"_bottom"),
                                ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()+"_top")
                        ));

                case STAIRS -> {
                    this.stairsBlock((StairBlock) customBlock.get(), ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+ BuiltInRegistries.BLOCK.getKey(((StairBlock) customBlock.get()).base).getPath()));
                    //this.simpleBlockItem(customBlock.get(), itemModels().);
                }

                case SLAB -> {/*
                    this.simpleBlockWithItem(
                            customBlock.get(),
                            models().cubeColumn(customBlock.getId()+"_double",
                                    ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()+"_double"),
                                    ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId())
                            )
                    );*/
                    this.slabBlock(
                            (SlabBlock) customBlock.get(),
                            ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()),
                            ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()),
                            ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId()),
                            ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER+"/"+customBlock.getId())
                    );
                }

                case PRESSURE_PLATE -> {
                    this.pressurePlateBlock((PressurePlateBlock) customBlock.get(), ResourceLocation.fromNamespaceAndPath(MODID, ModelProvider.BLOCK_FOLDER + "/" + customBlock.getId()));
                }



            }
        });

    }
}
