package goormthon.somtoring.domain.evaluate.presentation.response;

import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.presentation.response.TagListResponse;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.presentation.response.UserSummaryResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Builder
public record EvaluateSelectResponse(
        @Schema(
                description = "멘토 정보",
                example = "{\"id\": 1, \"nickname\": \"산뜻한 구름\", \"role\": \"MENTOR\", \"additionalInfo\": \"안녕하세요\", \"tags\": [\"열정적인\", \"친절한\"]}",
                requiredMode = REQUIRED)
        UserSummaryResponse user,
        @Schema(
                description = "태그 리스트",
                example = "[{\"id\": 1, \"content\": \"응답이 빨라요\", \"tagType\": \"GOOD\", \"}]",
                requiredMode = REQUIRED
        )
        TagListResponse tag
) {
    public static EvaluateSelectResponse of(User user, List<Tag> tag) {
        return EvaluateSelectResponse.builder()
                .user(UserSummaryResponse.from(user))
                .tag(TagListResponse.of(tag))
                .build();
    }
}
