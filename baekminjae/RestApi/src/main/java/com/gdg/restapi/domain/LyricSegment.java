package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class LyricSegment {
    private final UUID id;
    private UUID lyricsId;
    private String text;
    private Double startTime;  // 초 단위, 싱크 전에는 null
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
