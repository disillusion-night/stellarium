package top.atdove.stellarium.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ExtendedItem{

    protected ItemTabEnum itemTabEnum;
    protected DeferredItem deferredItem;
    protected ExtendedItem(DeferredItem deferredItem) {
        this.deferredItem = deferredItem;
    }

    public DeferredItem getDeferredItem() {
        return this.deferredItem;
    }
    public Item getItem() {
        return this.deferredItem.asItem();
    }
    public ItemTabEnum getItemTabEnum() {
        return this.itemTabEnum;
    }

    public final ExtendedItem setItemTab(ItemTabEnum itemTabEnum){
        this.itemTabEnum = itemTabEnum;
        return this;
    }
    public final ResourceLocation getRL(){
        return this.deferredItem.getId();
    }
    public final String getId(){
        return this.getRL().getPath();
    }

}
