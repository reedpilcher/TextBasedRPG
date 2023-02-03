package rpg;

import java.util.Random;

import java.util.Scanner;

public class Character {
    public String name;
    public int hp;
    public int attack;
    public int defense;
    public int magic;
    public int heroLevel;

    public void addName(String newvalue) {
        name = newvalue;
    }
    public void addLevel(int newvalue) {
        heroLevel = newvalue;
    }


    public void addHp(int newvalue) {
        hp = newvalue;
    }

    public void takeDamage(int newvalue) {
        hp = newvalue;
    }

    public void addAttack(int newvalue) {
        attack = newvalue;
    }

    public void addDefense(int newvalue) {
        defense = newvalue;
    }

    public void addMagic(int newvalue) {
        magic = newvalue;
    }

    public int battle(int answer) {
        Random num = new Random();

        int sword = num.nextInt(50);
        if (sword < 45)
            ;
        {
            int i = (answer - 7);
            System.out.println("Goblin's current hp:" + i);
            return i;
        }
    }

    public void printstats() {
        System.out.println("Level: " + heroLevel);
        System.out.println("HP: " + hp);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Magic: " + magic);

    }

    public void printhealth() {
        System.out.println("HP: " + hp);
        System.out.println("HP: " + hp);

    }

}
