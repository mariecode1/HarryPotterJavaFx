package fr.marie.harrypotterjavafx.levels;

import java.util.List;
import java.util.Scanner;

import org.example.console.Display;
import org.example.main_pack.*;
public class Level6 {
    private Wizard wizard;
    private boolean isSlytherin;

    public Level6() {
    }

    public void initStart(Wizard wizard) {
        Display.fullSeparator();
        System.out.println("Level 6 \n");
        Display.space();
        Display.text("The Half-Blood Prince \n");
        Display.text("The Death Eaters attack Hogwarts. \n"+
                "Are you ready to defend yourself? You must attack them (Sectumsempra). \n" +
                "If you are from Slytherin, you can decide to join the ranks of the\n" +
                "Death Eaters\n");
        Display.space();

        //defining the enemy
        Enemy enemy=new Enemy("The Death Eaters", 100, 30);
        //add the Sectumsempra spell to the list
        List<Spell> spellList=wizard.getKnownSpells();
        Spell sectumsempra = new Spell("Sectumsempra", 6, 35);
        spellList.add(sectumsempra);
        wizard.setKnownSpells(spellList);
        boolean isSlytherin = wizard.getHouse().getName().equals("Slytherin");

        //is Slytherin
        if (isSlytherin) {
            System.out.println("Would you like to join the ranks of the Death Eaters (y/n) ?");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();

            // Check the player's answer
            if (answer.equals("y")) {
                System.out.println("You chose to join the ranks of the Death Eaters!");
            } else if (answer.equals("n")) {
                System.out.println("You chose to defend Hogwarts!");
                start(wizard,enemy);
            }
        } else {
            System.out.println("You must defend Hogwarts !");
            start(wizard,enemy);
        }
    }
    public void start(Wizard wizard, Enemy enemy){
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
                initStart(wizard);
            }
            else if (choice==2) {
                System.exit(0);
            }
        }
        if (enemy.getLife() <= 0){
            System.out.println("Congratulations, you have defeated The Death Eaters ! 🎇");
            System.out.println("You can now access the next level.");
            wizard.setLife(100);
            Shop.earnMoney(wizard, 20);
            Shop.enterShop(wizard);
        }
    }
}