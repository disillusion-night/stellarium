package top.atdove.stellarium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.block.ModBlocks;

import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModItemTabs {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "stellarium" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final Supplier<CreativeModeTab> MOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("modblocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup."+MODID+".modblocks"))
            .icon(() -> new ItemStack(ModBlocks.SCORCHED_SAND.getBlockItemSupplier().get()))
            .displayItems((params, output) -> {
                ModBlocks.customBlocks.forEach((customBlock) -> {
                    output.accept(customBlock.getBlockItem());
                });
            })
            .build()
    );

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
