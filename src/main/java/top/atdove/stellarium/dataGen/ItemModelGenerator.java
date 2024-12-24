package top.atdove.stellarium.dataGen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.neoforged.neoforge.client.model.generators.loaders.SeparateTransformsModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import top.atdove.stellarium.block.ModBlocks;
import top.atdove.stellarium.item.ModItems;

import static top.atdove.stellarium.Stellarium.*;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        toBlock(ModBlocks.CARBONIZED_BUTTON.get());
        toBlock(ModBlocks.CARBONIZED_PLANKS.get());
        toBlock(ModBlocks.CARBONIZED_WOOD.get());
        toBlock(ModBlocks.CARBONIZED_LOG.get());
        toBlock(ModBlocks.CARBONIZED_SLAB.get());
        toBlock(ModBlocks.CARBONIZED_PRESSURE_PLATE.get());
        toBlock(ModBlocks.CARBONIZED_FENCE_GATE.get());
        toBlock(ModBlocks.CARBONIZED_STAIRS.get());
        toBlock(ModBlocks.SCORCHED_DIRT.get());
        toBlock(ModBlocks.SCORCHED_SAND.get());
        toBlock(ModBlocks.SCORCHED_SANDSTONE.get());

        simpleButton(ModBlocks.CARBONIZED_BUTTON, ModBlocks.CARBONIZED_PLANKS);
        simpleFence(ModBlocks.CARBONIZED_FENCE, ModBlocks.CARBONIZED_PLANKS);

        //singleTex(ModItems.FIERY_CRYSTAL.getDeferredItem());
        singleTex(ModItems.FLAMEGOLD_INGOT);

    }

    private ItemModelBuilder fullBright(String name, ResourceLocation... layers) {
        return buildItem(name, "item/generated", 15, layers);
    }

    private ItemModelBuilder fullBrightTool(String name, ResourceLocation... layers) {
        return buildItem(name, "item/handheld", 15, layers);
    }

    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        return buildItem(name, "item/generated", 0, layers);
    }

    private ItemModelBuilder tool(String name, ResourceLocation... layers) {
        return buildItem(name, "item/handheld", 0, layers);
    }

    private ItemModelBuilder buildItem(String name, String parent, int emissivity, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, parent);
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        if (emissivity > 0) builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder forceField(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/generated");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(15, 15, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    private ItemModelBuilder singleTexFullBright(DeferredHolder<Item, ? extends Item> item) {
        return fullBright(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder singleTexFullBrightTool(DeferredHolder<Item, ? extends Item> item) {
        return fullBrightTool(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder singleTexTool(DeferredHolder<Item, ? extends Item> item) {
        return tool(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder singleTex(DeferredHolder<?, ?> item) {
        return generated(item.getId().getPath(), prefix("item/" + item.getId().getPath()));
    }

    private ItemModelBuilder bowItem(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/bow");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private void bowTex(DeferredHolder<Item, Item> item, ModelFile pull0, ModelFile pull1, ModelFile pull2) {
        bowItem(item.getId().getPath(), prefix("item/" + item.getId().getPath()))
                .override().predicate(ResourceLocation.withDefaultNamespace("pulling"), 1).model(pull0).end()
                .override().predicate(ResourceLocation.withDefaultNamespace("pulling"), 1).predicate(ResourceLocation.withDefaultNamespace("pull"), (float) 0.65).model(pull1).end()
                .override().predicate(ResourceLocation.withDefaultNamespace("pulling"), 1).predicate(ResourceLocation.withDefaultNamespace("pull"), (float) 0.9).model(pull2).end();
    }

    private ItemModelBuilder phaseTex(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "twilightforest:item/moon_dial_template");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    private void woodenButton(Block button, String variant) {
        getBuilder(BuiltInRegistries.BLOCK.getKey(button).getPath())
                .parent(getExistingFile(mcLoc("block/button_inventory")))
                .texture("texture", "block/wood/planks_" + variant + "_0");
    }

    private void simpleButton(DeferredBlock<Block> button) {
        simpleButton(button, button);
    }
    private void simpleButton(DeferredBlock<Block> button, DeferredBlock<Block> texture) {
        getBuilder(getRL(button).getPath())
                .parent(getExistingFile(mcLoc("block/button_inventory")))
                .texture("texture", ModBlockStateProvider.getBlockTextureRL(texture));
    }
    private void simpleFence(DeferredBlock<Block> fence) {
        simpleFence(fence, fence);
    }
    private void simpleFence(DeferredBlock<Block> fence, DeferredBlock<Block> texture) {
        getBuilder(getRL(fence).getPath())
                .parent(getExistingFile(mcLoc("block/fence_inventory")))
                .texture("texture", ModBlockStateProvider.getBlockTextureRL(texture));
    }
    private void toBlock(Block b) {
        toBlockModel(b, BuiltInRegistries.BLOCK.getKey(b).getPath());
    }

    private void woodBlock(Block b, String variant) {
        woodBlockModel(b, BuiltInRegistries.BLOCK.getKey(b).getPath(), variant);
    }

    private void toBlockModel(Block b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void woodBlockModel(Block b, String model, String variant) {
        toBlockModel(b, prefix("block/wood/" + variant + "/" + model));
    }

    private void toBlockModel(Block b, ResourceLocation model) {
        withExistingParent(BuiltInRegistries.BLOCK.getKey(b).getPath(), model);
    }

    private void toGiantModel(Block b, ResourceLocation model, ItemModelBuilder base, ItemModelBuilder gui) {
        toGiantModel(b, model, model, base, gui);
    }

    private void toGiantModel(Block b, ResourceLocation model, ResourceLocation top, ItemModelBuilder base, ItemModelBuilder gui) {
        String name = BuiltInRegistries.BLOCK.getKey(b).getPath();
        withExistingParent(name, model).customLoader(SeparateTransformsModelBuilder::begin)
                .base(withExistingParent(name + "_base", base.getLocation()).texture("all", model).texture("top", top))
                .perspective(ItemDisplayContext.GUI, withExistingParent(name + "_gui", gui.getLocation()).texture("all", model).texture("top", top)).end();
    }

    private void toGiantItemModel(DeferredHolder<Item, Item> item, ResourceLocation parent, ItemModelBuilder base, int x, int y) {
        String name = item.getId().getPath();

        ItemModelBuilder gui = getBuilder(name + "_gui").texture("all", parent)
                .element().from(0, 0, 0).to(16, 16, 0).face(Direction.SOUTH).texture("#all").uvs(x, y, x + 8, y + 8).tintindex(0).end().end();

        withExistingParent(name, parent).customLoader(SeparateTransformsModelBuilder::begin)
                .base(withExistingParent(name + "_base", base.getLocation()).texture("layer0", parent))
                .perspective(ItemDisplayContext.GUI, gui.texture("all", parent)).end();
    }

    private ItemModelBuilder trimmedArmor(DeferredItem<ArmorItem> armor) {
        ItemModelBuilder base = this.singleTex(armor);
        for (ItemModelGenerators.TrimModelData trim : ItemModelGenerators.GENERATED_TRIM_MODELS) {
            String material = trim.name();
            String name = armor.getId().getPath() + "_" + material + "_trim";
            ModelFile trimModel = this.withExistingParent(name, this.mcLoc("item/generated"))
                    .texture("layer0", prefix("item/" + armor.getId().getPath()))
                    .texture("layer1", this.mcLoc("trims/items/" + armor.get().getEquipmentSlot(armor.toStack()).getName() + "_trim_" + material));
            base.override().predicate(ResourceLocation.withDefaultNamespace("trim_type"), trim.itemModelIndex()).model(trimModel).end();
        }
        return base;
    }

    private void trimmedFullbrightArmor(DeferredItem<ArmorItem> armor) {
        this.trimmedArmor(armor).customLoader(ItemLayerModelBuilder::begin).emissive(15, 15, 0).renderType("minecraft:translucent", 0).end();
    }

    private void trimmedLayeredArmor(DeferredItem<ArmorItem> armor) {
        ItemModelBuilder base = this.generated(armor.getId().getPath(), prefix("item/" + armor.getId().getPath()), prefix("item/" + armor.getId().getPath() + "_0"));
        for (ItemModelGenerators.TrimModelData trim : ItemModelGenerators.GENERATED_TRIM_MODELS) {
            String material = trim.name();
            String name = armor.getId().getPath() + "_" + material + "_trim";
            ModelFile trimModel = this.withExistingParent(name, this.mcLoc("item/generated"))
                    .texture("layer0", prefix("item/" + armor.getId().getPath()))
                    .texture("layer1", prefix("item/" + armor.getId().getPath() + "_0"))
                    .texture("layer2", this.mcLoc("trims/items/" + armor.get().getEquipmentSlot(armor.toStack()).getName() + "_trim_" + material));
            base.override().predicate(ResourceLocation.withDefaultNamespace("trim_type"), trim.itemModelIndex()).model(trimModel).end();
        }
    }

    private void lamp(DeferredHolder<Item, Item> item) {
        String name = item.getId().getPath();
        tool(name)
                .texture("layer0", prefix("item/" + name))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 0)
                .translation(0, -0.5F, -3.0F)
                .scale(0.65F)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, 0)
                .translation(0, -0.5F, -3.0F)
                .scale(0.65F)
                .end()
                .end();
    }

    private void moonwormQueen(DeferredHolder<Item, Item> item) {
        String name = item.getId().getPath();

        ModelFile alt = fullBrightTool(name + "_alt", prefix("item/" + name + "_alt"))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 55)
                .translation(0, 2.0F, -1.0F)
                .scale(0.85F)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -55)
                .translation(0, 2.0F, -1.0F)
                .scale(0.85F)
                .end()
                .end();

        singleTexFullBrightTool(item)
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0, -90, 55)
                .translation(0, 2.0F, -1.0F)
                .scale(0.85F)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0, 90, -55)
                .translation(0, 2.0F, -1.0F)
                .scale(0.85F)
                .end()
                .end()
                .override().predicate(prefix("alt"), 1).model(alt).end();
    }


}