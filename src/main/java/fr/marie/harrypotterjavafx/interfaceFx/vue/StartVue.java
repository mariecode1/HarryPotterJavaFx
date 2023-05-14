package fr.marie.harrypotterjavafx.interfaceFx.vue;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StartVue extends VBox {
    Label titleLabel = new Label("WELCOME to Harry Potter Game");
    Button startButton = new Button("Start Game");

    public StartVue() {
        titleLabel.getStyleClass().add("title");
        startButton.getStyleClass().add("btn");
        this.getChildren().addAll(titleLabel, startButton);
    }


}

