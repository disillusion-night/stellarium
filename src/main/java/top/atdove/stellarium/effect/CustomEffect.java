package top.atdove.stellarium.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.ArrayList;

import static top.atdove.stellarium.Stellarium.MODID;

public abstract class CustomEffect extends MobEffect {
    public static String effectName;
    protected static ArrayList<AttributeModifier> transientModifiers;
    public CustomEffect(MobEffectCategory category, int color, String name) {
        super(category, color);
        setEffectName(name);
    }
    private static void setEffectName(String name){
        effectName = name;
    }
    protected static ResourceLocation getResourceLocation(){
        return ResourceLocation.fromNamespaceAndPath(MODID, effectName);
    }
    public static String getId(){
        return MODID + ":" + effectName;
    }

    protected static double getDoubleAmount(ArrayList<Double> arrayList, int amplifier){
        int index = Math.min(amplifier, arrayList.size());
        if(index > 0){
            index -= 1;
        }
        return arrayList.get(index);
    }
    protected static int getIntAmount(ArrayList<Integer> arrayList, int amplifier){
        int index = Math.min(amplifier, arrayList.size());
        if(index > 0){
            index -= 1;
        }
        return arrayList.get(index);
    }
    public abstract void onEffectEnd(LivingEntity entity, int amplifier);

}
