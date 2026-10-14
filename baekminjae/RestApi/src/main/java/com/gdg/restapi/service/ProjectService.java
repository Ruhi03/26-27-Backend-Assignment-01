package com.gdg.restapi.service;

import com.gdg.restapi.domain.Project;
import com.gdg.restapi.dto.project.ProjectLoadResponse;
import com.gdg.restapi.dto.project.ProjectTitleRequest;
import com.gdg.restapi.repository.ProjectRepository;
import com.gdg.restapi.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TrackRepository trackRepository;

    public ProjectLoadResponse create(ProjectTitleRequest request) {
        // id 와 프로젝트 이름을 넣어 객체 생성하기
        Project project = new Project(UUID.randomUUID(), request.getTitle());

        // 저장소에 객체 저장하기
        projectRepository.create(project);

        // 객체 반환하기
        return new ProjectLoadResponse(project);
    }

    public List<ProjectLoadResponse> loadAll() {
        return projectRepository.loadAll().stream()
                .map(ProjectLoadResponse::new)
                .toList();
    }

    public ProjectLoadResponse loadById(UUID id) {
        Project project = projectRepository.loadById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "존재하지 않는 프로젝트입니다."));

        return new ProjectLoadResponse(project);
    }

    public ProjectLoadResponse renameById(UUID id, ProjectTitleRequest request) {
        Project project = projectRepository.loadById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "존재하지 않는 프로젝트입니다."));

        try {
            project.rename(request.getTitle());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    e.getMessage(),
                    e
            );
        }

        return new ProjectLoadResponse(project);
    }

    public void deleteById(UUID id) {
        if (!projectRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "존재하지 않는 프로젝트입니다.");
        }

        // 입력된 프로젝트 id를 가진 트랙도 전부 제거
        trackRepository.deleteAllByProjectId(id);
        projectRepository.deleteById(id);
    }
}
