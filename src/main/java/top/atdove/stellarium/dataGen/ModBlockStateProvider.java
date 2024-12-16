package top.atdove.stellarium.dataGen;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.atdove.stellarium.block.ModBlocks;

import static top.atdove.stellarium.Stellarium.MODID;
import static top.atdove.stellarium.Stellarium.getRL;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        ModBlocks.customBlocks.forEach(extendedBlock -> {
            switch (extendedBlock.getBasicBlockState()){
                case CUBE_ALL -> this.simpleBlockWithItem(extendedBlock.get(), cubeAll(extendedBlock.get()));
                case CUBE_COLUMN -> this.simpleBlockWithItem(
                        extendedBlock.get(),
                        models().cubeColumn(extendedBlock.getId(),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()+"_side"),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()+"_end")
                        ));
                case CUBE_TOP -> this.simpleBlockWithItem(
                        extendedBlock.get(),
                        models().cubeBottomTop(extendedBlock.getId(),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()+"_top")
                        ));

                case CUBE_BOTTOM_TOP -> this.simpleBlockWithItem(
                        extendedBlock.get(),
                        models().cubeBottomTop(extendedBlock.getId(),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()+"_side"),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()+"_bottom"),
                                getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()+"_top")
                        ));

                case STAIRS -> {
                    this.stairsBlock((StairBlock) extendedBlock.get(), getRL(ModelProvider.BLOCK_FOLDER+"/"+ BuiltInRegistries.BLOCK.getKey(((StairBlock) extendedBlock.get()).base).getPath()));
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
                            (SlabBlock) extendedBlock.get(),
                            getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()),
                            getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()),
                            getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId()),
                            getRL(ModelProvider.BLOCK_FOLDER+"/"+extendedBlock.getId())
                    );
                }

                case PRESSURE_PLATE -> {
                    this.pressurePlateBlock((PressurePlateBlock) extendedBlock.get(), getRL(ModelProvider.BLOCK_FOLDER + "/" + extendedBlock.getId()));
                }



            }
        });

    }
}
