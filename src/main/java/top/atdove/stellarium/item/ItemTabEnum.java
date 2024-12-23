package top.atdove.stellarium.item;

public enum ItemTabEnum {
    BLOCKS, BASIC_ITEMS;
    private ItemTabEnum(){

    }
    public String getStringId(){
        return this.toString().toLowerCase();
    }
}
