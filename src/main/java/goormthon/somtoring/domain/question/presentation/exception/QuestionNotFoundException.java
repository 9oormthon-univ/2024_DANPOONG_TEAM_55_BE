package goormthon.somtoring.domain.question.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class QuestionNotFoundException extends CustomException {
	public QuestionNotFoundException() {
		super(QuestionExceptionCode.QUESTION_NOT_EXISTS);
	}
}
