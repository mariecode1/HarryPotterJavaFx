package fr.marie.harrypotterjavafx.levels;

import java.util.List;
import java.util.Scanner;

import fr.marie.harrypotterjavafx.console.Display;
import fr.marie.harrypotterjavafx.main_pack.*;

public class Level3 {
    private Wizard wizard;

    public Level3() {
        this.wizard = wizard;
    }

    public void start(Wizard wizard) {
        Display.fullSeparator();
        System.out.println("Level 3 \n");
        Display.text("The Prisonner of Azkaban \n");
        Display.text("The Dementors are at large. They roam the streets, the countryside. Fortunately, you have\n" +
                "heard about a spell to put them on the run... Expect... Expecta... Oh yes, Expectro Patronum.\n" +
                "Your goal is to learn the spell and then use it to defeat the Dementors.\n");

        //adding a new spell
        List<Spell> spellList=wizard.getKnownSpells();
        Spell expectroPatronum = new Spell("Expectro Patronum", 2, 25);
        spellList.add(expectroPatronum);
        wizard.setKnownSpells(spellList);
        System.out.println("You just learned a new spell : Expectro Patronum\n");
        //defining the enemy
        Enemy enemy =new Enemy("The Dementors", 100, 20);

        while (enemy.getLife()>0 && wizard.getLife()>0) {
            wizard.act(wizard,enemy);
            enemy.attack(wizard,enemy);
            Display.fullSeparator();
        }
        // Fin du niveau
        if (wizard.getLife() <= 0) {
            System.out.println("The dementors have defeated you! Game-over. ☠️");
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
            System.out.println("Congratulations, you have defeated the dementors! 🎇");
            System.out.println("You can now access the next level.");
            wizard.setLife(100);
            Shop.earnMoney(wizard, 20);
            Shop.enterShop(wizard);
        }
    }
}