package goormthon.somtoring.domain.match.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class ApproveUnauthorizedMentorException extends CustomException {
	public ApproveUnauthorizedMentorException() {
		super(MatchExceptionCode.APPROVE_UNAUTHORIZED_MENTOR);
	}
}
