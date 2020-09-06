package com.tghr.comm.exception;

public class OptionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OptionNotFoundException(String exception) {
		super(exception);
	}

}