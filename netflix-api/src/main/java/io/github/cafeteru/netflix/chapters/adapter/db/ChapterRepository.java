package io.github.cafeteru.netflix.chapters.adapter.db;

import io.github.cafeteru.netflix.chapters.adapter.db.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
