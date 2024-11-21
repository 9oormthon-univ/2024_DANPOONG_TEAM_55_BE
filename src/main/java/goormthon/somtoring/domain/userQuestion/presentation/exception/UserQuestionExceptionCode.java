package goormthon.somtoring.domain.userQuestion.presentation.exception;

import org.springframework.http.HttpStatus;

import goormthon.somtoring.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserQuestionExceptionCode implements ExceptionCode {
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
