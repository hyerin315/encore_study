package com.chatting.client;

import java.util.Scanner;

public class ClientQna {
	public void run(Scanner sc) {
		boolean flag = true;
		int menu;
//		System.out.println("                            =======================FAQ========================                              ");
		System.out.println("							=======================FAQ========================								");
		while(flag) {     
			System.out.println("             ****** 1.Lost Ticket 2.Ticket Refund 3.In-flight meal 4.Earn Mileage 5.Agent connection 6.Return to previous menu *******           ");
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("\n\n[Lost Ticket] \nDomestic fares vary according to boarding date, time and section, so you can issue a new ticket after refund. \n\n");
				break;
			case 2:
				System.out.println("\n\n[Ticket Refund] \nA refund will be paid only to the passenger indicated in the ticket or the passenger¡¯s representative. "
						+ "\nIf you purchased your ticket through a travel agency, you must apply for ticket refund at the travel agency from which you purchased the ticket. \n\n");
				break;
			case 3:
				System.out.println("\n\n[In-flight meal] \nThere are different types of meals available for each route. \nMeterials of in-flight meals can be changed under Airline¡¯s circumstances\n\n");
				break;
			case 4:
				System.out.println("\n\n[Earn Mileage] \nDepending on the flight status, mileage accrual processing can take up to 3 days. "
						+ "\nWhen you fly with our airline partners, it may take about 8days to process from the date of your departure.\n\n");
				break;
			case 5:
				System.out.println("\n\n[Agent connection] 9:00~18:00, Monday ~ Friday \nCall from local area : 000-000-0000 \n\n");
				break;
			case 6:
				flag = false;
				break;
				}
			}
		System.out.println("                            =======================Exit========================                           \n");
	}
}
