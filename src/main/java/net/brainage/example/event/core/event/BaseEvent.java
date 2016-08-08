package net.brainage.example.event.core.event;

public abstract class BaseEvent<T> implements Event<T> {

    private final T data;

    public BaseEvent(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

}
