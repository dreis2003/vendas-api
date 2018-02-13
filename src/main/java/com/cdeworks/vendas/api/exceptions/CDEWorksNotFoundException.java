package com.cdeworks.vendas.api.exceptions;

public class CDEWorksNotFoundException extends CDEWorksException {

	private static final long serialVersionUID = 1L;
	
	public CDEWorksNotFoundException(String msg) {
		super(msg);
	}
	
	public CDEWorksNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
