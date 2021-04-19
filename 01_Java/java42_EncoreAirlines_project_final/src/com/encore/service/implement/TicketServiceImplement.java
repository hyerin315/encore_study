package com.encore.service.implement;

import java.util.ArrayList;
import java.util.Scanner;

import com.encore.dao.implement.TicketDaoImplement;
import com.encore.service.define.TicketServiceDefine;
import com.encore.vo.Ticket;

public class TicketServiceImplement implements TicketServiceDefine {
	private TicketDaoImplement dao;
	public ArrayList<Ticket> tickets;
	
	public TicketServiceImplement() {
		dao = new TicketDaoImplement();
	}
	
	@Override
	public ArrayList<Ticket> searchByDate(Scanner sc) {
		
		System.out.println("Depature day[example) 월]: ");
		String date = sc.next();
		tickets = dao.filterByDepatureDate(date);
		//if (tickets==null) System.out.println("\nNo flight is available.\n");
		//for (Ticket t : tickets)	System.out.println(t);
		return tickets;
	}
	
	@Override
	public ArrayList<Ticket> searchByDepart(Scanner sc) {
		
		System.out.println("Departure City: " );
		String departCity = sc.next();
		tickets = dao.filterByDepatureCity(departCity);
		//if (tickets==null) System.out.println("\n�빐�떦 �빆怨듯렪�쓣 李얠쓣 �닔 �뾾�뒿�땲�떎.\n");
		//else {
		//for (Ticket t : tickets)	System.out.println(t);
		return tickets;
	}
	
	@Override
	public ArrayList<Ticket> searchByPrice(Scanner sc) {
		
		System.out.println("Max Price: ");
		int price = sc.nextInt();
		tickets = dao.filterByPrice(price);
		//if (tickets==null) System.out.println("\n�빐�떦 �빆怨듯렪�쓣 李얠쓣 �닔 �뾾�뒿�땲�떎.\n");
		//for (Ticket t : tickets) System.out.println(t);
		return tickets;
	}
	
	@Override
	public ArrayList<Ticket> searchByArrive(Scanner sc) {
		
		System.out.println("Arrival City:");
		String arrivalCity = sc.next();
		
		tickets = dao.filterByArrivalCity(arrivalCity);
		
		//for (Ticket t : tickets)	System.out.println(t);
		return tickets;
	}
	
	@Override
	public ArrayList<Ticket> returnAllTicket(String path) {
		return tickets = dao.getAllTickets(path);	
	}
	
	@Override
	public void printfiltered() {
		System.out.println("Searching filghts...");
		if (tickets!=null) {
			for(Ticket t: tickets) System.out.println(t);
		}else System.out.println("\nNo flight is available.\n");
	}
}