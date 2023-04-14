package fr.marie.harrypotterjavafx.console;

import fr.marie.harrypotterjavafx.levels.*;
import fr.marie.harrypotterjavafx.main_pack.*;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Wizard wizard= Main.startGame();
        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();
        Level4 level4 = new Level4();
        Level5 level5 = new Level5();
        Level6 level6 = new Level6();
        Level7 level7 = new Level7();
        level1.start(wizard);
        Display.continuee();
        level2.start(wizard);
        Display.continuee();
        level3.start(wizard);
        Display.continuee();
        level4.start(wizard);
        Display.continuee();
        level5.start(wizard);
        Display.continuee();
        level6.initStart(wizard);
        Display.continuee();
        level7.start(wizard);

        System.out.println("Congratulations, you've finished the Harry Potter Game!");
    }

    public static Wizard startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Hogwarts ! What's your name ? ");
        String playerName = scanner.nextLine();

        //gives the player a house
        Display.space();
        Display.text("The hat is choosing the best house for you ... ");
        SortingHat sortingHat = new SortingHat();
        House playerHouse = sortingHat.chooseHouse();
        Display.space();

        //create a random main_pack.Wand
        Wand wizardWand = createRandomWand();
        Pet wizardPet =chooseRandomPet();

        Wizard playerWizard = new Wizard(playerName, wizardPet, wizardWand, playerHouse,null,null,100,10);

        Display.space();
        System.out.println("Welcome to Hogwarts " + playerName + ".\n 🎩 : You're officially part of the house " + playerHouse.getName() + " !");
        Display.space();
        System.out.println("\u001B[34mYour coefficients are as follows : \nPotion : "+ playerHouse.getPotionEff()+" | Spell eff : "+playerHouse.getSpellEff()+" | Resistance : "+playerHouse.getResistanceEff()+" | Precision : "+playerHouse.getPrecisionEff() +"\u001B[0m");
        Display.space();
        System.out.println("You got a " + wizardPet.display() + " as a pet!");
        System.out.println("The perfect wand has chosen you !    ||  🪄|size : "+ playerWizard.getWand().getSize()+ "  | core : "+ playerWizard.getWand().getCore()+ " 🔥");
        Display.separator();
        Display.doYouStart();
        Display.separator();
        System.out.println ("The game has started");

        return(playerWizard);
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
