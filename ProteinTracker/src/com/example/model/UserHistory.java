package com.example.model;

import java.util.Date;

public class UserHistory {
	private int id;
	private User user;
	
	private Date date;
	private String description;
	
	public UserHistory() {}
	
	public UserHistory(Date date, String description) {
		this.date = date;
		this.description = description;
	}


	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
