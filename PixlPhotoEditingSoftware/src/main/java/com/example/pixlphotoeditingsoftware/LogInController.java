package com.example.pixlphotoeditingsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LogInController {

    @FXML
    BorderPane borderPane;

    @FXML
    VBox logInPane;

    @FXML
    VBox rightLogInImage;

    @FXML
    Button logInButton;

    @FXML
    Button signUpButton;

    @FXML
    TextField EmailField;

    @FXML
    PasswordField passWordField;

    @FXML
    Label lblEmail;

    @FXML
    Label lblPassword;


//    @FXML
//    Label lblMain;



    //code for opening a new window (SignUp Form)
    @FXML
    protected void openNewWindow() throws Exception {

        ((Stage) signUpButton.getScene().getWindow()).close();

        Stage primaryStage = new Stage();

        //setting the min width and height for the SignUp Form
        primaryStage.setMinWidth(850);
        primaryStage.setMinHeight(450);

        // name of the Stage
        primaryStage.setTitle("SignUp Form");

        FXMLLoader fxmlLoader = new FXMLLoader(PixlSoftware.class.getResource("SignUpFXML.fxml"));
        Parent root = fxmlLoader.load();

        SignUpController load = fxmlLoader.getController();

        // log in pane background image
        String backgroundImage = getClass().getResource("backgroundForRegisterPane.png").toExternalForm();
        load.signUpPane.setStyle(
                "-fx-background-image: url('" + backgroundImage + "');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;"
        );

        // you have to click the text field to write something (disabling the auto-focus)
        load.EmailField.setFocusTraversable(false);
        load.passWordField.setFocusTraversable(false);

        Scene scene = new Scene(root, primaryStage.getMinWidth(), primaryStage.getMinHeight());
        primaryStage.setScene(scene);
        primaryStage.show();

        //setting the logo for Login form
        Image logoImage = new Image(getClass().getResource("logoForProgram.png").toExternalForm());
        primaryStage.getIcons().add(logoImage);
    }

    //code for opening a new window (Main Form) with password and Email check
    @FXML
    protected void openMainForm(ActionEvent actionEvent) throws IOException {


        ArrayList<String> allEmails = new ArrayList<>();
        HashMap<String, String> EmailANDpassword = new HashMap<>();

        File file = new File("D:\\Programing\\Java\\Projects Java\\PixlPhotoEditingSoftware\\src\\main\\resources\\com\\example\\pixlphotoeditingsoftware\\Users.txt");
        String email = EmailField.getText();
        String password = passWordField.getText();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            Object[] lines = br.lines().toArray();
            for(int i = 0; i<lines.length; i++){
                String[] row = lines[i].toString().split(" ");

                allEmails.add(row[0]);
                EmailANDpassword.put(row[0],row[1]);
                }

            if(allEmails.contains(email)){
                if(EmailANDpassword.get(email).equals(password)){

                    ((Stage) logInButton.getScene().getWindow()).close();
                    Stage stage = new Stage();

                    // setting the min width and height for the Stage
                    stage.setMinWidth(850);
                    stage.setMinHeight(450);

                    // name of the Stage
                    stage.setTitle("Pixl");

                    // FXML file loader
                    FXMLLoader fxmlLoader = new FXMLLoader(PixlSoftware.class.getResource("MainFXML.fxml"));
                    Parent root = fxmlLoader.load();


                    Scene mainScene = new Scene(root, stage.getMinWidth(), stage.getMinHeight());
                    stage.setScene(mainScene);
                    stage.setScene(mainScene);
                    stage.show();

                    // Setting the logo for the Main form
                    Image logoImage = new Image(getClass().getResource("logoForProgram.png").toExternalForm());
                    stage.getIcons().add(logoImage);
                }else{
                lblEmail.setText("Wrong email");
                lblPassword.setText("Wrong password");
            }

            }else{
                lblEmail.setText("Wrong email");
                lblPassword.setText("Wrong password");

            }

            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Reader close ERROR");
                e.printStackTrace();
            }

        }catch(FileNotFoundException e2) {
            System.out.println("File not found!!!!!!!!!!!!");
        }




    }
}
