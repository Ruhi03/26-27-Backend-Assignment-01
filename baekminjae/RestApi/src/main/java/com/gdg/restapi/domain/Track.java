package com.gdg.restapi.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Track {
    private final UUID id;
    private final UUID projectId;

    private String name;
    private Double volumeDb;
    private Boolean muted;

    public Track(UUID id, UUID projectId) {
        this.id = id;
        this.projectId = projectId;
        this.name = "track";
        this.volumeDb = 0.0;
        this.muted = false;
    }

    public void update(String name, Double volumeDb, Boolean muted) {
        if (name != null) {
            this.name = name;
        }
        if (volumeDb != null) {
            this.volumeDb = volumeDb;
        }
        if (muted != null) {
            this.muted = muted;
        }
    }
}
