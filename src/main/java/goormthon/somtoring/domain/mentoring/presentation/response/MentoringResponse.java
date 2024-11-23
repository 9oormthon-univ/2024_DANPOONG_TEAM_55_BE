package goormthon.somtoring.domain.mentoring.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import goormthon.somtoring.domain.mentoring.domain.Mentoring;
import goormthon.somtoring.domain.user.presentation.response.UserSummaryResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record MentoringResponse(
	@Schema(description = "멘토링 id", example = "1", requiredMode = REQUIRED)
	Long id,

	@Schema(description = "멘토링 제목", example = "피그마로 컨텐츠 제작하기", requiredMode = REQUIRED)
	String title,

	@Schema(description = "멘토링 프로필 이미지 url", example = "/example/profile.png", requiredMode = REQUIRED)
	String profileImageUrl,

	@Schema(
		description = "멘토 정보",
		example = "{\"id\": 1, \"nickname\": \"산뜻한 구름\", \"role\": \"MENTOR\", \"additionalInfo\": \"안녕하세요\", \"tags\": [\"열정적인\", \"친절한\"]}",
		requiredMode = REQUIRED)
	UserSummaryResponse mentor
) {
	public static MentoringResponse from(Mentoring mentoring) {
		return MentoringResponse.builder()
			.id(mentoring.getId())
			.title(mentoring.getTitle())
			.profileImageUrl(mentoring.getProfileImgUrl())
			.mentor(UserSummaryResponse.from(mentoring.getMentor()))
			.build();
	}
}
