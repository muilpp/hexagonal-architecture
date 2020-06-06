package architecture.notification;


import architecture.port.notification.MailSender;

import java.util.logging.Logger;

public class FakeMail implements MailSender {
    private static final Logger LOGGER = Logger.getLogger(MailSender.class.getName());

    @Override
    public boolean sendEmail(String to, String subject, String text) {
        LOGGER.info("Received to: " + to);
        LOGGER.info("Received subject: " + subject);
        LOGGER.info("Received text: " + text);
        LOGGER.info("Fake mail, not sending anything!");
        return false;
    }
}
