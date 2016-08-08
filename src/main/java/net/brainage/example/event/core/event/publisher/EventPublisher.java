package net.brainage.example.event.core.event.publisher;

import com.google.common.eventbus.EventBus;

public interface EventPublisher {

    void setEventBus(EventBus eventBus);

}
