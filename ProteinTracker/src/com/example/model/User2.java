package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class User2 {
	
	private int id;
	private String name;
	private ProteinData proteinData = new ProteinData();
	//private Set<UserHistory> history = new HashSet<UserHistory>();
	private List<UserHistory2> history = new ArrayList<UserHistory2>();

	
	public List<UserHistory2> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory2> history) {
		this.history = history;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
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

}
