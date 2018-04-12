package come.usecase.planner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.usecase.planner.ActivityAssigner;
import com.usecase.planner.bean.Activity;
import com.usecase.planner.bean.Team;

public class ActivityAssignerTest {
	
	ActivityAssigner assigner=new ActivityAssigner();
	@Test
	public void computeTimeTable(){
		List<Team> list=assigner.computeTimeTable(createActivityList());
		Assert.assertEquals("activity1", list.get(0).getActivityList().get(0).getName());
		Assert.assertEquals("09:00", list.get(0).getActivityList().get(0).getStartTime());
		Assert.assertEquals("10:00", list.get(0).getActivityList().get(1).getStartTime());
		Assert.assertEquals("10:40", list.get(0).getActivityList().get(2).getStartTime());
		Assert.assertEquals("11:10", list.get(0).getActivityList().get(3).getStartTime());
		Assert.assertEquals("11:20", list.get(0).getActivityList().get(4).getStartTime());
		Assert.assertEquals("12:20", list.get(0).getActivityList().get(5).getStartTime());
		Assert.assertEquals("13:30", list.get(0).getActivityList().get(6).getStartTime());
		Assert.assertEquals("14:30", list.get(0).getActivityList().get(7).getStartTime());
		Assert.assertEquals("15:10", list.get(0).getActivityList().get(8).getStartTime());
		Assert.assertEquals("16:10", list.get(0).getActivityList().get(9).getStartTime());

	}
	
	//Validate when list gets completed before 16hrs
	@Test
	public void computeTimeTable_Presentation(){
		List<Team> list=assigner.computeTimeTable(createActivityList_before16Hrs());
		Assert.assertEquals("16:00", list.get(0).getActivityList().get(9).getStartTime());

	}
	//Full List
	public List<Activity> createActivityList(){
		List<Activity> list=new ArrayList<>();
		list.add(new Activity("activity1", "60min"));
		list.add(new Activity("activity2", "40min"));
		list.add(new Activity("activity3", "30min"));
		list.add(new Activity("activity4", "10min"));
		list.add(new Activity("activity5", "70min"));
		list.add(new Activity("activity6", "60min"));
		list.add(new Activity("activity7", "40min"));
		list.add(new Activity("activity8", "60min"));
		return list;
		
	}
	
	public List<Activity> createActivityList_before16Hrs(){
		List<Activity> list=new ArrayList<>();
		list.add(new Activity("activity1", "60min"));
		list.add(new Activity("activity2", "40min"));
		list.add(new Activity("activity3", "30min"));
		list.add(new Activity("activity4", "10min"));
		list.add(new Activity("activity5", "70min"));
		list.add(new Activity("activity6", "60min"));
		list.add(new Activity("activity7", "40min"));
		list.add(new Activity("activity8", "sprint"));
		return list;
		
	}
	
}
