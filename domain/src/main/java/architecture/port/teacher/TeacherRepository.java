package architecture.port.teacher;

import architecture.entity.Teacher;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAll();
    boolean create(Teacher teacher);
    boolean deleteTeacher(Teacher teacher);
}
