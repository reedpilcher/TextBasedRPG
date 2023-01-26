package rpg;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class Battle {
    private int herohealth;
    private int enemyhealth;
    private int sword;
    private int value;

    public boolean battle(int answer, int heroHP) {
      //  Random secondNum = new Random();
    Random num = new Random(23);

for (int i = 0; (i < 4); i++) {
   value = num.nextInt(60);
}
    sword = value;
    if (sword <= 55 ) 
        return true;
        else{
            return false;
        }
    }
    

     
     
        }

