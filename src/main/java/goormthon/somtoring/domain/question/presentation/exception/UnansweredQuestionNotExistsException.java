package goormthon.somtoring.domain.question.presentation.exception;

import static goormthon.somtoring.domain.question.presentation.exception.QuestionExceptionCode.UNANSWERED_QUESTION_NOT_EXISTS;

import goormthon.somtoring.common.exception.CustomException;
import goormthon.somtoring.domain.userQuestion.presentation.exception.UserQuestionExceptionCode;

public class UnansweredQuestionNotExistsException extends CustomException {
	public UnansweredQuestionNotExistsException() {
		super(UNANSWERED_QUESTION_NOT_EXISTS);
	}
}
