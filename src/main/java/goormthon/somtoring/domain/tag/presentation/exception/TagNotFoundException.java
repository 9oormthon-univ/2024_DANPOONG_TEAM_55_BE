package goormthon.somtoring.domain.tag.presentation.exception;

import goormthon.somtoring.common.exception.CustomException;

public class TagNotFoundException extends CustomException {
    public TagNotFoundException() {
        super(TagExceptionCode.TAG_NOT_FOUND);
    }
}
