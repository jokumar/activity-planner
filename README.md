Steps to run the package

1.	Unzip the package.
2.	Input file is named as activities.txt inside resource folder(“activity-planner\src\main\resources\activities.txt”) 
3.	Output will be placed in the same place as input folder but with name output.txt
4.	Open command prompt 
5.	Navigate to the folder  “activity-planner” and run the following command:
mvn exec:java -Dexec.mainClass="com.usecase.planner.ActivityAssignerMain" test
6.	The output file will get generated in resource folder . Test case also will get executed .
7.	Log file also gets generated inside resource folder . 


Design Patterns & principles Used:
	
1.	Single Responsibility Principle- Every class I have written has only one specific job to achieve.
2.	Open Closed Principle  : All the methods in classes  are open for extension and hardly any scope of modification . Method parameters in Service classes are not wide but narrow to a specific type . 
3.	Factory Pattern – Used factory pattern for creating the Objects to read the files from the system . Currently we are reading files from local system. If any other way of reading is required it can be passed in runtime.  
