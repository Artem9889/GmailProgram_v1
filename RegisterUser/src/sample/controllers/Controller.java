package sample.controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.User;
import sample.animations.Shake;
import sample.database.setting.DatabaseHandler;
import sample.mail.MailSetting;
import sample.window.transitions.Windows;


public class Controller {

    Windows windows = new Windows();

    public static String emailData;
    public static String passwordData;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button singUpButton;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button exitButton;

    @FXML
    private Text textError;


    @FXML
    void initialize() {


        //Вхід в сестему
        exitButton.setOnAction(e -> {
            String loginText = email.getText().trim();
            String passwordText = password.getText().trim();

            if (!loginText.equals("") && !passwordText.equals("")) {
                emailUser(loginText, passwordText);

            } else {
                textError.setText("Поля вводу не можуть бути пустими!");
                Shake loginAnim = new Shake(email);
                Shake passAnim = new Shake(password);
                loginAnim.playAnim();
                passAnim.playAnim();
            }
        });
        //Перехід у вікно "Реєстрації"
        singUpButton.setOnAction(e -> {
            singUpButton.getScene().getWindow().hide();
            windows.windowSingUp();
        });
    }

    //Метод, який перевіряє, чи є такі дані в базі, якщо є, то user перенаправляєть до особистого кабінету
    private void emailUser(String loginText, String passwordText) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setEmail(loginText);
        user.setPass1(passwordText);
        ResultSet result = databaseHandler.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (counter >= 1) {
            emailData = loginText;
            passwordData = passwordText;
            exitButton.getScene().getWindow().hide();
            windows.windowGmail();
            textError.setText("");
        } else {
            textError.setText("\t      Даний акаун відсутній!");
            Shake loginAnim = new Shake(email);
            Shake passAnim = new Shake(password);
            loginAnim.playAnim();
            passAnim.playAnim();
        }
    }
}

