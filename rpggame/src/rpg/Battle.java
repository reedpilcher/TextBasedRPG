package rpg;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class Battle {
    private int sword;
    private int value;

    public int battle(int answer, int heroHP) {
      //  Random secondNum = new Random();
    Random num = new Random(23);

for (int i = 0; (i < 4); i++) {
   value = num.nextInt(60);

}

    sword = value;
    if (sword < 55) {
        int a = (answer - 7);
        int b = heroHP - 2;
        out.println("Goblin's current hp:" + a);
        out.println("Your current hp:" + b);
        return a;

    }
        else {int c = answer;
            int d = (heroHP - 2);
            out.println("Your attack missed! Goblin's current hp:" + c);
        out.println("Your current hp:" + d);
        return c;}
        }}

