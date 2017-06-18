package life.grass.grasscreatures.treasure;

import life.grass.grasscreatures.utils.RandomUtil;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ecila on 2017/06/18.
 */
public class LootTable {
    private String lootTableName;
    private List<LootTableElement> list;
    private List<Integer> weightArray;

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

    public ItemStack getDropItem() {
        return null;
    }

    public String getDropItemName() {
        return list.get(RandomUtil.getRandomIndexByWeight(getLootWeightArray())).getItemName();
    }

    private List<Integer> getLootWeightArray() {
        if(weightArray != null) {
            return weightArray;
        } else {
            List<Integer> array = list.stream().map(e -> e.getRatio()).collect(Collectors.toList());
            weightArray = array;
            return array;
        }
    }
}
