package com.gdg.restapi.controller;

import com.gdg.restapi.dto.project.ProjectLoadResponse;
import com.gdg.restapi.dto.project.ProjectTitleRequest;
import com.gdg.restapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    // 프로젝트 생성하기
    @PostMapping
    public ResponseEntity<ProjectLoadResponse> create(@RequestBody ProjectTitleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(request));
    }

    // 모든 프로젝트 불러오기
    @GetMapping
    public ResponseEntity<List<ProjectLoadResponse>> loadAll() {
        return ResponseEntity.ok(projectService.loadAll());
    }

    // 특정 프로젝트 불러오기
    @GetMapping("/{id}")
    public ResponseEntity<ProjectLoadResponse> loadById(@PathVariable UUID id) {
        return ResponseEntity.ok(projectService.loadById(id));
    }

    // 특정 프로젝트 이름 바꾸기
    @PatchMapping("/{id}")
    public ResponseEntity<ProjectLoadResponse> renameById(
            @PathVariable UUID id,
            @RequestBody ProjectTitleRequest request
    ) {
        return ResponseEntity.ok(projectService.renameById(id, request));
    }

    // 특정 프로젝트 삭제하기
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        projectService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
