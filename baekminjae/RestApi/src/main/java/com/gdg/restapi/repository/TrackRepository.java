package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class TrackRepository {
    private final Map<UUID, Track> tracks = new HashMap<>();

    public void create(Track track) {
        tracks.put(track.getId(), track);
    }

    public List<Track> loadAll(UUID projectId) {
        return tracks.values().stream()
                .filter(track -> track.getProjectId().equals(projectId))
                .toList();
    }

    public  Optional<Track> loadById(UUID id) {
        return Optional.ofNullable(tracks.get(id));
    }

    public boolean deleteById(UUID id) {
        return tracks.remove(id) != null;
    }
}
