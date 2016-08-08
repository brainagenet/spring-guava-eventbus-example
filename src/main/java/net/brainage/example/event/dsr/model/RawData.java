package net.brainage.example.event.dsr.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id", "data"})
public class RawData {

    private int id;
    private String type;
    private String data;

    private boolean needCtrip;

}
