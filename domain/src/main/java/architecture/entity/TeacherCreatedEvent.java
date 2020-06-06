package architecture.entity;

import org.springframework.context.ApplicationEvent;


public class TeacherCreatedEvent extends ApplicationEvent {
    private String teacherName;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public TeacherCreatedEvent(Object source, String teacherName) {
        super(source);
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
