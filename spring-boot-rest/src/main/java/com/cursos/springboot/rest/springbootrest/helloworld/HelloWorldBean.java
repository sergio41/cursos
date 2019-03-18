package com.cursos.springboot.rest.springbootrest.helloworld;

public class HelloWorldBean {

	private String message;
	public HelloWorldBean(String pMessage) {
		this.message = pMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
}
