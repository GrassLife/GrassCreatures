package life.grass.grasscreatures;

import life.grass.grasscreatures.listener.SpawnListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class GrassCreatures extends JavaPlugin {
    private final PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable() {
        // Plugin startup logic
//        this.getServer().getPluginManager().registerEvents(this, this);
        SpawnListener spawnListener = new SpawnListener(pluginManager, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
