package top.atdove.stellarium.eventsHandler;


import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import top.atdove.stellarium.effect.ExtendedEffect;

import java.util.Objects;

import static top.atdove.stellarium.Stellarium.MODID;

@Mod(MODID)
public class EffectsEventHandler {
    public EffectsEventHandler(IEventBus modBus) {
        NeoForge.EVENT_BUS.addListener(EffectsEventHandler::onEffectsRemoved);
        NeoForge.EVENT_BUS.addListener(EffectsEventHandler::onEffectsExpired);
    }

    private static void onEffectsRemoved(MobEffectEvent.Remove event) {
        LivingEntity entity = event.getEntity();
        Holder<MobEffect> effect = event.getEffect();
        int amplifier = Objects.requireNonNull(event.getEffectInstance()).getAmplifier();
        //int time = event.getEffectInstance().getDuration();
        if (!entity.level().isClientSide()) {
            if(effect.value() instanceof ExtendedEffect){
                ((ExtendedEffect) effect.value()).onEffectRemoved(entity, amplifier);
            }
        }
    }


    private static void onEffectsExpired(MobEffectEvent.Expired event) {
        LivingEntity entity = event.getEntity();
        Holder<MobEffect> effect = Objects.requireNonNull(event.getEffectInstance()).getEffect();
        int amplifier = Objects.requireNonNull(event.getEffectInstance()).getAmplifier();

        if (!entity.level().isClientSide()) {
            if(effect.value() instanceof ExtendedEffect){
                ((ExtendedEffect) effect.value()).onEffectExpired(entity, amplifier);
            }
        }
    }
}