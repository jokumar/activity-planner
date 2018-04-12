package com.usecase.planner;

import com.usecase.planner.constant.ActivityConstant;

public class ActivityAssignerMain {

	private ActivityAssignerMain(){
		
	}
	public static void main(String[] args) {
		ActivityAssigner designer = new ActivityAssigner();
		AbstractFileIO fileIO=FileIOFactory.getFileInstance(ActivityConstant.FILE_IO);
		fileIO.writeInFile(designer.computeTimeTable(fileIO.getActivityList()));
	}


}
