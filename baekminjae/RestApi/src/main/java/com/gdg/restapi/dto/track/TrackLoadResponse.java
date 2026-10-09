package com.gdg.restapi.dto.track;

import com.gdg.restapi.domain.AudioClip;
import com.gdg.restapi.domain.Track;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class TrackLoadResponse {
    private final UUID id;
    private final UUID projectId;
    private final String name;
    private final Double volume;
    private final Boolean muted;
    private final List<AudioClip> audioClips;

    public TrackLoadResponse(Track track) {
        this.id = track.getId();
        this.projectId = track.getProjectId();
        this.name = track.getName();
        this.volume = track.getVolume();
        this.muted = track.getMuted();
        this.audioClips = track.getAudioClips();
    }
}
