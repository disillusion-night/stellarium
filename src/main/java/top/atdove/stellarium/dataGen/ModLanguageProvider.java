package top.atdove.stellarium.dataGen;

import top.atdove.stellarium.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.atdove.stellarium.effect.ExtendedEffect;
import top.atdove.stellarium.effect.ModEffects;
import top.atdove.stellarium.i18n.Language;

import static top.atdove.stellarium.Stellarium.MODID;
import static top.atdove.stellarium.Stellarium.log;

public class ModLanguageProvider extends LanguageProvider {
    Language locale;
    public ModLanguageProvider(PackOutput output, Language locale) {
        super(output, MODID, locale.getStringId());
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        init();
        ModBlocks.customBlocks.forEach(customBlock -> {
            this.add(customBlock.get(), customBlock.getLanguageManager().getTranslation(locale));
        });

        ModEffects.effects.forEach(extendedEffect -> {
            this.add(extendedEffect, extendedEffect.getLanguageManager().getTranslation(locale));
            //log(1);
        });
    }

    protected void init(){
        ModBlocks.SCORCHED_DIRT.addSimplfiedChinese("炎灼泥土").generateEngTranslationFromId();
        ModBlocks.SCORCHED_SANDSTONE.addSimplfiedChinese("炎灼砂岩").generateEngTranslationFromId();
        ModBlocks.SCORCHED_SAND.addSimplfiedChinese("炎灼沙").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_PLANKS.addSimplfiedChinese("碳化木板").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_WOOD.addSimplfiedChinese("碳化木").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_BUTTON.addSimplfiedChinese("碳化木按钮").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_SLAB.addSimplfiedChinese("碳化木台阶").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_STAIRS.addSimplfiedChinese("碳化木楼梯").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_FENCE.addSimplfiedChinese("碳化木栅栏").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_LOG.addSimplfiedChinese("碳化原木").generateEngTranslationFromId();
        ModBlocks.CARBONIZED_FENCE_GATE.addSimplfiedChinese("碳化木栅栏门").generateEngTranslationFromId();

        ModEffects.SOUL_BURNT.addSimplfiedChinese("焚魂熔炎").generateEngTranslationFromId();
        ModEffects.FROZEN.addSimplfiedChinese("冻伤").generateEngTranslationFromId();
    }

}