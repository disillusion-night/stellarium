package top.atdove.stellarium.dataGen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import top.atdove.stellarium.block.ModBlocks;
import top.atdove.stellarium.effect.ExtendedEffect;
import top.atdove.stellarium.effect.ModEffects;
import top.atdove.stellarium.i18n.LanguageEnum;
import top.atdove.stellarium.item.ModItemTabs;
import top.atdove.stellarium.item.ModItems;

import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;
import static top.atdove.stellarium.Stellarium.getRL;

public class ModLanguageProvider extends LanguageProvider {
    LanguageEnum locale;
    public ModLanguageProvider(PackOutput output, LanguageEnum locale) {
        super(output, MODID, locale.getStringId());
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        switch (locale){
            case EN_US -> init();
            case ZH_CN -> initZHCN();
        }
    }

    protected void init(){
        addEnglishFromID(ModBlocks.SCORCHED_DIRT);
        addEnglishFromID(ModBlocks.SCORCHED_SAND);
        addEnglishFromID(ModBlocks.SCORCHED_SANDSTONE);
        addEnglishFromID(ModBlocks.CARBONIZED_PLANKS);
        addEnglishFromID(ModBlocks.CARBONIZED_WOOD);
        addEnglishFromID(ModBlocks.CARBONIZED_BUTTON);
        addEnglishFromID(ModBlocks.CARBONIZED_SLAB);
        addEnglishFromID(ModBlocks.CARBONIZED_STAIRS);
        addEnglishFromID(ModBlocks.CARBONIZED_FENCE);
        addEnglishFromID(ModBlocks.CARBONIZED_LOG);
        addEnglishFromID(ModBlocks.CARBONIZED_FENCE_GATE);
        addEnglishFromID(ModBlocks.CARBONIZED_PRESSURE_PLATE);

        addEnglishFromID(ModEffects.SOUL_BURNT);
        addEnglishFromID(ModEffects.FROZEN);

        addEnglishFromID(ModItems.FLAMEGOLD_INGOT);
        addEnglishFromID(ModItems.FIERY_CRYSTAL);


        add(ModItemTabs.MOD_BLOCKS_TAB, "Stellarium "+generateEngTranslationFromId(getRL(ModItemTabs.MOD_BLOCKS_TAB.get()).getPath()));
        add(ModItemTabs.MOD_ITEMS_TAB, "Stellarium "+generateEngTranslationFromId(getRL(ModItemTabs.MOD_ITEMS_TAB.get()).getPath()));
    }
    protected void initZHCN(){
        add(ModBlocks.SCORCHED_DIRT, "灼化砂土");
        add(ModBlocks.SCORCHED_SAND, "灼化沙");
        add(ModBlocks.SCORCHED_SANDSTONE, "灼化砂岩");
        add(ModBlocks.CARBONIZED_PLANKS, "碳化木板");
        add(ModBlocks.CARBONIZED_WOOD, "碳化木");
        add(ModBlocks.CARBONIZED_BUTTON, "碳化木按钮");
        add(ModBlocks.CARBONIZED_SLAB, "碳化木台阶");
        add(ModBlocks.CARBONIZED_STAIRS, "碳化木楼梯");
        add(ModBlocks.CARBONIZED_FENCE, "碳化木栅栏");
        add(ModBlocks.CARBONIZED_LOG, "碳化原木");
        add(ModBlocks.CARBONIZED_FENCE_GATE, "碳化木栅栏门");
        add(ModBlocks.CARBONIZED_PRESSURE_PLATE, "碳化木压力板");

        add(ModEffects.SOUL_BURNT, "焚魂熔炎");
        add(ModEffects.FROZEN, "冻伤");

        add(ModItems.FLAMEGOLD_INGOT, "炽焰金锭");
        add(ModItems.FIERY_CRYSTAL, "灼焱晶体");

        add(ModItemTabs.MOD_BLOCKS_TAB, "寰旅-方块");
        add(ModItemTabs.MOD_ITEMS_TAB, "寰旅-基础物品");
    }


    protected void addEnglishFromID(Item item){
        this.add(item, generateEngTranslationFromId(getRL(item).getPath()));
    }

    protected void addEnglishFromID(DeferredItem deferredItem){
        this.add(deferredItem.asItem(), generateEngTranslationFromId(deferredItem.getId().getPath()));
    }

    protected void addEnglishFromID(DeferredBlock<Block> deferredBlock){
        this.add(deferredBlock.get(), generateEngTranslationFromId(deferredBlock.getId().getPath()));
    }

    protected void addEnglishFromID(ExtendedEffect extendedEffect){
        this.add(extendedEffect, generateEngTranslationFromId(extendedEffect.getId()));
    }

    private void add(Supplier<CreativeModeTab> supplier, String value){
        this.add(getRL(supplier.get()).toLanguageKey("itemGroup"), value);
    }
    private void add(DeferredBlock<Block> deferredBlock, String value){
        this.add(deferredBlock.get(), value);
    }
    private void add(DeferredItem<Item> deferredItem, String value){
        this.add(deferredItem.get(), value);
    }


    public String generateEngTranslationFromId(String id){
        String[] words = id.split("_");
        StringBuilder text = new StringBuilder();
        for (String word : words) {
            text.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
        }
        return text.substring(0, text.length() - 1);
    }
}