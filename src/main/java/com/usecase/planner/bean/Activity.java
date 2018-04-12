package com.usecase.planner.bean;

import com.usecase.planner.constant.ActivityConstant;
/**
 * 
 * @author jokumar
 *	Bean for storing the activity information
 */
public class Activity {

	private String startTime;
	private String name;
	private String duation;
	private int durationInMin;

	
	public Activity(String name, String time) {

		this.name = name;
		this.duation = time;
		if ("sprint".equalsIgnoreCase(time)) {
			this.durationInMin = ActivityConstant.SPRINT;
		} else if (time != null && time.indexOf(ActivityConstant.MIN) != -1) {
			this.durationInMin = Integer.valueOf(time.substring(0, time.indexOf(ActivityConstant.MIN)));
		}

	}
	
	public Activity(String startTime,String name, String time) {
		
		this.startTime=startTime;
		this.name = name;
		this.duation = time;
		if ("sprint".equalsIgnoreCase(time)) {
			this.durationInMin = ActivityConstant.SPRINT;
		} else if (time != null && time.indexOf(ActivityConstant.MIN) != -1) {
			this.durationInMin = Integer.valueOf(time.substring(0, time.indexOf(ActivityConstant.MIN)));
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuation() {
		return duation;
	}

	public void setDuation(String duation) {
		this.duation = duation;
	}

	public int getDurationInMin() {
		return durationInMin;
	}

	public void setDurationInMin(int durationInMin) {
		this.durationInMin = durationInMin;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}
