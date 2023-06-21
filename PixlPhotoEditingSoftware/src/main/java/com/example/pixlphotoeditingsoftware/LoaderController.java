package com.example.pixlphotoeditingsoftware;

import javafx.fxml.*;
import javafx.scene.control.*;

public class LoaderController {
    @FXML
    ProgressBar progress;
    @FXML
    Button closeBtn;
    @FXML
    Label progressLabel;
    @FXML
    public void closeProgram() {
       System.exit(0);
    }

}