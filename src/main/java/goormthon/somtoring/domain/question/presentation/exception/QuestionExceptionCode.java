package goormthon.somtoring.domain.question.presentation.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import goormthon.somtoring.common.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum QuestionExceptionCode implements ExceptionCode {

    QUESTION_NOT_FOUND(NOT_FOUND, "질문을 찾을 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String message;

    @Override
    public String getCode() {
        return this.name();
    }
}
