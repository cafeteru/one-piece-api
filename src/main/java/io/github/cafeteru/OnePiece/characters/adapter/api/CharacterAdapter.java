package io.github.cafeteru.OnePiece.characters.adapter.api;

import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/characters")
public interface CharacterAdapter {
    @Operation(summary = "REST endpoint for querying all characters")
    @ApiResponse(responseCode = "200", description = "All filtered products' id sorted by sequence desc")
    @ApiResponse(responseCode = "204", description = "No results")
    @GetMapping
    ResponseEntity<Page<Character>> findAll(@ParameterObject Pageable pageable);
}
