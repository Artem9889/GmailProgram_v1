package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.database.setting.SendingData;
import sample.exception.ProgramErrors;
import sample.window.transitions.Windows;

public class SignUpController {


    Windows windows = new Windows();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButtonNew;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwordText2;

    @FXML
    private Button singUpButtonNew;

    @FXML
    private PasswordField passwordText1;

    @FXML
    private TextField emailText;

    @FXML
    private Text emailError;

    @FXML
    private Text passError;

    @FXML
    private Text loginError;

    @FXML
    void initialize() {

        //Перехід у вікно "Увійти"
        exitButtonNew.setOnAction(e -> {
            exitButtonNew.getScene().getWindow().hide();
            windows.windowLogout();
        });

        //Кнопка реєстрації
        singUpButtonNew.setOnAction(e -> {
            ProgramErrors programErrors = new ProgramErrors(loginText, emailText, passwordText1, passwordText2, passError, emailError, loginError);
            //Головний метод перевірки
            programErrors.audit();
        });
    }
}


