package goormthon.somtoring.domain.user.presentation.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;

import goormthon.somtoring.common.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserExceptionCode implements ExceptionCode {
	USER_NOT_FOUND(NOT_FOUND, "유저를 찾을 수 없습니다."),
	INACCURATE_SUGAR_VALUE(BAD_REQUEST, "당도 값이 적절하지 않습니다"),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
