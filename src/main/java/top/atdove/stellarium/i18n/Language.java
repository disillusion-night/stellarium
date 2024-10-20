package top.atdove.stellarium.i18n;

public enum Language {
    ZH_CN, EN_US;
    private Language(){

    }
    public String getStringId(){
        return this.toString().toLowerCase();
    }
}
