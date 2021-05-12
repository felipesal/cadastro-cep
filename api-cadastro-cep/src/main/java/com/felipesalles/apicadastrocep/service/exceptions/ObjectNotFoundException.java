package com.felipesalles.apicadastrocep.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	
	private String msg;


	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	
}