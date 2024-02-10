package io.github.cafeteru.OnePiece.characters.adapter.api;

import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/characters")
public interface CharacterAdapter {
    @GetMapping
    ResponseEntity<Page<Character>> findAll(Pageable pageable);
}
