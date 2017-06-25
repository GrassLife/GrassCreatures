package life.grass.grasscreatures.utils;

import java.util.List;
import java.util.Random;

/**
 * Created by ecila on 2017/06/18.
 */
public class RandomUtil {
    public static int generateRand(int min, int max) {
        Random rand = new Random();
        return min == max ? min : rand.nextInt(max - min + 1) + min;
    }

    public static int getRandomIndexByWeight(List<Integer> weight) {
        int sum = weight.stream().mapToInt(x -> x).sum();
        int rand = generateRand(0, sum);
        int index = 0;
        for(int i = 0; i < weight.size(); i++) {
            if(weight.get(i) > rand) {
                index = i;
                break;
            }
            rand -= weight.get(i);
        }
        return index;
    }
}
