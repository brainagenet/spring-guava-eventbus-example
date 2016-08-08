package net.brainage.example.event.dsr.event;

import net.brainage.example.event.core.event.BaseEvent;
import net.brainage.example.event.dsr.model.RawData;

/**
 * Created by ms29.seo on 2016-08-08.
 */
public class TicketEvent extends BaseEvent<RawData> {

    public TicketEvent(RawData data) {
        super(data);
    }



}
