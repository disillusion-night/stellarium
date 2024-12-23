package top.atdove.stellarium.effect.debuff;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import top.atdove.stellarium.effect.ExtendedEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Soulburnt extends ExtendedEffect {
    public Soulburnt(MobEffectCategory category, int color) {
        super(category, color);
    }
    private static final ArrayList<Double> maxHealthReducePL = new ArrayList<>(Arrays.asList(-0.1, -0.25, -0.5, -0.8));
    private static final ArrayList<Integer> ticksByLevel = new ArrayList<>(Arrays.asList(80, 50, 20, 10));

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).addOrReplacePermanentModifier(generateModifier(entity, amplifier));
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount % getAmountInt(ticksByLevel, amplifier) == 0;
    }

    @Override
    public void onEffectRemoved(LivingEntity entity, int amp){
        Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).removeModifier(getRL());
    }
    private AttributeModifier generateModifier(LivingEntity entity, int amplifier){
        AttributeModifier modifier = Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).getModifier(getRL());
        double amount;
        if(modifier != null){
            amount = Math.max(modifier.amount() - 0.05, getAmountDouble(maxHealthReducePL, amplifier));
        }else {
            amount = -0.05;
        }
        return new AttributeModifier(getRL(), amount, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

}