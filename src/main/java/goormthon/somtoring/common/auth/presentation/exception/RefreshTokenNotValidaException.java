package goormthon.somtoring.common.auth.presentation.exception;

import static goormthon.somtoring.common.auth.presentation.exception.AuthExceptionCode.REFRESH_TOKEN_NOT_VALID;

import goormthon.somtoring.common.exception.CustomException;

public class RefreshTokenNotValidaException extends CustomException {
	public RefreshTokenNotValidaException() {
		super(REFRESH_TOKEN_NOT_VALID);
	}
}
