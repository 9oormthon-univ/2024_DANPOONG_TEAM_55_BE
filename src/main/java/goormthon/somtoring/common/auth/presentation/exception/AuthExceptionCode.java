package goormthon.somtoring.common.auth.presentation.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.http.HttpStatus;

import goormthon.somtoring.common.exception.ExceptionCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthExceptionCode implements ExceptionCode {
	ALREADY_REGISTERED_USER(BAD_REQUEST, "다른 소셜 계정으로 이미 가입된 사용자입니다."),
	AUTHENTICATION_REQUIRED(UNAUTHORIZED, "인증 정보가 유효하지 않습니다."),
	REFRESH_TOKEN_NOT_VALID(UNAUTHORIZED, "리프레시 토큰이 유효하지 않습니다."),
	;

	private final HttpStatus status;
	private final String message;

	@Override
	public String getCode() {
		return this.name();
	}
}
