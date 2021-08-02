package sample;

public class User {

    private  String login;
    private  String email;
    private  String pass1;

    public User(String login, String email, String pass1) {
        this.login = login;
        this.email = email;
        this.pass1 = pass1;
    }

    public User(){}


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }


}
