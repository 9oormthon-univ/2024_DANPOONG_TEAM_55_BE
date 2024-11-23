package goormthon.somtoring.domain.tag.presentation.exception;

import goormthon.somtoring.common.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum TagExceptionCode implements ExceptionCode {

    TAG_NOT_FOUND(NOT_FOUND, "태그를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return this.name();
    }
}
