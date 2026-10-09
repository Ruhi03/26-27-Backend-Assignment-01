package com.gdg.restapi.controller;

import com.gdg.restapi.dto.track.TrackLoadResponse;
import com.gdg.restapi.dto.track.TrackUpdateRequest;
import com.gdg.restapi.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects/{projectId}/tracks")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping
    public ResponseEntity<TrackLoadResponse> createTrack(@PathVariable("projectId") UUID projectId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(trackService.create(projectId));
    }

    @GetMapping
    public ResponseEntity<List<TrackLoadResponse>> loadAll(@PathVariable("projectId") UUID projectId) {
        return ResponseEntity.ok(trackService.loadAll(projectId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackLoadResponse> loadById(@PathVariable UUID id) {
        return ResponseEntity.ok(trackService.loadById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TrackLoadResponse> update(@PathVariable UUID projectId, @PathVariable UUID id, @RequestBody TrackUpdateRequest request) {
        return ResponseEntity.ok(trackService.update(projectId, id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrackLoadResponse> deleteById(@PathVariable UUID id) {
        trackService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}