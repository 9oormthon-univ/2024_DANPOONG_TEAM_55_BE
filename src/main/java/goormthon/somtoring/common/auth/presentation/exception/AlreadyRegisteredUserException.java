package goormthon.somtoring.common.auth.presentation.exception;

import static goormthon.somtoring.common.auth.presentation.exception.AuthExceptionCode.ALREADY_REGISTERED_USER;

import goormthon.somtoring.common.exception.CustomException;

public class AlreadyRegisteredUserException extends CustomException {
	public AlreadyRegisteredUserException() {
		super(ALREADY_REGISTERED_USER);
	}
}
