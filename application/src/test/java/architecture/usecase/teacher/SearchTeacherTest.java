package architecture.usecase.teacher;

import architecture.entity.Teacher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import architecture.port.teacher.TeacherRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SearchTeacherTest {
    protected TeacherRepository repository;

    @Before
    public void setUp() {
        repository = mock(TeacherRepository.class);
    }

    @Test
    public void findAllTeachersTest() {
        List<Teacher> teacherList = repository.findAll();
        when(repository.findAll()).thenReturn(Arrays.asList(new Teacher("John", 22, "Barcelona")));

        SearchTeacher searchTeacher = new SearchTeacher(repository);
        Assert.assertEquals(searchTeacher.search().size(), 1);
    }
}
