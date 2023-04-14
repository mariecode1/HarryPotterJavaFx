package fr.marie.harrypotterjavafx.levels;

import java.util.List;
import fr.marie.harrypotterjavafx.console.Display;
import fr.marie.harrypotterjavafx.main_pack.*;
public class Level2 {

    public void start(Wizard wizard) {
        Display.fullSeparator();
        System.out.println("Level 2 \n");
        Display.text("You are in The Chamber of Secrets\n");
        Display.text("You are facing the terrible basilisk\n");
        Display.space();
        List<Spell> spellList=wizard.getKnownSpells();
        Spell accio = new Spell("Accio", 2, 30);
        spellList.add(accio);
        wizard.setKnownSpells(spellList);
        Enemy enemy=new Enemy("The basilisk", 100, 25);
        boolean isGryffindor = wizard.getHouse().getName().equals("Gryffindor");

        if (isGryffindor) {
            System.out.println("During this level, you can call on  \033[38;2;255;165;0mThe legendary sword of Godric Gryffindor\033[0m to defeat the basilisk.");
            List<Spell> spellList1=wizard.getKnownSpells();
            Spell sword = new Spell("The legendary sword of Godric Gryffindor", 2, 75);
            spellList1.add(sword);
            wizard.setKnownSpells(spellList1);
        } else {
            Display.text("You'll have to rip one of his fangs out and use it to destroy Tom Riddle's journal");
        }

        while (enemy.getLife()>0 && wizard.getLife()>0) {
            wizard.act(wizard,enemy);
            enemy.attack(wizard,enemy);
            Display.fullSeparator();
        }
        // Fin du niveau
        if (wizard.getLife() <= 0) {
            System.out.println("The BASILISK has defeated you! Game-over. ☠️");
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
            System.out.println("Congratulations, you have defeated the basilisk! 🎇");
            System.out.println("You can now access the next level.");
            wizard.setLife(100);
            Shop.earnMoney(wizard, 20);
            Shop.enterShop(wizard);
        }
    }

}