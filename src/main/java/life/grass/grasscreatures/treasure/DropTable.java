package life.grass.grasscreatures.treasure;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ecila on 2017/06/18.
 */
public class DropTable {
    private String tableName;
    private String targetEntity;
    private List<DropTableElement> tables;

    public String getTableName() {
        return tableName;
    }

    public String getTargetEntity() {
        return targetEntity;
    }

    public List<DropTableElement> getTables() {
        return tables;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setTargetEntity(String targetEntity) {
        this.targetEntity = targetEntity;
    }

    public void setTables(List<DropTableElement> tables) {
        this.tables = tables;
    }

    public List<ItemStack> getDropItems(int level) {
        List<ItemStack> list = new ArrayList<>();
        for(DropTableElement elem: tables) {
            if(level >= elem.getMinLevel() && level <= elem.getMaxLevel() && Math.random() <= elem.getChance()) {
                list.add(TreasureHolder.getLootList(elem.getLoostListName()).getDropItem());
            }
        }
        return list;
    }

}
