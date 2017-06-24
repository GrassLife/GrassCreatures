package life.grass.grasscreatures.treasure;

/**
 * Created by ecila on 2017/06/18.
 */
public class DropTableElement {
    private String lootListName;
    private double chance;
    private int minLevel;
    private int maxLevel;

    public String getLootListName() {
        return lootListName;
    }

    public double getChance() {
        return chance;
    }

    public void setLootListName(String lootListName) {
        this.lootListName = lootListName;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}
