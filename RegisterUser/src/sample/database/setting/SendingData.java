package sample.database.setting;

import javafx.scene.control.TextField;
import sample.User;


public class SendingData {

    private final TextField logText;
    private final TextField mailText;
    private final TextField passText1;

    public SendingData(TextField logText, TextField mailText, TextField passText1) {
        this.logText = logText;
        this.mailText = mailText;
        this.passText1 = passText1;
    }

    //Метод, який заносить дані до бази даних
    public void singUpUser() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        String login = logText.getText();
        String email = mailText.getText();
        String pass1 = passText1.getText();

        User user = new User(login, email, pass1);
        databaseHandler.singUpUser(user);
    }
}
