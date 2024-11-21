package goormthon.somtoring.domain.answer.presentation.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import goormthon.somtoring.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnswerExceptionCode implements ExceptionCode {
	ANSWER_NOT_FOUND(NOT_FOUND, "존재하지 않는 답변입니다"),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}