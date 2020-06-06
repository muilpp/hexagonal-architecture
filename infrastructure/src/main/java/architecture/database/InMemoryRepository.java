package architecture.database;

import architecture.entity.Teacher;
import architecture.port.teacher.TeacherRepository;
import architecture.service.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class InMemoryRepository implements TeacherRepository {
    private static final List<Teacher> inMemoryTeachers = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(InMemoryRepository.class.getName());

    @Autowired
    private Publisher publisher;

    @Override
    public List<Teacher> findAll() {
        return inMemoryTeachers;
    }

    @Override
    public boolean create(Teacher teacher) {
        inMemoryTeachers.add(teacher);

        publisher.publishEvent(teacher.getName());

        return inMemoryTeachers.contains(teacher);
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) {
        inMemoryTeachers.remove(teacher);

        return inMemoryTeachers.contains(teacher);
    }
}
