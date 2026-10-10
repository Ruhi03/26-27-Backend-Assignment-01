package com.gdg.restapi.service;

import com.gdg.restapi.domain.Track;
import com.gdg.restapi.dto.track.TrackLoadResponse;
import com.gdg.restapi.dto.track.TrackUpdateRequest;
import com.gdg.restapi.repository.ProjectRepository;
import com.gdg.restapi.repository.TrackRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;
    private final ProjectRepository projectRepository;

    // 입력된 프로젝트 아이디가 존재하는 프로젝트인지 확인
    private void validateProjectExists(UUID projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "존재하지 않는 프로젝트입니다.");
        }
    }

    // 1. 프로젝트 유효 확인
    // 2. 트랙 유효 확인
    // 3. 트랙의 소속 확인
    private Track findTrack(UUID projectId, UUID id) {
        validateProjectExists(projectId);

        Track track = trackRepository.loadById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "존재하지 않는 트랙입니다."));

        if (!track.getProjectId().equals(projectId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "해당 프로젝트에 속하지 않는 트랙입니다.");
        }

        return track;
    }

    // 입력된 볼륨의 값을 확인 후
    // 조건을 만족하지 않을 경우 예외처리
    private void validateVolume(Double volume) {
        if (volume != null
                && (!Double.isFinite(volume) || volume < 0 || volume > 100)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "볼륨은 0~100 사이여야 합니다.");
        }
    }

    public TrackLoadResponse create(UUID projectId) {
        validateProjectExists(projectId);
        Track track = new Track(UUID.randomUUID(), projectId);
        trackRepository.create(track);

        return new TrackLoadResponse(track);
    }

    public List<TrackLoadResponse> loadAll(UUID projectId) {
        validateProjectExists(projectId);

        return trackRepository.loadAll(projectId).stream()
                .map(TrackLoadResponse::new)
                .toList();
    }

    public TrackLoadResponse loadById(UUID projectId, UUID id) {
        Track track = findTrack(projectId, id);

        return new TrackLoadResponse(track);
    }

    public TrackLoadResponse update(UUID projectId, UUID id, TrackUpdateRequest request) {
        Track track = findTrack(projectId, id);
        validateVolume(request.getVolume());
        track.update(request.getName(), request.getVolume(), request.getMuted());

        return new TrackLoadResponse(track);
    }

    public void deleteById(UUID projectId, UUID id) {
        findTrack(projectId, id);
        trackRepository.deleteById(id);
    }
}
