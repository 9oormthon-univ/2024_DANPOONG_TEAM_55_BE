package goormthon.somtoring.domain.question.presentation.response;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import java.util.List;

import goormthon.somtoring.domain.answer.domain.Answer;
import goormthon.somtoring.domain.answer.presentation.response.AnswerResponse;
import goormthon.somtoring.domain.question.domain.Question;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record QuestionResponse(
	@Schema(description = "질문 id", example = "1", requiredMode = REQUIRED)
	Long id,

	@Schema(description = "질문 제목", example = "질문 제목 예시 입니다", requiredMode = REQUIRED)
	String title,

	@Schema(description = "질문에 대한 답변 목록", requiredMode = REQUIRED)
	List<AnswerResponse> answers
) {
	public static QuestionResponse of(Question question, List<Answer> answers) {
		return QuestionResponse.builder()
			.id(question.getId())
			.title(question.getTitle())
			.answers(
				answers.stream()
					.map(AnswerResponse::of)
					.toList()
			)
			.build();
	}

}
