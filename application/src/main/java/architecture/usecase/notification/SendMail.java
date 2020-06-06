package architecture.usecase.notification;

import architecture.port.notification.MailSender;

public class SendMail {
    private final MailSender mailSender;

    public SendMail(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean send(final String to, final String subject, final String text) {
        return mailSender.sendEmail(to, subject, text);
    }
}