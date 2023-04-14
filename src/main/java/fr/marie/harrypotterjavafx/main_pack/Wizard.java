package fr.marie.harrypotterjavafx.main_pack;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import fr.marie.harrypotterjavafx.console.Display;

public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private List<Spell> knownSpells ;
    private List<Potion> potions;
    private float money;


    public Wizard(String name, Pet pet, Wand wand, House house,List<Spell> knownSpells, List<Potion> potions,float life, float money) {
        super(name,100);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.money=money;
    }

    //Getters
    public Pet getPet() {
        return pet;
    }
    public Wand getWand() {
        return wand;
    }
    public House getHouse() {
        return house;
    }
    public List<Spell> getKnownSpells() {
        return knownSpells;
    }
    public List<Potion> getPotions() {
        return potions;
    }
    public float getMoney() {return money;}


    //Setters
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void setWand(Wand wand) {
        this.wand = wand;
    }
    public void setHouse(House house) {
        this.house = house;
    }
    public void setKnownSpells(List<Spell> knownSpells) {
        this.knownSpells = knownSpells;
    }
    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }
    public void setMoney(float money){this.money=money;}

    //Methods
    public void act(Wizard wizard,AbstractEnemy enemy){
        Scanner scanner=new Scanner(System.in);
        float answer=0;
        while (answer!=1 && answer!=2){
            Display.space();
            System.out.println("What do you want to use?");
            System.out.println("1- Spell   ||    2- Potion");
            answer =scanner.nextInt();
            if (answer==1){
                attack(wizard,enemy);
            }
            else if (answer==2){
                Potion.choosePotion(wizard);
            }
        }

    }
    public void attack(Wizard wizard, AbstractEnemy enemy) {
        System.out.println("Choose a spell from the list");
        int i=1;
        List<Spell> spells=wizard.getKnownSpells();
        Display.space();
        for (Spell spell : spells) {
            System.out.println(i+"- Name: " + spell.getSpellName() + ", Effect: " + spell.getEffectiveness() );
            i++;
        }
        int index=0;

        do {
            System.out.println("Enter a number between 1 and " + spells.size());
            Scanner scanner = new Scanner(System.in);
            index = scanner.nextInt();
        } while (index< 1 || index>spells.size());

        if (index<=spells.size() && index>0){
            Spell spell=spells.get(index-1);
            System.out.println("You attack "+ enemy.getName()+" with the spell "+ spell.getSpellName());
            float damage = (float)(spell.getEffectiveness()* wizard.getHouse().getSpellEff() * wizard.getHouse().getPrecisionEff());
            System.out.println("inflicts " + damage + " damage points.");
            enemy.setLife(enemy.getLife() - damage);
            Display.space();
            System.out.println("\033[38;2;255;165;0m"+enemy.getName() +" : "+ (int)(enemy.getLife()) +" HP | 🧟‍♂️☢️\033[0m");
        }

    }

    public float defend(Wizard wizard) {
        //when the wizard defends himself, his resistance rises so the damage will go down
        //this methods return a resistance value that will correspond to the temporary resistance of the wizard
        //while he is defending himself
        float resistance=wizard.getHouse().getResistanceEff() *2 ;
        System.out.println("\033[32mYou defended yourself 🧫!\033[0m");
        return (resistance);
    }


}

