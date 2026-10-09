package com.gdg.restapi.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class AudioClip {
    private UUID id;

    @Setter
    private String audioPath;

    private Double position;
    private Double sourceStart;
    private Double sourceEnd;
}
