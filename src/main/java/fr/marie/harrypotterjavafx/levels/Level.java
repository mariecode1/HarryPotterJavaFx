package fr.marie.harrypotterjavafx.levels;

import fr.marie.harrypotterjavafx.console.Display;
import fr.marie.harrypotterjavafx.interfaceFx.vue.WindowTalk;
import fr.marie.harrypotterjavafx.main_pack.*;

import java.util.Scanner;

public class Level {
    public int tryAgain() {
        //Scanner scanner=new Scanner(System.in);
        //Display.fullSeparator();
        //float answer=0;
        //do{
        //    System.out.println("Do you want to try again ?");
        //    System.out.println("1- Yes   ||    2- No, exit");
        //    answer =scanner.nextInt();
        //}while (answer!=1 && answer!=2);
        //Display.fullSeparator();
        float answer = WindowTalk.askForInt("Do you want to try again ?" + "\n\n1- Yes\n2- No, exit", 1, 2);
        if (answer == 1) {
            return 1;
        } else if (answer == 2) {
            return 0;
        } else {
            return 0;
        }

    }
}
