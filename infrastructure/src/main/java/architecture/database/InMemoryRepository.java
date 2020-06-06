package architecture.database;

import architecture.entity.Teacher;
import org.springframework.stereotype.Service;
import architecture.port.teacher.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryRepository implements TeacherRepository {
    private static final List<Teacher> inMemoryTeachers = new ArrayList<>();

    @Override
    public List<Teacher> findAll() {
        return inMemoryTeachers;
    }

    @Override
    public boolean create(Teacher teacher) {
        inMemoryTeachers.add(teacher);

        return inMemoryTeachers.contains(teacher);
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) {
        inMemoryTeachers.remove(teacher);

        return inMemoryTeachers.contains(teacher);
    }
}
