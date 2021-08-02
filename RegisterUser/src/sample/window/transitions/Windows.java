package sample.window.transitions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Windows {

    //Вікно реєстрації
    public void windowSingUp(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/design/singUp.fxml"));

        try {
            loader.load();
        } catch (IOException er) {
            er.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,500, 350));
        stage.setResizable(false);
        stage.showAndWait();
    }

    //Вікно кабінету
    public void windowGmail(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/design/gmail.fxml"));

        try {
            loader.load();
        } catch (IOException er) {
            er.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,500,460));
        stage.setResizable(false);
        stage.show();
    }

    //Вікно входу
    public void windowLogout(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/design/sample.fxml"));

        try {
            loader.load();
        } catch (IOException er) {
            er.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    //Вікно, яке повідомляє про зареєстрування користувача
    public void registeredUser(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/design/pop-up/windows/theUserIsRegistered.fxml"));

        try {
            loader.load();
        } catch (IOException er) {
            er.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void smsNotification(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/design/pop-up/windows/smsNotification.fxml"));

        try {
            loader.load();
        } catch (IOException er) {
            er.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public void smsErrorNotification(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/design/pop-up/windows/smsErrorNotification.fxml"));

        try {
            loader.load();
        } catch (IOException er) {
            er.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }
}

