package io.github.cafeteru.OnePiece.characters.port;

import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CharacterPort {
    Page<Character> findAll(Pageable pageable);
}
