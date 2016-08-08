package net.brainage.example.event.directory;

import lombok.Data;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Data
public class PathEvents implements PathEventContext {

    private final List<PathEvent> events = new ArrayList<>();
    private final Path watchedDirectory;
    private final boolean valid;

    public PathEvents(boolean valid, Path watchedDirectory) {
        this.valid = valid;
        this.watchedDirectory = watchedDirectory;
    }

    public void add(PathEvent pathEvent) {
        events.add(pathEvent);
    }

}
