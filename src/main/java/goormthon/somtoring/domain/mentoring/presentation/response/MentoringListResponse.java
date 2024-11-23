package goormthon.somtoring.domain.mentoring.presentation.response;

import java.util.List;

import goormthon.somtoring.domain.mentoring.domain.Mentoring;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record MentoringListResponse(
	@Schema(
		description = "멘토링 목록",
		example = "[{\"id\": 1, \"title\": \"피그마로 컨텐츠 제작하기\", \"profileImageUrl\": \"/example/profile.png\", \"mentor\": {\"id\": 1, \"nickname\": \"산뜻한 구름\", \"role\": \"MENTOR\", \"additionalInfo\": \"안녕하세요\", \"tags\": [\"열정적인\", \"친절한\"]}}]",
		requiredMode = Schema.RequiredMode.REQUIRED
	)
	List<MentoringResponse> contents
) {
	public static MentoringListResponse from(List<Mentoring> mentorings) {
		return MentoringListResponse.builder()
			.contents(
				mentorings.stream()
					.map(MentoringResponse::from)
					.toList()
			)
			.build();
	}

}
