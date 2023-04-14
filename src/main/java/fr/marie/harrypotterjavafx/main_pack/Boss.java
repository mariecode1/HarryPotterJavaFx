package fr.marie.harrypotterjavafx.main_pack;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.console.Display;
public class Boss extends AbstractEnemy{

    public Boss(String name, float life, float power){
        super(name,life,power);
    }


    ForbiddenSpell avadaKedavra=new ForbiddenSpell("AVADA KEDAVRA", 0, 200,"This spell instantly kills any living thing it is used on.");
    //ForbiddenSpell cruciatus=new ForbiddenSpell("CRUSIATUS", 0, 50,"This spell is used to inflict unbearable pain and suffering on its victims.");

    public void attack1(Wizard wizard, Boss enemy){
        if (enemy.getLife()>0){
            Display.space();
            System.out.println("\033[32m"+"WARNING : "+ enemy.getName()+ " is attacking\033[0m");
            Display.space();
            System.out.println("To defend yourself, press D");
            Display.space();
            //when the wizard defends himself, his resistance rises so the damage will go down
            Scanner scanner=new Scanner(System.in);
            String answer ="E";
            answer =scanner.next();
            float resistance=0;
            if (answer.equals("D")){
                resistance=1;
            }
            else {
                resistance=0;
            }
            float percentage = (float)(Math.random());
            //we have 20% chance of using AvadaKedavra
            if (percentage<0.2){
                wizard.setLife(-1);
                System.out.println("Oh no ! "+ enemy.getName()+ "is using AvadaKedavra");
                System.out.println(avadaKedavra.getDescription());
                Display.space();
                if (resistance==1){
                    wizard.setLife(wizard.getLife()-20);
                    System.out.println("omg You almost died");
                    Display.space();
                    System.out.println("\033[31mYou got : "+ -20 + "damage points\033[0m ");
                    System.out.println("\033[31mYou : "+ wizard.getLife() +" | 🧙‍♀️❤️\033[0m ️");
                }

            }
            else if (percentage>=0.2){
                enemy.attack(wizard,enemy);
            }
        }
    }
}

