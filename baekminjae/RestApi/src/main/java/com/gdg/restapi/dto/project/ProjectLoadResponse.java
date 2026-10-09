package com.gdg.restapi.dto.project;

import com.gdg.restapi.domain.Project;
import com.gdg.restapi.domain.Lyrics;
import com.gdg.restapi.domain.Note;
import java.util.List;
import java.util.UUID;
import lombok.Getter;

@Getter
public class ProjectLoadResponse {
    private final UUID id;
    private final String title;
    private final Lyrics lyrics;

    public ProjectLoadResponse(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.lyrics = project.getLyrics();
    }
}
