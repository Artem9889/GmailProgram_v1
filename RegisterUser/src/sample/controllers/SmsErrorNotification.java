package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SmsErrorNotification {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okButton;

    @FXML
    void initialize() {

        //Закриття вікна з "ок"
        okButton.setOnAction(e->{
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        });
    }
}
