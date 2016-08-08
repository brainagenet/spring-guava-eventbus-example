package net.brainage.example.event.directory;

import lombok.Data;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

@Data
public class PathEvent {

    private final Path eventTarget;
    private final WatchEvent.Kind type;

    public PathEvent(Path eventTarget, WatchEvent.Kind type) {
        this.eventTarget = eventTarget;
        this.type = type;
    }

}
