package top.atdove.stellarium.i18n;

import java.util.HashMap;
import java.util.Map;

public class LanguageManager {
    Map<Language,String> translations;

    public LanguageManager (){
        this.translations = new HashMap<>();

    }

    public LanguageManager add(Language language, String text){
        this.translations.put(language, text);
        return this;
    }
    public LanguageManager addSimplfiedChinese(String text){
        this.translations.put(Language.ZH_CN, text);
        return this;
    }
    public LanguageManager addEnglish(String text) {
        this.translations.put(Language.EN_US, text);
        return this;
    }

    public String getTranslation(Language language) {
        return translations.get(language);
    }
}
