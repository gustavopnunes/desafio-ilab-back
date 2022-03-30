package br.com.grupodois.desafioilab.exceptions;

public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message; 
	private int statusCode;
	
	public CustomException(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
