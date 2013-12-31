package com.example.model;

public class GoalAlert {
	private int id;
	private String message;
	
	public GoalAlert() {}
	
	public GoalAlert(String msg) {
		this.message = msg;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
