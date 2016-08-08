package net.brainage.example.event.dsr;

import com.google.common.eventbus.EventBus;
import net.brainage.example.event.core.event.subscriber.DeadEventSubscriber;
import net.brainage.example.event.dsr.event.TicketEvent;
import net.brainage.example.event.dsr.model.RawData;
import net.brainage.example.event.dsr.subscriber.CtripEventSubscriber;
import net.brainage.example.event.dsr.subscriber.RefundEventSubscriber;
import net.brainage.example.event.dsr.subscriber.TasfEventSubscriber;
import net.brainage.example.event.dsr.subscriber.TicketEventSubscriber;
import net.brainage.example.event.dsr.subscriber.processor.StackStringReverseTicketEventProcessor;
import net.brainage.example.event.dsr.subscriber.processor.TicketEventProcessor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.file.StandardWatchEventKinds;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DsrEventBusPrototypeTest {

    @Configuration
    static class TestConfig {

        @Bean
        public EventBus eventBus() {
            return new EventBus();
        }

        @Bean
        public TicketEventProcessor ticketEventProcessor() {
            return new StackStringReverseTicketEventProcessor();
        }

        @Bean
        public TicketEventSubscriber ticketEventSubscriber(EventBus eventBus, TicketEventProcessor ticketEventProcessor) {
            TicketEventSubscriber subscriber = new TicketEventSubscriber();
            subscriber.setEventBus(eventBus);
            subscriber.setTicketEventProcessor(ticketEventProcessor);
            eventBus.register(subscriber);
            return subscriber;
        }

        @Bean
        public RefundEventSubscriber refundEventSubscriber(EventBus eventBus) {
            RefundEventSubscriber subscriber = new RefundEventSubscriber();
            eventBus.register(subscriber);
            return subscriber;
        }

        @Bean
        public TasfEventSubscriber tasfEventSubscriber(EventBus eventBus) {
            TasfEventSubscriber subscriber = new TasfEventSubscriber();
            eventBus.register(subscriber);
            return subscriber;
        }

        @Bean
        public CtripEventSubscriber ctripEventSubscriber(EventBus eventBus) {
            CtripEventSubscriber subscriber = new CtripEventSubscriber();
            eventBus.register(subscriber);
            return subscriber;
        }

        @Bean
        public DeadEventSubscriber deadEventSubscriber(EventBus eventBus) {
            DeadEventSubscriber subscriber = new DeadEventSubscriber();
            eventBus.register(subscriber);
            return subscriber;
        }

    }

    @Autowired
    private EventBus eventBus;

    @Before
    public void setup() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void publish_ticket_event_without_ctripevent() {
        RawData data = new RawData(1234, "Ticket", "ABCD", false);
        eventBus.post(new TicketEvent(data));
    }

    @Test
    public void publish_ticket_event_with_ctripevent() {
        RawData data = new RawData(1234, "Ticket", "ABCD", true);
        eventBus.post(new TicketEvent(data));
    }

    @Test
    public void publish_multiple_ticket_events() {
        RawData[] datas = {
                new RawData(1, "T", "ABCD", true),
                new RawData(2, "T", "EFGH", false),
                new RawData(3, "T", "IJKL", false),
                new RawData(4, "T", "MNOP", true),
                new RawData(5, "T", "QRST", false)
        };

        for ( RawData d : datas) {
            eventBus.post(new TicketEvent(d));
        }

    }


}
