package com.gdg.restapi.dto.track;

import com.gdg.restapi.domain.Track;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TrackLoadResponse {
    private final UUID id;
    private final UUID projectId;
    private final String name;
    private final Double volume;
    private final Boolean muted;

    public TrackLoadResponse(Track track) {
        this.id = track.getId();
        this.projectId = track.getProjectId();
        this.name = track.getName();
        this.volume = track.getVolume();
        this.muted = track.getMuted();
    }
}
