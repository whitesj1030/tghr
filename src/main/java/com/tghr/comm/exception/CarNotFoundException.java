package com.tghr.comm.exception;

public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CarNotFoundException(String exception) {
		super(exception);
	}

}