package top.atdove.stellarium.dataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModBlockTagsProvider extends BlockTagsProvider {


    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        /*
        ModBlocks.customBlocks.forEach(extendedBlock -> {
            if(!extendedBlock.getBlockTagKeys().isEmpty()){
                extendedBlock.getBlockTagKeys().forEach(blockTagKey -> {
                    this.tag(blockTagKey).add(extendedBlock.get());
                });
            }
        });*/
    }
}
