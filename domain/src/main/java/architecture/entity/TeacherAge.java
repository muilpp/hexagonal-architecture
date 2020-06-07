package architecture.entity;

import java.security.InvalidParameterException;

//value object to validate age during constructor of teacher object
public class TeacherAge {
    private final int age;

    public TeacherAge(int age) {
        if (age > 0 && age < 99) {
            this.age = age;
        } else {
            throw new InvalidParameterException("Age must be between 0 and 99");
        }
    }

    public int getAge() {
        return age;
    }
}
