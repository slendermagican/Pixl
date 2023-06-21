package com.example.pixlphotoeditingsoftware;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpController {


    @FXML
    BorderPane signUpBorderPane;
    @FXML
    VBox signUpPane;

    @FXML
    Label backToLogIn;

    @FXML
    Button signUpButton;

    @FXML
    TextField EmailField;

    @FXML
    PasswordField passWordField;

    @FXML
    Label lblEmail;

    @FXML
    Label lblPass;



    /* @FXML
    protected void openNewWindow() throws Exception {
        Stage primaryStage = new Stage();

        //setting the min width and height for the SignUp Form
        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(500);

        // name of the Stage
        primaryStage.setTitle("Pixl");

        FXMLLoader fxmlLoader = new FXMLLoader(PixlSoftware.class.getResource("SignUpFXML.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, primaryStage.getMinWidth(), primaryStage.getMinHeight());
        primaryStage.setScene(scene);
        primaryStage.show();

        //setting the logo for Login form
        Image logoImage = new Image(getClass().getResource("logoForProgram.png").toExternalForm());
        primaryStage.getIcons().add(logoImage);
    }*/

    @FXML
    private void openLogInForm() throws Exception {

        ((Stage) backToLogIn.getScene().getWindow()).close();

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
                "-fx-background-image: url('" + rightLogInImageString + "');" +
                "-fx-background-repeat: no-repeat;" +
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

    @FXML
    private void RegisterButton() throws Exception {

        String email = EmailField.getText();
        String pass = passWordField.getText();

        if (email.isEmpty() || pass.isEmpty()){
            lblEmail.setText("Wrong email");
            lblPass.setText("Wrong password");

        }else{
            try{
                FileWriter fw1 = new FileWriter("D:\\Programing\\Java\\Projects Java\\PixlPhotoEditingSoftware\\src\\main\\resources\\com\\example\\pixlphotoeditingsoftware\\Users.txt", true);
                fw1.write(email+" ");
                fw1.write(pass+"\n");
                fw1.close();

                ((Stage) signUpButton.getScene().getWindow()).close();

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
                        "-fx-background-image: url('" + rightLogInImageString + "');" +
                                "-fx-background-repeat: no-repeat;" +
                                "-fx-background-size: cover;"
                );

                Scene scene = new Scene(root, primaryStage.getMinWidth(), primaryStage.getMinHeight());
                primaryStage.setScene(scene);
                primaryStage.setScene(scene);
                primaryStage.show();

                // Setting the logo for the Login form
                Image logoImage = new Image(getClass().getResource("logoForProgram.png").toExternalForm());
                primaryStage.getIcons().add(logoImage);

                //Write in users file
                String username = EmailField.getText();
                String password = passWordField.getText();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }
}
