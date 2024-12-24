package top.atdove.stellarium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.block.ModBlocks;

import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModItemTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> MOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("mod_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup."+MODID+"."+"mod_blocks"))
            .icon(() -> ModBlocks.SCORCHED_SAND.toStack(1))
            .displayItems((params, output) -> {
                output.accept(ModBlocks.SCORCHED_SAND);
                output.accept(ModBlocks.SCORCHED_SANDSTONE);
                output.accept(ModBlocks.SCORCHED_DIRT);
                output.accept(ModBlocks.CARBONIZED_WOOD);
                output.accept(ModBlocks.CARBONIZED_LOG);
                output.accept(ModBlocks.CARBONIZED_PLANKS);
                output.accept(ModBlocks.CARBONIZED_SLAB);
                output.accept(ModBlocks.CARBONIZED_STAIRS);
                output.accept(ModBlocks.CARBONIZED_BUTTON);
                output.accept(ModBlocks.CARBONIZED_FENCE);
                output.accept(ModBlocks.CARBONIZED_FENCE_GATE);
                output.accept(ModBlocks.CARBONIZED_PRESSURE_PLATE);
            })
            .build()
    );
    public static final Supplier<CreativeModeTab> MOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("mod_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup."+MODID+"."+"mod_items"))
            .icon(() -> ModItems.FLAMEGOLD_INGOT.toStack(1))
            .displayItems((params, output) -> {
                output.accept(ModItems.FLAMEGOLD_INGOT);
                output.accept(ModItems.FIERY_CRYSTAL);
            })
            .build()
    );



    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
