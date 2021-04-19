package com.encore.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.chatting.client.ClientQna;
import com.chatting.client.EmployeeMain;
import com.encore.service.implement.BookedTicketServiceImplement;
import com.encore.service.implement.EmployeeServiceImplement;
import com.encore.service.implement.JoinServiceImplement;
import com.encore.service.implement.ProductServiceImplement;
import com.encore.service.implement.TicketServiceImplement;
import com.encore.vo.Ticket;
import com.util.LoadConfig;

public class Menu {
	
	Scanner sc;
	int input;
	String password;
	String id;
	
	JoinServiceImplement joinService;
	TicketServiceImplement ticketService;
	ProductServiceImplement productService;
	EmployeeServiceImplement employeeService;
	BookedTicketServiceImplement bookedTicketService;
	
	EmployeeMain employeeMain;
	LoadConfig loadConfig;
	
	String path_custEmpList;
	String path_ticketList;
	String path_bookedTicketList;
	String path_productList;
	String path_empSchedule;
	
	public Menu() {
		sc = new Scanner(System.in);
		
		joinService = new JoinServiceImplement();
		ticketService = new TicketServiceImplement();
		productService = new ProductServiceImplement();
		employeeService = new EmployeeServiceImplement();
		bookedTicketService = new BookedTicketServiceImplement();
		
		loadConfig = new LoadConfig();
		
		loadConfig.getFilePath("Path_CustEmpList");
		this.path_custEmpList = loadConfig.getPath();
		
		loadConfig.getFilePath("Path_TicketList");
		this.path_ticketList = loadConfig.getPath();
		
		loadConfig.getFilePath("Path_BookedTiketList");
		this.path_bookedTicketList = loadConfig.getPath();
		
		loadConfig.getFilePath("Path_ProductList");
		this.path_productList = loadConfig.getPath();
		
		loadConfig.getFilePath("Path_EmpSchedule");
		this.path_empSchedule = loadConfig.getPath();
		
		
		
	}
	
	public void startMenu() {
		input = 0;
		password = "";
		id = "";
		boolean flag = true;
		while(flag) {	
		
		System.out.println("							*****   Encore Airlines Reservation System     *****					");
		System.out.println("							*****                                          *****					");
		System.out.println("							*****   Home Menu                    	       *****					");
		System.out.println("							*****   ________________________________       *****					");
		System.out.println("							*****  | 1.Log In			|      *****					");
		System.out.println("							*****  | 2.Sign Up			|      *****					");
		System.out.println("							*****   --------------------------------       *****					");
		
		input = sc.nextInt();
		
		switch(input) {
		case 1:
			flag = selectLogin();
			break;
		case 2:
			flag = selectSignUp();
			break;
		}
	}
}		
	
	public boolean selectLogin() {
		
		id = "";
		password = "";
		String check = "";
		
		System.out.println("							*****   LOG-IN PROCESS			   *****					");
		System.out.print("							*****   Please Input ID:");
		id = sc.next();
		
		System.out.println();
		System.out.print("							*****   Please Input Password[Integer]:");
		password =Integer.toString(sc.nextInt());
		
		
		check = joinService.logIn(id, password);
		
		if(check.equals("customer")) {
			customerMenu();
			return false;
		}else if(check.equals("employee")) {
			employeeMenu();
			return false;
		}else {
			System.out.println();
			System.out.println("							*****   Invalid ID or password          *****					");
			System.out.println("							*****   Please sign up        	  *****					");
			
			System.out.println();
			//selectSignUp();
			return true;
		}
		
	}
	
	public boolean selectSignUp() {
		boolean done = false;
		String name = "";
		String birthDate = "";
		String yesOrNo ="";
		id = "";
		password = "";
		
		
		System.out.println("							*****   SIGN-UP PROCESS                *****					");
		System.out.println();
		System.out.print("							*****   Name:");
		name = sc.next();
		System.out.println();
		System.out.print("							*****   ID:");
		id = sc.next();
		System.out.println();
		System.out.print("							*****   Password:");
		password = sc.next();
		System.out.println();
		System.out.print("							*****   Birth Date[YYYY.MM.DD]:");
		birthDate = sc.next();
		System.out.println();
		
		
		System.out.print("							*****   Are you customer? input Yes or No :");
		yesOrNo = sc.next();
		
	
		System.out.println();
		
		if(joinService.signUp(name, id, password, birthDate, yesOrNo)) {
			//selectLogin();
			done = true;
		}
		return done;
		/*else {
			startMenu();
		}*/
	}
	
	
	//customer menu
	public void customerMenu() {
		boolean flag = true;
		while(flag) {
		
		input = 0;
		System.out.println("							*****   You have logged in as [Customer]	 *****					");
		System.out.println("");
		System.out.println("							*****please choose one of the following options*****				");
		System.out.println("							*****   ________________________________     *****					");
		System.out.println("							*****  | 1.Entire Tickets infomation.	|    *****					");
		System.out.println("							*****  | 2.Booking Ticket.              |    *****         ");
		System.out.println("							*****  | 3.Q&A                          |    *****					");
		System.out.println("							*****  | 4.Home menu.                   |    *****					");
		System.out.println("							*****   --------------------------------     *****					");
		
		//System.out.println("							*****  | 2.Booking Ticket.              |    *****                  ");
		//System.out.println("							*****  | 3.Home menu.                   |    *****					");
		//System.out.println("							*****   --------------------------------     *****					");
		
		input = sc.nextInt();
		switch(input) {
		
		case 1:
			ticketMenu();
			break;
		case 2:
			bookedTicketMenu();
			break;
		case 3: 
			System.out.println();
			qnaMenu();
			customerMenu();
		case 4: 
			startMenu();
			flag = false;
			break;
		
		}	
	}
	}
	
		
	//µ¿°ü bookedTicket menu
		public void bookedTicketMenu() {
			boolean flag = true;
			while(flag) {
			input = 0;
				//String tempType = type;
				System.out.println("							*****   You choose the [Ticket Menu]           *****					");
				System.out.println("							*****   Please Choice Menu                     *****					");
				System.out.println("							*****   __________________________________     *****					");
				System.out.println("							*****  | 1.Book Tickets.                  |    *****					");
				System.out.println("							*****  | 2.Search MY Booked Tickets.      |    *****					");
				System.out.println("							*****  | 3.Cancel MY Booked Tickets.      |    *****					");
				System.out.println("							*****  | 4.Previous Menu.                 |    *****					");
				System.out.println("							*****   ----------------------------------     *****					");
					
			input = sc.nextInt();
			bookedTicketService.startBookedTicket(path_bookedTicketList);
			switch(input) {
			
			case 1:
				System.out.println("							*****   Selected Search My Bookedticket.       *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				bookedTicketService.bookTicket(sc);
				bookedTicketService.saveBookedTicket(path_bookedTicketList);
				break;

			case 2: 
				System.out.println("							*****   Selected Search My Bookedticket.       *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				System.out.println();
			    bookedTicketService.searchMyBooking(sc);
					    
			    /*if(tempType.equals("emp")) {
					employeeMenu();
				}else if(tempType.equals("cust")) {
					customerMenu();
				}*/
				break;
		
			case 3:		
				System.out.println("							*****   Selected Cancel My Booked ticket.      *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				bookedTicketService.cancelMyBooking(sc);
				bookedTicketService.saveBookedTicket(path_bookedTicketList);
				//bookedTicketMenu(tempType);
				break;
			case 4: 
				System.out.println("							*****   Selected Previous menu.                *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
						
				/*if(type.equals("emp")) {
					employeeMenu();
				}else if(type.equals("cust")) {
					customerMenu();
				}*/
				flag = false;
				break;
			}
		}
					
					
		}
	
	    public void ticketMenu() {
	        input = 0;
	        boolean flag = true;
	        while(flag) {
	            System.out.println("							*****   You've chosen [Ticket Menu]            *****					");
	            System.out.println("							*****please choose one of the following options*****					");
	            System.out.println("							*****   __________________________________     *****					");
		//		System.out.println("							*****  | 2.Search MY Booked Tickets.      |    *****					");
	            System.out.println("							*****  | 1.View all flights.              |    *****					");
	            System.out.println("							*****  | 2.Search Ticket.                 |    *****					");
	            System.out.println("							*****  | 3.Previous Menu.                 |    *****					");
	            System.out.println("							*****   ----------------------------------     *****					");
	            
	            input = sc.nextInt();
	            ticketService.returnAllTicket(this.path_ticketList);
	            switch(input) {
	            case 1:
	                //System.out.println("                         *****   Please Choice Menu                     *****                    ");
	                System.out.println("                           *****   Selected Show all tickets.             *****                    ");
	                System.out.println();
	                
	                ticketService.printfiltered();
	            
	                break;
	            case 2: 
	                System.out.println("                           *****   Selected Search ticket.                *****                    ");
	                //System.out.println("                         *****   Selected Show all tickets.             *****                    ");
	                System.out.println();
	                ticketService.searchByDepart(sc);
	                ticketService.searchByArrive(sc);
	                ticketService.searchByDate(sc);
	                ticketService.printfiltered();
	                
	                /*if(type.equals("emp")) {
	                    employeeMenu();
	                }else if(type.equals("cust")) {
	                    customerMenu();
	                }*/
	                break;
	            case 3: 
	                System.out.println("                           *****   Selected Previous menu.                *****                    ");
	        
	                flag = false;
	                break;
	            }
	        }
	        
	        
	    }	
		
		
	//employee menu
	public void employeeMenu() {
		boolean flag = true;
		while(flag) {
		
		input = 0;
		
		String id = "";
		System.out.println();
		System.out.println("							*****   You have logged in as [Employee]	   *****					");
		System.out.println();
		System.out.println("							*****please choose one of the following options*****						");
		System.out.println("							*****   __________________________________     *****					");
		System.out.println("							*****  | 1.Show All Customer Infomation.  |    *****					");
		System.out.println("							*****  | 2.Delete Account                 |    *****					");
		System.out.println("							*****  | 3.Entire Scuedules infomation.	  |    *****					");
		System.out.println("							*****  | 4.The Management In-filght Items |    *****					");
		System.out.println("							*****  | 5.Messenger                      |    *****					");
		System.out.println("							*****  | 6.Home Menu                      |    *****					");
		System.out.println("							*****   ----------------------------------     *****					");
		
		input = sc.nextInt();
		
		switch(input) {
		
		case 1://show all customer/employees info
			System.out.println();
			System.out.println("							*****   Show all cust. info	         *****					");
			System.out.println();
			
			joinService.showInfo();
			//employeeMenu();
			break;
			
		case 2://delete account
			System.out.println();
			System.out.println("							*****   ACCOUNT DELETION PROCESS	 	*****					");

			System.out.print("							*****   ID:");
			id = sc.next();
			
			joinService.deleteInfo(id);
			//employeeMenu();
			break;
			
		case 3://entire schedule
			System.out.println();
			System.out.println("							*****   Entire schedules info     	*****					");
			System.out.println();
			//employeeMenu();
			//ticketMenu("emp");
			scheduleMenu();
			//employeeMenu();
			break;
			
		case 4:
			System.out.println();
			System.out.println("							*****  Management of items	        *****					");
			System.out.println();
			//employeeMenu();
			productMenu();
			//employeeMenu();
			break;
			
		case 5://chatting
			System.out.println();
			System.out.println("							*****   You choose Messenger                 *****					");
			System.out.println();
			chattingMenu();
			
		case 6://previous menu
			System.out.println("							*****   You choose Previous Menu             *****					");
			startMenu();
			flag = false;
			break;
		
		}
	}
		

	}

	
	/*
	 * ï¿½Â¿ï¿½ï¿½ï¿½
	 */
	public void scheduleMenu() {
		System.out.println("							*****   You choose the [Schedule Management]   *****					");
		System.out.println("							*****please choose one of the following options*****					");
		System.out.println("							*****   __________________________________     *****					");
		System.out.println("							*****  | 1.Search schedule.               |    *****					");
		System.out.println("							*****  | 2.Add Schedule.                  |    *****					");
		System.out.println("							*****  | 3.Delete Schedule.               |    *****					");
		System.out.println("							*****  | 4.Previous Menu.                 |    *****					");
		System.out.println("							*****   ----------------------------------     *****					");
		
		employeeService.excelRead(path_empSchedule);
		
		boolean flag = true;
		while(flag) {
		
		input = 0;
		input = sc.nextInt();
		
		switch(input) {
		case 1:
			System.out.println("							*****   Selected search schedule               *****					");
			//System.out.println("							*****   Selected Show all tickets.             *****					");
			employeeService.searchSchedule(sc);
			break;
		case 2:
			System.out.println("							*****   Selected add schedule                  *****					");
			for (int i=0; i<1; i++) {
			employeeService.addEmpSchedule(sc);
			}
			//System.out.println("							*****   Selected Show all tickets.             *****					");
//			employeeService.addEmpSchedule(sc);
//			employeeService.excelwrite(path_empSchedule);
			break;
		case 3:
			System.out.println("							*****   Selected Delete schedule               *****					");
			//System.out.println("							*****   Selected Show all tickets.             *****					");
			//employeeMenu();

			employeeService.deleteEmployeeSchedule(sc);
			employeeService.excelwrite(path_empSchedule);
			break;
		case 4:
			System.out.println("							*****   Selected Previous menu                 *****					");
			//System.out.println("							*****   Selected Show all tickets.             *****					");
			//employeeMenu();
			flag = false;
			break;
		}
		}
	}
	
	/*
	 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ 
	 */
	public void chattingMenu() {
		System.out.println("							*****   You choose the [Messenger]             *****					");
		//System.out.println("							*****   Please Choice Menu                     *****					");
		employeeMain = new EmployeeMain();
		employeeMain.chatEmployeeMethod();
		System.out.println("							*****   Start Chatting with Company members    *****					");
	}
	
	/*
	 * ¼ÒÁ¤´Ô
	 */
	public void productMenu() {
		
		productService.startWarehouse(path_productList);
		boolean flag = true;
		while(flag) {
			
		System.out.println("							*****   You choose the [Product Management]    *****					");
		System.out.println("							*****   Please Choice Menu                     *****					");
		System.out.println("							*****   __________________________________     *****					");
		System.out.println("							*****  | 1.Show All Product list.         |    *****					");
		System.out.println("							*****  | 2.Show list by number.           |    *****					");
		System.out.println("							*****  | 3.Registry product.              |    *****					");
		System.out.println("							*****  | 4.Remove product.                |    *****					");
		System.out.println("							*****  | 5.In & Out product.              |    *****					");
		System.out.println("							*****  | 6.Previous Menu.                 |    *****					");
		System.out.println("							*****   ----------------------------------     *****					");
		
		input = 0;
		input = sc.nextInt();
		
		
			switch(input){
			case 1:
				System.out.println("							*****   Selected Show all product list.        *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				productService.printAllProducts(sc);
				//productMenu();
				break;
			case 2:
				
				System.out.println("							*****   Selected Show list by number.          *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				productService.getByNum(sc);
				//productMenu();
				break;
			case 3: 
				
				System.out.println("							*****   Selected registry product.             *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				productService.registerProduct(sc);
				//productService.saveWarehouse(path_productList);
				//productMenu();
				break;
			case 4:
				
				System.out.println("							*****   Selected Remove product.               *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				productService.printAllProducts(sc);
				productService.removeProduct(sc);
				//productService.saveWarehouse(path_productList);
				//productMenu();
				break;
			case 5:
				
				System.out.println("							*****   Selected In&out product.               *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				productService.inOutProduct(sc);
				//productService.saveWarehouse(path_productList);
				//productMenu();
				
				break;
			case 6:
				productService.saveWarehouse(path_productList);
				System.out.println("							*****   Selected Previous menu                 *****					");
				//System.out.println("							*****   Selected Show all tickets.             *****					");
				//employeeMenu();
				//break;
				flag=false;
				return;
			
			}
		}
	}
	
	//Qna class¿¡ ³»¿ë º¹ºÙ¿¹Á¤
	public void qnaMenu() {
		ClientQna clientQna;
		
		System.out.println("							*****    You choose the [Q&A]		   	 *****							");

		clientQna = new ClientQna();
		clientQna.run(sc);
	}
	

}
