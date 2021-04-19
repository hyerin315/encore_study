package com.encore.service.define;

import java.util.Scanner;

public interface BookedTicketServiceDefine {
	void bookTicket(Scanner sc);
	void searchMyBooking(Scanner sc);
	void cancelMyBooking(Scanner sc);
	void startBookedTicket(String path);
	void saveBookedTicket(String path);
}
