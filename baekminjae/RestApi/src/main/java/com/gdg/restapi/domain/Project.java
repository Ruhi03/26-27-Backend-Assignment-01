package com.gdg.restapi.domain;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Project {
    private final UUID id;

    @Setter
    private String title;

    @Setter
    private Lyrics lyrics; // 구조 고민중

    public Project(UUID id, String title) {
        this.id = id;
        this.title = title;
        this.lyrics = null;
    }
}