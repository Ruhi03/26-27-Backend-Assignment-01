package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
public class AudioClip {
    private final UUID id;
    private UUID trackId;

    @Setter
    private String audioPath;

    private Double position;
    private Double sourceStart;
    private Double sourceEnd;
}
