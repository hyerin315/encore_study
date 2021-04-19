package com.encore.dao.define;

import java.util.ArrayList;

import com.encore.vo.Ticket;

public interface TicketDaoDefine {
	ArrayList<Ticket> getAllTickets(String path);
	ArrayList<Ticket> filterByPrice(int price);
	ArrayList<Ticket> filterByDepatureCity(String city);
	ArrayList<Ticket> filterByArrivalCity(String city);
	ArrayList<Ticket> filterByDepatureDate(String date);

}
