package com.gdg.restapi.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Track {
    private final UUID id;
    private final UUID projectId;

    private String name;
    private Double volume;
    private Boolean muted;

    public Track(UUID id, UUID projectId) {
        this.id = id;
        this.projectId = projectId;
        this.name = "track";
        this.volume = 100.0;
        this.muted = false;
    }

    public void update(String name, Double volume, Boolean muted) {
        if (name != null) {
            this.name = name;
        }
        if (volume != null) {
            this.volume = volume;
        }
        if (muted != null) {
            this.muted = muted;
        }
    }
}
