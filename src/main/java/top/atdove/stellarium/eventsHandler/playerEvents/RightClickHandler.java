package top.atdove.stellarium.eventsHandler.playerEvents;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TippedArrowItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import static top.atdove.stellarium.Stellarium.MODID;

@Mod(MODID)
public class RightClickHandler {

    @SubscribeEvent
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        if(!player.level().isClientSide){
            ItemStack itemStack = event.getItemStack();

            if(itemStack.getItem() instanceof TippedArrowItem && player.getHealth() > 2){
                RightClickHandler.useTippedArrow(player, itemStack);
            }
        }
    }



    public static void useTippedArrow(Player player, ItemStack itemStack){
        player.getCooldowns().addCooldown(itemStack.getItem(), 200);

        Timer timer=new Timer();//实例化Timer类
        timer.schedule(new TimerTask(){
            public void run(){
                player.hurt(new DamageSource(
                                player.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC),
                                player,
                                player
                        ), 2
                );
                Objects.requireNonNull(itemStack.get(DataComponents.POTION_CONTENTS)).forEachEffect(player::addEffect);
                itemStack.setCount(itemStack.getCount() - 1);
                this.cancel();
            }},200);
    }
}
