package top.atdove.stellarium.effect.debuff;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import org.jetbrains.annotations.NotNull;
import top.atdove.stellarium.Stellarium;
import top.atdove.stellarium.effect.ExtendedEffect;

import java.util.*;

public class Frozen extends ExtendedEffect {
    public Frozen(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final ArrayList<Double> maxHealthReducePL = new ArrayList<>(Arrays.asList(-0.3, -0.4, -0.5, -0.8));
    private static final ArrayList<Double> speedReducePL = new ArrayList<>(Arrays.asList(-0.5, -0.75, -0.9, -1.0));

    private static final ArrayList<Double> jumpReducePL = new ArrayList<>(Arrays.asList(-0.2, -0.3, -0.5, -1.0));
    private static final ArrayList<Integer> ticksByLevel = new ArrayList<>(Arrays.asList(40, 20, 10, 5));

    @Override
    public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        processAbsorption(entity);
        return true;
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return (tickCount + 1) % getAmountInt(ticksByLevel, amplifier) == 0;
    }

    @Override
    public void onEffectAdded(@NotNull LivingEntity entity, int amplifier) {
        generateModifier(entity, amplifier);
    }

    @Override
    public void onEffectRemoved(LivingEntity entity, int amp){
        entity.setData(Stellarium.CAN_SPRINT, true);
        Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).removeModifier(getRL());
        Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(getRL());
        Objects.requireNonNull(entity.getAttribute(Attributes.JUMP_STRENGTH)).removeModifier(getRL());
    }

    private void generateModifier(LivingEntity entity, int amplifier){
        float max_health1 = (float) entity.getAttributeValue(Attributes.MAX_HEALTH);
        Objects.requireNonNull(entity.getAttribute(Attributes.MAX_HEALTH)).addPermanentModifier(new AttributeModifier(getRL(), getAmountDouble(maxHealthReducePL, amplifier), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        float max_health2 = (float) entity.getAttributeValue(Attributes.MAX_HEALTH);
        float absorption = entity.getAbsorptionAmount() + max_health1 - max_health2;
        Objects.requireNonNull(entity.getAttribute(Attributes.MAX_ABSORPTION)).setBaseValue(absorption);
        entity.setAbsorptionAmount(absorption);
        Objects.requireNonNull(entity.getAttribute(Attributes.MOVEMENT_SPEED)).addOrReplacePermanentModifier(new AttributeModifier(getRL(), getAmountDouble(speedReducePL, amplifier), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        Objects.requireNonNull(entity.getAttribute(Attributes.JUMP_STRENGTH)).addOrReplacePermanentModifier(new AttributeModifier(getRL(), getAmountDouble(jumpReducePL, amplifier), AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    }
    private void processAbsorption(LivingEntity entity){
        float absorption_amount = Math.max(entity.getAbsorptionAmount() - 1, 0);
        entity.setAbsorptionAmount(absorption_amount);

        if(absorption_amount == 0){
            if(entity.canSprint()){
                entity.setData(Stellarium.CAN_SPRINT, false);
            }
        }
    }
}