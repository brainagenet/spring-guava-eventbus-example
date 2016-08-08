package net.brainage.example.event.directory;

import com.google.common.eventbus.EventBus;
import net.brainage.example.event.directory.DirectoryEventWatcher;
import net.brainage.example.event.directory.DirectoryEventWatcherImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by ms29.seo on 2016-08-08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DirectoryEventWatcherImplTest {

    @Configuration
    static class TestConfig {

        @Bean
        public EventBus eventBus() {
            return new EventBus();
        }

        @Bean
        @Autowired
        public DirectoryEventWatcher directoryEventWatcher(EventBus eventBus) {
            return new DirectoryEventWatcherImpl(eventBus, Paths.get(""));
        }


    }

    @Autowired
    private EventBus eventBus;

    @Autowired
    private DirectoryEventWatcher directoryEventWatcher;


    @Before
    public void setup() throws IOException {
        directoryEventWatcher.start();
    }

    @After
    public void tearDown() {
        directoryEventWatcher.stop();
    }

}
