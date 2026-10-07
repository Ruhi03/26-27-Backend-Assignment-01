package com.gdg.restapi.domain;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Lyrics {
    private UUID id;
    private List<LyricSegment> segments;
}