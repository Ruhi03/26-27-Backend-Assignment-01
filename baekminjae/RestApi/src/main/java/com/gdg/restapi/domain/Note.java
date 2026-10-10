package com.gdg.restapi.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Note {
    private final UUID id;
    private UUID trackId;
    private String text;
    private Double startTime;
    private Double endTime;

    public void update(String text, Double startTime, Double endTime) {
        if (text != null) {
            this.text = text;
        }
        if (startTime != null) {
            this.startTime = startTime;
        }
        if (endTime != null) {
            this.endTime = endTime;
        }
    }
}
