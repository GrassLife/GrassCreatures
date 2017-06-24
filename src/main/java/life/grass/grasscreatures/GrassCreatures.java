package life.grass.grasscreatures;

import life.grass.grasscreatures.listener.DropListener;
import life.grass.grasscreatures.listener.SpawnListener;
import life.grass.grasscreatures.loader.TreasureLoader;
import life.grass.grasscreatures.timer.MiniBossTimer;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class GrassCreatures extends JavaPlugin {
    private final PluginManager pluginManager = this.getServer().getPluginManager();
    private static JavaPlugin instance;


    @Override
    public void onEnable() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        File dropTablePath = new File(getDataFolder(), "./DropTables/");
        File lootTablePath = new File(getDataFolder(), "./LootTables/");
        instance = this;
        SpawnListener spawnListener = new SpawnListener(pluginManager, this);
        DropListener dropListener = new DropListener(pluginManager, this);
        this.getServer().getScheduler().runTaskTimer(this, new MiniBossTimer(), 0, 20);
        TreasureLoader.loadLoots(lootTablePath);
        TreasureLoader.loadDrops(dropTablePath);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin getInstance() {
        return instance;
    }
}
