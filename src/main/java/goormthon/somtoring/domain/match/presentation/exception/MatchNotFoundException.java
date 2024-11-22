package goormthon.somtoring.domain.match.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class MatchNotFoundException extends CustomException {
    public MatchNotFoundException() {
        super(MatchExceptionCode.MATCH_NOT_FOUND);
    }
}
