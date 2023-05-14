package fr.marie.harrypotterjavafx.interfaceFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fr.marie.harrypotterjavafx.interfaceFx.vue.StartVue;
import fr.marie.harrypotterjavafx.interfaceFx.vue.StartController;


import java.io.IOException;

public class HelloApplication extends Application {
    private Stage stage;


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        showStartScene();
    }

    public void showStartScene() {
        StartVue startVue = new StartVue();
        StartController startController = new StartController(startVue, this);
        Scene scene = new Scene(startVue, 800, 600);
        stage.setTitle("Harry Potter Game");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}