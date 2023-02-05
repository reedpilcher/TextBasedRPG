package rpg;

import java.util.Random;

public class Battle {
    public boolean battle(int bound, int threshold) {
        Random rand = new Random();
        int random_integer = rand.nextInt(bound);
        return random_integer <= threshold;
    }
}