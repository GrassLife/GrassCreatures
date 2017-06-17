package life.grass.grasscreatures.treasure;

/**
 * Created by ecila on 2017/06/18.
 */
public class LootTableElement {
    private String itemName;
    private int ratio;

    public String getItemName() {
        return itemName;
    }

    public int getRatio() {
        return ratio;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }
}
