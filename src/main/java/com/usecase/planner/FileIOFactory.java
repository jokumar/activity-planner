package com.usecase.planner;

import com.usecase.planner.constant.ActivityConstant;
/**
 * 
 * @author jokumar
 *	This file can be modified based on new requirements
 */
public class FileIOFactory {
	
	private FileIOFactory(){
		
	}
	public static AbstractFileIO getFileInstance(String type){
		if(ActivityConstant.FILE_IO.equalsIgnoreCase(type)){
			return new ActivityFileIO();
		}
		return new ActivityFileIO();
	}
}
