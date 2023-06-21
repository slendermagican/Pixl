package com.example.pixlphotoeditingsoftware;

import javafx.application.*;
import javafx.concurrent.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import java.util.*;

public class PixlSoftware extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(PixlSoftware.class.getResource("LoaderFXML.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED); // remove the minimize, maximize and close button

        // Create a StackPane to hold the ProgressBar and progressLabel
        Scene scene = new Scene(fxmlLoader.load(), 700, 320);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("Loading...");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setScene(scene);

        //setting the logo
        Image logoImage = new Image(getClass().getResource("logoForProgram.png").toExternalForm());
        primaryStage.getIcons().add(logoImage);

        primaryStage.show();

        // opening the fxml in this method to change some style
        LoaderController load = fxmlLoader.getController();
        // customizing the progressbar
        load.progress.getStyleClass().add("progressBar");
        load.progressLabel.setStyle("-fx-font-weight: bold;");

        // Simulate a task that takes some time to complete
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                // Perform your task here...
                int randomNumberTask = 1;
                for (int i = 0; i <= 100; i += randomNumberTask) {
                    // Update the progress of the task
                    randomNumberTask = new Random().nextInt(1, 4);
                    updateProgress(i, 100);
                    updateMessage(i + "%"); // Update the progress label
                    Thread.sleep(40);
                }
                return null;
            }
        };

        // Bind the ProgressBar's progress to the task's progress
        load.progress.progressProperty().bind(task.progressProperty());

        // Bind the Label's text to the task's message
        load.progressLabel.textProperty().bind(task.messageProperty());

        // Open another window after the task is complete
        task.setOnSucceeded(event -> {
            try {
                openNewWindow();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            primaryStage.close();
        });

        // Start the task
        new Thread(task).start();
    }

    // code for opening a new window (LogIn Form)
    private void openNewWindow() throws Exception {

        Stage primaryStage = new Stage();

        // setting the min width and height for the Stage
        primaryStage.setMinWidth(850);
        primaryStage.setMinHeight(450);

        // name of the Stage
        primaryStage.setTitle("LogIn Form");

        FXMLLoader fxmlLoader = new FXMLLoader(PixlSoftware.class.getResource("LogInFXML.fxml"));
        Parent root = fxmlLoader.load();

        LogInController load = fxmlLoader.getController();

        // log in pane background image
        String backgroundImage = getClass().getResource("backgroundForLogInPane.jpg").toExternalForm();
        load.logInPane.setStyle(
                "-fx-background-image: url('" + backgroundImage + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;"
        );

        // right log in pane background image
        String rightLogInImageString = getClass().getResource("backgroundForSignUpPaneInLogIn.png").toExternalForm();
        load.rightLogInImage.setStyle(
                "-fx-background-image: url('" + rightLogInImageString + "');"+
                "-fx-background-repeat: no-repeat;"+
                "-fx-background-size: cover;"
        );

        Scene scene = new Scene(root, primaryStage.getMinWidth(), primaryStage.getMinHeight());
        primaryStage.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Setting the logo for the Login form
        Image logoImage = new Image(getClass().getResource("logoForProgram.png").toExternalForm());
        primaryStage.getIcons().add(logoImage);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
