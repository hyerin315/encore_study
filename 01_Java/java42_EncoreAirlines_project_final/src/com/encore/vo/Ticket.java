package com.encore.vo;

public class Ticket {
	
	private String code;
	private String departCity;
	private String arriveCity;
	private String departTime;
	private String arriveTime; 
	private String workingDate;
	private static int seatCnt;	
	private int price;

	public Ticket(String code, String departCity, String arriveCity, String departTime, String arriveTime,
			String workingDate, int seatCnt, int price) {
		
		this.code = code;
		this.departCity = departCity;
		this.arriveCity = arriveCity;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.workingDate = workingDate;
		this.seatCnt = seatCnt;
		this.price = price;
	}

	public Ticket() {}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDepartCity() {
		return departCity;
	}

	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}

	public String getArriveCity() {
		return arriveCity;
	}

	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getWorkingDate() {
		return workingDate;
	}

	public void setWorkingDate(String workingDate) {
		this.workingDate = workingDate;
	}

	public int getSeatCnt() {
		return seatCnt;
	}

	public void setSeatCnt(int seatCnt) {
		this.seatCnt = seatCnt;
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ticket [code=" + code + ", departCity=" + departCity + ", arriveCity=" + arriveCity + ", departTime="
				+ departTime + ", arriveTime=" + arriveTime + ", workingDate=" + workingDate + ", seatCnt=" + seatCnt
				+ ", price=" + price + "]";
	}

	
	
	

}
