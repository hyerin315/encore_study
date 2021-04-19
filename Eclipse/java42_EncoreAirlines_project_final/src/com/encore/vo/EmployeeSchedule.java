package com.encore.vo;


public class EmployeeSchedule {
	private String empCode;
	private String name;
	private String id;
	private String offday;
	private String departAirport;
	private String arriveAirport;
	private String startDate;
	
	public EmployeeSchedule() {}
	
	public EmployeeSchedule(String empCode, String name, String id, String offday,  String departAirport, String arriveAirport,  String startDate) {
		super();
		 this. empCode = empCode;
		 this. name = name;
		 this. id = id;
		 this. offday = offday;
		 this. departAirport = departAirport;
		 this. arriveAirport = arriveAirport;		
		 this. startDate = startDate;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOffday() {
		return offday;
	}
	public void setOffday(String offday) {
		this.offday = offday;
	}
	
	public String getDepartAirport() {
		return departAirport;
	}
	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}
	public String getArriveAirport() {
		return arriveAirport;
	}
	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", name=" + name + ", id=" + id + ", offday=" + offday + ", departAirport=" + departAirport + ", arriveAirport=" + arriveAirport +   ", startDate="
				+ startDate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof EmployeeSchedule) {
			if(empCode == ((EmployeeSchedule)obj).empCode) {
				return true;
			}
		}
		return super.equals(obj);
	}
 
		}
