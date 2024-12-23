package top.atdove.stellarium.dataGen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import top.atdove.stellarium.block.ExtendedBlock;
import top.atdove.stellarium.block.ModBlocks;
import top.atdove.stellarium.item.ExtendedItem;
import top.atdove.stellarium.item.ModItems;

import static top.atdove.stellarium.Stellarium.MODID;
import static top.atdove.stellarium.Stellarium.prefix;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //toBlock(ModBlocks.CARBONIZED_BUTTON);
        //toBlock(ModBlocks.CARBONIZED_SLAB);
        //toBlock(ModBlocks.CARBONIZED_STAIRS);


        //singleTex(ModItems.FIERY_CRYSTAL.getDeferredItem());
        singleTex(ModItems.FLAMEGOLD_INGOT.getDeferredItem());

    }

    private ItemModelBuilder buildItem(String name, String parent, int emissivity, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, parent);
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        if (emissivity > 0) builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    private ItemModelBuilder bowItem(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/bow");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        return buildItem(name, "item/generated", 0, layers);
    }

    private ItemModelBuilder singleTex(DeferredHolder<?, ?> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder singleTex(ExtendedItem extendedItem) {
        return singleTex(extendedItem.getDeferredItem());
    }

    private void toBlock(ExtendedBlock extendedBlock) {
        toBlock(extendedBlock.get());
    }
    private void toBlock(Block b) {
        toBlockModel(b, BuiltInRegistries.BLOCK.getKey(b).getPath());
    }


    private void toBlockModel(Block b, ResourceLocation model) {
        withExistingParent(BuiltInRegistries.BLOCK.getKey(b).getPath(), model);
    }

    private void toBlockModel(Block b, String model) {
        withExistingParent(BuiltInRegistries.BLOCK.getKey(b).getPath(), model);
    }


}