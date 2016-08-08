package net.brainage.example.event.dsr.subscriber;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import net.brainage.example.event.core.event.subscriber.EventSubscriber;
import net.brainage.example.event.dsr.event.CtripEvent;
import net.brainage.example.event.dsr.event.TicketEvent;
import net.brainage.example.event.dsr.model.RawData;
import net.brainage.example.event.dsr.subscriber.processor.TicketEventProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

@Slf4j
public class TicketEventSubscriber implements EventSubscriber<TicketEvent>, InitializingBean {

    private EventBus eventBus;

    TicketEventProcessor ticketEventProcessor;

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setTicketEventProcessor(TicketEventProcessor ticketEventProcessor) {
        this.ticketEventProcessor = ticketEventProcessor;
    }

    @Override
    @Subscribe
    public void onEvent(TicketEvent event) {
        log.debug("event data: {}", event.getData().toString());

        RawData data = ticketEventProcessor.process(event.getData());
        if (data.isNeedCtrip()) {
            eventBus.post(new CtripEvent(data));
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(eventBus);
    }

}
