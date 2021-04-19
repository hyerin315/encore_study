package com.encore.vo;

public class People {

	private String name;
	private String Id;
	private String password;
	private int code;
	private String birthDate;
	
	public People() {
		
	}

	
	public People(String name, String id, String password, int code, String birthDate) {
		this.name = name;
		Id = id;
		this.password = password;
		this.code = code;
		this.birthDate = birthDate;
	}
	
	//if ID equal, people obj equal 
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 !=null && arg0 instanceof People) {
			if(((People)arg0).getId()==Id) {
				return true;
			}
		}
		return super.equals(arg0);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public String toString() {
		return "[Name=" + name + "\t Id=" + Id + "\t password=" + password + "\t code=" + code + "\t birthDate=" + birthDate + "]";
	}


	
	
	
	
}
