package com.gdg.restapi.dto.track;

import com.gdg.restapi.domain.Track;
import java.util.UUID;
import lombok.Getter;

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
