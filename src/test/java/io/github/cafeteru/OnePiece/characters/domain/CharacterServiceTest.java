package io.github.cafeteru.OnePiece.characters.domain;

import io.github.cafeteru.OnePiece.characters.adapter.db.CharacterRepository;
import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {
    private List<Character> characters;

    @InjectMocks
    private CharacterService service;

    @Mock
    private CharacterRepository repository;

    @BeforeEach
    void setUp() {
        characters = List.of(
                Character.builder().name("a").surname("a").build(),
                Character.builder().name("b").surname("b").build(),
                Character.builder().name("c").surname("c").build()
        );
    }

    @Test
    void findAll_with_successfully_response() {
        var page = new PageImpl<>(characters);
        var pageable = PageRequest.of(1, 10);
        when(repository.findAll(pageable)).thenReturn(page);

        var result = service.findAll(pageable);

        verify(repository, times(1)).findAll(pageable);
        assertNotEquals(characters.getClass(), result.getClass());
        assertEquals(characters.size(), result.getSize());
    }
}
