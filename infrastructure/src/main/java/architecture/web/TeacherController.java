package architecture.web;

import architecture.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import architecture.port.teacher.TeacherRepository;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        List<Teacher> teacherList = teacherRepository.findAll();

        return teacherList;
    }

}
