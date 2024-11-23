package goormthon.somtoring.domain.tag.presentation.response;

import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.domain.TagType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Builder
public record TagResponse(
    @Schema(description = "태그 id", example = "1", requiredMode = REQUIRED)
    Long id,

    @Schema(description = "태그 내용", example = "응답이 빨라요", requiredMode = REQUIRED)
    String content,

    @Schema(description = "태그 종류", example = "GOOD", requiredMode = REQUIRED)
    TagType tagType
) {
    public static TagResponse of (Tag tag) {
        return TagResponse.builder()
            .id(tag.getId())
            .content(tag.getContent())
            .tagType(tag.getTagType())
            .build();
    }
}
