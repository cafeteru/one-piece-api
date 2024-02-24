package io.github.cafeteru.netflix.chapters.port;

import io.github.cafeteru.netflix.chapters.adapter.api.dto.ChapterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChapterPort {
    Page<ChapterDto> findAll(Pageable pageable);
}
