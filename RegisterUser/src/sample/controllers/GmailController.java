package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.mail.MailSetting;
import sample.window.transitions.Windows;

public class GmailController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sendSms;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField subjectTextField;

    @FXML
    private TextField fieldForWrite;

    @FXML
    private Button deleteDataButton;

    private MailSetting sender = new MailSetting(Controller.emailData, Controller.passwordData);

    @FXML
    void initialize() {

        //Вихід в з сестеми у вікно "Вхід"
        logoutButton.setOnAction(e -> {

            Windows windows = new Windows();
            logoutButton.getScene().getWindow().hide();
            windows.windowLogout();
        });

        //Відправка смс на введену електронну адерсу
        sendSms.setOnAction(e -> {
            System.out.println(Controller.emailData+" "+Controller.passwordData);
            sender.setText(fieldForWrite.getText());

            sender.send(subjectTextField.getText(), Controller.emailData, emailTextField.getText());
        });

        //Кнопка для очищення даних
        deleteDataButton.setOnAction(e->{
            emailTextField.setText("");
            subjectTextField.setText("");
            fieldForWrite.setText("");
        });
    }
}
