package io.github.cafeteru.netflix.chapters.adapter.api.dto;

import lombok.Builder;

@Builder
public record ChapterDto(Long id, String title, String description, Integer duration, Integer number) {
}
