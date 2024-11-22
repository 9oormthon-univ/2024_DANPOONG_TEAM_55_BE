package goormthon.somtoring.domain.match.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class MentorNotFoundException extends CustomException {
    public MentorNotFoundException() {
        super(MatchExceptionCode.MENTOR_NOT_FOUND);
    }
}
