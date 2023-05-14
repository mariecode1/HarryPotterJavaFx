package fr.marie.harrypotterjavafx.console;

import fr.marie.harrypotterjavafx.interfaceFx.vue.WindowTalk;
import fr.marie.harrypotterjavafx.levels.*;
import fr.marie.harrypotterjavafx.main_pack.*;


import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Wizard wizard;

    public static void main(String[] args) {
        //Wizard wizard= Main.startGame();
        //Level1 level1 = new Level1();
        //level1.start(wizard);
        //Display.continuee();
        //Level2 level2 = new Level2();
        //level2.start(wizard);
        //Display.continuee();
        Level3 level3 = new Level3();
        level3.start(wizard);
        Display.continuee();
        Level4 level4 = new Level4();
        level4.start(wizard);
        Display.continuee();
        Level5 level5 = new Level5();
        level5.start(wizard);
        Display.continuee();
        Level6 level6 = new Level6();
        level6.initStart(wizard);
        Display.continuee();
        Level7 level7 = new Level7();
        level7.start(wizard);

        System.out.println("Congratulations, you've finished the Harry Potter Game!");
    }

    public static void startGame() {
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hogwarts ! What's your name ?");
        String playerName = WindowTalk.askForString("Welcome to Hogwarts ! What's your name ? ");

        //gives the player a house
        Display.space();
        WindowTalk.printInWindow("Welcome to Hogwarts " + playerName + ".\nThe hat is choosing the best house for you ...");
        WindowTalk.nextButton.setOnAction(event -> {
            SortingHat sortingHat = new SortingHat();
            House playerHouse = sortingHat.chooseHouse();
            Display.space();

            //create a random main_pack.Wand
            Wand wizardWand = createRandomWand();
            Pet wizardPet = chooseRandomPet();

            wizard = new Wizard(playerName, wizardPet, wizardWand, playerHouse, null, null, 100, 10);

            Display.space();
            System.out.println("Welcome to Hogwarts " + playerName + ".\n 🎩 : You're officially part of the house " + playerHouse.getName() + " !");
            Display.space();
            System.out.println("\u001B[34mYour coefficients are as follows : \nPotion : " + playerHouse.getPotionEff() + " | Spell eff : " + playerHouse.getSpellEff() + " | Resistance : " + playerHouse.getResistanceEff() + " | Precision : " + playerHouse.getPrecisionEff() + "\u001B[0m");
            Display.space();
            System.out.println("You got a " + wizardPet.display() + " as a pet!");
            System.out.println("The perfect wand has chosen you !    ||  🪄|size : " + wizard.getWand().getSize() + "  | core : " + wizard.getWand().getCore() + " 🔥");
            Display.separator();
            WindowTalk.printInWindow("Welcome to Hogwarts " + playerName + ".\n 🎩 : You're officially part of the house " + playerHouse.getName()
                    + " !  \nYour coefficients are as follows : \nPotion : " + playerHouse.getPotionEff() + " | Spell eff : " + playerHouse.getSpellEff()
                    + " | Resistance : " + playerHouse.getResistanceEff() + " | Precision : " + playerHouse.getPrecisionEff()+"\n You RANDOMLY got a "
                    + wizardPet.display() + " as a pet!" + "\nThe perfect wand has chosen you !    || |size : " + wizard.getWand().getSize()
                    + "  | core : " + wizard.getWand().getCore() + " \uD83D\uDD25\"");
            WindowTalk.nextButton.setOnAction(event1 -> {
                Display.doYouStart();
                //Display.separator();
                System.out.println("The game has started");
                WindowTalk.printInWindow("The game has started");
                WindowTalk.nextButton.setOnAction(event2 -> {
                    Level1 level1 = new Level1();
                    level1.start(wizard);
                });
            });
        });

    }

    public static Wand createRandomWand() {
        Random random = new Random();
        Core core = Core.values()[random.nextInt(Core.values().length)];
        int size = random.nextInt(32) + 22;
        return new Wand(core, size);
    }

    public static Pet chooseRandomPet() {
        Random random = new Random();
        int index = random.nextInt(Pet.values().length);
        return Pet.values()[index];
    }


}
