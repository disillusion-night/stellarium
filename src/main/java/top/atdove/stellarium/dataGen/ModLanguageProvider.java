package top.atdove.stellarium.dataGen;

import top.atdove.stellarium.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.atdove.stellarium.i18n.Language;

import java.util.Objects;

import static top.atdove.stellarium.Stellarium.MODID;

public class ModLanguageProvider extends LanguageProvider {
    Language locale;
    public ModLanguageProvider(PackOutput output, Language locale) {
        super(output, MODID, locale.getStringId());
        this.locale = locale;
    }

    @Override
    protected void addTranslations() {
        ModBlocks.customBlocks.forEach(customBlock -> {
            this.add(customBlock.get(), customBlock.getTranslation(locale));
        });
    }

}