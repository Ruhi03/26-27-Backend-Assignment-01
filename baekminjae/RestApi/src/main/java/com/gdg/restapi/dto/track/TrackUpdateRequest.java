package com.gdg.restapi.dto.track;

import lombok.Getter;

@Getter
public class TrackUpdateRequest {
    private String name;
    private Double volumeDb;
    private Boolean muted;
}
