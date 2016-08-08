package net.brainage.example.event.dsr.subscriber.processor;

import net.brainage.example.event.dsr.model.RawData;

/**
 * Created by ms29.seo on 2016-08-08.
 */
public interface TicketEventProcessor {

    RawData process(RawData data);

}
