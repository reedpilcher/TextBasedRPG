package rpg;

//importing java package Scanner to allow user inputs


import java.util.Scanner;
//importing java random package to generate random numbers for battling








public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // Introduction screen with instructions to add your name

        System.out.println("Welcome to Dolphin Fables. What is your name? press enter when complete.");
        // creating new character objects with certain characteristics to allow more
        // preferences

        Character hero = new Character();
        // initializing the hero's level when you start
        hero.addLevel(5);

//creation of a new enemy "boss" using the same stat types as the character
Character boss = new Character();
boss.addAttack(7);
boss.addDefense(7);
boss.addHp(65);
boss.addMagic(7);
//creation of a new enemy "unemployment"
Character unemployment = new Character();
unemployment.addAttack(6);
unemployment.addDefense(8);
unemployment.addHp(64);
unemployment.addMagic(3);

        // creation of a new enemy "alcoholism" using the same stat types as the
        // character
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

        try (Scanner username = new Scanner(System.in)) {
            String nameinput = username.nextLine();

            // adding the name to the main character object

            hero.addName(nameinput);
            try (Scanner style = new Scanner(System.in)) {
                // text asking which style you prefer
                System.out.println(
                        "What style do you belong to?\nType in the number which corresponds to you:\n1. Swordsman style\n2. Wizard style\n3. Guard style\n4. Healer style");
                int styleinput = style.nextInt();
                // switch case to determine which style your character belongs to
                // as well as output their new stats

                switch (styleinput) {
                    // Swordsman style with more balanced stats
                    case 1 -> {
                        System.out.println("Congratulations! You have selected the Swordsman style!");
                        hero.addHp(7);
                        hero.addAttack(7);
                        hero.addDefense(7);
                        hero.addMagic(5);
                        System.out.println("Name: " + nameinput);
                        hero.printstats();
                    }
                    // Wizard style with better magic stats
                    case 2 -> {
                        System.out.println("Congratulations! You have selected the Wizard style!");
                        hero.addHp(8);
                        hero.addAttack(5);
                        hero.addDefense(6);
                        hero.addMagic(10);
                        System.out.println("Name: " + nameinput);
                        hero.printstats();
                    }
                    // Guard style with better defensive stats
                    case 3 -> {
                        System.out.println("Congratulations! You have selected the Guard style!");
                        hero.addHp(9);
                        hero.addAttack(4);
                        hero.addDefense(10);
                        hero.addMagic(5);
                        System.out.println("Name: " + nameinput);
                        hero.printstats();
                    }
                    // Healer style with better HP and defense
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
            }
            // creating integer variables to more easily change them when leveled up
            int originalHP = (hero.hp);
            int originalAttack = (hero.attack);
            int originalDefense = (hero.defense);
            int originalMagic = (hero.magic);
            int originalLevel = (hero.heroLevel);

            // placeholder lines to seperate text more clearly
            System.out.println("------------------------------------------------");
            // an instance of promptig the user to press "Enter"; This will be used
            // frequently throughout
            promptEnterKey();
            // First battle instance
            System.out.println("Oh crap! You ran into a goblin.\nYou must battle him to prove your value.");
            System.out.println("BATTLE: GOBLIN VS " + nameinput);
            System.out.println("Your HP:" + hero.hp);
            System.out.println("Enemy HP:" + goblin1.hp);

            // A while loop that makes sure the battle continutes until either the enemy or
            // the player
            // loses all their HP (Health Points). Loop will end when it meets one or both
            // of these requirements.
            while (hero.hp > 0 && goblin1.hp > 0) {
                // Option selection for battle
                System.out.println("------------------------------------------------");

                System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");

                System.out.println("------------------------------------------------");
                try (// Scanner to dictate which option is selected based on user input (1, 2, or 3)
                Scanner option = new Scanner(System.in)) {
                    int choice = option.nextInt();
                    Battle battle1 = new Battle();

                    // switch case to determine which option got selected by user, and to carry out
                    // the specified option
                    switch (choice) {
                        // case 1 is to Attack; This remains consistent for every battle
                        case 1: {
                            // Using a boolean method to determine whether the random number is within the
                            // range to hit or miss
                            // There is an element of randomness and not 100% accuracy everytime
                            if (battle1.battleGoblin() == true)
                            // if the method returns true, attack hits. If it returns false, attack misses.
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
                        // case 2 is to guard attacks; This remains consistent for every battle.
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
                        // case 3 is to use magic; This remains consistent for every battle
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
            try (// scanner to get user input
            Scanner alarm = new Scanner(System.in)) {
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
                // new battle object created
                Battle battle3 = new Battle();
                // battle dictated on decision 1 - Battle with Boredom

                if (alarmclock == 1) {
                    while (hero.hp > 0 && boredom.hp > 0) {

                        System.out.println("------------------------------------------------");
                        System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                        System.out.println("------------------------------------------------");

                        try (Scanner option = new Scanner(System.in)) {
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
                }
                // battle with jimmy
                if (alarmclock == 2) {
                    while (hero.hp > 0 && jimmy.hp > 0) {

                        System.out.println("------------------------------------------------");
                        System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                        System.out.println("------------------------------------------------");

                        try (Scanner option = new Scanner(System.in)) {
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
                }
                // if both you and Jimmy lose enough hp, this path will occur
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
                    // if you lose your hp before jimmy, this path occurs
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
                    // if Jimmy loses all his hp before you, this path occurs
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
                // if you lose all your hp and boredom does too, this path occurs
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
                    // if you lose all your hp before boredom can, this path occurs
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
                    // if boredom loses all of its hp this path occurs
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
                // Transition into chapter 2
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
                try (// scanner that takes user inout to put into the switch case
                Scanner textmessage = new Scanner(System.in)) {
                    int textreply = Integer.parseInt(textmessage.nextLine());
                    // switch case to dictate whether you start drinking - option 1
                    // or if you work on your paper - option 2
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
                            promptEnterKey();
                            System.out.println("BATTLE: Alcoholism vs " + nameinput);
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
                            promptEnterKey();
                            System.out.println("BATTLE: Paper vs " +nameinput);
                        }
                    }
                    // new batttle
                    Battle battle4 = new Battle();

                    if (textreply == 1) {
                        while (hero.hp > 0 && alcoholism.hp > 0) {

                            System.out.println("------------------------------------------------");
                            System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                            System.out.println("------------------------------------------------");

                            try (Scanner option = new Scanner(System.in)) {
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
                    }

                    if (textreply == 2) {
                        while (hero.hp > 0 && paper.hp > 0) {

                            System.out.println("------------------------------------------------");
                            System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                            System.out.println("------------------------------------------------");

                            try (Scanner option = new Scanner(System.in)) {
                                int choice = option.nextInt();
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
                                            paper.takeDamage(paper.hp - hero.magic);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + paper.hp);
                                            // else if ((battle1.battle(answer, heroHP)) == false)
                                        } else if ((battle4.battlePaper()) == false) {
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
                    }
                    // if you lose your all your hp and so does alcoholism, this path occurs
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
                        // if you lose your hp before alcoholism, this path occurs
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
                        // if alcoholism loses his hp before you, this path occurs
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
                    // if you lose your hp and so does paper, this path occurs
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
                        // if you lose your hp before paper does, this path occurs
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
                        // if paper loses its hp before you, this path occurs
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
                    // transition to chapter 3
                    System.out.println("Chapter 3: Adulthood");
                    promptEnterKey();
                    System.out.println("You wake up again, and feel 100 pounds heavier.");
                    promptEnterKey();
                    System.out.println("You look around, and see that you have a wife putting her makeup on.");
                    promptEnterKey();
                    System.out.println("Wife: 'Honey get up, you need to go to work!'");
                    promptEnterKey();
                    System.out.println("You realize you have to go to the office, again.\nYou dread it.");
                    promptEnterKey();
                    System.out.println("Wife: 'Babe I'm serious. you're going to be late again!");

                    

                    System.out.println(
                        "Select your Option:\n1.Say 'yeah I'll be up in a minute', then go back to sleep'\n2.Get up begrudgingly and head to work");
   System.out.println("~");
   System.out.println("------------------------------------------------");
   System.out.println("~");
   try (// scanner that takes user input to put into the switch case
Scanner work = new Scanner(System.in)) {
    int workinput = Integer.parseInt(work.nextLine());
       // switch case to dictate whether you start drinking - option 1
       // or if you work on your paper - option 2
       switch (workinput) {
                        case 1: {
                            System.out.println("You dream peacefully.");
                            promptEnterKey();
                            System.out.println("You hear your phone vibrating.");
                            promptEnterKey();
                            System.out.println("You ignore it.");
                            System.out
                                    .println("You finally wake up and it's 1PM. You see a text from your boss.");
                            promptEnterKey();
                            System.out.println(
                                    "You open it.");
                                    promptEnterKey();
                            System.out.println("Boss: " + nameinput);
                            System.out.println("YOU'RE FIRED!!!!!!!!!!!!");
                            promptEnterKey();
                            System.out.println("You're unemployed.\nYour wife is going to be pissed.");
                            System.out.println("BATTLE: Unemployment vs " + nameinput);
                            
                            break;
                        }
                        case 2: {
                            System.out.println("You crawl out of bed.");
                            promptEnterKey();
                            System.out.println("You get ready and get into your car.");
                            promptEnterKey();
                            System.out.println("You make the hour long commute to a place you hate.");
                            System.out.println("You sit down at your desk, relieved you get to enjoy your cup of coffee.");
                            promptEnterKey();
                            System.out.println("*Your boss walks in*");
                            promptEnterKey();
                            System.out.println("Oh yeah by the way, " +nameinput);
                            promptEnterKey();
                            System.out.println("I fucked your wife.");
                            System.out.println("You spit out your coffee, and jump up ready to fight.");
                            System.out.println("BATTLE: Boss vs " + nameinput);
                        }
       }
       // new batttle
       Battle battle5 = new Battle();
    
       if (workinput == 1) {
                        while (hero.hp > 0 && unemployment.hp > 0) {
    
                            System.out.println("------------------------------------------------");
                            System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                            System.out.println("------------------------------------------------");
    
                            try (Scanner option = new Scanner(System.in)) {
                                int choice = option.nextInt();
   
                                switch (choice) {
                                    case 1: {
   
                                        if (battle5.battleUnemployment() == true) {
                                            System.out.println("Apply for food stamps, get approved but you have to apply to another job!");
                                          unemployment.takeDamage(unemployment.hp - hero.attack);
                                            hero.takeDamage(hero.hp - unemployment.attack);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + unemployment.hp);
   
                                            System.out.println("------------------------------------------------");
   
                                        } else if (battle5.battleUnemployment() == false) {
                                            System.out.println(
                                                    "Your food stamps get delayed by another week!");
                                            hero.takeDamage(hero.hp - unemployment.attack);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + unemployment.hp);
   
                                            System.out.println("------------------------------------------------");
   
                                        }
                                        break;
                                    }
                                    case 2: {
   
                                        if ((battle5.battleUnemployment() == true)) {
                                            System.out.println("You drive around for an hour so your wife thinks you're at work!");
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + unemployment.hp);
   
                                        } else if ((battle5.battleUnemployment()) == false) {
                                            System.out.println("You drive around so your wife thinks you're at work, but she sees you out her work window!");
                                            hero.takeDamage((hero.hp - unemployment.attack));
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + unemployment.hp);
                                        }
                                    }
                                        break;
   
                                    case 3: {
   
                                        if (battle5.battleUnemployment() == true) {
                                            System.out.println("You use photoshop to create a fake paycheck!");
                                            hero.takeDamage((hero.hp - unemployment.attack));
                                            unemployment.takeDamage(unemployment.hp - hero.magic);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + unemployment.hp);
   
                                        } else if ((battle5.battleUnemployment()) == false) {
                                            System.out.println("You attempt to photoshop a paycheck, but it looks fake as hell!");
                                            hero.takeDamage(hero.hp - unemployment.attack);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + unemployment.hp);
                                        }
                                        break;
                                    }
                                }
                            }
                        }
       }
    
       if (workinput == 2) {
                        while (hero.hp > 0 && boss.hp > 0) {
    
                            System.out.println("------------------------------------------------");
                            System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
                            System.out.println("------------------------------------------------");
    
                            try (Scanner option = new Scanner(System.in)) {
                                int choice = option.nextInt();
                     
   
                                switch (choice) {
                                    case 1: {
   
                                        if (battle5.battleBoss() == true) {
                                            System.out.println("You kick your boss in the balls, he swings on you!");
                                            boss.takeDamage(boss.hp - hero.attack);
                                            hero.takeDamage(hero.hp - boss.attack);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + boss.hp);
   
                                        } else if (battle5.battleBoss() == false) {
                                            System.out.println(
                                                    "You try to kick your boss in the balls, but he grabs your leg and puts you on the ground!");
                                            hero.takeDamage(hero.hp - boss.attack);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + boss.hp);
   
                                        }
                                        break;
                                    }
                                    case 2: {
   
                                        if ((battle5.battleBoss() == true)) {
                                            System.out.println("You hide under your desk, and your boss doesn't know where you are!");
   
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + boss.hp);
                                            // else if ((battle1.battle(answer, heroHP)) == false)
                                        } else if ((battle5.battleBoss()) == false) {
                                            System.out.println("You hide under your desk, but your boss kicks you while you're under there");
                                            hero.takeDamage((hero.hp - boss.attack));
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + boss.hp);
                                        }
                                    }
                                        break;
   
                                    case 3: {
   
                                        if (battle5.battleBoss() == true) {
                                            System.out.println(
                                                    "You speak Portugese to your boss, he gets confused!");
                                            hero.takeDamage((hero.hp - boss.attack));
                                            boss.takeDamage(boss.hp - hero.magic);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + boss.hp);
                                            // else if ((battle1.battle(answer, heroHP)) == false)
                                        } else if ((battle5.battleBoss()) == false) {
                                            System.out.println("You try to speak Portugese to your boss, but he ignores it!");
                                            hero.takeDamage(hero.hp - boss.attack);
                                            System.out.println("Your HP:" + hero.hp);
                                            System.out.println("Enemy HP:" + boss.hp);
                                        }
                                        break;
                                    }
                                }
                            }
                        }
       }
       // if you lose all your hp and so does unemployment, this path occurs
       if (hero.hp <= 0 && unemployment.hp <= 0 && workinput == 1) {
                        System.out.println("You beat umeployment, sort of.");
                        promptEnterKey();
                        System.out.println("You got on welfare so you can at least feed your family.");
                        System.out.println("You leveled up!");
                        originalLevel += 19;
                        originalHP += 32;
                        originalAttack += 17;
                        originalDefense += 16;
                        originalMagic += 18;
                        hero.addLevel(originalLevel);
                        hero.addHp(originalHP);
                        hero.addAttack(originalAttack);
                        hero.addDefense(originalDefense);
                        hero.addMagic(originalMagic);
                        hero.printstats();
                        System.out.println("Your wife gets home and berates you.");
                        promptEnterKey();
                        System.out.println("She still loves you though.");
                        promptEnterKey();
                        System.out.println("After a long day of saving your marriage, you head to bed.");
                        // if you lose your hp before unemployment, this path occurs
       } else if (hero.hp <= 0 && workinput == 1) {
                        System.out.println("You got food stamps, but denied unemployment.");
                        promptEnterKey();
                        System.out.println("You somehow still leveled up? Really?");
                        originalLevel += 22;
                        originalHP += 25;
                        originalAttack += 12;
                        originalDefense += 10;
                        originalMagic += 14;
                        hero.addLevel(originalLevel);
                        hero.addHp(originalHP);
                        hero.addAttack(originalAttack);
                        hero.addDefense(originalDefense);
                        hero.addMagic(originalMagic);
                        hero.printstats();
                        System.out.println("Your wife gets home.");
                        promptEnterKey();
                        System.out.println("She wants a divorce.");
                        promptEnterKey();
                        System.out.println("You cry yourself to sleep on the couch.");
                        // if unemployment loses his hp before you, this path occurs
       } else if (unemployment.hp <= 0 && textreply == 1) {
                        System.out.println("You found a new job!");
                        promptEnterKey();
                        System.out.println("It pays better too!");
                        promptEnterKey();
                        System.out.println("You leveled up.");
                        originalLevel += 30;
                        originalHP += 30;
                        originalAttack += 18;
                        originalDefense += 12;
                        originalMagic += 15;
                        hero.addLevel(originalLevel);
                        hero.addHp(originalHP);
                        hero.addAttack(originalAttack);
                        hero.addDefense(originalDefense);
                        hero.addMagic(originalMagic);
                        hero.printstats();
                        promptEnterKey();
                        System.out.println("Your wife gets home, and you tell her the good news.");
                        promptEnterKey();
                        System.out.println("You lay in bed thinking about the new boat you're gonna buy.");
                        promptEnterKey();
                        System.out.println("You go to sleep to once again dream peacefully.");
    
       }
       // if you lose your hp and so does your boss, this path occurs
       if (hero.hp <= 0 && boss.hp <= 0 && workinput == 2) {
                        System.out.println("You and your boss lay on the ground,\nas two grown men would after battling.");
                        promptEnterKey();
                        System.out.println("You still leveled up!");
                        originalLevel += 23;
                        originalHP += 27;
                        originalAttack += 12;
                        originalDefense += 8;
                        originalMagic += 12;
                        hero.addLevel(originalLevel);
                        hero.addHp(originalHP);
                        hero.addAttack(originalAttack);
                        hero.addDefense(originalDefense);
                        hero.addMagic(originalMagic);
                        hero.printstats();
                        System.out.println("You get up and walk out.");
                        promptEnterKey();
                        System.out.println("You file for divorce and your wife is upset.");
                        promptEnterKey();
                        System.out.println("You split the assets 50/50, but you get main custody of your kid.");
                        promptEnterKey();
                        System.out.println("You go to sleep peacefully knowing you still have your kid.");
                        // if you lose your hp before paper does, this path occurs
       } else if (hero.hp <= 0 && workinput == 2) {
                        System.out.println("You get your ass beat.");
                        promptEnterKey();
                        System.out.println("You just now realize your boss is Jimmy, despite working there for years.");
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
                        System.out.println("Your wife is leaving you.");
                        promptEnterKey();
                        System.out
                                .println("You lose the house.");
                        promptEnterKey();
                        System.out.println("You fall asleep in a hotel room.");
                        promptEnterKey();
                        // if your boss loses its hp before you, this path occurs
       } else if (boss.hp <= 0 && workinput == 2) {
                        System.out.println("You kicked you boss's ass.");
                        System.out.println("You somehow realize Jimmy was your boss this whole time.");
                        promptEnterKey();
                        System.out.println("You leveled up!");
                        originalLevel += 26;
                        originalHP += 28;
                        originalAttack += 19;
                        originalDefense += 9;
                        originalMagic += 15;
                        hero.addLevel(originalLevel);
                        hero.addHp(originalHP);
                        hero.addAttack(originalAttack);
                        hero.addDefense(originalDefense);
                        hero.addMagic(originalMagic);
                        hero.printstats();
                        promptEnterKey();
                        System.out.println("You go home and divorce your wife.");
                        System.out.println("You win the house and your kid!");
                        promptEnterKey();
                        System.out.println("Afterwards, head to sleep very happy.");
                        promptEnterKey();
    
       }
    
       System.out.println("Chapter 4: Old Age");
       promptEnterKey();
       System.out.println("You wake up\nYou feel weak and frail.");
       promptEnterKey();
       System.out.println("You feel very wrinkly\nYou look in the mirror.");
       promptEnterKey();
       System.out.println("You scream. You're about 80 years old.");
       promptEnterKey();
       System.out.println("You feel your heart palpitating.");
       promptEnterKey();
       System.out.println("You're having a heart attack.");
       promptEnterKey();
       System.out.println("You grab your phone.");
       promptEnterKey();
       System.out.println("Who are you going to call?");
       System.out.println("Select your Option:\n1.Your kid\n2.911 (Emergency Services).");
       promptEnterKey();
       System.out.println("It doesn't matter either way.");
       promptEnterKey();
       System.out.println("You feel your life coming to an end.");
       promptEnterKey();
       System.out.println("You feel your life flash before your eyes.");
       promptEnterKey();
       if(alarmclock == 1){
                        System.out.println("Boredom...");
                        promptEnterKey();
       }
       if(alarmclock == 2){
                        System.out.println("Jimmy...");
                        promptEnterKey();
       }
       if(textreply == 1){
                        System.out.println("Alcoholism...");
                        promptEnterKey();
       }
       if(textreply == 2){
                        System.out.println("Paper...");
                        promptEnterKey();
       }
       if(workinput == 1){
                        System.out.println("Unemployment...");
                        promptEnterKey();
       }
       if(workinput == 2){
                        System.out.println("Boss...");
                        promptEnterKey();
       }
}
                }
            }
            System.out.println("You see a light...");
   promptEnterKey();
   System.out.println("You see a dragon??????????????");
   promptEnterKey();
System.out.println("FINAL BATTLE: Dragon of Death vs " + nameinput);
        } 
        System.out.println("------------------------------------------------");
            System.out.println("Select your Option:\n1. Attack\n2.Guard\n3.Use Magic");
            System.out.println("------------------------------------------------");
    promptEnterKey();
    System.out.println("Once again, it doesn't matter what you chose.");
    promptEnterKey();
    System.out.println("Dragon of Death Attacked! He did 5000 damage!");
    promptEnterKey();
    System.out.println("You have died.");
    promptEnterKey();
    System.out.println("GAME OVER");



    }

    // method to simplify promting user to press enter
    private static void promptEnterKey() {
        System.out.println("Press ENTER to continue");
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
        }
        return;
    }

}
