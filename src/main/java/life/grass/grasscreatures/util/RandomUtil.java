package life.grass.grasscreatures.util;

import java.util.Random;

/**
 * Created by ecila on 2017/06/18.
 */
public class RandomUtil {
    public static int generateRand(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }
}
