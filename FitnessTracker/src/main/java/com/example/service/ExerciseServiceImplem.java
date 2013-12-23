package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Activity;

@Service("exerciseService")
public class ExerciseServiceImplem implements ExerciseService{
	public List<Activity> findAllActivities() {
		String[] sactivities = {"Swim", "Run", "Bike"};
		List<Activity> activities = new ArrayList<Activity>();
		
		for (String sactivity: sactivities) {
			Activity act = new Activity();
			act.setDesc(sactivity);
			activities.add(act);
		}
		
		return activities;
	}
}
