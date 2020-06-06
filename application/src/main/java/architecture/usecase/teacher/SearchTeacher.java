package architecture.usecase.teacher;


import architecture.entity.Teacher;
import architecture.port.teacher.TeacherRepository;

import java.util.List;

public class SearchTeacher {
    TeacherRepository teacherRepository;

    public SearchTeacher(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> search() {
        return teacherRepository.findAll();
    }
}
