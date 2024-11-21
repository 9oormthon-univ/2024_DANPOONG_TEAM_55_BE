package goormthon.somtoring.domain.user.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class UserNotFoundException extends CustomException {
	public UserNotFoundException() {
		super(UserExceptionCode.USER_NOT_FOUND);
	}
}
