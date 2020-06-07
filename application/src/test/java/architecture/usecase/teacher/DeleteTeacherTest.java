package architecture.usecase.teacher;

import architecture.entity.Teacher;
import architecture.entity.TeacherAge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import architecture.port.teacher.TeacherRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DeleteTeacherTest {
    protected TeacherRepository repository;

    @Before
    public void setUp() {
        repository = mock(TeacherRepository.class);
    }

    @Test
    public void deleteNewTeacher() {
        Teacher teacher = Teacher.create("Miquel", new TeacherAge(22), "Aviram");
        when(repository.deleteTeacher(teacher)).thenReturn(true);

        DeleteTeacher deleteTeacher = new DeleteTeacher(repository);
        Assert.assertTrue(deleteTeacher.delete(teacher));
    }
}
