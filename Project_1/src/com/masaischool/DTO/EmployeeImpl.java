package com.masaischool.DTO;

public class EmployeeImpl implements Employee {

	String username;
	String password;
	
	public EmployeeImpl() {};
	
	public EmployeeImpl(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
    @Override
	public String getUsername() {
		return username;
	}
    @Override
	public void setUsername(String username) {
		this.username = username;
	}
    @Override
	public String getPassword() {
		return password;
	}
    @Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
