package life.grass.grasscreatures.treasure;

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
}
