package goormthon.somtoring.domain.evaluate.presentation.response;

import goormthon.somtoring.domain.tag.domain.Tag;
import goormthon.somtoring.domain.tag.presentation.response.TagListResponse;
import goormthon.somtoring.domain.user.domain.user.User;
import goormthon.somtoring.domain.user.presentation.response.UserSummaryResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record EvaluateSelectResponse(
        UserSummaryResponse user,
        TagListResponse tag
) {
    public static EvaluateSelectResponse of(User user, List<Tag> tag) {
        return EvaluateSelectResponse.builder()
                .user(UserSummaryResponse.from(user))
                .tag(TagListResponse.of(tag))
                .build();
    }
}
