package io.github.cafeteru.OnePiece.characters;

import io.github.cafeteru.OnePiece.characters.adapter.db.CharacterRepository;
import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
class LoadCharacters {

    @Bean
    protected CommandLineRunner initDatabase(CharacterRepository repository) {
        return args -> {
            var characters = loadCharacters();
            characters.forEach(character -> log.info("Preloading " + repository.save(character)));
        };
    }

    private List<Character> loadCharacters() {
        List<Character> characters = new ArrayList<>();
        characters.add(Character.builder().surname("Monkey D.").name("Luffy").build());
        characters.add(Character.builder().surname("Roronoa").name("Zoro").build());
        characters.add(Character.builder().name("Nami").build());
        characters.add(Character.builder().name("Usopp").build());
        characters.add(Character.builder().surname("Vinsmoke").name("Sanji").build());
        characters.add(Character.builder().surname("Tony Tony").name("Chopper").build());
        characters.add(Character.builder().surname("Nico").name("Robin").build());
        characters.add(Character.builder().name("Franky").build());
        characters.add(Character.builder().name("Brook").build());
        characters.add(Character.builder().name("Jinbe").build());
        return characters;
    }
}