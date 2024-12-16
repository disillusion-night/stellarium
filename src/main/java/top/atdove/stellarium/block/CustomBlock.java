package top.atdove.stellarium.block;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import top.atdove.stellarium.dataGen.BasicBlockState;
import top.atdove.stellarium.i18n.Language;
import top.atdove.stellarium.i18n.LanguageManager;
import top.atdove.stellarium.item.ModItems;

import java.security.PublicKey;
import java.util.*;
import java.util.function.Supplier;

public class CustomBlock {
    String id;
    LanguageManager languageManager;
    DeferredBlock<? extends Block> deferredBlock;
    Supplier<BlockItem> blockItemSupplier;
    BasicBlockState basicBlockState;
    ArrayList<TagKey<Block>> blockTagKeys;

    public CustomBlock (String id, BasicBlockState basicBlockState, DeferredBlock<? extends Block> deferredBlock){
        this.id = id;
        this.deferredBlock = deferredBlock;
        this.basicBlockState = basicBlockState;
        this.blockItemSupplier = ModItems.createBlockItem(id, deferredBlock);
    }

    public DeferredBlock<? extends Block> getDeferredBlock() {
        return deferredBlock;
    }

    public String getId() {
        return id;
    }

    public Supplier<BlockItem> getBlockItemSupplier() {
        return blockItemSupplier;
    }
    public Block get(){
        return deferredBlock.get();
    }

    public BlockItem getBlockItem(){
        return blockItemSupplier.get();
    }

    public BasicBlockState getBasicBlockState() {
        return basicBlockState;
    }
    public CustomBlock addBlockTag(TagKey<Block> blockTagKey){
        if(this.blockTagKeys == null){
            this.blockTagKeys = new ArrayList<TagKey<Block>>();
        }
        this.blockTagKeys.add(blockTagKey);
        return this;
    }
    public ArrayList<TagKey<Block>> getBlockTagKeys(){
        if(this.blockTagKeys == null){
            return new ArrayList<TagKey<Block>>();
        }
        return this.blockTagKeys;
    }
    public LanguageManager getLanguageManager(){
        if(this.languageManager == null){
            this.languageManager = new LanguageManager();
        }
        return this.languageManager;
    }
    public CustomBlock addSimplfiedChinese(String chineseName){
        this.getLanguageManager().addSimplfiedChinese(chineseName);
        return this;
    }
    public CustomBlock generateEngTranslationFromId(){
        String name = this.id.replace("_", " ");
        String[] words = name.split(" ");
        String text = "";
        for (String word : words) {
            text += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
        }

        this.getLanguageManager().addEnglish(text.substring(0, text.length() - 1));
        return this;
    }
}
