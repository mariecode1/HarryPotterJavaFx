package fr.marie.harrypotterjavafx.interfaceFx.vue;


import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;

public class WindowTalk {
    public static Stage stagetext = new Stage();

    public static void printInWindow(String text) {
        printInWindow(text, stagetext, 0);
    }

    public static void printInWindow(String text, int delay) {
        printInWindow(text, stagetext, delay);
    }

    public static Button nextButton;
    public static Scene scene;

    public static void printInWindow(String text, Stage stage, int delay) {
        VBox root = new VBox();
        scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        root.getChildren().add(textArea);
        nextButton = new Button("Suivant");
        nextButton.setOnAction(event -> {
            stage.close();
        });
        root.getChildren().add(nextButton);
        VBox.setMargin(nextButton, new Insets(20, 0, 0, 0));
        nextButton.setAlignment(Pos.CENTER);

        stage.show();

        String[] lines = text.split("\n");
        for (String line : lines) {
            if (delay > 0) {
                PauseTransition pause = new PauseTransition(Duration.millis(delay));
                pause.setOnFinished(event -> textArea.appendText(line + "\n"));
                pause.play();
            } else {
                textArea.appendText(line + "\n");
            }
        }
    }

    public static void printInWindow(String text, Stage stage, int delay, String imageUrl) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        root.getChildren().add(textArea);

        ImageView imageperso = new ImageView(new Image(imageUrl));
        //ImageView imageperso2 = new ImageView(new Image(imageUrl2));
        root.getChildren().add(imageperso);
        //root.getChildren().add(imageperso2);

        Button nextButton = new Button("Suivant");
        nextButton.setOnAction(event -> {
            stage.close();
        });
        root.getChildren().add(nextButton);
        VBox.setMargin(nextButton, new Insets(20, 0, 0, 0));
        nextButton.setAlignment(Pos.CENTER);

        stage.show();

        String[] lines = text.split("\n");
        for (String line : lines) {
            if (delay > 0) {
                PauseTransition pause = new PauseTransition(Duration.millis(delay));
                pause.setOnFinished(event -> textArea.appendText(line + "\n"));
                pause.play();
            } else {
                textArea.appendText(line + "\n");
            }
        }
    }

    public static String askForString(String message) {
        String value;

        while (true) {
            TextInputDialog dialog = new TextInputDialog();
            if (!message.isBlank() && !message.isEmpty()) {
                dialog.setHeaderText(message);
            }

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                value = result.get();
                break;
            } else {
                System.out.println("No value entered.");
            }
        }

        return value;
    }

    public static int askForInt(String message, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be lower than max");
        }

        int value;

        while (true) {
            TextInputDialog dialog = new TextInputDialog();
            if (!message.isBlank() && !message.isEmpty()) {
                dialog.setHeaderText(message);
            }

            dialog.setContentText("Saisis un nombre entre " + min + " et " + max + ":");

            Optional<String> result = dialog.showAndWait();

            try {
                value = Integer.parseInt(result.get());
                if (value < min || value > max) {
                    System.out.println("The value must be between " + min + " and " + max + ".");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The value must be a number.");
            } catch (Exception e) {
                return -1;
            }
        }

        return value;
    }

    public static int askForInt(int min, int max) {
        return askForInt("", min, max);
    }

}

