package com.gdg.restapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Project {
    private final UUID id;

    @Setter
    private String title;

    public Project(UUID id, String title) {
        this.id = id;
        this.title = title;
    }
}
