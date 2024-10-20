package top.atdove.stellarium.dataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.atdove.stellarium.i18n.Language;
import top.atdove.stellarium.provider.ModDatapackBuiltinEntriesProvider;

import java.util.concurrent.CompletableFuture;

import static top.atdove.stellarium.Stellarium.MODID;

// 用于注册数据生成器的类，该类通过EventBusSubscriber注解自动注册到MOD总线上
@EventBusSubscriber(modid = MODID,bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {
    // 订阅GatherDataEvent事件，当数据收集事件触发时执行该方法
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        // 为数据生成器添加一个自定义的数据包内置条目提供者
        generator.addProvider(event.includeServer(),new ModDatapackBuiltinEntriesProvider(output,lookupProvider));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(output, Language.EN_US));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(output, Language.ZH_CN));
    }
}