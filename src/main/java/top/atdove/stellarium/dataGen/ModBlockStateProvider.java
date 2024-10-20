package top.atdove.stellarium.dataGen;


import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.atdove.stellarium.block.ModBlocks;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.simpleCubeBlocks.forEach(customBlock -> this.simpleBlockWithItem(customBlock.get(), cubeAll(customBlock.get())));
    }
}
