package com.cdeworks.vendas.api.exceptions;

public class CDEWorksException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private final String message;

	public CDEWorksException() {
	        super();
	        this.message = "";
	    }

	public CDEWorksException(String message) {
	        super(message);
	        this.message = message;
	    }

	public CDEWorksException(String message, Throwable cause) {
	        super(message, cause);
	        this.message = message;
	    }

	public CDEWorksException(Throwable cause) {
	        super(cause);
	        this.message = "";
	    }

	@Override
	public String getLocalizedMessage() {
		return message;
	}

}
