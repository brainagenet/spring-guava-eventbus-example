package net.brainage.example.event.dsr.event;

import net.brainage.example.event.core.event.BaseEvent;
import net.brainage.example.event.dsr.model.RawData;

public class CtripEvent extends BaseEvent<RawData> {

    public CtripEvent(RawData data) {
        super(data);
    }

}
