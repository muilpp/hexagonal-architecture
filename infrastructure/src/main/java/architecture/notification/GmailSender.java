package architecture.notification;

import architecture.port.notification.MailSender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GmailSender implements MailSender {
    private final String from;
    private final Session session;
    private static final Logger LOGGER = Logger.getLogger(GmailSender.class.getName());

    public GmailSender() {
        from = "architecture.web@gmail.com";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "localhost");
        session = Session.getDefaultInstance(properties);
    }

    @Override
    public boolean sendEmail(final String to, final String subject, final String text) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);
            LOGGER.info("Sent message successfully....");
        } catch (MessagingException mex) {
            LOGGER.log(Level.SEVERE, mex.getMessage(), mex);
            mex.printStackTrace();
            return false;
        }

        return true;
    }
}
