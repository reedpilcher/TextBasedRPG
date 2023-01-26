package rpg;
//importing java package Scanner to allow user inputs
import rpg.Battle;

import java.util.Scanner;
//importing java random package to generate random numbers for battling

import java.lang.reflect.Array;

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
       System.out.println("What style do you belong to?\nType in the number which corresponds to you:\n1. Swordsman style\n2. Wizard style\n3. Guard style\n4.Healer style");
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
                hero.addHp(8);
                hero.addAttack(5);
                hero.addDefense(6);
                hero.addMagic(10);
                System.out.println("Name: " + nameinput);
                hero.printstats();
            }
            case 3 -> {
                System.out.println("Congratulations! You have selected the Guard style!");
                hero.addHp(9);
                hero.addAttack(4);
                hero.addDefense(10);
                hero.addMagic(5);
                System.out.println("Name: " + nameinput);
                hero.printstats();
            }
            case 4 -> {
                System.out.println("Congratulations! You have selected the Healer style!");
                hero.addHp(12);
                hero.addAttack(5);
                hero.addDefense(8);
                hero.addMagic(7);
                System.out.println("Name: " + nameinput);
                hero.printstats();
            }

        }
        System.out.println("Oh crap! You ran into a goblin.\nYou must battle him to prove your value.");

       int answer = goblin1.hp;
       int heroHP = hero.hp;
       
        
        Scanner option = new Scanner(System.in);
        int choice = option.nextInt();
        Battle battle1 = new Battle();
        System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
        
        for (int i = 0; (i < goblin1.hp) && (i < hero.hp  ) && (i == 0); i++){
        switch (choice){
        case 1:  {  System.out.println("You attacked the goblin!, he attacked back!");
        
        if ((battle1.battle(goblin1.hp, hero.hp)) ==true){
        hero.takeDamage((hero.hp - goblin1.attack));
        goblin1.takeDamage(goblin1.hp - hero.attack);
        System.out.println("Your HP:" + hero.hp);
            System.out.println("Enemy HP:" + goblin1.hp) ;}
        else if((battle1.battle(answer, heroHP)) ==false ){
                
            System.out.println("Your HP:" + hero.hp);
            System.out.println("Enemy HP:" + goblin1.hp);}
            i--;
        break;}
            case 2: {System.out.println("You guarded the attack!, his attack was blocked!");
            
                if ((battle1.battle(goblin1.hp, hero.hp)) ==true){
                    hero.takeDamage((hero.hp));
                    goblin1.takeDamage(goblin1.hp);
                    System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp) ;}
                    else if((battle1.battle(answer, heroHP)) ==false ){
                            
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);}}
                        break;
            
            case 3: {
                System.out.println("You attacked the goblin using magic!, he attacked back!");
                
                if ((battle1.battle(goblin1.hp, hero.hp)) ==true){
                    hero.takeDamage((hero.hp - goblin1.attack));
                    goblin1.takeDamage(goblin1.hp - hero.magic);
                    System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp) ;}
                    else if((battle1.battle(answer, heroHP)) ==false ){
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);}
                        i--;
                        break;
            }}
            

           

        
           

        

        }
            System.out.println("You have slain the goblin.");}
            
        
        
        
            
    
    }


       

       









