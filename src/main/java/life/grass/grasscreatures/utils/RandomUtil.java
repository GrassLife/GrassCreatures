package life.grass.grasscreatures.utils;

import java.util.Random;

/**
 * Created by ecila on 2017/06/18.
 */
public class RandomUtil {
    public static int generateRand(int min, int max) {
        Random rand = new Random();
        return min == max ? min : rand.nextInt(max - min) + min;
    }
}
