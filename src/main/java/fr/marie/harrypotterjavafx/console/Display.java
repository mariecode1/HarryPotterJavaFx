package fr.marie.harrypotterjavafx.console;

import fr.marie.harrypotterjavafx.interfaceFx.vue.WindowTalk;

import java.util.Scanner;

public class Display {

    public static void separator(){
        System.out.println("\n======================================================================================\n");
    }
    public static void space(){
        System.out.println("");
    }

    public static void fullSeparator(){
        space();
        separator();
        space();
    }

    public static void doYouStart(){
        //Scanner scanner=new Scanner(System.in);
        //float answer=0;
        //while (answer!=1 && answer!=2){
        //    System.out.println("Are you ready to start the adventure ?");
        //    System.out.println("1- Yes   ||    2- Exit");
        //    answer =scanner.nextInt();
        //}
        float answer = WindowTalk.askForInt("Are you ready to start the adventure ?\n1- Yes\n2- Exit",1,2);
        if (answer==1){
            return;
        }
        else if (answer==2){
            System.exit(0);
        }
    }

    public static void continuee(){
        Scanner scanner=new Scanner(System.in);
        Display.fullSeparator();
        float answer=0;
        while (answer!=1 && answer!=2){
            System.out.println("Do you want to do ?");
            System.out.println("1- Continue   ||    2- Exit");
            answer =scanner.nextInt();
        }
        if (answer==1){
            return;
        }
        else if (answer==2){
            System.exit(0);
            System.out.println("See you soon !");
        }
        Display.fullSeparator();
    }

    public static void text(String texte){
        String[] mots = texte.split(" "); // Divise le texte en un tableau de mots séparés par un espace

        for (String mot : mots) { // Parcours chaque mot dans le tableau
            System.out.print(mot + " "); // Affiche le mot suivi d'un espace
            try {
                Thread.sleep(0); // Met le thread en pause pendant une seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void delay(){
        //
        try {
            Thread.sleep(300); // Met le thread en pause pendant une seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
