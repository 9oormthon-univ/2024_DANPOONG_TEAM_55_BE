package goormthon.somtoring.domain.file.presentation.exception;

import static goormthon.somtoring.domain.file.presentation.exception.FileExceptionCode.OBJECTSTORAGE_SERVER_ERROR;

import goormthon.somtoring.common.exception.CustomException;

public class ObjectStorageServerException extends CustomException {
	public ObjectStorageServerException() {
		super(OBJECTSTORAGE_SERVER_ERROR);
	}
}
