package fr.marie.harrypotterjavafx.levels;

import fr.marie.harrypotterjavafx.console.Display;
import fr.marie.harrypotterjavafx.interfaceFx.vue.WindowTalk;
import fr.marie.harrypotterjavafx.main_pack.Object;
import fr.marie.harrypotterjavafx.main_pack.*;
import fr.marie.harrypotterjavafx.main_pack.Wizard;
import fr.marie.harrypotterjavafx.main_pack.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static fr.marie.harrypotterjavafx.interfaceFx.vue.WindowTalk.nextButton;

public class Level1 {

    public void start(Wizard wizard){

        //spells and potions contain the spells and potions that are accessible to the wizard, and are updated starting each levels.level.
        List<Spell> spells = new ArrayList<>();
        Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 1, 40);
        spells.add(wingardiumLeviosa);
        /////////////////////////////////////////////////////////////
        Potion HEALER = new Potion("Healing Potion", 10.0f, "Increases your life points", 10.0f);
        List<Potion> potions = new ArrayList<>();
        potions.add(HEALER);
        wizard.setPotions(potions);
        wizard.setKnownSpells(spells);


        //contains the different objects that can be thrown on the troll
        List<Object> objects = new ArrayList<>();
        Object chandelier = new Object("chandelier", 20);
        Object table = new Object("table", 40);
        Object rock = new Object("rock", 30);
        Object sink = new Object("sink", 55);
        objects.add(chandelier);
        objects.add(table);
        objects.add(rock);
        objects.add(sink);

        // Initialisation des variables
        Scanner scanner = new Scanner(System.in);
        wingardiumLeviosa = new Spell("Wingardium Leviosa", 1, 25);
        Enemy enemy = new Enemy("Troll", 100, 16);

        // Level 1 Description
        Display.separator();
        Display.text("Level 1 : The Philosopher’s Stone");
        Display.space();
        Display.text("You are in the donjon's toilets.\n");
        Display.text("The troll is getting in your way.\n");
        Display.text("Use the spell Wingardium Leviosa ✨ to drop objects on the troll's head.\n");
        Display.text("🧙‍♂️ Advice :Throw at it the heaviest one !\n");
        Display.space();
        //display in the window

        WindowTalk.printInWindow("Level 1 : The Philosopher’s Stone" + "\n\nYou are in the donjon's toilets.\nThe troll is getting in your way.\n" +
                "Use the spell Wingardium Leviosa ✨ to drop objects on the troll's head.\n" +
                "\n🧙‍♂️Advice :Throw at it the heaviest one !\n");
        Spell WingardiumLeviosa = wingardiumLeviosa;
        WindowTalk.nextButton.setOnAction(event1 -> {
            // Level 1
            counter = 0;
            //you can't throw more than 6 objects
            while (counter < 15 && enemy.getLife() > 0 && wizard.getLife() > 0) {
                System.out.println("Which object to you want to choose ? (1-chandelier , 2-table, 3-rock ou 4-lavabo)");
                int index = 0;
                while (index > 4 || index < 1) {
                    System.out.println("Please, enter a number from 1 to 4");
                    index = scanner.nextInt();
                }
                Object object = objects.get(index - 1);
                System.out.println("You cast Wingardium Leviosa on the " + object.getName() + ". ");
                //WindowTalk.printInWindow("You cast Wingardium Leviosa on the " + object.getName() + ". ");
                //WindowTalk.nextButton.setOnAction(event2 -> {
                counter++;
                float damage = (float) (object.getWeight() * WingardiumLeviosa.getEffectiveness() * 0.01 * wizard.getHouse().getSpellEff() * wizard.getHouse().getPrecisionEff());
                System.out.println("The " + object.getName() + " falls on the troll's head and inflicts " + damage + " damage points.");
                enemy.setLife(enemy.getLife() - damage);
                Display.space();
                System.out.println("\033[38;2;255;165;0mThe Troll : " + (int) (enemy.getLife()) + " HP | 🧟‍♂️☢️\033[0m ");
                Display.space();
                //intensity of the troll's attack after each wizard attack
                System.out.println("The troll is attacking 💥");
                float intensity = (float) (Math.random());
                float enemyDamage = (enemy.getPower() * intensity) / wizard.getHouse().getResistanceEff();
                wizard.setLife(wizard.getLife() - enemyDamage);
                Display.space();
                System.out.println("\033[31mYou : " + (int) (wizard.getLife()) + " HP | 🧙‍♀️❤️\033[0m ️");
                Display.space();
                System.out.println("You have " + (15 - counter) + " objects left");
                WindowTalk.printInWindow("You cast Wingardium Leviosa on the " + object.getName() + ". " + "\n\nThe " + object.getName() + " falls on the troll's head and inflicts " + damage + " damage points." + "\n \nThe Troll : " + (int) (enemy.getLife()) + " HP |  🧟‍☢️" + "\nThe troll is attacking 💥" + "\n\nYou : " + (int) (wizard.getLife()) + " HP | 🧙❤️" + "\nYou have " + (9 - counter) + " objects left");
                //WindowTalk.nextButton.setOnAction(event3 -> {
                //});});
            }
            WindowTalk.nextButton.setOnAction(event2 -> {
                // Fin du niveau
                if (wizard.getLife() <= 0) {
                    System.out.println("The troll has defeated you! Game-over. ☠️");
                    WindowTalk.printInWindow("The troll has defeated you! Game-over. ☠️");
                    WindowTalk.nextButton.setOnAction(event4 -> {
                        Level level = new Level();
                        int choice = level.tryAgain();
                        if (choice == 1) {
                            wizard.setLife(100);
                            start(wizard);
                        } else if (choice == 2) {
                            System.exit(0);
                        }
                    });
                }
                if (enemy.getLife() <= 0) {
                    System.out.println("Congratulations, you have defeated the troll! 🎇");
                    System.out.println("You can now access the next level.");
                    wizard.setLife(100);
                    WindowTalk.printInWindow("Congratulations, you have defeated the troll! 🎇" + "\nWould you like to access the next level." + "\nYou earned " + 15 + "🪙" + "🧙‍♀️You have : " + wizard.getMoney() + " 🪙");
                    WindowTalk.nextButton.setOnAction(event5 -> {
                        Shop.earnMoney(wizard, 15);
                        //Shop.enterShop(wizard);

                        Level2 level2 = new Level2();
                        level2.start(wizard);

                    });
                }
            });
        });
    }
}



