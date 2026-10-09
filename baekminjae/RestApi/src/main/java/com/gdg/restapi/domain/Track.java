package com.gdg.restapi.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Track {
    private final UUID id;

    // 수정 가능한 거 의도된 것입니다.
    @Setter
    private UUID projectId;

    @Setter
    private String name;

    @Setter
    private Double volume;

    @Setter
    private Boolean muted;

    private final List<AudioClip> audioClips;

    public Track(UUID id, UUID projectId) {
        this.id = id;
        this.projectId = projectId;
        this.name = "track";
        this.volume = 100.0;
        this.muted = false;
        this.audioClips = new ArrayList<>();
    }

    public void update(UUID projectId, String name, Double volume, Boolean muted) {
        if (projectId != null) {
            this.projectId = projectId;
        }
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
