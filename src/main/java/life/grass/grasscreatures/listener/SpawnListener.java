package life.grass.grasscreatures.listener;

import life.grass.grasscreatures.boss.MiniBoss;
import life.grass.grasscreatures.creature.LevelRange;
import life.grass.grasscreatures.creature.LeveledCreature;
import life.grass.grasscreatures.timer.MiniBossTimer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

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
//        if(entity.getType().equals(EntityType.IRON_GOLEM)) {
//            entity = LeveledCreature.generate(entity, LevelRange.MINI_BOSS, "ためしのボスだよ").getEntity();
//            entity.setGlowing(true);
//            MiniBoss boss = new MiniBoss(entity);
//            MiniBossTimer.add(boss);
//        } else {
            entity = LeveledCreature.generate(e.getEntity(), LevelRange.NORMAL).getEntity();
//        }
    }
}
