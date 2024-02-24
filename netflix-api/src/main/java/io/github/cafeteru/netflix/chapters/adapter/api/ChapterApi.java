package io.github.cafeteru.netflix.chapters.adapter.api;

import io.github.cafeteru.netflix.chapters.adapter.api.dto.ChapterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chapters")
@Tag(name = "Chapters", description = "Chapters API")
public interface ChapterApi {
    @Operation(summary = "REST endpoint for querying all chapters")
    @ApiResponse(responseCode = "200", description = "All filtered products' id sorted by sequence desc")
    @ApiResponse(responseCode = "204", description = "No results")
    @GetMapping
    ResponseEntity<Page<ChapterDto>> findAll(@ParameterObject Pageable pageable);
}
