package net.brainage.example.event.dsr.subscriber;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.brainage.example.event.core.event.subscriber.EventSubscriber;
import net.brainage.example.event.dsr.event.TasfEvent;

@Slf4j
public class TasfEventSubscriber implements EventSubscriber<TasfEvent> {

    @Override
    @Subscribe
    public void onEvent(TasfEvent event) {
        log.debug("event data: {}", event.getData().toString());
    }

}
