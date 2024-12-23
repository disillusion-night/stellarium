package top.atdove.stellarium.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final ArrayList<ExtendedItem> modItems = new ArrayList<>();
    //public static final ExtendedItem EXAMPLE_ITEM = registerExtendedItem("example_item", new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(1).saturationModifier(2f).build()));
    //public static final ExtendedItem TEST_CHUIZI = registerExtendedItem("chuizi", new Item.Properties().durability(114514));
    public static final ExtendedItem FLAMEGOLD_INGOT = registerExtendedItem("flamegold_ingot");
    public static final ExtendedItem FIERY_CRYSTAL = registerExtendedItem("fiery_crystal");

    public static ExtendedItem registerExtendedItem(String itemName, Item.Properties properties, ItemTabEnum itemTabEnum){
        ExtendedItem extendedItem = new ExtendedItem(ITEMS.registerSimpleItem(itemName, properties)).setItemTab(itemTabEnum);
        modItems.add(extendedItem);
        return extendedItem;
    }
    public static ExtendedItem registerExtendedItem(String itemName, Item.Properties properties){
        ExtendedItem extendedItem = new ExtendedItem(ITEMS.registerSimpleItem(itemName, properties)).setItemTab(ItemTabEnum.BASIC_ITEMS);
        modItems.add(extendedItem);
        return extendedItem;
    }

    public static ExtendedItem registerExtendedItem(String itemName){
        ExtendedItem extendedItem = new ExtendedItem(ITEMS.registerSimpleItem(itemName)).setItemTab(ItemTabEnum.BASIC_ITEMS);
        modItems.add(extendedItem);
        return extendedItem;
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
