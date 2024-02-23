package io.github.cafeteru.OnePiece.characters.adapter.db;

import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
