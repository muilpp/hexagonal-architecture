package architecture.usecase.notification;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import architecture.port.notification.MailSender;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SendMailTest {
    protected MailSender mailSender;

    @Before
    public void setUp() {
        mailSender = mock(MailSender.class);
    }

    @Test
    public void sendMailTest() {
        when(mailSender.sendEmail(anyString(), anyString(), anyString())).thenReturn(true);

        SendMail sendMail = new SendMail(mailSender);
        Assert.assertTrue(sendMail.send("to@gmail.com", "subject", "text"));
    }
}
