package com.masaischool.Exception;

public class NoProblemsFoundException extends Exception{

	public NoProblemsFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "No Problems Found Exception";
	}
	
	
	
	
}
