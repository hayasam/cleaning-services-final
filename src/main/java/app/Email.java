package app;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Email {
    static Logger logger = Logger.getLogger(Email.class.getName());
    public void send() {
        // Recipient's email ID needs to be mentioned.
        String to = "mohammedadwan44@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "adwan111@mail.ru";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("mohammedadwan44@gmail.com", "******");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Your Order!");

            // Now set the actual message
            message.setText("Your order Done you can take it thank you for using our service");


            logger.log(Level.INFO, "sending...");
            // Send message
            Transport.send(message);

            logger.log(Level.INFO, "Sent message successfully....");
        }

        catch (MessagingException mex) {
            // handle the exception
       }
    }
}
