package com.tghr.comm.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApplicationException(String exception) {
		super(exception);
	}

}