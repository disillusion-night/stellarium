package top.atdove.stellarium.block;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import top.atdove.stellarium.dataGen.BasicBlockState;
import top.atdove.stellarium.i18n.Language;
import top.atdove.stellarium.i18n.LanguageManager;

import java.security.PublicKey;
import java.util.List;
import java.util.function.Supplier;

public class CustomBlock {
    String id;
    LanguageManager languageManager;

    DeferredBlock<? extends Block> deferredBlock;
    Supplier<BlockItem> blockItemSupplier;
    BasicBlockState basicBlockState;
    List<TagKey<Block>> blockTagKeys;
    public CustomBlock (String id, LanguageManager languageManager, BasicBlockState basicBlockState, DeferredBlock<? extends Block> deferredBlock, Supplier<BlockItem> blockItem){
        this.id = id;
        this.languageManager = languageManager;
        this.deferredBlock = deferredBlock;
        this.basicBlockState = basicBlockState;
        this.blockItemSupplier = blockItem;
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
    public LanguageManager getLanguageManager(){
        return languageManager;
    }
    protected void generateEnglishTextFromId(){
        String name = this.id.replace("_", " ");
        String[] words = name.split(" ");
        String text = "";
        for(String word : words){
            if(!word.isEmpty()){
                text = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ";
            }
        }
        getLanguageManager().addEnglish(text);
    }

    public BasicBlockState getBasicBlockState() {
        return basicBlockState;
    }
    public CustomBlock addBlockTag(TagKey<Block> blockTagKey){
        this.blockTagKeys.add(blockTagKey);
        return this;
    }
    public List<TagKey<Block>> getBlockTagKeys(){
        return this.blockTagKeys;
    }
    public String getTranslation(Language language){
        return this.languageManager.getTranslation(language);
    }
}
