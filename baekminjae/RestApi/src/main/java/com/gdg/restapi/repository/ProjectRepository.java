package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Project;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProjectRepository {
    // Project 객체들을 모아두는 맵
    private final Map<UUID, Project> projects = new HashMap<>();

    // 저장소에 객체 저장하기
    public void create(Project project) {
        projects.put(project.getId(), project);
    }

    public List<Project> loadAll() {
        return new ArrayList<>(projects.values());
    }

    public Optional<Project> loadById(UUID id) {
        return Optional.ofNullable(projects.get(id));
    }

    public void deleteById(UUID id) {
        projects.remove(id);
    }

    public boolean existsById(UUID id) {
        return projects.containsKey(id);
    }
}
