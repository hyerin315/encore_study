package com.encore.vo;

import java.io.Serializable;

public class BookedTicket implements Serializable{
	
	private String name;
	private String id;
	private int bookingSeat;
	private static int seatCnt;
	private String ticketNum;
	private String depart;
	private String arrival;
	private String departTime;
	//private String arrivalTime;
	private double price;
	

	public BookedTicket(String name, String id, int bookingSeat, String ticketNum, String depart, String arrival,
			String departTime, double price) {
		super();
		this.name = name;
		this.id = id;
		this.bookingSeat = bookingSeat;
		this.ticketNum = ticketNum;
		this.depart = depart;
		this.arrival = arrival;
		this.departTime = departTime;
		//this.arrivalTime = arrivalTime;
		this.price = price;
		//this.seatCnt = 30;
	}
	public BookedTicket() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj != null && obj instanceof BookedTicket) {
			if (ticketNum == ((BookedTicket) obj).ticketNum) {
				return true;
			}
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "BookedTicket [name=" + name + ", id=" + id + ", bookingSeat=" + bookingSeat + ", ticketNum=" + ticketNum
				+ ", depart=" + depart + ", arrival=" + arrival + ", departTime=" + departTime + ", price=" + price + "]";
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
	public int getBookingSeat() {
		return bookingSeat;
	}
	public void setBookingSeat(int bookingSeat) {
		this.bookingSeat = bookingSeat;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	/*public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	*/
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static int getSeatCnt() {
		return seatCnt;
	}
	public static void setSeatCnt(int num) {
		seatCnt = num;
	}



}