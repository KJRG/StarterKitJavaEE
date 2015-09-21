package com.capgemini.starterkit.jee.todo.service;

public class AuthorizationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2892193729265698329L;

	public AuthorizationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorizationException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AuthorizationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AuthorizationException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AuthorizationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
