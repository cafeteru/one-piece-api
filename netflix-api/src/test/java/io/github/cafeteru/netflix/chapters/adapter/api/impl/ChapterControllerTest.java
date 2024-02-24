package io.github.cafeteru.netflix.chapters.adapter.api.impl;

import io.github.cafeteru.netflix.chapters.adapter.api.dto.ChapterDto;
import io.github.cafeteru.netflix.chapters.domain.ChapterService;
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
public class ChapterControllerTest {
    private List<ChapterDto> characters;
    private PageImpl<ChapterDto> page;
    private PageRequest pageable;

    @InjectMocks
    private ChapterController controller;
    @Mock
    private ChapterService service;

    @BeforeEach
    void setUp() {
        characters = List.of(
                ChapterDto.builder().title("1089").number(1089).duration(23).build(),
                ChapterDto.builder().title("1090").number(1090).duration(23).build()
        );
        page = new PageImpl<>(characters);
        pageable = PageRequest.of(1, 10);
    }

    @Test
    void when_findAll_obtain_results_should_return_a_page() {
        when(service.findAll(pageable)).thenReturn(page);

        var result = controller.findAll(pageable);

        verify(service, times(1)).findAll(pageable);
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(characters, result.getBody().getContent());
    }

    @Test
    void when_findAll_not_obtain_results_should_return_empty() {
        when(service.findAll(pageable)).thenReturn(Page.empty());

        var result = controller.findAll(pageable);

        verify(service, times(1)).findAll(pageable);
        assertNotNull(result);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        assertNull(result.getBody());
    }
}
