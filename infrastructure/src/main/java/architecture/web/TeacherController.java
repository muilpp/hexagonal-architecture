package architecture.web;

import architecture.entity.Teacher;
import architecture.entity.TeacherAge;
import architecture.entity.TeacherCreatedEvent;
import architecture.port.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    private static final Logger LOGGER = Logger.getLogger(TeacherController.class.getName());

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        teacherRepository.create(Teacher.create("Joan", new TeacherAge(22), "BCN"));
        return teacherRepository.findAll();
    }

    @EventListener
    public void handleUserCreatedEvent(TeacherCreatedEvent event) {
        LOGGER.info("Teacher created event received -> " + event.getTeacherName());
    }
}
