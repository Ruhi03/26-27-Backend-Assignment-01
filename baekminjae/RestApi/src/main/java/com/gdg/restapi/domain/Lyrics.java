package com.gdg.restapi.domain;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Lyrics {
    private final UUID id;
    private UUID trackId;
}
