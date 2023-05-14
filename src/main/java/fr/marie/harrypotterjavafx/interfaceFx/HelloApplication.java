package fr.marie.harrypotterjavafx.interfaceFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HelloApplication extends Application {
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("HarryPotterGame.fxml"));
        Scene scene0 = new Scene(fxmlLoader.load(), 1300, 600);
        primaryStage.setTitle("Harry Potter Game");
        primaryStage.setScene(scene0);
        primaryStage.show();

        //Scene
        Label label0= new Label("Welcome to the Harry Potter Game");
        Button buttonStart= new Button("Would you like to start the game ?");
        buttonStart.setOnAction(e -> primaryStage.setScene(scene1));
        VBox layout0 = new VBox(20);
        layout0.getChildren().addAll(label0, buttonStart);
        scene1= new Scene(layout0, 600, 500);

        //Scene 1
        Label label1= new Label("This is the first scene");
        Button button1= new Button("Go to scene 2");
        button1.setOnAction(e -> primaryStage.setScene(scene2));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1= new Scene(layout1, 600, 500);

        //Scene 2
        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to scene 1");
        button2.setOnAction(e -> primaryStage.setScene(scene1));
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        scene2= new Scene(layout2,300,250);

        primaryStage.setScene(scene0);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}