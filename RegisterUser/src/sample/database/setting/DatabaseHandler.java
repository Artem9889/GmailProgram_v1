package sample.database.setting;

import sample.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    Connection dbConnection;


    //Підключення до бази даних
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "mol", "root");
        if (!dbConnection.isClosed()) {
            System.out.println("Соединение с БД установлено");
        }
        return dbConnection;
    }

    //Метод, який получає введені дані
    public void singUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_LOGIN + "," + Const.USER_EMAIL + "," + Const.USER_PASSWORD1 + ")" +
                "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getEmail());
            prSt.setString(3, user.getPass1());
            prSt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=? AND " + Const.USER_PASSWORD1 + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getEmail());
            prSt.setString(2, user.getPass1());

            resSet = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public ResultSet getEmail(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_EMAIL + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getEmail());

            resSet = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}