package com.gdg.restapi.service;

import com.gdg.restapi.domain.Track;
import com.gdg.restapi.dto.track.TrackLoadResponse;
import com.gdg.restapi.dto.track.TrackUpdateRequest;
import com.gdg.restapi.repository.TrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    public TrackLoadResponse create(UUID projectId) {
        Track track = new Track(UUID.randomUUID(), projectId);

        trackRepository.create(track);

        return new TrackLoadResponse(track);
    }

    public List<TrackLoadResponse> loadAll(UUID projectId) {
        return trackRepository.loadAll(projectId).stream()
                .map(TrackLoadResponse::new)
                .toList();
    }

    public TrackLoadResponse loadById(UUID id) {
        Track track = trackRepository.loadById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 트랙입니다."));

        return new TrackLoadResponse(track);
    }

    public TrackLoadResponse update(UUID projectId, UUID id, TrackUpdateRequest request) {
        Track track = trackRepository.loadById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 트랙입니다."));

        track.update(projectId, request.getName(), request.getVolume(), request.getMuted());

        return new TrackLoadResponse(track);
    }

    public void deleteById(UUID id) {
        if (!trackRepository.deleteById(id)) {
            throw new IllegalArgumentException("존재하지 않는 프로젝트입니다.");
        }
    }
}
