package io.github.cafeteru.OnePiece.characters;

import io.github.cafeteru.OnePiece.characters.adapter.db.CharacterRepository;
import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadCharacters {

    @Bean
    CommandLineRunner initDatabase(CharacterRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Character(null, "Monkey D.", "Luffy")));
            log.info("Preloading " + repository.save(new Character(null, "Roronoa", "Zoro")));
        };
    }
}