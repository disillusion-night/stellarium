package top.atdove.stellarium.effect;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;

public class ExtendedEffect extends MobEffect{
    protected ExtendedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
    protected final ResourceLocation getRL(){
        return BuiltInRegistries.MOB_EFFECT.getKey(this);
    }
    public final String getId(){
        return this.getRL().getPath();
    }
    protected final double getAmountDouble(ArrayList<Double> arrayList, int amplifier){
        int index = Math.min(Math.min(amplifier, arrayList.size()) - 1, 0);
        return arrayList.get(index);
    }
    protected final int getAmountInt(ArrayList<Integer> arrayList, int amplifier){
        int index = Math.min(Math.min(amplifier, arrayList.size()) - 1, 0);
        return arrayList.get(index);
    }
    public void onEffectRemoved(LivingEntity entity, int amplifier){
    }
    public void onEffectExpired(LivingEntity entity, int amplifier){
    }
}