package goormthon.somtoring.domain.user.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class InaccurateSugarValueException extends CustomException {
	public InaccurateSugarValueException() {
		super(UserExceptionCode.INACCURATE_SUGAR_VALUE);
	}
}
