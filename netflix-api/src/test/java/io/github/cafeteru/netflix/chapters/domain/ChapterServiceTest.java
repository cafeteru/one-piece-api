package io.github.cafeteru.netflix.chapters.domain;

import io.github.cafeteru.netflix.chapters.adapter.api.mapper.ChapterMapper;
import io.github.cafeteru.netflix.chapters.adapter.api.mapper.ChapterMapperImpl;
import io.github.cafeteru.netflix.chapters.adapter.db.ChapterRepository;
import io.github.cafeteru.netflix.chapters.adapter.db.model.Chapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Import(ChapterMapperImpl.class)
public class ChapterServiceTest {
    private List<Chapter> chapters;

    @InjectMocks
    private ChapterService service;

    @Mock
    private ChapterRepository repository;

    @Autowired
    private ChapterMapper mapper;

    @BeforeEach
    void setUp() {
        chapters = List.of(
                Chapter.builder().title("1089").number(1089).duration(23).build(),
                Chapter.builder().title("1090").number(1090).duration(23).build()
        );
        service = new ChapterService(repository, mapper);
    }

    @Test
    void when_findAll_get_a_pageable_then_return_chapters() {
        var page = new PageImpl<>(chapters);
        var pageable = PageRequest.of(1, 10);
        when(repository.findAll(pageable)).thenReturn(page);

        var result = service.findAll(pageable);

        verify(repository, times(1)).findAll(pageable);
        assertNotEquals(chapters.getClass(), result.getClass());
        assertEquals(chapters.size(), result.getSize());
    }
}
