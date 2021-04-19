package com.encore.service.implement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.encore.dao.implement.BookedTicketDaoImplement;
import com.encore.service.define.BookedTicketServiceDefine;
import com.encore.vo.BookedTicket;
import com.encore.vo.People;

public class BookedTicketServiceImplement implements BookedTicketServiceDefine {
	private BookedTicketDaoImplement dao;
	
	public  BookedTicketServiceImplement() {
		dao = new BookedTicketDaoImplement();
		}
	
	@Override
	public void bookTicket(Scanner sc) {
		System.out.println("Ƽ�� ����");
		System.out.println("�̸�: ");
		String name = sc.next();
		System.out.println("ID: ");
		String id = sc.next();
		System.out.println("�¼� ��: ");
		int bookingSeat = sc.nextInt();
		System.out.println("Ƽ�� ��ȣ(������ ã�� �� �ֵ��� ����): ");
		String ticketNum = sc.next();
		System.out.println("��� ����: ");
		String depart = sc.next();
		System.out.println("���� ����: ");
		String arrival = sc.next();
		System.out.println("��� �ð�: ");
		String departTime = sc.next();
		//System.out.println("���� �ð�: ");
		//String arrivalTime = sc.next();
		System.out.println("Ƽ�� ����: ");
		double price = sc.nextDouble();
		BookedTicket bt = new BookedTicket(name, id, bookingSeat, ticketNum, depart, arrival, departTime, price);

		dao.addBooking(bt);
	}


	@Override
	public void searchMyBooking(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("��ȸ�Ϸ��� Ƽ�Ϲ�ȣ�� �Է����ּ���: ");
		String bookedTicketNum=sc.next();
		if(dao.getBooking(bookedTicketNum)!=null)
			System.out.println(dao.getBooking(bookedTicketNum));
		else
			System.out.println("�ش� ��ȣ�� �����ϴ�.");
	}

	@Override
	public void cancelMyBooking(Scanner sc) {
		System.out.println("���� ���");
		System.out.println("����Ϸ��� Ƽ���� ��ȣ�� �Է����ּ���: ");
		String bookedTicketNum=sc.next();
		dao.deleteBooking(bookedTicketNum);
	}
	@Override
	public void saveBookedTicket(String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow row = null;
		//XSSFCell cell = null;
	    //�ο� ����
		for(int i=0; i<dao.getAllBookedTicket().size() ; i++) {
			
			row = sheet.createRow(i);// �ο� ����� 
			row.createCell(0).setCellValue(dao.getAllBookedTicket().get(i).getName());
			row.createCell(1).setCellValue(dao.getAllBookedTicket().get(i).getId());//�� ����鼭 �� ����
			row.createCell(2).setCellValue(dao.getAllBookedTicket().get(i).getBookingSeat());
			row.createCell(3).setCellValue(dao.getAllBookedTicket().get(i).getTicketNum());
			row.createCell(4).setCellValue(dao.getAllBookedTicket().get(i).getDepart());//�� ����鼭 �� ����
			row.createCell(5).setCellValue(dao.getAllBookedTicket().get(i).getArrival());
			row.createCell(6).setCellValue(dao.getAllBookedTicket().get(i).getDepartTime());
			//row.createCell(7).setCellValue(dao.getAllBookedTicket().get(i).getArrivalTime());
			row.createCell(8).setCellValue(dao.getAllBookedTicket().get(i).getPrice());

		}
		try {
			FileOutputStream fo = new FileOutputStream(path,true);
			workbook.write(fo);
			System.out.println("�Ϸ�");
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void startBookedTicket(String path) {
		try {
			//ArrayList<bookedTicket> prodList = new ArrayList<bookedTicket>();
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
						BookedTicket bookedTicket = new BookedTicket();
						//People people = new People();
						//people.setName((cellList.get(4)));
						//people.setId((cellList.get(4)));
						
						bookedTicket.setName(String.valueOf((cellList.get(0))));
						bookedTicket.setId(String.valueOf((cellList.get(1))));
						bookedTicket.setBookingSeat((int) Double.parseDouble(cellList.get(2)));
						bookedTicket.setTicketNum(String.valueOf(cellList.get(3)));
						bookedTicket.setDepart(String.valueOf((cellList.get(4))));
						bookedTicket.setArrival(String.valueOf((cellList.get(5))));
						bookedTicket.setDepartTime(String.valueOf((cellList.get(6))));
						//bookedTicket.setArrivalTime(String.valueOf((cellList.get(7))));
						bookedTicket.setPrice(Double.parseDouble(cellList.get(7)));
						
						BookedTicket.setSeatCnt(30);

						if(bookedTicket !=null)
							//prodList.add(bookedTicket);
							dao.addBooking(bookedTicket);
					
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
		//System.out.println("Success");

		//for(BookedTicket p: dao.getAllBookedTicket())
		//	System.out.println(p);
	}

	
	/*
	 * ���� ����
	 */
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
}
