package goormthon.somtoring.common.auth.presentation.exception;

import static goormthon.somtoring.common.auth.presentation.exception.AuthExceptionCode.AUTHENTICATION_REQUIRED;

import goormthon.somtoring.common.exception.CustomException;

public class AuthenticationRequiredException extends CustomException {
	public AuthenticationRequiredException() {
		super(AUTHENTICATION_REQUIRED);
	}
}
