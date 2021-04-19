package com.encore.self;


public class Programmer {
	
	public String name;
	public int height;
	public double weight;
	public String gender;

	
	public void getProgrammerInfo() {
		System.out.println(name+","+height+"cm,"+weight+"kg,"+gender);
	}
		
	
	public void setProgrammerInfo(String name, int height, double weight, String gender) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		
	}

}

