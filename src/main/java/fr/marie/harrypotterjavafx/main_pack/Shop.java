package fr.marie.harrypotterjavafx.main_pack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fr.marie.harrypotterjavafx.console.Display;

//This class gives access to the shop so the player can shop potions.
public class Shop {
    public static int buyPotion(Wizard wizard, int index, List<Potion> potions) {
        List<Potion> wizardPotion = wizard.getPotions();
        Potion potion = potions.get(index-1);
        if (potion.getPrice() <= wizard.getMoney()) {
            wizardPotion.add(potion);
            wizard.setPotions(wizardPotion);
            wizard.setMoney(wizard.getMoney()-potion.getPrice());
            System.out.println("You bought a " + potion.getName() + " for " + potion.getPrice()+ "🪙");
            System.out.println("🧙‍♀️ \033[34mYou have : " + wizard.getMoney() + " \033[0m🪙" );
        }
        else if (potion.getPrice() > wizard.getMoney()) {
            System.out.println("You don't have enough money\n");
            System.out.println("🧙‍♀️ \033[34mYou have : " + wizard.getMoney() + " \033[0m🪙" );
        }
        Display.separator();
        System.out.println("Do you want to shop another potion ?");
        System.out.println("Yes |1  or   No |2");
        Scanner scanner = new Scanner(System.in);
        int answer= scanner.nextInt();
        return(answer);
    }

    public static void showPotions(Wizard wizard){
        Display.space();
        System.out.println("\u001B[34mYou have these potions in your bag");
        int i=1;
        List<Potion> potions=wizard.getPotions();
        for (Potion potion : potions) {
            System.out.println("\u001B[34m"+ i+"- Name: " + potion.getName() + ", Effect: " + potion.getEffect()+"\u001B[0m" );
            i++;
        }
        Display.space();
    }
    public static List<Potion> listPotions() {
        //this method lists all the potions in the shop
        List<Potion> potions = new ArrayList<>();
        Potion HEALER= new Potion("Healing Potion", 10.0f, "Increases your life points", 10.0f);
        Potion STRENGTH=new Potion("Strength Potion", 15.0f, "Increases Strength", 10.0f);
        Potion INVISIBILITY= new Potion("Invisibility Potion", 20.0f, "Makes Invisible", 20.0f);
        potions.add(HEALER);
        potions.add(STRENGTH);
        potions.add(INVISIBILITY);
        int i=1;
        for (Potion potion : potions) {
            System.out.println(i+"- Name: " + potion.getName() + " || Impact: " + potion.getImpact() + " || Effect: " + potion.getEffect() + " || Price: " + potion.getPrice()+" 🪙");
            i++;
        }
        Display.space();
        return(potions);
    }

    public static void enterShop(Wizard wizard){
        //asks either you want to go to the shop or not
        System.out.println("Good job "+wizard.getName()+ ".");
        showPotions(wizard);
        System.out.println("Would you like to go shopping some potions ?");
        System.out.println("Yes |1  or   No |2");
        Scanner scanner = new Scanner(System.in);
        int answer= scanner.nextInt();
        if (answer==1){
            shopping(wizard);
        }
    }
    public static void shopping(Wizard wizard){
        //To list and shop a potion
        Display.fullSeparator();
        System.out.println("Welcome to the Diagon Alley");
        System.out.println("🧙‍♀️ \033[34mYou have : " + wizard.getMoney() + " \033[0m🪙" );
        Display.separator();
        List<Potion> potions=listPotions();
        int answer=1;
        while (answer==1) {
            System.out.println("Which potion would you like to buy?");
            System.out.println("Enter the potion number\n"+"");
            Scanner scanner = new Scanner(System.in);
            int index = 0;
            while (index > potions.size() || index < 1) {
                System.out.println("Please, enter a number from 1 to 3");
                index = scanner.nextInt();
            }
            answer=buyPotion(wizard, index, potions);
        }
        System.out.println("Ok "+ wizard.getName()+ ", let's go back to the game ! " );
    }

    public static void earnMoney(Wizard wizard, float amount){
        wizard.setMoney(wizard.getMoney()+ amount);
        System.out.println("\033[32mYou earned " + amount + "🪙\033[0m");
        System.out.println("🧙‍♀️ \033[34mYou have : " + wizard.getMoney() + " \033[0m🪙" );
        Display.space();
    }
}