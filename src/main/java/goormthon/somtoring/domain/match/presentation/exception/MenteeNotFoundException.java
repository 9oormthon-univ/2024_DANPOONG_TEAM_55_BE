package goormthon.somtoring.domain.match.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class MenteeNotFoundException extends CustomException {
    public MenteeNotFoundException() {
        super(MatchExceptionCode.MENTEE_NOT_FOUND);
    }
}
