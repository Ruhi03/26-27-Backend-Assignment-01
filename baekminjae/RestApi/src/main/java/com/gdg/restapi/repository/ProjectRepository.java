package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository {
    // Project 객체들을 모아두는 맵
    private final Map<UUID, Project> projects = new HashMap<>();

    // 저장소에 객체 저장하기
    public void create(Project project) {
        // 입력된 Project 객체를 맵에 추가하기
        projects.put(project.getId(), project);
    }

    public List<Project> loadAll() {
        return new ArrayList<>(projects.values());
    }

    public Optional<Project> loadById(UUID id) {
        return Optional.ofNullable(projects.get(id));
    }

    public Optional<Project> renameById(UUID id, String newTitle) {
        Optional<Project> project = loadById(id);
        project.ifPresent(value -> value.setTitle(newTitle));
        return project;
    }

    public void deleteById(UUID id) {
        projects.remove(id);
    }

    public boolean existsById(UUID id) {
        return projects.containsKey(id);
    }
}
