package goormthon.somtoring.domain.answer.presentation.response;

import goormthon.somtoring.domain.answer.domain.Answer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record AnswerResponse(
	@Schema(description = "답변 id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
	Long id,

	@Schema(description = "답변 내용", example = "답변 내용 예시 입니다", requiredMode = Schema.RequiredMode.REQUIRED)
	String content
) {
	public static AnswerResponse of(Answer answer) {
		return AnswerResponse.builder()
			.id(answer.getId())
			.content(answer.getContent())
			.build();
	}
}
