package fr.marie.harrypotterjavafx.main_pack;

import fr.marie.harrypotterjavafx.console.Display;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Potion {
    private String name;
    private float impact;
    private String effect;
    private float price;

    public Potion(String name, float impact, String effect, float price){
        this.name=name;
        this.impact=impact;
        this.effect=effect;
        this.price=price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getImpact() {
        return impact;
    }
    public void setImpact(float impact) {
        this.impact = impact;
    }
    public String getEffect(){
        return effect;
    }
    public void setEffect(String effect){
        this.effect=effect;
    }
    public float getPrice() {return price;}
    public void setPrice(float price){this.price=price;}

    public static void choosePotion(Wizard wizard){
        System.out.println("Choose a spell from the list");
        int i=1;
        List<Potion> potions=wizard.getPotions();
        Display.space();
        for (Potion potion : potions) {
            System.out.println(i+"- Name: " + potion.getName() + "⚗️" );
            i++;
        }
        System.out.println("Enter a number between 1 and "+ potions.size());
        Scanner scanner=new Scanner(System.in);
        int index =scanner.nextInt();
        if (index<potions.size()+1 && index>0) {
            Potion potion = potions.get(index - 1);
            if (potion.getName().equals("Healing Potion")){
                wizard.setLife(wizard.getLife()+20F);
                System.out.println("You choose the Healing Potion");
                System.out.println("You earn \033[31m 20 HP \033[0m");
                Display.space();
                System.out.println("\033[31mYou : "+ wizard.getLife() +" HP | 🧙‍♀️❤️\033[0m ️");
            }
            else if (potion.getName().equals("Strength Potion")){
                System.out.println("You choose the Strength Potion");
                System.out.println("Your resistance is improved by 20%");
                Display.space();
                wizard.getHouse().setResistanceEff(wizard.getHouse().getResistanceEff()+0.1F);
                System.out.println("\033[31mYou : "+ wizard.getLife() +" HP | 🧙‍♀️❤️\033[0m ️");
            }
        }


    }

}