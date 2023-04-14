package fr.marie.harrypotterjavafx.main_pack;
import org.example.console.Display;
import java.util.Scanner;

public abstract class AbstractEnemy extends Character{
    private float power;
    //the power corresponds to the default hit points per attack

    public AbstractEnemy(String name, float life, float power){
        super(name,life);
        this.power=power;
    }

    public float getPower() {
        return power;
    }
    public void setPower(float power) {
        this.power = power;
    }

    public void attack(Wizard wizard, AbstractEnemy enemy){
        if (enemy.getLife()>0){
            System.out.println(enemy.getName()+ " is attacking 💥");
            System.out.println("To defend yourself, press D");
            //when the wizard defends himself, his resistance rises so the damage will go down
            Scanner scanner=new Scanner(System.in);
            String answer ="E";
            answer =scanner.next();
            float resistance=wizard.getHouse().getResistanceEff();
            if (answer.equals("D")){
                resistance=wizard.defend(wizard);
            }
            else {
                resistance=resistance;
            }
            float intensity = (float)(Math.random());  //float between 0 and 1
            float enemyDamage= (enemy.getPower()*intensity)/resistance;
            wizard.setLife(wizard.getLife()- enemyDamage);
            Display.delay();
            System.out.println("\033[31mYou got : "+(int)(enemyDamage) + " damage points\033[0m ");
            Display.delay();
            System.out.println("\033[31mYou : "+ (int)(wizard.getLife()) +" HP | 🧙‍♀️❤️\033[0m ️");
        }
    }
}