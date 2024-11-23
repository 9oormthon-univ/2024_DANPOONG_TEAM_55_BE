package goormthon.somtoring.domain.file.presentation.exception;

import static goormthon.somtoring.domain.file.presentation.exception.FileExceptionCode.FILE_CONVERT_ERROR;

import goormthon.somtoring.common.exception.CustomException;

public class FileConvertErrorException extends CustomException {

	public FileConvertErrorException() {
		super(FILE_CONVERT_ERROR);
	}
}
