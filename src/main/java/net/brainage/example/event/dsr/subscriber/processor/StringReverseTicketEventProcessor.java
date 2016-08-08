package net.brainage.example.event.dsr.subscriber.processor;

import net.brainage.example.event.dsr.model.RawData;

public class StringReverseTicketEventProcessor implements TicketEventProcessor {

    @Override
    public RawData process(RawData data) {
        RawData newData = new RawData();
        newData.setId(data.getId());
        newData.setType(data.getType());
        newData.setNeedCtrip(data.isNeedCtrip());
        newData.setData(reverse(data.getData()));
        return newData;
    }

    public String reverse(String text) {
        if (text == null || text.length() == 0) return "";

        char[] result = text.toCharArray();
        int begin = 0;
        int end = result.length -1;
        while (end > begin) {
            result[end] = text.charAt(begin);
            result[begin] = text.charAt(end);
            end--;
            begin++;
        }
        return new String(result);
    }

}
