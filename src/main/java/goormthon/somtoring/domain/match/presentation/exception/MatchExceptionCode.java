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
    MENTOR_NOT_FOUND(NOT_FOUND, "해당 멘토를 찾을 수 없습니다."),
    MENTEE_NOT_FOUND(NOT_FOUND, "해당 멘티를 찾을 수 없습니다."),
    ALREADY_ACCEPTED(BAD_REQUEST, "이미 승인된 매칭입니다.");

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return this.name();
    }
}
