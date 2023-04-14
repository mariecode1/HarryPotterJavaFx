package fr.marie.harrypotterjavafx.levels;
import java.util.Scanner;

import org.example.console.Display;
import org.example.main_pack.*;

public class Level5 {

    public void start(Wizard wizard) {
        Display.fullSeparator();
        System.out.println("Level 5 \n");
        Display.space();
        Display.text("The Order of the Phoenix \n");
        Display.text("You are in the Hogwarts Exam Room\n");
        Display.text("It's time for the BUSE (Universal Patent of Elementary Witchcraft)! \n" +
                "Dolores Ombrage 🦹‍♀️ watches over the grain 🌰.\n"+
                "Your goal is to distract her until the fireworks are ready to be used.\n");

        //defining the enemy
        Enemy enemy =new Enemy("Dolores Ombrage", 100, 25);

        while (enemy.getLife()>0 && wizard.getLife()>0) {
            wizard.act(wizard,enemy);
            enemy.attack(wizard,enemy);
        }
        // Fin du niveau
        if (wizard.getLife() <= 0) {
            System.out.println(enemy.getName()+" have defeated you! Game-over. ☠️");
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
        if (enemy.getLife() <= 0){
            System.out.println("Congratulations, you have defeated Dolores Ombrage ! 🎇");
            System.out.println("You can now access the next level.");
            wizard.setLife(100);
            Shop.earnMoney(wizard, 20);
            Shop.enterShop(wizard);
        }
    }
}