package com.masaischool.Exception;

public class NoEngineerFoundException extends Exception{

	public NoEngineerFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "No Engineer Found Exception";
	}
	
}
