package io.github.cafeteru.netflix.common.adapter.api.dto;


import lombok.Builder;

@Builder
public record ErrorDto(String message) {
}
