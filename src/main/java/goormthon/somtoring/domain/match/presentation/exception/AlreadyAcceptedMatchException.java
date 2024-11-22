package goormthon.somtoring.domain.match.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class AlreadyAcceptedMatchException extends CustomException {
    public AlreadyAcceptedMatchException() {
        super(MatchExceptionCode.ALREADY_ACCEPTED);
    }
}
