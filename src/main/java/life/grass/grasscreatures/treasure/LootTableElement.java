package life.grass.grasscreatures.treasure;

/**
 * Created by ecila on 2017/06/18.
 */
public class LootTableElement {
    private String itemName;
    private int ratio;
    private int maxCount;
    private int minCount;

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

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }
}
