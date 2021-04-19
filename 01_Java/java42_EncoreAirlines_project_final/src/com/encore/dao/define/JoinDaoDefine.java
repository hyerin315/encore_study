package com.encore.dao.define;

import java.util.ArrayList;

import com.encore.vo.People;

public interface JoinDaoDefine {
	
	//get entire list
	public ArrayList<People> getAllList(); 
	//Join us.
	public boolean insertList(People p);
	//Show my info 
	public void getList(People p);
	//delete my info 
	public void deleteList(People p);

}
