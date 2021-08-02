package sample.exception;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.User;
import sample.animations.Shake;
import sample.database.setting.DatabaseHandler;
import sample.database.setting.SendingData;
import sample.window.transitions.Windows;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramErrors {

    private final TextField logText;
    private final TextField mailText;
    private final TextField passText1;
    private final TextField passText2;
    private final Text passError;
    private final Text mailError;
    private final Text logError;

    Windows windows = new Windows();


    public ProgramErrors(TextField logText, TextField mailText, TextField passText1, TextField passText2, Text passError, Text mailError, Text logError) {
        this.logText = logText;
        this.mailText = mailText;
        this.passText1 = passText1;
        this.passText2 = passText2;
        this.passError = passError;
        this.mailError = mailError;
        this.logError = logError;
    }


    //Змінні, які відповідають за занесення даних до бази, коли всі змінні = true, новий користувач заноситься до бази
    private boolean loginTrue = false;
    private boolean emailTrue = false;
    private boolean pass1True = false;
    private boolean pass2True = false;

    //Змінна, яка передає свій результат в SingUpController, якщо true, то дані заносяться до бази, якщо false, то повідомляє про помилки
    public boolean resultTrue = false;


    //Головний метод перевірки
    public void audit() {
        loginAudit();
        mailDatabase(mailText.getText());
        passwordAudit();

        //Блок кода, який перевіряє, чи всі операції перевірки пройшли вдало
        if (loginTrue && emailTrue && pass1True && pass2True) {
            resultTrue = true;
            windows.registeredUser();

            //Даний блок кода заносить дані до бази, якщо всі перевірки прошлий вдало
            if (resultTrue = true) {
                SendingData sendingData = new SendingData(logText, mailText, passText1);
                sendingData.singUpUser();
            }
        }
    }

    //Метод, який перевіряє логін
    private void loginAudit() {
        if (logText.getText().equals("")) {
            logError.setText("Поле не може бути пустим!");
            Shake login = new Shake(logText);
            login.playAnim();
        } else {
            loginTrue = true;
            logError.setText("");
        }
    }

    //Метод, який перевіряє, чи є така електронна адреса в базі
    public void mailDatabase(String emailText) {

        Shake passAnim = new Shake(mailText);

        if (mailText.getText().equals("")) {
            passAnim.playAnim();
        }

        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setEmail(emailText);
        ResultSet result = databaseHandler.getEmail(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (counter >= 1) {
            mailError.setText("Дана почта зареєстрована!");
            passAnim.playAnim();
        } else {
            emailTrue = true;
            mailError.setText("");
        }
    }

    //Метод, який перевіряє паролі на розмір та схожість
    private void passwordAudit() {
        Shake pass1 = new Shake(passText1);
        Shake pass2 = new Shake(passText2);
        if (!logText.getText().equals("") && !mailText.getText().equals("") && !passText1.getText().equals("") && !passText2.getText().equals("")) {

            if (passText1.getText().equals(passText2.getText())) {
                passError.setText("");

                if (passText1.getText().length() < 6) {
                    pass2True = false;
                    passError.setText("Пароль небезпечний! Задайте пароль не менше 6 символів.");
                    pass1.playAnim();
                    pass2.playAnim();
                } else {
                    pass2True = true;
                    passError.setText("");
                }

            } else {
                pass1True = false;
                passError.setText("Паролі не схожі!!");
                pass1.playAnim();
                pass2.playAnim();
            }
            pass1True = true;
        } else {
            pass1.playAnim();
            pass2.playAnim();
        }
    }
}


