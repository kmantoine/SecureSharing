package SecureShareServer;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;

/**
 *
 * @author arkane
 */
public class SendEmailAttachment {
    static void ConstructEmail   (String from, String to, String filepath) {

       String host = "localhost";
       final String username = "";
       final String password = "";

       Properties properties = System.getProperties();
       properties.setProperty("mail.smtp.host", host);
       properties.setProperty("mail.smtp.port", "");
       properties.setProperty("mail.smtp.starttls.enable", "true");
       properties.setProperty("mail.smtp.auth", "");

       Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
           protected PasswordAuthentication getPasswordAuthenticator() {
               return new PasswordAuthentication(username, password);
           }
       });

       try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("A File Has Been Shared With You");

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please check your user folder in directory - 'Shared With Me'\n\n");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filepath);

            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filepath);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            Logger.getLogger (SMS.class.getName()).log (Level.INFO, "Email Mmssage sent:", message);
       } 
       catch (MessagingException |RuntimeException ex) {
            Logger.getLogger (SMS.class.getName()).log (Level.WARNING, "Message has not been sent", ex);
       }
    }
}