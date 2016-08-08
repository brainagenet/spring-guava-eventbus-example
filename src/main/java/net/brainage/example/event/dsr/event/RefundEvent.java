package net.brainage.example.event.dsr.event;

import net.brainage.example.event.core.event.BaseEvent;
import net.brainage.example.event.dsr.model.RawData;

public class RefundEvent extends BaseEvent<RawData> {

    public RefundEvent(RawData data) {
        super(data);
    }

}
