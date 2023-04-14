package fr.marie.harrypotterjavafx.levels;

import java.util.Scanner;

import org.example.console.Display;
import org.example.main_pack.*;
import org.example.main_pack.Object;

public class Level4 {

    public void start(Wizard wizard) {
        Display.fullSeparator();
        System.out.println("Level 4 \n");
        Display.text("The Goblet of Fire \n");
        Display.text("You are in the Little Hangleton Cemetery \n");
        Display.text("Unfortunately, you won the Triwizard Tournament... and the right to die. \n" +
                "You are in a cemetery, where Voldemort and Peter Pettigrew are also located. Your only chance of escape is\n" +
                "to get closer to the Portkey to attract it to you (Accio!). Don't worry, you'll see again\n" +
                "Voldemort."+"\n Voldemort is not able to use his forbidden spells");
        Display.space();

        //defining the enemy
        Enemy voldemort =new Enemy("Lord Voldemort", 100, 40);
        Enemy pettigrew =new Enemy("Peter Pettigrew", 100, 20);
        //the portkey
        Object portkey=new Object("The Portkey",0);

        while (voldemort.getLife()>0 && pettigrew.getLife()>0 && wizard.getLife()>0) {
            Display.space();
            System.out.println("Who do you want to attack ?");
            System.out.println("1- " + voldemort.getName() + "    |   2- " + pettigrew.getName());
            int choice = 0;
            while (choice != 1 && choice != 2) {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            }
            if (choice == 1) {
                wizard.attack(wizard, voldemort);
                voldemort.attack(wizard, voldemort);
            } else if (choice == 2) {
                wizard.attack(wizard, pettigrew);
                pettigrew.attack(wizard, pettigrew);
            }
        }
        if (voldemort.getLife() <= 0) {
            do{
                System.out.println("You got this ! You have defeated Lord Voldemort 🦹‍♂️");
                System.out.println("It remains that to overcome Peter Pettigrew 🐀");
                wizard.attack(wizard, pettigrew);
                pettigrew.attack(wizard, pettigrew);
            } while (pettigrew.getLife() > 0) ;
        }

        else if  (pettigrew.getLife()<=0){
            do{
                System.out.println("You got this ! You have defeated Peter Pettigrew 🐀");
                System.out.println("It remains that to overcome Lord Voldemort 🦹‍♂️");
                wizard.attack(wizard,voldemort);
                voldemort.attack(wizard,voldemort);
            } while  (voldemort.getLife()>0);
        }

        // Fin du niveau
        if (wizard.getLife() <= 0) {
            System.out.println("Voldemort and Peter Pettigrew have defeated you! Game-over. ☠️");
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
        if (voldemort.getLife() <= 0 && pettigrew.getLife() <=0){
            System.out.println("Congratulations, you have defeated Voldemort and Pettigrew! 🎇");
            System.out.println("You can now access the next level.");
            wizard.setLife(100);
            Shop.earnMoney(wizard, 20);
            Shop.enterShop(wizard);
        }
    }
}