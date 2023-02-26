package com.masaischool.DTO;

import java.util.Objects;

public class EngineerImpl implements Engineer {

	private String username;
	private String password;
	private String category;
	
	public EngineerImpl() {};
	
	public EngineerImpl(String username, String password, String category) {
		super();
		this.username = username;
		this.password = password;
		this.category = category;
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
    @Override
	public String getCategory() {
		return category;
	}
    @Override
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EngineerImpl other = (EngineerImpl) obj;
		return Objects.equals(username, other.username);
	}
	
	
	
	
}
