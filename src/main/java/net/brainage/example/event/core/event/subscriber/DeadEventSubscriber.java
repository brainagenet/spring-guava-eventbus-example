package net.brainage.example.event.core.event.subscriber;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by ms29.seo on 2016-08-08.
 */
@Slf4j
public class DeadEventSubscriber {

    @Subscribe
    public void onEvent(DeadEvent event) {
        log.debug("event : {}", event.toString());
    }

}
