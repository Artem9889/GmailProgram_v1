package sample.mail;

import sample.window.transitions.Windows;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSetting {

    private String username;
    private String password;
    private String text;
    private Properties properties;
    private boolean isTrue = true;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MailSetting(String username, String password) {
        this.username = username;
        this.password = password;

        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
    }

    public void send(String subject, String fromEmail, String toEmail) {
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Windows windows = new Windows();

        try {
            Message message = new MimeMessage(session);
            //від кого лист
            message.setFrom(new InternetAddress(fromEmail));
            //кому лист
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            //тема листа
            message.setSubject(subject);
            //вміст листа
            message.setText(getText());
            //Отправка листа
            Transport.send(message);
            //Вікно, яке повідомляє про відправлене смс
            windows.smsNotification();

        } catch (MessagingException e) {
            //Вікно, яке повідомляє про "неправильно" введені дані
                windows.smsErrorNotification();
            throw new RuntimeException(e);
        }
    }
}
