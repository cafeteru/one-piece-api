package io.github.cafeteru.netflix.chapter.adapter.db;

import io.github.cafeteru.netflix.chapter.adapter.db.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
