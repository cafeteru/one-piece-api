package io.github.cafeteru.OnePiece.characters.adapter.api.impl;

import io.github.cafeteru.OnePiece.characters.adapter.db.model.Character;
import io.github.cafeteru.OnePiece.characters.domain.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CharacterControllerTest {
    private List<Character> characters;
    private PageImpl<Character> page;
    private PageRequest pageable;

    @InjectMocks
    private CharacterController controller;
    @Mock
    private CharacterService service;

    @BeforeEach
    void setUp() {
        characters = List.of(
                Character.builder().name("a").surname("a").build(),
                Character.builder().name("b").surname("b").build(),
                Character.builder().name("c").surname("c").build()
        );
        page = new PageImpl<>(characters);
        pageable = PageRequest.of(1, 10);
    }

    @Test
    void findAll_with_successfully_response() {
        when(service.findAll(pageable)).thenReturn(page);

        var result = controller.findAll(pageable);

        verify(service, times(1)).findAll(pageable);
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(characters, result.getBody().getContent());
    }

    @Test
    void findAll_with_empty_response() {
        when(service.findAll(pageable)).thenReturn(Page.empty());

        var result = controller.findAll(pageable);

        verify(service, times(1)).findAll(pageable);
        assertNotNull(result);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        assertNull(result.getBody());
    }
}
