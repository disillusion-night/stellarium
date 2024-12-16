package top.atdove.stellarium.effect;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.atdove.stellarium.effect.debuff.Frozen;
import top.atdove.stellarium.effect.debuff.Soulburnt;

import java.util.ArrayList;

import static top.atdove.stellarium.Stellarium.MODID;


public class ModEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MODID);
    public static final ArrayList<ExtendedEffect> effects = new ArrayList<>();

    public static final ExtendedEffect SOUL_BURNT = register("soul_burnt", new Soulburnt(MobEffectCategory.HARMFUL, 11451419));
    public static final ExtendedEffect FROZEN = register("frozen", new Frozen(MobEffectCategory.HARMFUL, 11451419));

    public static ExtendedEffect register(String effectName,ExtendedEffect extendedEffect){
        effects.add(extendedEffect);
        MOD_EFFECTS.register(effectName, () -> extendedEffect);
        return extendedEffect;
    }

    public static void initialize(IEventBus eventBus){
        MOD_EFFECTS.register(eventBus);
    }

}
