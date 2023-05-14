package fr.marie.harrypotterjavafx.interfaceFx.vue;

import fr.marie.harrypotterjavafx.main_pack.Wizard ;
import fr.marie.harrypotterjavafx.main_pack.Enemy ;
import fr.marie.harrypotterjavafx.levels.Level1 ;
import fr.marie.harrypotterjavafx.interfaceFx.HelloApplication ;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import fr.marie.harrypotterjavafx.console.Main;

import java.util.Objects;


public class StartController {

    private Stage stage;
    private StartVue startVue;
    private HelloApplication helloApplication;


    public StartController(StartVue startVue, HelloApplication helloApplication) {
        this.startVue = startVue;
        //this.startVue.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        this.startVue.startButton.setOnAction(this::onPlayAction);
    }

    public void onPlayAction(ActionEvent e) {
        Main.startGame();
    }
}
