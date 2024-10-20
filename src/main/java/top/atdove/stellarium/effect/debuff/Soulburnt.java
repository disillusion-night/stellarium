package top.atdove.stellarium.effect.debuff;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import top.atdove.stellarium.effect.CustomEffect;

import java.util.*;

public class Soulburnt extends CustomEffect {
    public Soulburnt(MobEffectCategory category, int color) {
        super(category, color, effectName);
    }

    public static final String effectName = "soulburnt";

    private static final ArrayList<Double> maxHealthReducePL = new ArrayList<>(Arrays.asList(-0.1, -0.25, -0.5, -0.8));
    private static final ArrayList<Integer> ticksByLevel = new ArrayList<>(Arrays.asList(80, 50, 20, 10));

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).addOrReplacePermanentModifier(generateModifier(entity, amplifier));
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount % getIntAmount(ticksByLevel, amplifier) == 0;
    }

    @Override
    public void onEffectRemoved(LivingEntity entity, int amp){
        Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).removeModifier(getResourceLocation());
    }
    private static AttributeModifier generateModifier(LivingEntity entity, int amplifier){
        AttributeModifier modifier = Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).getModifier(getResourceLocation());
        double amount;
        if(modifier != null){
            amount = modifier.amount();
            amount = amount - 0.05;
            if(amount < getDoubleAmount(maxHealthReducePL, amplifier)){
                amount = getDoubleAmount(maxHealthReducePL, amplifier);
            }
        }else {
            amount = -0.05;
        }
        return new AttributeModifier(getResourceLocation(), amount, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

}