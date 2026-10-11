package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Lyrics {
    private final UUID id;
    private UUID trackId;
}
