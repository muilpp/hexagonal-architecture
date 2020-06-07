package architecture.service;

import architecture.entity.TeacherCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private final ApplicationEventPublisher publisher;

    Publisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent(final String name) {
        publisher.publishEvent(new TeacherCreatedEvent(this, name));
    }
}
