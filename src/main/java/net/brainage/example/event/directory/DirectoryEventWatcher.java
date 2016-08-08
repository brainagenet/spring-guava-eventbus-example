package net.brainage.example.event.directory;

import java.io.IOException;

public interface DirectoryEventWatcher {

    void start() throws IOException;

    boolean isRunning();

    void stop();

}
