package com.gdg.restapi.dto.track;

import lombok.Getter;

@Getter
public class TrackUpdateRequest {
    private String name;
    private Double volume;
    private Boolean muted;
}
