package io.github.cafeteru.netflix.chapter;

import io.github.cafeteru.netflix.chapter.adapter.db.ChapterRepository;
import io.github.cafeteru.netflix.chapter.adapter.db.model.Chapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
class LoadChapters {
    @Bean
    protected CommandLineRunner initDatabase(ChapterRepository repository) {
        return args -> {
            var chapters = createChapters();
            chapters.forEach(price -> log.info("Preloading price" + repository.save(price)));
        };
    }

    public List<Chapter> createChapters() {
        return List.of(
                Chapter.builder().title("1089").number(1089).duration(23).build(),
                Chapter.builder().title("1090").number(1090).duration(23).build(),
                Chapter.builder().title("1091").number(1091).duration(23).build(),
                Chapter.builder().title("1092").number(1092).duration(23).build(),
                Chapter.builder().title("1093").number(1093).duration(23).build(),
                Chapter.builder().title("1094").number(1094).duration(23).build()
        );
    }
}
