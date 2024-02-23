package io.github.cafeteru.OnePiece.characters.domain;

import io.github.cafeteru.OnePiece.characters.adapter.db.CharacterRepository;
import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import io.github.cafeteru.OnePiece.characters.port.CharacterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService implements CharacterPort {
    private final CharacterRepository repository;

    @Override
    public Page<Character> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
