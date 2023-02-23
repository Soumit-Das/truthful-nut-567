package com.masaischool.Exception;

public class SomeThingWentWrongException extends Exception {

	@Override
	public String toString() {
		return "SomeThing Went Wrong Exception" + getMessage();
	}

	
	
}
