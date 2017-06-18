package life.grass.grasscreatures.listener;

import life.grass.grasscreatures.creature.LevelRange;
import life.grass.grasscreatures.creature.LeveledCreature;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by ecila on 2017/06/18.
 */
public class SpawnListener implements Listener {
    JavaPlugin plugin;

    public SpawnListener(PluginManager pm, JavaPlugin plugin) {
        pm.registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        LivingEntity entity = e.getEntity();
        entity = LeveledCreature.generate(e.getEntity(), LevelRange.NORMAL).getEntity();
    }
}
