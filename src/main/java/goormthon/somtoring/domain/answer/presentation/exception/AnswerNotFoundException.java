package goormthon.somtoring.domain.answer.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class AnswerNotFoundException extends CustomException {
	public AnswerNotFoundException() {
		super(AnswerExceptionCode.ANSWER_NOT_FOUND);
	}
}
