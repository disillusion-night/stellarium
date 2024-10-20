package top.atdove.stellarium.effect;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.Stellarium;
import top.atdove.stellarium.effect.debuff.Frozen;
import top.atdove.stellarium.effect.debuff.Soulburnt;

import java.util.function.Supplier;


public class ModEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, Stellarium.MODID);

    public static final Supplier<MobEffect> SOUL_BURNT = register(Soulburnt.effectName, ()->new Soulburnt(MobEffectCategory.HARMFUL, 11451419));

    public static final Supplier<MobEffect> FROZEN = register(Frozen.effectName, ()-> new Frozen(MobEffectCategory.HARMFUL, 11451419));

    public static <T extends MobEffect> DeferredHolder<MobEffect, T> register(String name, Supplier<T> effect){
        return MOD_EFFECTS.register(name, effect);
    }
    public static void register(IEventBus eventBus){
        MOD_EFFECTS.register(eventBus);
    }

}
