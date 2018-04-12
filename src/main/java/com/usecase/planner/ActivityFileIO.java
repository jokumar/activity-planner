package com.usecase.planner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.usecase.planner.bean.Activity;
import com.usecase.planner.bean.Team;
import com.usecase.planner.constant.ActivityConstant;

/**
 * 
 * @author jokumar
 *	This class does the IO operations for reading and writing file
 */
public class ActivityFileIO extends AbstractFileIO{

	Logger logger = Logger.getLogger(ActivityFileIO.class);
	@Override
	public void writeInFile(List<Team> teamList) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(ActivityConstant.OUTPUT_PATH))) {

			for (Team team : teamList) {
				out.write((team.getTeamName() + ActivityConstant.COLON));
				out.newLine();
				for (Activity activity : team.getActivityList()) {

					out.write((TimeConvertersUtil.convert24HrsTo12Hrs(activity.getStartTime()) + ActivityConstant.COLON
							+ activity.getName() + " " + activity.getDuation()));
					out.newLine();
				}

			}

			out.close();
		} catch (IOException e) {
			logger.error("File Not found ", e);
		}
	}
	@Override
	public List<Activity> getActivityList() {

		File file = new File(ActivityConstant.INPUT_PATH);
		List<Activity> activityList = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line!=null && !line.trim().equals(""))
				activityList.add(getActivity(line.trim()));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			logger.error("File Not found ", e);
		}

		return activityList;
	}

}
