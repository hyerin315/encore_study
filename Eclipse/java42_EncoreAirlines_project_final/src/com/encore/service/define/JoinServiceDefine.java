package com.encore.service.define;

public interface JoinServiceDefine {
	//Login
	public String logIn(String id, String password);
	//Join us.
	public boolean signUp(String name, String id, String password, String birthDate, String yesOrNo);
	//Show my info 
	public void showInfo();
	//delete my info 
	public void deleteInfo(String id);

}
