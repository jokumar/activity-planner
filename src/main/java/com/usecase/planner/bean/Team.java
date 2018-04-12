package com.usecase.planner.bean;

import java.util.List;
/**
 * 
 * @author jokumar
 *	Bean for storing the teams
 */
public class Team {


	private String teamName;
	private List<Activity> activityList;
	
	public Team(String teamName , List<Activity> activity){
		
		this.teamName=teamName;
		this.activityList=activity;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}
	
	
	
}
