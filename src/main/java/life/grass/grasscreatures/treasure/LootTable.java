package life.grass.grasscreatures.treasure;

import java.util.List;

/**
 * Created by ecila on 2017/06/18.
 */
public class LootTable {
    private String lootTableName;
    private List<LootTableElement> list;

    public String getLootTableName() {
        return lootTableName;
    }

    public List<LootTableElement> getList() {
        return list;
    }

    public void setLootListName(String lootTableName) {
        this.lootTableName = lootTableName;
    }

    public void setList(List<LootTableElement> list) {
        this.list = list;
    }
}
