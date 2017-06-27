package life.grass.grasscreatures.timer;

import life.grass.grasscreatures.boss.MiniBoss;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ecila on 2017/06/18.
 */
public class MiniBossTimer implements Runnable {
    private static List<MiniBoss> bossList;

    public MiniBossTimer() {
        bossList = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public void run() {
        synchronized (bossList) {
            Iterator<MiniBoss> iterator = bossList.iterator();
            while(iterator.hasNext()) {
                MiniBoss boss = iterator.next();
                boss.update();
                if(boss.isFinished()) {
                    iterator.remove();
                }
            }
        }
    }

    public static int count() {
        return bossList.size();
    }

    public static boolean add(MiniBoss boss) {
        if(bossList.size() >= 10) return false;
        return bossList.add(boss);
    }

    public static void remove(MiniBoss boss) {
        bossList.remove(boss);
    }
}
