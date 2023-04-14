package fr.marie.harrypotterjavafx.levels;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import org.example.console.Display;
import org.example.main_pack.*;
public class Level7 {

    public Level7() {
    }

    public void start(Wizard wizard) {
        Display.fullSeparator();
        System.out.println("Level 7 \n");
        Display.space();
        Display.text("The Deathly Hallows \n");
        Display.text("You are at Poudlard\n");
        Display.text("No more procrastination, we must attack the problem at the source. \n" +
                "You are facing Voldemort and Bellatrix Lestrange. \n" +
                "Be careful, they can kill you in one fell swoop with Avada Kedavra if you are not ready.");
        Display.space();

        //defining the enemy
        Boss voldemort =new Boss("Lord Voldemort", 100, 40);
        Boss lestrange =new Boss("Bellatrix Lestrange", 100, 25);
        List<AbstractEnemy> enemies =new ArrayList<>();
        enemies.add(voldemort);
        enemies.add(lestrange);


        while (voldemort.getLife()>0 && lestrange.getLife()>0 && wizard.getLife()>0) {
            Display.space();
            System.out.println("Who do you want to attack ?");
            System.out.println("1- " + voldemort.getName() + "    |   2- " + lestrange.getName());
            int choice = 0;
            while (choice != 1 && choice != 2) {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            }
            if (choice == 1) {
                wizard.attack(wizard, voldemort);
                voldemort.attack1(wizard, voldemort);
            } else if (choice == 2) {
                wizard.attack(wizard, lestrange);
                lestrange.attack1(wizard, lestrange);
            }
        }
        if (voldemort.getLife() <= 0) {
            do {
                System.out.println("You got this ! You have defeated Lord Voldemort 🦹‍♂️");
                System.out.println("It remains that to overcome Beatrix Lestrange 🐀");
                wizard.attack(wizard, lestrange);
                lestrange.attack(wizard, lestrange);
            } while (lestrange.getLife() > 0);
        }
        else if (lestrange.getLife()<=0) {
            do{
                Display.space();
                System.out.println("You got this ! You have defeated Beatrix Lestrange 🐀");
                System.out.println("It remains that to overcome Lord Voldemort 🦹‍♂️");
                wizard.attack(wizard,voldemort);
                voldemort.attack(wizard,voldemort);
            }while (voldemort.getLife()>0);
        }
        // Fin du niveau
        if (wizard.getLife() <= 0) {
            System.out.println("Voldemort and Bellatrix Lestrange have defeated you! Game-over. ☠️");
            Level level = new Level();
            int choice=level.tryAgain();
            if (choice==1){
                wizard.setLife(100);
                start(wizard);
            }
            else if (choice==2) {
                System.exit(0);
            }
        }
        if (voldemort.getLife() <= 0 && lestrange.getLife() <=0){
            Display.fullSeparator();
            System.out.println("Congratulations, you have defeated Voldemort and Beatrix Lestrange! 🎇");
            Display.space();
            System.out.println("You WON the HARRY POTTER GAME !!!!️");
            wizard.setLife(100);
            Display.fullSeparator();
        }
    }
}