package com.usecase.planner;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.usecase.planner.bean.Activity;
import com.usecase.planner.bean.Team;
import com.usecase.planner.constant.ActivityConstant;

/**
 * 
 * @author jokumar
 *	This file is main file which assigns the activities
 */

public class ActivityAssigner {
	
	Logger logger = Logger.getLogger(ActivityAssigner.class);
 
	public List<Team> computeTimeTable(List<Activity> activityList) {
		logger.info("Starting to compute the Time ");
		// Start time for activities
		String startTime = ActivityConstant.NINE_HRS;
		// Activity start time which varies
		String variableTime = startTime;
		// List of all the activity of a team
		List<Activity> assignedList = new ArrayList<>();
		// List of all the teams
		List<Team> teamList = new ArrayList<>();
		// flag to verify if lunch is already served for the team
		boolean isLunchServed = false;
		// flag to verify if presentation is already done for the team
		boolean isPresentationDone = false;
		// Counter to count the number of team
		int teamCount = 1;
		// Counter to count the number of activity
		int activityCounter = 0;
		// measure the size of the activity list
		int activeSize = activityList.size();

		for (Activity activity : activityList) {
			activityCounter++;

			// Setting Lunch Hours
			if (!isLunchServed && TimeConvertersUtil.compareTime(TimeConvertersUtil.addTime(variableTime, activity.getDurationInMin()), ActivityConstant.TWELVE_HRS)) {
				assignedList.add(new Activity(variableTime, ActivityConstant.LUNCH_BREAK, "60min"));
				variableTime = TimeConvertersUtil.addTime(variableTime, 60);
				isLunchServed = true;
			}

			// Setting Presentation Hours
			if (!isPresentationDone && TimeConvertersUtil.compareTime(TimeConvertersUtil.addTime(variableTime, activity.getDurationInMin()),
					ActivityConstant.SEVENTEEN_HRS)) {
				assignedList.add(new Activity(variableTime, "Staff Motivation Presentation", ""));
				isPresentationDone = true;
			}

			// Setting Presentation Hours for the final set where the activities
			// are not reaching till 4pm
			if (activityCounter == activeSize && !isPresentationDone
					&& !TimeConvertersUtil.compareTime(TimeConvertersUtil.addTime(variableTime, activity.getDurationInMin()),
							ActivityConstant.SEVENTEEN_HRS)) {
				
				
				assignedList.add(new Activity(variableTime, activity.getName(), activity.getDuation()));
				variableTime = TimeConvertersUtil.addTime(variableTime, activity.getDurationInMin());
				
				if(!isLunchServed){
					assignedList.add(new Activity(ActivityConstant.TWELVE_HRS, ActivityConstant.LUNCH_BREAK, "60min"));
				}
				// If current time is before 4pm then set the presentation time
				// as 4pm,
				if (TimeConvertersUtil.compareTime(ActivityConstant.SIXTEEN_HRS, variableTime)) {
					variableTime = ActivityConstant.SIXTEEN_HRS;
				}
				assignedList.add(new Activity(variableTime, "Staff Motivation Presentation", ""));
				teamList.add(new Team("Team " + teamCount, assignedList));
				break;
			}
			
			// When presentation is done , reset the flags and assignedList
			if (isPresentationDone) {
				teamList.add(new Team("Team " + teamCount++, assignedList));
				isPresentationDone = false;
				isLunchServed = false;
				variableTime = startTime;
				assignedList = new ArrayList<>();
			}

			// add each activity time
			assignedList.add(new Activity(variableTime, activity.getName(), activity.getDuation()));
			variableTime = TimeConvertersUtil.addTime(variableTime, activity.getDurationInMin());

		}
		logger.info("Completed forming the teams and the activities. Check the file in resource folder");
		return teamList;
	}

}
