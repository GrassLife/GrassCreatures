package life.grass.grasscreatures.treasure;

import java.util.HashMap;

/**
 * Created by ecila on 2017/06/18.
 */
public class TreasureHolder {
    private HashMap<String, DropTable> dropTables;
    private HashMap<String, LootTable> lootTables;

    public DropTable getDropTable(String key) {
        return dropTables.containsKey(key) ? dropTables.get(key) : null;
    }

    public LootTable getLootList(String key) {
        return lootTables.containsKey(key) ? lootTables.get(key) : null;
    }

    public void putDropTable(DropTable table) {
        dropTables.put(table.getTableName(), table);
    }

    public void putLootTable(LootTable table) {
        lootTables.put(table.getLootTableName(), table);
    }
}
