package life.grass.grasscreatures.treasure;

import java.util.List;

/**
 * Created by ecila on 2017/06/18.
 */
public class LootList {
    private String lootListName;
    private List<LootListElement> list;

    public String getLootListName() {
        return lootListName;
    }

    public List<LootListElement> getList() {
        return list;
    }

    public void setLootListName(String lootListName) {
        this.lootListName = lootListName;
    }

    public void setList(List<LootListElement> list) {
        this.list = list;
    }
}
