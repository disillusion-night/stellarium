package top.atdove.stellarium.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import top.atdove.stellarium.Stellarium;
import top.atdove.stellarium.i18n.LanguageManager;

import java.util.ArrayList;

public class ExtendedEffect extends MobEffect {
    String effectName;
    LanguageManager languageManager;
    //protected static ArrayList<AttributeModifier> transientModifiers;
    protected ExtendedEffect(String name, MobEffectCategory category, int color) {
        super(category, color);
        this.effectName = name;
    }
    public LanguageManager getLanguageManager(){
        if(this.languageManager == null){
            this.languageManager = new LanguageManager();
        }
        return this.languageManager;
    }
    protected ResourceLocation getRL(){
        return Stellarium.getRL(this.effectName);
    }
    public ExtendedEffect addSimplfiedChinese(String chineseName){
        this.getLanguageManager().addSimplfiedChinese(chineseName);
        return this;
    }
    public ExtendedEffect generateEngTranslationFromId(){
        String[] words = this.effectName.split("_");
        StringBuilder text = new StringBuilder();
        for (String word : words) {
            text.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
        }
        this.getLanguageManager().addEnglish(text.substring(0, text.length() - 1));
        return this;
    }
    protected static double getAmountDouble(ArrayList<Double> arrayList, int amplifier){
        int index = Math.min(amplifier, arrayList.size());
        if(index > 0){
            index -= 1;
        }
        return arrayList.get(index);
    }
    protected static int getAmountInt(ArrayList<Integer> arrayList, int amplifier){
        int index = Math.min(amplifier, arrayList.size());
        if(index > 0){
            index -= 1;
        }
        return arrayList.get(index);
    }
    public void onEffectRemoved(LivingEntity entity, int amplifier){

    }

}