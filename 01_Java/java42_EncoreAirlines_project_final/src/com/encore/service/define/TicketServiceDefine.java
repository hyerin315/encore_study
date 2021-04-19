package com.encore.service.define;

import java.util.ArrayList;
import java.util.Scanner;

import com.encore.vo.Ticket;

public interface TicketServiceDefine {
	ArrayList<Ticket> searchByDate(Scanner sc);
	
	ArrayList<Ticket> searchByDepart(Scanner sc) ; 

	ArrayList<Ticket> searchByPrice(Scanner sc) ;

	ArrayList<Ticket> searchByArrive(Scanner sc) ;
	
	void printfiltered();

	ArrayList<Ticket> returnAllTicket(String path);
}
