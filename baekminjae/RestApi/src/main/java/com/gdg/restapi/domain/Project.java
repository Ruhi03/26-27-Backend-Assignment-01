package com.gdg.restapi.domain;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Getter
public class Project {
    private final UUID id;
    private String title;

    public Project(UUID id, String title) {
        this.id = id;
        this.title = StringUtils.hasText(title)
                ? title
                : "기본 프로젝트";
    }

    public void rename(String title) {
        if (!StringUtils.hasText(title)) {
            throw new IllegalArgumentException("프로젝트 제목은 비어 있을 수 없습니다.");
        }

        this.title = title;
    }
}
