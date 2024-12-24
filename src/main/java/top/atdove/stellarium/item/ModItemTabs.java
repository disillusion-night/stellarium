package top.atdove.stellarium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.block.ModBlocks;

import java.util.Objects;
import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModItemTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    /*public static final Supplier<CreativeModeTab> MOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register(ItemTabEnum.BLOCKS.getStringId(), () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup."+MODID+"."+ItemTabEnum.BLOCKS.getStringId()))
            .icon(() -> ModBlocks.SCORCHED_SAND.toStack(1))
            .displayItems((params, output) -> {

                ModBlocks.customBlocks.forEach((customBlock) -> {
                    output.accept(customBlock.asItem());
                });
            })
            .build()
    );*/
    public static final Supplier<CreativeModeTab> MOD_ITEMS_TAB = CREATIVE_MODE_TABS.register(ItemTabEnum.BASIC_ITEMS.getStringId(), () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup."+MODID+"."+ItemTabEnum.BASIC_ITEMS.getStringId()))
            .icon(() -> ModItems.FLAMEGOLD_INGOT.getDeferredItem().toStack())
            .displayItems((params, output) -> {
                ModItems.modItems.forEach(extendedItem -> {
                    if(Objects.equals(extendedItem.getItemTabEnum(), ItemTabEnum.BASIC_ITEMS)){
                        output.accept(extendedItem.getItem());
                    }
                });
            })
            .build()
    );



    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
