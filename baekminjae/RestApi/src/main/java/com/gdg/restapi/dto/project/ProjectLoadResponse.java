package com.gdg.restapi.dto.project;

import com.gdg.restapi.domain.Project;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProjectLoadResponse {
    private final UUID id;
    private final String title;

    public ProjectLoadResponse(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
    }
}
