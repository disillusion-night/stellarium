package top.atdove.stellarium.eventsHandler;


import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
//import top.atdove.stellarium.effect.CustomBuff;
import top.atdove.stellarium.effect.CustomEffect;

import java.util.Objects;

import static top.atdove.stellarium.Stellarium.MODID;

@Mod(MODID)
public class effectsHandler {
    public effectsHandler(IEventBus modBus) {
        NeoForge.EVENT_BUS.addListener(effectsHandler::onEffectsEnd);
    }

    private static void onEffectsEnd(MobEffectEvent.Remove event) {
        LivingEntity entity = event.getEntity();
        Holder<MobEffect> effect = event.getEffect();
        int amplifier = Objects.requireNonNull(event.getEffectInstance()).getAmplifier();

        if (!entity.level().isClientSide()) {
            if(effect.value() instanceof CustomEffect){
                ((CustomEffect)effect.value()).onEffectEnd(entity, amplifier);
            }
        }
    }
}