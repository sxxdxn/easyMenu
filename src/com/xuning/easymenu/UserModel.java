package com.xuning.easymenu;

public class UserModel {
	
	private int userId;
	private String name;
	private String password;
	private String sessionId;
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return userId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	
	public void setSessionId(String sessionId){
		this.sessionId = sessionId;
	}
	public String getSessionId(){
		return sessionId;
	}

}
