package com.felipesalles.apicadastrocep.service.exceptions;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	private String msg;


	public BusinessException(String msg) {
		super(msg);
	}
	
	
}