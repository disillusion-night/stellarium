package top.atdove.stellarium.effect;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.Stellarium;
import top.atdove.stellarium.block.CustomBlock;
import top.atdove.stellarium.dataGen.BasicBlockState;
import top.atdove.stellarium.effect.debuff.Frozen;
import top.atdove.stellarium.effect.debuff.Soulburnt;

import java.util.ArrayList;
import java.util.function.Supplier;

import static top.atdove.stellarium.Stellarium.MODID;


public class ModEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MODID);
    public static final ArrayList<ExtendedEffect> effects = new ArrayList<>();

    public static final ExtendedEffect SOUL_BURNT = register(new Soulburnt("soul_burnt", MobEffectCategory.HARMFUL, 11451419));
    public static final ExtendedEffect FROZEN = register(new Frozen("frozen", MobEffectCategory.HARMFUL, 11451419));

    public static ExtendedEffect register(ExtendedEffect extendedEffect){
        effects.add(extendedEffect);
        MOD_EFFECTS.register(extendedEffect.effectName, () -> extendedEffect);
        return extendedEffect;
    }

    public static void initiaze(IEventBus eventBus){
        MOD_EFFECTS.register(eventBus);
    }

}
