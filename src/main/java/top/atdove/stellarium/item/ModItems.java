package top.atdove.stellarium.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.block.ModBlocks;

import java.util.ArrayList;
import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    //public static final ExtendedItem EXAMPLE_ITEM = registerExtendedItem("example_item", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build()));
    //public static final ExtendedItem TEST_CHUIZI = registerExtendedItem("chuizi", new Item.Properties().durability(114514));

    public static final DeferredItem<Item> FLAMEGOLD_INGOT = ITEMS.registerSimpleItem("flamegold_ingot");
    public static final DeferredItem<Item> FIERY_CRYSTAL = ITEMS.registerSimpleItem("fiery_crystal");

    public static final Supplier<BlockItem> SCORCHED_SAND_ITEM = createBlockItem(ModBlocks.SCORCHED_SAND);
    public static final Supplier<BlockItem> SCORCHED_SANDSTONE_ITEM = createBlockItem(ModBlocks.SCORCHED_SANDSTONE);
    public static final Supplier<BlockItem> SCORCHED_DIRT_ITEM = createBlockItem(ModBlocks.SCORCHED_DIRT);
    public static final Supplier<BlockItem> CARBONIZED_WOOD_ITEM = createBlockItem(ModBlocks.CARBONIZED_WOOD);
    public static final Supplier<BlockItem> CARBONIZED_LOG_ITEM = createBlockItem(ModBlocks.CARBONIZED_LOG);
    public static final Supplier<BlockItem> CARBONIZED_PLANKS_ITEM = createBlockItem(ModBlocks.CARBONIZED_PLANKS);
    public static final Supplier<BlockItem> CARBONIZED_BUTTON_ITEM = createBlockItem(ModBlocks.CARBONIZED_BUTTON);
    public static final Supplier<BlockItem> CARBONIZED_SLAB_ITEM= createBlockItem(ModBlocks.CARBONIZED_SLAB);
    public static final Supplier<BlockItem> CARBONIZED_STAIRS_ITEM = createBlockItem(ModBlocks.CARBONIZED_STAIRS);
    public static final Supplier<BlockItem> CARBONIZED_FENCE_ITEM = createBlockItem(ModBlocks.CARBONIZED_FENCE);
    public static final Supplier<BlockItem> CARBONIZED_FENCE_GATE_ITEM = createBlockItem(ModBlocks.CARBONIZED_FENCE_GATE);
    public static final Supplier<BlockItem> CARBONIZED_PRESSURE_PLATE_ITEM = createBlockItem(ModBlocks.CARBONIZED_PRESSURE_PLATE);

    public static Supplier<BlockItem> createBlockItem(DeferredBlock<Block> deferredBlock){
        return ITEMS.registerSimpleBlockItem(deferredBlock.getId().getPath(), deferredBlock);
    }
    public static Supplier<BlockItem> createBlockItem(DeferredBlock<Block> deferredBlock, Item.Properties properties){
        return ITEMS.registerSimpleBlockItem(deferredBlock.getId().getPath(), deferredBlock, properties);
    }
    public static Supplier<BlockItem> createBlockItem(String name, Supplier<? extends Block> supplier, Item.Properties properties){
        return ITEMS.registerSimpleBlockItem(name, supplier, properties);
    }
    public static Supplier<BlockItem> createBlockItem(String name, Supplier<? extends Block> supplier){
        return ITEMS.registerSimpleBlockItem(name, supplier, new Item.Properties());
    }
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
