package architecture.usecase.teacher;

import architecture.entity.Teacher;
import architecture.entity.TeacherAge;
import architecture.port.notification.MailSender;
import architecture.port.teacher.TeacherRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


public class CreateTeacherTest {
    protected TeacherRepository repository;
    private MailSender mailSender;

    @Before
    public void setUp() {
        repository = spy(TeacherRepository.class);
        mailSender = spy(MailSender.class);
    }

    @Test
    public void createTeacherTest() {
        Teacher teacher = Teacher.create("John", new TeacherAge(22), "Barcelona");
        when(repository.create(any(Teacher.class))).thenReturn(true);

        CreateTeacher createTeacher = new CreateTeacher(repository, mailSender);
        Assert.assertTrue(createTeacher.create(teacher));
        verify(mailSender, atLeastOnce()).sendEmail(anyString(), anyString(), anyString());
    }

    @Test(expected= InvalidParameterException.class)
    public void createTeacherWithWrongAgeTest() {
        Teacher.create("John", new TeacherAge(102), "BCN");
    }
}
