package life.grass.grasscreatures.creature;

import life.grass.grasscreatures.utils.RandomUtil;

/**
 * Created by ecila on 2017/06/18.
 */
public enum LevelRange {
    NORMAL(1, 5),
    MINI_BOSS(20, 20);

    private int min;
    private int max;

    LevelRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getRandomLevel() {
        return RandomUtil.generateRand(this.min, this.max);
    }
}
