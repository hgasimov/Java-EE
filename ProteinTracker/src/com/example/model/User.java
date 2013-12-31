package com.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
	
	private int id;
	private String name;
	private ProteinData proteinData;
	//private Set<UserHistory> history = new HashSet<UserHistory>();
	private List<UserHistory> history = new ArrayList<UserHistory>();
	private Set<GoalAlert> goalAlert = new HashSet<GoalAlert>();
	

	public User() {
		setProteinData(new ProteinData());
	}
	
	
	public List<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		proteinData.setUser(this);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		this.history.add(historyItem);
	}
	public Set<GoalAlert> getGoalAlert() {
		return goalAlert;
	}
	public void setGoalAlert(Set<GoalAlert> goalAlert) {
		this.goalAlert = goalAlert;
	}
	public void addGoalAlert(GoalAlert alert) {
		this.goalAlert.add(alert);
	}
}
