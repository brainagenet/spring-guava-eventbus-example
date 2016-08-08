package net.brainage.example.event.directory;

import java.nio.file.Path;
import java.util.List;

public interface PathEventContext {

    boolean isValid();

    Path getWatchedDirectory();

    List<PathEvent> getEvents();

}
