package life.grass.grasscreatures.treasure;

import java.util.HashMap;

/**
 * Created by ecila on 2017/06/18.
 */
public class TreasureHolder {
    private static HashMap<String, DropTable> dropTables;
    private static HashMap<String, LootTable> lootTables;

    public static DropTable getDropTable(String key) {
        return dropTables.containsKey(key) ? dropTables.get(key) : null;
    }

    public static LootTable getLootList(String key) {
        return lootTables.containsKey(key) ? lootTables.get(key) : null;
    }

    public static void putDropTable(DropTable table) {
        dropTables.put(table.getTableName(), table);
    }

    public static void putLootTable(LootTable table) {
        lootTables.put(table.getLootTableName(), table);
    }
}
