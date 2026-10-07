package com.gdg.restapi.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Project {
    private final UUID id;

    @Setter
    private String title;

    @Setter
    private Lyrics lyrics; // 구조 고민중

    private final List<Note> notes;
    private final List<Track> tracks;

    public Project(UUID id, String title) {
        this.id = id;
        this.title = title;
        this.lyrics = null;
        this.notes = new ArrayList<>();
        this.tracks = new ArrayList<>();
    }
}