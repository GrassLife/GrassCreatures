package life.grass.grasscreatures.boss;

import life.grass.grasscreatures.GrassCreatures;
import life.grass.grasscreatures.creature.LeveledCreature;
import org.bukkit.Server;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 * Created by ecila on 2017/06/18.
 */
public class MiniBoss {
    private BossBar bar;
    private LivingEntity entity;
    private LeveledCreature leveledCreature;
    private boolean finished = false;

    public MiniBoss(LivingEntity entity) {
        this.entity = entity;
        this.leveledCreature = new LeveledCreature(entity);
        this.bar = GrassCreatures.getInstance().getServer().createBossBar(leveledCreature.getDisplayName(), BarColor.YELLOW, BarStyle.SEGMENTED_10);
        bar.setProgress(1.0);
    }

    public void update() {
        bar.removeAll();
        for(Entity e: entity.getNearbyEntities(50, 50, 50)) {
            if(e instanceof Player) {
                bar.addPlayer((Player) e);
            }
        }
        if(entity.isDead()) {
            bar.setProgress(0);
            bar.removeAll();
            finished = true;
        } else {
            bar.setProgress(entity.getHealth() / entity.getMaxHealth());
        }
    }

    public boolean isFinished() {
        return finished;
    }
}
