package rpg;

//importing java package Scanner to allow user inputs
import rpg.Battle;

import java.util.Scanner;
//importing java random package to generate random numbers for battling

import java.lang.reflect.Array;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Introduction screen with instructions to add your name

        System.out.println("Welcome to Dolphin Fables. What is your name? press enter when complete.");
        // creating new character objects with certain characteristics to allow more
        // preferences

        Character hero = new Character();

        // creation of a new enemy goblin using the same stat types as the character
        Character boredom = new Character();
        boredom.addAttack(1);
        boredom.addDefense(5);
        boredom.addHp(40);
        boredom.addMagic(0);

        Character jimmy = new Character();
        jimmy.addAttack(4);
        jimmy.addDefense(5);
        jimmy.addHp(22);
        jimmy.addMagic(0);

        Character goblin1 = new Character();
        goblin1.addAttack(2);
        goblin1.addDefense(2);
        goblin1.addHp(12);
        goblin1.addMagic(0);

        // Scanner to get input from user and add it to character object using a method

        Scanner username = new Scanner(System.in);
        String nameinput = username.nextLine();

        // adding the name to the main character object

        hero.addName(nameinput);
        Scanner style = new Scanner(System.in);
        System.out.println(
                "What style do you belong to?\nType in the number which corresponds to you:\n1. Swordsman style\n2. Wizard style\n3. Guard style\n4. Healer style");
        int styleinput = style.nextInt();
        // switch case to determine which style your character belongs to
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
        int originalHP = (hero.hp);
        // placeholder lines to seperate text more clearly
        System.out.println("------------------------------------------------");

        promptEnterKey();
        System.out.println("Oh crap! You ran into a goblin.\nYou must battle him to prove your value.");
        System.out.println("Your HP:" + hero.hp);
        System.out.println("Enemy HP:" + goblin1.hp);
        int answer = goblin1.hp;
        int heroHP = hero.hp;
        while (hero.hp > 0 && goblin1.hp > 0) {

            System.out.println("------------------------------------------------");

            System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");

            System.out.println("------------------------------------------------");

            Scanner option = new Scanner(System.in);
            int choice = option.nextInt();
            Battle battle1 = new Battle();
            // Battle battle2 = new Battle();

            switch (choice) {
                case 1: {
                    System.out.println("You attacked the goblin!, he attacked back!");

                    if (battle1.battleGoblin()) {
                        goblin1.takeDamage((goblin1.hp) - hero.attack);
                        hero.takeDamage(hero.hp - (goblin1.attack));
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);

                        System.out.println("------------------------------------------------");
                        // else if (battle1.battle(answer, heroHP) == false)
                    } else if (battle1.battleGoblin() == false) {
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);

                        System.out.println("------------------------------------------------");

                    }
                    break;
                }
                case 2: {
                    System.out.println("You guarded the attack!, his attack was blocked!");
                    // if ((battle1.battle(goblin1.hp, hero.hp)))
                    if ((battle1.battleGoblin())) {
                        hero.takeDamage((hero.hp));
                        goblin1.takeDamage(goblin1.hp);
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);
                        // else if ((battle1.battle(answer, heroHP)) == false)
                    } else if ((battle1.battleGoblin()) == false) {

                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);
                    }
                }
                    break;

                case 3: {
                    System.out.println("You attacked the goblin using magic!, he attacked back!");
                    // if ((battle1.battle(goblin1.hp, hero.hp)))
                    if (battle1.battleGoblin()) {
                        hero.takeDamage((hero.hp - goblin1.attack));
                        goblin1.takeDamage(goblin1.hp - hero.magic);
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);
                        // else if ((battle1.battle(answer, heroHP)) == false)
                    } else if ((battle1.battleGoblin()) == false) {
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);
                    }
                    break;
                }
            }
        }
        // Notifying you that the battle is over
        if (hero.hp > 0 && goblin1.hp <= 0) {
            System.out.println("You have slain the goblin.");
            System.out.println("Your hp was replinished, and increased slightly.");
            hero.addHp(originalHP + 3);
        }
        // Transition from introduction to Chapter 1
        System.out.println("You hear a faint noise in the background.\nIt sounds so familiar and annoying.\n");
        System.out.println("You open your eyes.\nThe sun is blinding you.\nYou realize it was all a dream.");
        System.out.println("Chapter 1: Middle School");
        promptEnterKey();
        System.out.println("You hear your alarm ringing.\nYou're about to miss the bus.\nWhat are you going to do?");

        System.out.println("------------------------------------------------");

        System.out.println(
                "Select your Option:\n1.Throw alarm clock across the room\n2.Turn alarm off and get ready for school");
        System.out.println("~");
        System.out.println("------------------------------------------------");
        System.out.println("~");
        Scanner alarm = new Scanner(System.in);
        int alarmclock = Integer.parseInt(alarm.nextLine());
        // switch case to dictate a certain path of throwing alarm clock or getting up
        // and going to school, as well as the consequences of either
        switch (alarmclock) {
            case 1:
                System.out.println("You threw your alarm clock across the room.");
                System.out.println("It shatters into a million pieces.\nYou hear loud footsteps approaching.");
                System.out.println(nameinput);
                promptEnterKey();
                System.out.println("WHAT THE HELL ARE YOU DOING?!?");
                promptEnterKey();
                System.out
                        .println("GET YOUR ASS UP AND GO TO SCHOOL\nWHEN YOU GET HOME, YOU'RE GROUNDED, " + nameinput);
                System.out.println("You ran to the bus and barely made it");
                promptEnterKey();
                System.out.println("*7 Hours go by, and you walk off the bus after school*");
                promptEnterKey();
                System.out.println(
                        "You waddle to your room, bored as hell.\nYou know you're gonna be stuck here all day.");
                break;

            case 2:
                System.out.println("You got up and got ready for school");
                promptEnterKey();
                System.out.println("You ran to the bus and barely made it");
                promptEnterKey();
                System.out.println("*7 Hours go by, and you walk off the bus after school*");
                promptEnterKey();
                System.out.println("You get home and decide you want to walk to the park and hang out.");
                promptEnterKey();
                System.out.println("As you are halfway there, the neighborhood bully Jimmy approaches you.");
                promptEnterKey();

        }
        Battle battle3 = new Battle();
        // battle dictated on decision 1 - Battle with Boredom
        // or 2 - Battle with Jimmy
        if (alarmclock == 1) {
            while (hero.hp > 0 && boredom.hp > 0) {

                System.out.println("------------------------------------------------");

                System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");

                System.out.println("------------------------------------------------");

                Scanner option = new Scanner(System.in);
                int choice = option.nextInt();
                // Battle battle1 = new Battle();
                // Battle battle2 = new Battle();
                // Battle battle3 = new Battle();

                switch (choice) {
                    case 1: {
                        System.out.println("You read a book,\nyour boredom worsens!");

                        if (battle3.battleBoredom()) {
                            boredom.takeDamage(boredom.hp - hero.attack);
                            hero.takeDamage(hero.hp - boredom.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);

                            System.out.println("------------------------------------------------");

                        } else if (battle3.battleBoredom() == false) {
                            System.out.println("You tried to turn the tv on, but it's unplugged!");
                            hero.takeDamage(hero.hp - boredom.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);

                            System.out.println("------------------------------------------------");

                        }
                        break;
                    }
                    case 2: {
                        System.out.println("You quietly listened to music!,\nboredom is tempoarily halted!");

                        if ((battle3.battleBoredom())) {

                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);

                        } else if ((battle3.battleBoredom()) == false) {
                            hero.takeDamage((hero.hp - boredom.attack));
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);
                        }
                    }
                        break;

                    case 3: {
                        System.out.println("You drew a picture!,\nbut you're still a little bored!");

                        if (battle3.battleBoredom()) {
                            hero.takeDamage((hero.hp - boredom.attack));
                            boredom.takeDamage(boredom.hp - hero.magic);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);

                        } else if ((battle3.battleBoredom()) == false) {
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);
                        }
                        break;
                    }
                }
            }
        }

        if (alarmclock == 2) {
            while (hero.hp > 0 && jimmy.hp > 0) {

                System.out.println("------------------------------------------------");
                System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                System.out.println("------------------------------------------------");

                Scanner option = new Scanner(System.in);
                int choice = option.nextInt();
                Battle battle1 = new Battle();
                Battle battle2 = new Battle();

                switch (choice) {
                    case 1: {
                        System.out.println("You used your paddleball on Jimmy's face!,\nhe swung his baseball bat!");

                        if (battle2.battleJimmy()) {
                            jimmy.takeDamage(jimmy.hp - hero.attack);
                            hero.takeDamage(hero.hp + (hero.defense / 2) - jimmy.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);

                        } else if (battle2.battleJimmy() == false) {
                            System.out.println("Your attack missed, Jimmy's still hit!");
                            hero.takeDamage(hero.hp - jimmy.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);

                        }
                        break;
                    }
                    case 2: {
                        System.out.println("You guarded his swing!,\nhis attack was blocked!");

                        if ((battle2.battleJimmy())) {
                            // hero.takeDamage((hero.hp));
                            // jimmy.takeDamage(jimmy.hp);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                            // else if ((battle1.battle(answer, heroHP)) == false)
                        } else if ((battle1.battleJimmy()) == false) {
                            hero.takeDamage((hero.hp - jimmy.attack));
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                        }
                    }
                        break;

                    case 3: {
                        System.out.println("You attacked Jimmy using magic!,\nhe attacked back!");

                        if (battle2.battleJimmy()) {
                            hero.takeDamage((hero.hp - jimmy.attack));
                            jimmy.takeDamage(jimmy.hp - hero.magic);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                            // else if ((battle1.battle(answer, heroHP)) == false)
                        } else if ((battle1.battleJimmy()) == false) {
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                        }
                        break;
                    }
                }
            }
        }
        if (hero.hp <= 0 && jimmy.hp <= 0 && alarmclock == 2) {
            System.out.println("You are tired but shake hands.\nYou go your separate ways.");
            System.out.println("After a long day of fighting, you go home, eat dinner, then go to bed.");

        } else if (hero.hp <= 0 && alarmclock == 2) {
            System.out.println("Jimmy beat your ass. All the neighborhood kids are laughing.");
            System.out.println("Defeated, you go back home in embarrasment.");
            promptEnterKey();
            System.out.println(
                    "After a short day of getting your ass handed to you\nyou go home, eat dinner, then go to bed.");
            promptEnterKey();
        } else if (jimmy.hp <= 0 && alarmclock == 2) {
            System.out.println("You kicked Jimmy's ass. He runs off to cry in his room.");
            System.out.println(
                    "The neighborhood kids suddenly appear and clap for you.\nYou enjoy your day at the park.");
            System.out.println("You leveled up.");
            promptEnterKey();
            // Still need to create level system, maybe a linked list
            promptEnterKey();
            System.out.println("After a long day of fun, you go home, eat dinner, then go to bed.");

        }
        if (hero.hp <= 0 && boredom.hp <= 0 && alarmclock == 1) {
            System.out.println("You defeated boredom, but at what cost?");
            System.out.println("You lay there in silence until you fall asleep.");
        } else if (hero.hp <= 0 && alarmclock == 1) {
            System.out.println("Boredom defeated you. You lay in agony.");
            System.out.println("Defeated, you try to take a nap.");
            promptEnterKey();
            System.out.println("You can't sleep.\nYou eat dinner, then you can fall asleep for the night.");
            promptEnterKey();
        } else if (boredom.hp <= 0 && alarmclock == 1) {
            System.out.println("You don't feel bored anymore. You feel content in your solitude.");
            System.out.println("You finish reading, gaining new wisdom along the way.");
            promptEnterKey();
            System.out.println("You leveled up.");
            promptEnterKey();
            System.out.println("You eat dinner, go to your room, and go to sleep for the night.");
            promptEnterKey();

        }

        System.out.println("You wake up. You feel completely different.");
        System.out.println("Chapter 2: College");
    }

    // method to simplify promting user to press enter
    private static void promptEnterKey() {
        System.out.println("Press ENTER to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
