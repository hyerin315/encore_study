package com.encore.service.implement;

import java.util.ArrayList;
import java.util.Scanner;

import com.encore.dao.implement.JoinDaoImplement;
import com.encore.service.define.JoinServiceDefine;
import com.encore.vo.People;

public class JoinServiceImplement implements JoinServiceDefine {
	
	ArrayList<People> p;
	private int input;
	private String id;
	private String password;  
	private static int a;
	private static int b;
	
	JoinDaoImplement dao;
	
	Scanner sc;
	
	public JoinServiceImplement() {
		
		dao = new JoinDaoImplement();
		
	}
	
	//Login
	public String logIn(String id, String password) {
		
		p = dao.getAllList();
		String type = "";
		
		for(People people : p) {
			if(people == null)
				continue;
			if(people.getId().equals(id)){
				String strNum = Integer.toString(people.getCode());
				
				if(strNum.substring(0, 1).equals("1")) {
					type = "customer";
					break;
				}else {
					type = "employee";
					break;
				}
			}
		}
		
		return type;
	}
	//Join us.
	public boolean signUp(String name, String id, String password, String birthDate, String yesOrNo) {
		
		People addPeople = new People();
		
		System.out.println("							*****   Choose sign Up menu.                 *****					");
		System.out.println();

		if(yesOrNo.equals("Yes")) {
			addPeople.setCode(10051 + a++);
		}else {
			addPeople.setCode(20051 + b++);
		}
		System.out.println();
		
		addPeople.setName(name);
		addPeople.setId(id);
		addPeople.setPassword(password);
		addPeople.setBirthDate(birthDate);

		return dao.insertList(addPeople);
	
	}
	//Show my info 
	public void showInfo() {
		
		p = null;
		p = dao.getAllList();
		
		for(People people : p)
			System.out.println("							" + people);
		
	}
	//delete my info 
	public void deleteInfo(String id) {
		
		p = null;
		p = dao.getAllList();
	
		People tempPeople = new People();
		
		for(People people : p) {
			if(people == null)
				continue;
			
			if(people.getId().equals(id)) {
				tempPeople = people;
				break;
			}
		}
		dao.deleteList(tempPeople);
	}



}
