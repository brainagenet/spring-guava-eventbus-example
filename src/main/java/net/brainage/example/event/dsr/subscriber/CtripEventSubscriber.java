package net.brainage.example.event.dsr.subscriber;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.brainage.example.event.core.event.subscriber.EventSubscriber;
import net.brainage.example.event.dsr.event.CtripEvent;
import net.brainage.example.event.dsr.model.RawData;

@Slf4j
public class CtripEventSubscriber implements EventSubscriber<CtripEvent> {

    @Override
    @Subscribe
    public void onEvent(CtripEvent event) {
        log.debug("event data: {}", event.getData().toString());
        RawData data = event.getData();
        data.setData("OPQRSTUVWXYZ");
        log.debug("  >> event data: {}", event.getData().toString());
    }

}
