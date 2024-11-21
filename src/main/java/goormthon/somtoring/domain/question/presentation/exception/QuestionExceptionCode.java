package goormthon.somtoring.domain.question.presentation.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import goormthon.somtoring.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionExceptionCode implements ExceptionCode {
	UNANSWERED_QUESTION_NOT_EXISTS(NOT_FOUND, "모든 질문에 답변을 완료하였습니다"),
	QUESTION_NOT_EXISTS(NOT_FOUND, "존재하지 않는 질문입니다"),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}