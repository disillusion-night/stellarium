package top.atdove.stellarium.dataGen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.atdove.stellarium.block.ExtendedBlock;
import top.atdove.stellarium.block.ModBlocks;
import top.atdove.stellarium.effect.ExtendedEffect;
import top.atdove.stellarium.effect.ModEffects;
import top.atdove.stellarium.i18n.Language;
import top.atdove.stellarium.item.ExtendedItem;
import top.atdove.stellarium.item.ModItems;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModLanguageProvider extends LanguageProvider {
    Language locale;
    public ModLanguageProvider(PackOutput output, Language locale) {
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
        this.addEnglishFromID(ModBlocks.SCORCHED_DIRT);
        this.addEnglishFromID(ModBlocks.SCORCHED_SAND);
        this.addEnglishFromID(ModBlocks.SCORCHED_SANDSTONE);
        this.addEnglishFromID(ModBlocks.CARBONIZED_PLANKS);
        this.addEnglishFromID(ModBlocks.CARBONIZED_WOOD);
        this.addEnglishFromID(ModBlocks.CARBONIZED_BUTTON);
        this.addEnglishFromID(ModBlocks.CARBONIZED_SLAB);
        this.addEnglishFromID(ModBlocks.CARBONIZED_STAIRS);
        this.addEnglishFromID(ModBlocks.CARBONIZED_FENCE);
        this.addEnglishFromID(ModBlocks.CARBONIZED_LOG);
        this.addEnglishFromID(ModBlocks.CARBONIZED_FENCE_GATE);
        this.addEnglishFromID(ModBlocks.CARBONIZED_PRESSURE_PLATE);

        this.addEnglishFromID(ModEffects.SOUL_BURNT);
        this.addEnglishFromID(ModEffects.FROZEN);

        this.addEnglishFromID(ModItems.FLAMEGOLD_INGOT);
    }
    protected void initZHCN(){
        this.add(ModBlocks.SCORCHED_DIRT.get(), "灼化砂土");
        this.add(ModBlocks.SCORCHED_SAND.get(), "灼化沙");
        this.add(ModBlocks.SCORCHED_SANDSTONE.get(), "灼化砂岩");
        this.add(ModBlocks.CARBONIZED_PLANKS.get(), "碳化木板");
        this.add(ModBlocks.CARBONIZED_WOOD.get(), "碳化木");
        this.add(ModBlocks.CARBONIZED_BUTTON.get(), "碳化木按钮");
        this.add(ModBlocks.CARBONIZED_SLAB.get(), "碳化木台阶");
        this.add(ModBlocks.CARBONIZED_STAIRS.get(), "碳化木楼梯");
        this.add(ModBlocks.CARBONIZED_FENCE.get(), "碳化木栅栏");
        this.add(ModBlocks.CARBONIZED_LOG.get(), "碳化原木");
        this.add(ModBlocks.CARBONIZED_FENCE_GATE.get(), "碳化木栅栏门");
        this.add(ModBlocks.CARBONIZED_PRESSURE_PLATE.get(), "碳化木压力板");

        this.add(ModEffects.SOUL_BURNT, "焚魂熔炎");
        this.add(ModEffects.FROZEN, "冻伤");

        this.add(ModItems.FLAMEGOLD_INGOT.getItem(), "炽焰金锭");
    }


    protected void addEnglishFromID(ExtendedItem extendedItem){
        this.add(extendedItem.getItem(), generateEngTranslationFromId(extendedItem.getId()));
    }

    protected void addEnglishFromID(ExtendedBlock extendedBlock){
        this.add(extendedBlock.get(), generateEngTranslationFromId(extendedBlock.getId()));
    }

    protected void addEnglishFromID(ExtendedEffect extendedEffect){
        this.add(extendedEffect, generateEngTranslationFromId(extendedEffect.getId()));
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