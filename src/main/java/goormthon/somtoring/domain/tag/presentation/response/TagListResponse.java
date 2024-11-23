package goormthon.somtoring.domain.tag.presentation.response;

import goormthon.somtoring.domain.tag.domain.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
public record TagListResponse(
        @Schema(
                description = "태그 리스트",
                example = "[{\"id\": 1, \"content\": \"응답이 빨라요\", \"tagType\": \"GOOD\"}]"
        )
        List<TagResponse> contents
) {
    public static TagListResponse of(List<Tag> tags) {
        return TagListResponse.builder()
                .contents(
                        tags.stream()
                                .map(TagResponse::of)
                                .toList()
                )
                .build();
    }
}
