package io.github.cafeteru.netflix.chapter.adapter.api.impl;

import io.github.cafeteru.netflix.chapter.adapter.api.ChapterApi;
import io.github.cafeteru.netflix.chapter.adapter.api.dto.ChapterDto;
import io.github.cafeteru.netflix.chapter.domain.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChapterController implements ChapterApi {
    private final ChapterService chapterService;

    public ResponseEntity<Page<ChapterDto>> findAll(Pageable pageable) {
        final var page = chapterService.findAll(pageable);
        return page.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(page);
    }
}
