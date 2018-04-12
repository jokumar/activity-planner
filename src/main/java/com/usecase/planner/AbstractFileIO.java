package com.usecase.planner;

import java.util.List;

import org.apache.log4j.Logger;

import com.usecase.planner.bean.Activity;
import com.usecase.planner.bean.Team;

/**
 * 
 * 
 * @author jokumar
 *	Abstract class for reading files in different manner
 */
public abstract class AbstractFileIO {
	
	Logger logger = Logger.getLogger(AbstractFileIO.class);
	
	public abstract void writeInFile(List<Team> teamList);
	
	public abstract List<Activity> getActivityList();
	
	
	// Get the activity by parsing each line
		public Activity getActivity(String line) {

			if (line.lastIndexOf(' ') == -1) {
				logger.error("Wrong syntax in inputfile : " + line);
			}
			return new Activity(line.substring(0, line.lastIndexOf(' ')), line.substring(line.lastIndexOf(' ') + 1));
		}
	
}
