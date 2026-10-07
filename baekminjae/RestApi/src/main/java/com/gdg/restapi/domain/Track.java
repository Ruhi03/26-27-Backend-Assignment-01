package com.gdg.restapi.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Track {
    private UUID id;

    @Setter
    private String name;

    @Setter
    private String audioPath;

    private Double duration;
    private Double startTime;
    private Double endTime;

    @Setter
    private Double volume;

    @Setter
    private Boolean muted;

    public void update(Double duration, Double startTime, Double endTime) {
        if (duration != null) {
            this.duration = duration;
        }
        if (startTime != null) {
            this.startTime = startTime;
        }
        if (endTime != null) {
            this.endTime = endTime;
        }
    }
}
