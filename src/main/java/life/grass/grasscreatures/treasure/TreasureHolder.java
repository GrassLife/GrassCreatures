package life.grass.grasscreatures.treasure;

import java.util.HashMap;

/**
 * Created by ecila on 2017/06/18.
 */
public class TreasureHolder {
    private static HashMap<String, DropTable> dropTables;
    private static HashMap<String, LootTable> lootTables;

    static {
        dropTables = new HashMap<>();
        lootTables = new HashMap<>();
    }

    public static DropTable getDropTable(String key) {
        return dropTables.get(key);
    }

    public static LootTable getLootList(String key) {
        return lootTables.get(key);
    }

    public static void putDropTable(DropTable table) {
        System.out.println("DROP TABLE LOAD : " + table.getTableName());
        dropTables.put(table.getTableName(), table);
    }

    public static void putLootTable(LootTable table) {
        System.out.println("LOOT TABLE LOAD : " + table.getLootTableName());
        lootTables.put(table.getLootTableName(), table);
    }
}
