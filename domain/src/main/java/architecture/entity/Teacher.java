package architecture.entity;

public class Teacher {
    private final String name;
    private final TeacherAge age;
    private final String location;
    private boolean isActive;

    public Teacher(String name, TeacherAge age, String location, boolean isActive) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.isActive = isActive;
    }

    //named constructor
    public static Teacher create(String name, TeacherAge age, String location) {
        return new Teacher(name, age, location, false);
    }

    public String getName() {
        return name;
    }

    public TeacherAge getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }
}
