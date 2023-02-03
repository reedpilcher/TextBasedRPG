package rpg;

import java.util.Random;



public class Battle {



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

public boolean battleAlcoholism() {
    Random rand = new Random();
    int random_integer = rand.nextInt(115);
    return random_integer <= 70 ? true : false;

}
public boolean battlePaper() {
    Random rand = new Random();
    int random_integer = rand.nextInt(105);
    return random_integer <= 65 ? true : false;

}
public boolean battleUnemployment() {
    Random rand = new Random();
    int random_integer = rand.nextInt(120);
    return random_integer <= 75 ? true : false;

}
public boolean battleBoss() {
    Random rand = new Random();
    int random_integer = rand.nextInt(125);
    return random_integer <= 80 ? true : false;

}

}
