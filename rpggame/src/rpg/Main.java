package rpg;
//importing java package Scanner to allow user inputs

import java.util.Scanner;
//importing java random package to generate random numbers for battling

import java.util.Random;
public class Main {
    public static void main(String[] args) {

        //Introduction screen with instructions to add your name

System.out.println("Welcome to Dolphin Fables. What is your name? press enter when complete.");
//creating new character objects with certain characteristics to allow more preferences

        Character hero = new Character();
        Character wizard = new Character();
        Character guard = new Character();
        Character healer = new Character();

//creation of a new enemy goblin using the same stat types as the character

        Character goblin1 = new Character();
        goblin1.addAttack(2);
        goblin1.addDefense(2);
        goblin1.addHp(12);
        goblin1.addMagic(0);


//Scanner to get input from user and add it to character object using a method

        Scanner username = new Scanner(System.in);
        String nameinput = username.nextLine();

        //adding the name to the main character object

        hero.addName(nameinput);
       Scanner style = new Scanner(System.in);
       System.out.println("What style do you belong to?\nType in the number which corresponds to you:\n1. Hero style\n2. Wizard style\n3. Guard style\n4.Healer style");
       int styleinput = style.nextInt();
//switch case to determine which style your character belongs to
// as well as output their new stats
        switch (styleinput) {
            case 1 -> {
                System.out.println("Congratulations! You have selected the Hero style!");
                hero.addHp(7);
                hero.addAttack(7);
                hero.addDefense(7);
                hero.addMagic(5);
                System.out.println("Name: " + nameinput);
                hero.printstats();
            }
            case 2 -> {
                System.out.println("Congratulations! You have selected the Wizard style!");
                wizard.addHp(8);
                wizard.addAttack(5);
                wizard.addDefense(6);
                wizard.addMagic(10);
                System.out.println("Name: " + nameinput);
                wizard.printstats();
            }
            case 3 -> {
                System.out.println("Congratulations! You have selected the Guard style!");
                guard.addHp(9);
                guard.addAttack(4);
                guard.addDefense(10);
                guard.addMagic(5);
                System.out.println("Name: " + nameinput);
                guard.printstats();
            }
            case 4 -> {
                System.out.println("Congratulations! You have selected the Healer style!");
                healer.addHp(12);
                healer.addAttack(5);
                healer.addDefense(8);
                healer.addMagic(7);
                System.out.println("Name: " + nameinput);
                healer.printstats();
            }

        }
        System.out.println("Oh crap! You ran into a goblin.\nYou must battle him to prove your value.");
System.out.println("Enter 1 and press return to attack!");
       int answer = goblin1.hp;
       int heroHP = hero.hp;

        Scanner option = new Scanner(System.in);
        int choice = option.nextInt();
        if (choice == 1){
            System.out.println("You attacked the goblin!, he attacked back!reed");
        }
        Battle battle1 = new Battle();
        battle1.battle(answer, heroHP);



       }

       }









