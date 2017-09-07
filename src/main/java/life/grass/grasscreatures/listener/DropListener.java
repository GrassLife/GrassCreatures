package life.grass.grasscreatures.listener;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import life.grass.grasscombat.entity.Victim;
import life.grass.grasscreatures.treasure.DropTable;
import life.grass.grasscreatures.treasure.TreasureHolder;
import life.grass.grassitem.GrassJson;
import life.grass.grassitem.JsonHandler;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ecila on 2017/06/24.
 */
public class DropListener implements Listener {
    JavaPlugin plugin;
    Gson gson;

    public DropListener(PluginManager pm, JavaPlugin plugin) {
        pm.registerEvents(this, plugin);
        this.plugin = plugin;
        gson = new Gson();
    }

    @EventHandler
    public void onLivingEntityDeath(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        e.setDroppedExp(3);
        if(e.getEntity() instanceof Player) return;
        List<ItemStack> items = e.getDrops();
        items.clear();

        Victim victim = new Victim(entity);
        if(!victim.isDroppable()) return;
        String jsonString = entity.getScoreboardTags().stream().filter(s -> s.startsWith("{")).findFirst().orElse(null);
        String name = entity.getCustomName();
        int level = 1;

        if(jsonString != null) {
            JsonObject json = gson.fromJson(jsonString, JsonElement.class).getAsJsonObject();
            if(json.get("CustomName") != null) name = json.get("CustomName").getAsString();
            if(json.get("Level") != null) level = json.get("Level").getAsInt();
        }
        DropTable table = TreasureHolder.getDropTable(name);
        if(table != null) {
            items.addAll(table.getDropItems(level));
        }
    }
}
