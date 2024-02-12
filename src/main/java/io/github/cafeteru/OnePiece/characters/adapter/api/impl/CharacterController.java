package io.github.cafeteru.OnePiece.characters.adapter.api.impl;

import io.github.cafeteru.OnePiece.characters.adapter.api.CharacterAdapter;
import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import io.github.cafeteru.OnePiece.characters.domain.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CharacterController implements CharacterAdapter {
    private final CharacterService characterService;

    @Override
    public ResponseEntity<Page<Character>> findAll(Pageable pageable) {
        final var page = characterService.findAll(pageable);
        return page.isEmpty() ? ResponseEntity.noContent().build() :
                ResponseEntity.ok(page);

    }
}
