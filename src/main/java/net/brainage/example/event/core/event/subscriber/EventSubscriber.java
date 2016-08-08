package net.brainage.example.event.core.event.subscriber;

import net.brainage.example.event.core.event.Event;

public interface EventSubscriber<T extends Event> {

    void onEvent(T event);

}
