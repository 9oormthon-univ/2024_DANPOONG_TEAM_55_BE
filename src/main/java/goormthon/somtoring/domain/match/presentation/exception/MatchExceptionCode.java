package goormthon.somtoring.domain.match.presentation.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.HttpStatus;
import goormthon.somtoring.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MatchExceptionCode implements ExceptionCode {
    MATCH_NOT_FOUND(NOT_FOUND, "해당 매칭 정보를 찾을 수 없습니다."),
    ALREADY_ACCEPTED(BAD_REQUEST, "이미 승인된 매칭입니다."),
    APPROVE_UNAUTHORIZED_MENTOR(BAD_REQUEST, "해당 매칭을 승인할 수 있는 멘토가 아닙니다.")
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return this.name();
    }
}
