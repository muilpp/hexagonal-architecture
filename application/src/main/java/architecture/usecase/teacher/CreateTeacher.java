package architecture.usecase.teacher;

import architecture.entity.Teacher;
import architecture.port.notification.MailSender;
import architecture.port.teacher.TeacherRepository;

import java.util.logging.Logger;

public class CreateTeacher {
    private final TeacherRepository teacherRepository;
    private final MailSender mailSender;
    private static final Logger LOGGER = Logger.getLogger(CreateTeacher.class.getName());

    public CreateTeacher(TeacherRepository teacherRepository, MailSender mailSender) {
        this.teacherRepository = teacherRepository;
        this.mailSender = mailSender;
        LOGGER.info("Al constructor!");
    }

    public boolean create(Teacher teacher) {
        boolean isCreated = teacherRepository.create(teacher);

        if (isCreated) {
            mailSender.sendEmail("mua", "subject", "text");
        }

        LOGGER.info("Torno -> " + isCreated);
        return isCreated;
    }

}
