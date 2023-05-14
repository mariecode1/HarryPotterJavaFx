package fr.marie.harrypotterjavafx.interfaceFx.vue;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NameVue extends VBox {

    TextField name = new TextField("Enter your name");
    Button check = new Button("OK");

    public NameVue() {
        name.getStyleClass().add("name");
        check.getStyleClass().add("check");
        this.getChildren().addAll(name, check);
    }
}
