package com.encore.dao.implement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.encore.dao.define.TicketDaoDefine;
import com.encore.vo.Ticket;
public class TicketDaoImplement implements TicketDaoDefine {
	public ArrayList<Ticket> tickets;
	ArrayList<String> arrTemp;
	Ticket objTicket;
	FileInputStream fileInputStream;
	FileOutputStream fileOutputStream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow excelRow;
	XSSFCell excelCell;
	
	public TicketDaoImplement() {
		tickets = new ArrayList<>();
	}
	@Override
	public ArrayList<Ticket> filterByArrivalCity(String city) {
		ArrayList<Ticket> sortedTickets = new ArrayList<>();
		for(Ticket t: tickets) {
			if(t.getArriveCity().contains(city)) sortedTickets.add(t);
		}
		//Collections.sort(sortedTickets, Ticket.ArrivalCityComp);
		tickets = sortedTickets;
		
		return tickets;
	}
	@Override
	public ArrayList<Ticket> filterByDepatureCity(String city) {
		ArrayList<Ticket> sortedTickets = new ArrayList<>();
		for(Ticket t: tickets) {
			if(t.getDepartCity().contains(city)) sortedTickets.add(t);
		}
		//Collections.sort(sortedTickets, Ticket.ArrivalCityComp);
		tickets = sortedTickets;
		return tickets;
	}
	@Override
	public ArrayList<Ticket> filterByDepatureDate(String date) {
		ArrayList<Ticket> sortedTickets = new ArrayList<>();
		for(Ticket t: tickets) {
			if(t.getWorkingDate().contains(date)) sortedTickets.add(t);
		}
		//Collections.sort(sortedTickets, Ticket.ArrivalCityComp);
		tickets = sortedTickets;
		return tickets;
	}
	@Override
	public ArrayList<Ticket> filterByPrice(int price) {
		ArrayList<Ticket> sortedTickets = new ArrayList<>();
		for(Ticket t: tickets) {
			if(t.getPrice() <= price) sortedTickets.add(t);
		}
		return sortedTickets;
	}
	
	public ArrayList<Ticket> getAllTickets(String path) {
		ArrayList <Ticket> empty =  new ArrayList<>();
		tickets = empty;
		try {
			FileInputStream fi = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fi);//��������
			XSSFSheet sheet = workbook.getSheetAt(0);//�Ʒ� Sheet ��
			// row �б�
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				if (row != null) {
					// ����Ʈ�� ����Ʈ ����
					ArrayList<String> cellList = new ArrayList<String>();
					
					// �� �б�
					for (int j = 0; j < row.getLastCellNum(); j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							cellList.add(cellReader(cell));
						}
					}
					
					if(i>0 && cellList !=null) {
						Ticket ticket = new Ticket();
						ticket.setCode(cellList.get(0));
						ticket.setDepartCity(cellList.get(1));
						ticket.setArriveCity(cellList.get(2));
						ticket.setDepartTime(TimeConverter(cellList.get(3)));
						ticket.setArriveTime(TimeConverter(cellList.get(4)));
						ticket.setWorkingDate(cellList.get(5));
						ticket.setSeatCnt((int)Double.parseDouble(cellList.get(6)));
						ticket.setPrice((int)Double.parseDouble(cellList.get(7)));
						
						if(ticket !=null) tickets.add(ticket);
					}
				}
			}
			workbook.close();
		} catch (FileNotFoundException fn) {
			fn.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	
	
	@SuppressWarnings("incomplete-switch")
	private static String cellReader(XSSFCell cell) {
		String value = "";
		CellType ct = cell.getCellType();
		if (ct != null) {
			switch (cell.getCellType()) {
			case FORMULA:
				value = cell.getCellFormula();
				break;
			case NUMERIC:
				value = cell.getNumericCellValue() + "";
				break;
			case STRING:
				value = cell.getStringCellValue() + "";
				break;
			case BOOLEAN:
				value = cell.getBooleanCellValue() + "";
				break;
			case ERROR:
				value = cell.getErrorCellValue() + "";
				break;				
			}
		}
		return value;
	}
	private static String TimeConverter(String cell) {
		String hh,mm,hhmm;
		
		double time = (Double.parseDouble(cell)) * 24;
		int hours = (int)time;
		int minutes = (int) Math.round((time - hours) * 60);
		
		if (hours<10) {hh = "0"+ String.valueOf(hours);}
		else {hh = String.valueOf(hours);}
		if(minutes<10) { mm = "0"+ String.valueOf(minutes);}
		else {mm = String.valueOf(minutes);}
		
		hhmm= hh+":"+mm;
		
		return hhmm;
	}
}
//package com.encore.dao.implement;
//import java.util.ArrayList;
//import java.util.Collections;
//
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.CreationHelper;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.encore.dao.define.TicketDaoDefine;
//import com.encore.vo.Ticket;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;  
//
//
//public class TicketDaoImplement implements TicketDaoDefine {
//	public ArrayList<Ticket> tickets;
//	ArrayList<String> arrTemp;
//	Ticket objTicket;
//	FileInputStream fileInputStream;
//	FileOutputStream fileOutputStream;
//	XSSFWorkbook workbook;
//	XSSFSheet sheet;
//	XSSFRow excelRow;
//	XSSFCell excelCell;
//	
//	public TicketDaoImplement() {
//		tickets = new ArrayList<>();
//	}
//
//	@Override
//	public ArrayList<Ticket> filterByArrivalCity(String city) {
//		ArrayList<Ticket> sortedTickets = new ArrayList<>();
//		for(Ticket t: tickets) {
//			if(t.getArriveCity().contains(city)) sortedTickets.add(t);
//		}
//		//Collections.sort(sortedTickets, Ticket.ArrivalCityComp);
//		tickets = sortedTickets;
//		
//		return tickets;
//	}
//
//	@Override
//	public ArrayList<Ticket> filterByDepatureCity(String city) {
//		ArrayList<Ticket> sortedTickets = new ArrayList<>();
//		for(Ticket t: tickets) {
//			if(t.getDepartCity().contains(city)) sortedTickets.add(t);
//		}
//		//Collections.sort(sortedTickets, Ticket.ArrivalCityComp);
//		tickets = sortedTickets;
//		return tickets;
//	}
//
//	@Override
//	public ArrayList<Ticket> filterByDepatureDate(String date) {
//		ArrayList<Ticket> sortedTickets = new ArrayList<>();
//		for(Ticket t: tickets) { 
//			if(t.getWorkingDate().contains(date)) sortedTickets.add(t);
//		}
//		//Collections.sort(sortedTickets, Ticket.ArrivalCityComp);
//		tickets = sortedTickets;
//		return tickets;
//	}
//
//	@Override
//	public ArrayList<Ticket> filterByPrice(int price) {
//		ArrayList<Ticket> sortedTickets = new ArrayList<>();
//		for(Ticket t: tickets) {
//			if(t.getPrice() <= price) sortedTickets.add(t);
//			System.out.println(t.getPrice());
//		}
//		return sortedTickets;
//	}
//
//	
//	public ArrayList<Ticket> getAllTickets(String path) {
//		try {
//			FileInputStream fi = new FileInputStream(path);
//			XSSFWorkbook workbook = new XSSFWorkbook(fi);//엑셀파일
//			XSSFSheet sheet = workbook.getSheetAt(0);//아래 Sheet 탭
//		
//			
//			// row 읽기
//			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//				XSSFRow row = sheet.getRow(i);
//
//				if (row != null) {
//					// 리스트의 리스트 선언
//					ArrayList<String> cellList = new ArrayList<String>();
//					
//					// 셀 읽기
//					for (int j = 0; j < row.getLastCellNum(); j++) {
//						XSSFCell cell = row.getCell(j);
//						if (cell != null) {
//							cellList.add(cellReader(cell));
//						}
//					}
//					
//					if(i>0 && cellList !=null) {
//						Ticket ticket = new Ticket();
//						
//						
//						
//						ticket.setCode(cellList.get(0));
//						ticket.setDepartCity(cellList.get(1));
//						ticket.setArriveCity(cellList.get(2));
//						ticket.setDepartTime(TimeConverter(cellList.get(3)));
//						ticket.setArriveTime(TimeConverter(cellList.get(4)));
//						ticket.setWorkingDate(cellList.get(5));
//						ticket.setSeatCnt((int)Double.parseDouble(cellList.get(6)));
//						ticket.setPrice((int)Double.parseDouble(cellList.get(7)));
//						
//						if(ticket !=null) tickets.add(ticket);
//					}
//				}
//			}
//			workbook.close();
//
//		} catch (FileNotFoundException fn) {
//			fn.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch(NumberFormatException e) {
//			e.printStackTrace();
//		}
//		return tickets;
//	}
//	
//	
//	@SuppressWarnings("incomplete-switch")
//	private static String cellReader(XSSFCell cell) {
//		String value = "";
//		CellType ct = cell.getCellType();
//		if (ct != null) {
//			switch (cell.getCellType()) {
//			case FORMULA:
//				value = cell.getCellFormula();
//				break;
//			case NUMERIC:
//				value = cell.getNumericCellValue() + "";
//				break;
//			case STRING:
//				value = cell.getStringCellValue() + "";
//				break;
//			case BOOLEAN:
//				value = cell.getBooleanCellValue() + "";
//				break;
//			case ERROR:
//				value = cell.getErrorCellValue() + "";
//				break;				
//			}
//		}
//		return value;
//	}
//	
//	private static String TimeConverter(String cell) {
//		String hh,mm,hhmm;
//		
//		double time = (Double.parseDouble(cell)) * 24;
//		int hours = (int)time;
//		int minutes = (int) ((time - hours) * 60);
//		
//		if (hours<10) {hh = "0"+ String.valueOf(hours);}
//		else {hh = String.valueOf(hours);}
//
//		if(minutes<10) { mm = "0"+ String.valueOf(minutes);}
//		else {mm = String.valueOf(minutes);}
//		
//		hhmm= hh+":"+mm;
//		
//		return hhmm;
//	}
//
//}