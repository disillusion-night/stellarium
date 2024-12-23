package top.atdove.stellarium.i18n;

public enum LanguageEnum {
    ZH_CN, EN_US;
    private LanguageEnum(){

    }
    public String getStringId(){
        return this.toString().toLowerCase();
    }
}
