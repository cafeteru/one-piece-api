package io.github.cafeteru.netflix.chapter.adapter.api.mapper;

import io.github.cafeteru.netflix.chapter.adapter.api.dto.ChapterDto;
import io.github.cafeteru.netflix.chapter.adapter.db.model.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ChapterMapper {
    ChapterDto toDto(Chapter chapter);
}
