package com.encore.dao.define;
import java.util.ArrayList;
import com.encore.vo.BookedTicket;

public interface BookedTicketDaoDefine {
	ArrayList<BookedTicket> getAllBookedTicket();
	//BookedTicket getBooking(String ticketNum);
	void deleteBooking(String ticketNum);
	void addBooking(BookedTicket bt);
	ArrayList<BookedTicket> addBooking(String ticketNum);
}