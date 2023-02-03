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
//initializing the hero's level when you start
        hero.addLevel(5);

        // creation of a new enemy "alcoholism" using the same stat types as the character
        Character alcoholism = new Character();
        alcoholism.addAttack(5);
        alcoholism.addDefense(7);
        alcoholism.addHp(37);
        alcoholism.addMagic(12);
// creation of a new enemy "paper" using the same stat types as the character
        Character paper = new Character();
        paper.addAttack(5);
        paper.addDefense(6);
        paper.addHp(36);
        paper.addMagic(7);
// creation of a new enemy "boredom" using the same stat types as the character
        Character boredom = new Character();
        boredom.addAttack(1);
        boredom.addDefense(5);
        boredom.addHp(28);
        boredom.addMagic(0);
// creation of a new enemy "jimmy" using the same stat types as the character
        Character jimmy = new Character();
        jimmy.addAttack(4);
        jimmy.addDefense(5);
        jimmy.addHp(22);
        jimmy.addMagic(0);
// creation of a new enemy "goblin1" using the same stat types as the character
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
        //text asking which style you prefer
        System.out.println(
                "What style do you belong to?\nType in the number which corresponds to you:\n1. Swordsman style\n2. Wizard style\n3. Guard style\n4. Healer style");
        int styleinput = style.nextInt();
        // switch case to determine which style your character belongs to
        // as well as output their new stats

        switch (styleinput) {
            //Swordsman style with more balanced stats
            case 1 -> {
                System.out.println("Congratulations! You have selected the Swordsman style!");
                hero.addHp(7);
                hero.addAttack(7);
                hero.addDefense(7);
                hero.addMagic(5);
                System.out.println("Name: " + nameinput);
                hero.printstats();
            }
            //Wizard style with better magic stats
            case 2 -> {
                System.out.println("Congratulations! You have selected the Wizard style!");
                hero.addHp(8);
                hero.addAttack(5);
                hero.addDefense(6);
                hero.addMagic(10);
                System.out.println("Name: " + nameinput);
                hero.printstats();
            }
            //Guard style with better defensive stats
            case 3 -> {
                System.out.println("Congratulations! You have selected the Guard style!");
                hero.addHp(9);
                hero.addAttack(4);
                hero.addDefense(10);
                hero.addMagic(5);
                System.out.println("Name: " + nameinput);
                hero.printstats();
            }
            //Healer style with better HP and defense
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
//creating integer variables to more easily change them when leveled up
        int originalHP = (hero.hp);
        int originalAttack = (hero.attack);
        int originalDefense = (hero.defense);
        int originalMagic = (hero.magic);
        int originalLevel = (hero.heroLevel);

        // placeholder lines to seperate text more clearly
        System.out.println("------------------------------------------------");
//an instance of promptig the user to press "Enter"; This will be used frequently throughout
        promptEnterKey();
        //First battle instance
        System.out.println("Oh crap! You ran into a goblin.\nYou must battle him to prove your value.");
        System.out.println("BATTLE: GOBLIN VS " + nameinput);
        System.out.println("Your HP:" + hero.hp);
        System.out.println("Enemy HP:" + goblin1.hp);
       
// A while loop that makes sure the battle continutes until either the enemy or the player
// loses all their HP (Health Points). Loop will end when it meets one or both of these requirements.
        while (hero.hp > 0 && goblin1.hp > 0) {
//Option selection for battle
            System.out.println("------------------------------------------------");

            System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");

            System.out.println("------------------------------------------------");
//Scanner to dictate which option is selected based on user input (1, 2, or 3)
            Scanner option = new Scanner(System.in);
            int choice = option.nextInt();
            Battle battle1 = new Battle();
            
//switch case to determine which option got selected by user, and to carry out the specified option
            switch (choice) {
                //case 1 is to Attack; This remains consistent for every battle
                case 1: {
//Using a boolean method to determine whether the random number is within the range to hit or miss
// There is an element of randomness and not 100% accuracy everytime
                    if (battle1.battleGoblin() == true) 
                    //if the method returns true, attack hits. If it returns false, attack misses.
                    {
                        System.out.println("You attacked the goblin!, he attacked back!");
                        goblin1.takeDamage((goblin1.hp) - hero.attack);
                        hero.takeDamage(hero.hp - (goblin1.attack));
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);

                        System.out.println("------------------------------------------------");
                        // else if (battle1.battle(answer, heroHP) == false)
                    } else if (battle1.battleGoblin() == false) {
                        System.out.println("You attack missed, he hit you though!");
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);

                        System.out.println("------------------------------------------------");

                    }
                    break;
                }
                //case 2 is to guard attacks; This remains consistent for every battle.
                case 2: {

                    if ((battle1.battleGoblin() == true)) {
                        System.out.println("You guarded the attack!, his attack was blocked!");
                        hero.takeDamage((hero.hp));
                        goblin1.takeDamage(goblin1.hp);
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);
                        // else if ((battle1.battle(answer, heroHP)) == false)
                    } else if ((battle1.battleGoblin()) == false) {
                        System.out.println("Guard failed, he snuck in an attack!");
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);
                    }
                }
                    break;
//case 3 is to use magic; This remains consistent for every battle
                case 3: {

                    // if ((battle1.battle(goblin1.hp, hero.hp)))
                    if (battle1.battleGoblin()) {
                        System.out.println("You attacked the goblin using magic!, he attacked back!");
                        hero.takeDamage((hero.hp - goblin1.attack));
                        goblin1.takeDamage(goblin1.hp - hero.magic);
                        System.out.println("Your HP:" + hero.hp);
                        System.out.println("Enemy HP:" + goblin1.hp);
                        // else if ((battle1.battle(answer, heroHP)) == false)
                    } else if ((battle1.battleGoblin()) == false) {
                        System.out.println("Your magic missed, he hit you!");
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
            originalHP += 3;
            hero.addHp(originalHP);
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
        //scanner to get user input
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
                promptEnterKey();
                System.out.println("You decide to fight the boredom!");
                promptEnterKey();
                System.out.println("BATTLE: Boredom vs " + nameinput);
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
                System.out.println("BATTLE: Jimmy vs " + nameinput);

        }
        //new battle object created
        Battle battle3 = new Battle();
        // battle dictated on decision 1 - Battle with Boredom
        
        if (alarmclock == 1) {
            while (hero.hp > 0 && boredom.hp > 0) {

                System.out.println("------------------------------------------------");
                System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                System.out.println("------------------------------------------------");

                Scanner option = new Scanner(System.in);
                int choice = option.nextInt();
                

                switch (choice) {
                    case 1: {

                        if (battle3.battleBoredom() == true) {
                            System.out.println("You read a book,\nyour boredom worsens!");
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

                        if ((battle3.battleBoredom() == true)) {
                            System.out.println("You quietly listened to music!,\nboredom is tempoarily halted!");
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);

                        } else if ((battle3.battleBoredom()) == false) {
                            System.out.println("You got excited, but got bored right after.");
                            hero.takeDamage((hero.hp - boredom.attack));
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);
                        }
                    
                        break;
                    }

                    case 3: {

                        if (battle3.battleBoredom() == true) {
                            System.out.println("You drew a picture!,\nbut you're still a little bored!");
                            hero.takeDamage((hero.hp - boredom.attack));
                            boredom.takeDamage(boredom.hp - hero.magic);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);

                        } else if ((battle3.battleBoredom()) == false) {
                            System.out.println("You tried drawing, but all your colored pencils are dull!");
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + boredom.hp);
                        }
                        break;
                    }
                }
            }
        }
//battle with jimmy
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

                        if (battle2.battleJimmy() == true) {
                            System.out
                                    .println("You used your paddleball on Jimmy's face!,\nhe swung his baseball bat!");
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

                        if ((battle2.battleJimmy() == true)) {
                            System.out.println("You guarded his swing!,\nhis attack was blocked!");
                            // hero.takeDamage((hero.hp));
                            // jimmy.takeDamage(jimmy.hp);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                            // else if ((battle1.battle(answer, heroHP)) == false)
                        } else if ((battle1.battleJimmy()) == false) {
                            System.out.println("You tried to block him, but he called you a pussy and hit you!");
                            hero.takeDamage((hero.hp - jimmy.attack));
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                        }
                    
                        break;
                    }
                    case 3: {

                        if (battle2.battleJimmy() == true) {
                            System.out.println("You attacked Jimmy using magic!,\nhe attacked back!");
                            hero.takeDamage((hero.hp - jimmy.attack));
                            jimmy.takeDamage(jimmy.hp - hero.magic);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                            // else if ((battle1.battle(answer, heroHP)) == false)
                        } else if ((battle1.battleJimmy()) == false) {
                            System.out.println("You aren't magic, your atack missed!");
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + jimmy.hp);
                        }
                        break;
                    }
                }
            }
        }
//if both you and Jimmy lose enough hp, this path will occur
        if (hero.hp <= 0 && jimmy.hp <= 0 && alarmclock == 2) {
            System.out.println("You are tired but shake hands.\nYou go your separate ways.");
            promptEnterKey();
            System.out.println("You still leveled up!");
            originalLevel += 11;
            originalHP += 9;
            originalAttack += 6;
            originalDefense += 5;
            originalMagic += 6;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println("After a long day of fighting, you go home, eat dinner, then go to bed.");
//if you lose your hp before jimmy, this path occurs
        } else if (hero.hp <= 0 && alarmclock == 2) {
            System.out.println("Jimmy beat your ass. All the neighborhood kids are laughing.");
            System.out.println("Defeated, you go back home in embarrasment.");
            promptEnterKey();
            System.out.println("You still leveled up?");
            originalLevel += 8;
            originalHP += 8;
            originalAttack += 6;
            originalDefense += 5;
            originalMagic += 7;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println(
                    "After a short day of getting your ass handed to you\nyou go home, eat dinner, then go to bed.");
            promptEnterKey();
            //if Jimmy loses all his hp before you, this path occurs
        } else if (jimmy.hp <= 0 && alarmclock == 2) {
            System.out.println("You kicked Jimmy's ass. He runs off to cry in his room.");
            promptEnterKey();
            System.out.println("You leveled up!");
            originalLevel += 15;
            originalHP += 12;
            originalAttack += 9;
            originalDefense += 7;
            originalMagic += 8;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println(
                    "The neighborhood kids suddenly appear and clap for you.\nYou enjoy your day at the park.");
            promptEnterKey();
            System.out.println("After a long day of fun, you go home, eat dinner, then go to bed.");

        }
        //if you lose all your hp and boredom does too, this path occurs
        if (hero.hp <= 0 && boredom.hp <= 0 && alarmclock == 1) {
            System.out.println("You defeated boredom, but at what cost?");
            promptEnterKey();
            System.out.println("You leveled up!");
            originalLevel += 10;
            originalHP += 8;
            originalAttack += 6;
            originalDefense += 5;
            originalMagic += 8;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println("You lay there in silence until you fall asleep.");
            //if you lose all your hp before boredom can, this path occurs
        } else if (hero.hp <= 0 && alarmclock == 1) {
            System.out.println("Boredom defeated you. You lay in agony.");
            promptEnterKey();
            System.out.println("You somehow still leveled up?");
            originalLevel += 7;
            originalHP += 6;
            originalAttack += 4;
            originalDefense += 4;
            originalMagic += 5;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println("Defeated, you try to take a nap.");
            promptEnterKey();
            System.out.println("You can't sleep.\nYou eat dinner, then you can fall asleep for the night.");
            promptEnterKey();
            //if boredom loses all of its hp this path occurs
        } else if (boredom.hp <= 0 && alarmclock == 1) {
            System.out.println("You don't feel bored anymore. You feel content in your solitude.");
            System.out.println("You finish reading, gaining new wisdom along the way.");
            promptEnterKey();
            System.out.println("You leveled up.");
            originalLevel += 15;
            originalHP += 10;
            originalAttack += 7;
            originalDefense += 6;
            originalMagic += 9;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            promptEnterKey();
            System.out.println("You eat dinner, go to your room, and go to sleep for the night.");
            promptEnterKey();

        }

        System.out.println("You wake up. You feel completely different.");
        promptEnterKey();
        //Transition into chapter 2
        System.out.println("Chapter 2: College");
        System.out.println("You look around. It feels like you're in a jail cell.");
        promptEnterKey();
        System.out.println("You realize you are in a dorm room,\nyou're in college,\nand you have a paper due at 5PM.");
        promptEnterKey();
        System.out.println("You see a 24 pack of beer on the floor, next to your laptop.");
        System.out
                .println("You get a text from Jimmy, your old bully. He's in your frat now and you have reconciiled.");
        promptEnterKey();
        System.out.println("His text says 'Yoooo" + nameinput);
        System.out.println("There's a party tonight. You in?'");

        System.out.println(
                "Select your Option:\n1.Text him 'Fuck Yeah!'\n2.Text him 'Nah sorry, I have a paper to write.'");
        System.out.println("~");
        System.out.println("------------------------------------------------");
        System.out.println("~");
        Scanner textmessage = new Scanner(System.in);
        int textreply = Integer.parseInt(textmessage.nextLine());

        switch (textreply) {
            case 1: {
                System.out.println("You text Jimmy, and begin to chug a beer despite it being 9AM.");
                promptEnterKey();
                System.out.println("Noon rolls around, and 10 beers are already gone.");
                promptEnterKey();
                System.out.println("You're mildly wasted, but still want more.");
                System.out
                        .println("Depression sets in.\nYou're pumped for the party later,\nbut disgusted at yourself.");
                promptEnterKey();
                System.out.println(
                        "You realize you have a problem.\nThis isn't what your parents are paying for you to go to school for.");
                System.out.println("You decide to put your foot down.");
                break;
            }
            case 2: {
                System.out.println("You text Jimmy, and he gets pissed.\nClassic Jimmy.");
                promptEnterKey();
                System.out.println("You ignore the beer, despite craving one.");
                promptEnterKey();
                System.out.println("You pick up your laptop and realize it's dead.");
                System.out.println("You plug it in and wait with a splitting headache from last night's endeavor");
                promptEnterKey();
                System.out.println("Charging 5%");
                promptEnterKey();
                System.out.println("Charging 48%");
                promptEnterKey();
                System.out.println("CHarging 100%\n It's time to begin this paper.");
            }
        }
        Battle battle4 = new Battle();

        if (textreply == 1) {
            while (hero.hp > 0 && alcoholism.hp > 0) {

                System.out.println("------------------------------------------------");
                System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                System.out.println("------------------------------------------------");

                Scanner option = new Scanner(System.in);
                int choice = option.nextInt();

                switch (choice) {
                    case 1: {

                        if (battle4.battleAlcoholism() == true) {
                            System.out.println("You pour your beer out,\nbut there's still a shit ton!");
                            alcoholism.takeDamage(alcoholism.hp - hero.attack);
                            hero.takeDamage(hero.hp - alcoholism.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + alcoholism.hp);

                            System.out.println("------------------------------------------------");

                        } else if (battle4.battleAlcoholism() == false) {
                            System.out.println(
                                    "You attempt to pour the beer down the drain, but you take a swig anyways!");
                            hero.takeDamage(hero.hp - alcoholism.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + alcoholism.hp);

                            System.out.println("------------------------------------------------");

                        }
                        break;
                    }
                    case 2: {

                        if ((battle4.battleAlcoholism() == true)) {
                            System.out.println("You didn't drink the beer,\nyou sober up a bit!");
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + alcoholism.hp);

                        } else if ((battle4.battleAlcoholism()) == false) {
                            System.out.println("You tried not to drink the beer,\nbut it's calling your name!");
                            hero.takeDamage((hero.hp - alcoholism.attack));
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + alcoholism.hp);
                        }
                    }
                        break;

                    case 3: {

                        if (battle4.battleAlcoholism() == true) {
                            System.out.println("You shook up the beer and sprayed it at the wall!,\nwhat the fuck???!");
                            hero.takeDamage((hero.hp - alcoholism.attack));
                            alcoholism.takeDamage(alcoholism.hp - hero.magic);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + alcoholism.hp);

                        } else if ((battle4.battleAlcoholism()) == false) {
                            System.out.println("You tried to open the beer, but it slipped out of your hand!");
                            hero.takeDamage(hero.hp - alcoholism.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + alcoholism.hp);
                        }
                        break;
                    }
                }
            }
        }

        if (textreply == 2) {
            while (hero.hp > 0 && paper.hp > 0) {

                System.out.println("------------------------------------------------");
                System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                System.out.println("------------------------------------------------");

                Scanner option = new Scanner(System.in);
                int choice = option.nextInt();
                Battle battle1 = new Battle();
                Battle battle2 = new Battle();

                switch (choice) {
                    case 1: {

                        if (battle4.battlePaper() == true) {
                            System.out.println("You wrote 100 words!,\nbut half of those aren't real words!");
                            paper.takeDamage(paper.hp - hero.attack);
                            hero.takeDamage(hero.hp - paper.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + paper.hp);

                        } else if (battle4.battlePaper() == false) {
                            System.out.println(
                                    "Your weren't even typing dude,\ntime to retype everything you just wrote!");
                            hero.takeDamage(hero.hp - paper.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + paper.hp);

                        }
                        break;
                    }
                    case 2: {

                        if ((battle4.battlePaper() == true)) {
                            System.out.println("You didn't accidentally delete everything!,\nnice save!");

                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + paper.hp);
                            // else if ((battle1.battle(answer, heroHP)) == false)
                        } else if ((battle4.battlePaper()) == false) {
                            System.out.println("You tried to be smart, but you couldn't.");
                            hero.takeDamage((hero.hp - paper.attack));
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + paper.hp);
                        }
                    }
                        break;

                    case 3: {

                        if (battle4.battlePaper() == true) {
                            System.out.println(
                                    "You cited your source and added 70 words!,\nbut you still need to spell check!");
                            hero.takeDamage((hero.hp - paper.attack));
                            paper.takeDamage(jimmy.hp - hero.magic);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + paper.hp);
                            // else if ((battle1.battle(answer, heroHP)) == false)
                        } else if ((battle4.battleJimmy()) == false) {
                            System.out.println("You cited your source!,\nbut used APA intead of MLA!");
                            hero.takeDamage(hero.hp - paper.attack);
                            System.out.println("Your HP:" + hero.hp);
                            System.out.println("Enemy HP:" + paper.hp);
                        }
                        break;
                    }
                }
            }
        }
        if (hero.hp <= 0 && alcoholism.hp <= 0 && textreply == 1) {
            System.out.println("You defeated alcoholism, but it has taken its toll on you.");
            promptEnterKey();
            System.out.println("You leveled up!");
            originalLevel += 20;
            originalHP += 28;
            originalAttack += 12;
            originalDefense += 10;
            originalMagic += 13;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println("You call your parents.");
            promptEnterKey();
            System.out.println("You're going to rehab.");
            promptEnterKey();
        } else if (hero.hp <= 0 && textreply == 1) {
            System.out.println("Alcoholism defeated you. You your body aches and you feel terrible.");
            promptEnterKey();
            System.out.println("You somehow still leveled up?");
            originalLevel += 18;
            originalHP += 19;
            originalAttack += 9;
            originalDefense += 8;
            originalMagic += 10;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println("You reach for your phone, and call your parents.");
            promptEnterKey();
            System.out.println("You're going to rehab.");
            promptEnterKey();

        } else if (alcoholism.hp <= 0 && textreply == 1) {
            System.out.println("You finally sober up.");
            System.out.println("You have the shakes but your confidence to stop is through the roof.");
            promptEnterKey();
            System.out.println("You leveled up.");
            originalLevel += 22;
            originalHP += 25;
            originalAttack += 15;
            originalDefense += 8;
            originalMagic += 13;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            promptEnterKey();
            System.out.println("You eat some food, then cancel on the party.");
            promptEnterKey();
            System.out.println("You can finally look ahead. You begin your paper peacefully");
            promptEnterKey();

        }
        if (hero.hp <= 0 && paper.hp <= 0 && textreply == 2) {
            System.out.println("You finished your paper, but end up getting a C on it.");
            promptEnterKey();
            System.out.println("You still leveled up!");
            originalLevel += 21;
            originalHP += 24;
            originalAttack += 10;
            originalDefense += 9;
            originalMagic += 11;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println("You manage to pass the class.");
            promptEnterKey();
            System.out.println("You head to bed after a long mental battle.");
            promptEnterKey();
        } else if (hero.hp <= 0 && textreply == 2) {
            System.out.println("You couldn't finish the paper. You turned in what you had.");
            promptEnterKey();
            System.out.println("You somehow still leveled up?");
            originalLevel += 17;
            originalHP += 20;
            originalAttack += 9;
            originalDefense += 7;
            originalMagic += 12;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            System.out.println("You got an F on the paper.");
            promptEnterKey();
            System.out
                    .println("You're going to have to retake this class next semester,\nassuming you don't drop out.");
            promptEnterKey();
            System.out.println("You drink a beer, then head to bed.");
            promptEnterKey();
        } else if (paper.hp <= 0 && textreply == 2) {
            System.out.println("You finish the damn thing.");
            System.out.println("You end up getting an A on it.");
            promptEnterKey();
            System.out.println("You leveled up!");
            originalLevel += 24;
            originalHP += 25;
            originalAttack += 16;
            originalDefense += 9;
            originalMagic += 14;
            hero.addLevel(originalLevel);
            hero.addHp(originalHP);
            hero.addAttack(originalAttack);
            hero.addDefense(originalDefense);
            hero.addMagic(originalMagic);
            hero.printstats();
            promptEnterKey();
            System.out.println("You eat some food, then head to the party.");
            promptEnterKey();
            System.out.println("You have a great time!");
            promptEnterKey();
            System.out.println("Afterwards, you head home and pass out in your dorm room.");
            promptEnterKey();

        }
        System.out.println("Chapter 3: Adulthood");

    }

    // method to simplify promting user to press enter
    private static void promptEnterKey() {
        System.out.println("Press ENTER to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
