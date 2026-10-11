package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Track;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TrackRepository {
    // Track 객체들을 모아두는 맵
    private final Map<UUID, Track> tracks = new HashMap<>();

    public void create(Track track) {
        tracks.put(track.getId(), track);
    }

    public List<Track> loadAll(UUID projectId) {
        return tracks.values().stream()
                .filter(track -> track.getProjectId().equals(projectId))
                .toList();
    }

    public Optional<Track> loadById(UUID id) {
        return Optional.ofNullable(tracks.get(id));
    }

    public void deleteById(UUID id) {
        tracks.remove(id);
    }

    public void deleteAllByProjectId(UUID projectId) {
        tracks.values().removeIf(
                track -> track.getProjectId().equals(projectId)
        );
    }
}
