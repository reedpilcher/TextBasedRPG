package rpg;

import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class Battle {

    private int sword;
    private int value;

    public boolean battleGoblin() {
        Random rand = new Random();
        int random_integer = rand.nextInt(60);
        return random_integer <= 55 ? true : false;
    }
    public boolean battleJimmy() {
        Random rand = new Random();
        int random_integer = rand.nextInt(80);
        return random_integer <= 65 ? true : false;
 
}

public boolean battleBoredom() {
    Random rand = new Random();
    int random_integer = rand.nextInt(90);
    return random_integer <= 65 ? true : false;

}

}
