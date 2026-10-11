package com.gdg.restapi.controller;

import com.gdg.restapi.dto.track.TrackLoadResponse;
import com.gdg.restapi.dto.track.TrackUpdateRequest;
import com.gdg.restapi.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tracks")
public class TrackController {
    private final TrackService trackService;

    // 특정 프로젝트에 속하는 트랙 생성하기
    @PostMapping
    public ResponseEntity<TrackLoadResponse> createTrack(@PathVariable UUID projectId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trackService.create(projectId));
    }

    // 특정 프로젝트에 속하는 모든 트랙 불러오기
    @GetMapping
    public ResponseEntity<List<TrackLoadResponse>> loadAll(@PathVariable UUID projectId) {
        return ResponseEntity.ok(trackService.loadAll(projectId));
    }

    // 특정 프로젝트에 속하는 특정 트랙 불러오기
    @GetMapping("/{id}")
    public ResponseEntity<TrackLoadResponse> loadById(
            @PathVariable UUID projectId,
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(trackService.loadById(projectId, id));
    }

    // 특정 프로젝트에 속하는 특정 트랙 수정하기
    @PatchMapping("/{id}")
    public ResponseEntity<TrackLoadResponse> update(
            @PathVariable UUID projectId,
            @PathVariable UUID id,
            @RequestBody TrackUpdateRequest request
    ) {
        return ResponseEntity.ok(trackService.update(projectId, id, request));
    }

    // 특정 프로젝트에 속하는 특정 트랙 삭제하기
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID projectId, @PathVariable UUID id) {
        trackService.deleteById(projectId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
