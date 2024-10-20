package top.atdove.stellarium.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.Stellarium;
import top.atdove.stellarium.block.ModBlocks;

import java.util.ArrayList;
import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModItems {
    public static int items = 0;

    public static final ArrayList<Supplier<BlockItem>> blockItems = new ArrayList<>();
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build()));

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
