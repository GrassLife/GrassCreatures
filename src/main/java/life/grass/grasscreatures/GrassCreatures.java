package life.grass.grasscreatures;

import life.grass.grasscreatures.listener.SpawnListener;
import life.grass.grasscreatures.timer.MiniBossTimer;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GrassCreatures extends JavaPlugin {
    private final PluginManager pluginManager = this.getServer().getPluginManager();
    private static JavaPlugin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
//        this.getServer().getPluginManager().registerEvents(this, this);
        instance = this;
        SpawnListener spawnListener = new SpawnListener(pluginManager, this);
        this.getServer().getScheduler().runTaskTimer(this, new MiniBossTimer(), 0, 20);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}
