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

import com.encore.dao.implement.EmployeeDaoImplement;
import com.encore.service.define.EmployeeServiceDefine;
import com.encore.vo.EmployeeSchedule;

public class EmployeeServiceImplement implements EmployeeServiceDefine{
	private EmployeeDaoImplement daoImpl;
	private EmployeeSchedule employeeSchedule;
	ArrayList<EmployeeSchedule> arrEmp;
	private String path;
	
	public EmployeeServiceImplement () {
		daoImpl = new EmployeeDaoImplement();
	}

	@Override
	public void getAllEmployee(Scanner sc) {
		ArrayList<EmployeeSchedule> temp = daoImpl.getAllEmployee(); 
		for(EmployeeSchedule e : temp) {
			System.out.println(e);
		}
		
	}

	@SuppressWarnings("unused")
	@Override
	public void addEmpSchedule(Scanner sc) {
		employeeSchedule = new EmployeeSchedule();
		
		System.out.println("�߰��� ���������� �Է�");
		System.out.print("Emp_Code : ");
		String empCode = sc.next(); 
		System.out.print("Name : ");
		String name = sc.next(); 
		System.out.print("ID : ");
		String id =sc.next(); 
		System.out.print("Off_Day : ");
		String offday = sc.next(); 
		System.out.print("departAirport : ");
		String departAirport = sc.next();
		System.out.print("arriveAirport : ");
		String arriveAirport = sc.next();
		System.out.print("startDate : ");
		String startDate = sc.next();
		EmployeeSchedule e = new EmployeeSchedule(empCode,name, id, offday,departAirport,arriveAirport,startDate);
		daoImpl.addEmpSchedule(e);
	}

	@Override
	public void searchSchedule(Scanner sc) {
		System.out.println("��ȸ�Ϸ��� �����ȣ�� �Է����ּ��� : ");
		String eNum = sc.next();
		if(daoImpl.selectByEmpCode(eNum)!=null) {
			
			System.out.println(daoImpl.selectByEmpCode(eNum));
		}
		else
			System.out.println("�ش� ����� �����ϴ�.");
	}

	
	@Override
	public void updateSchdule(Scanner sc) {
		System.out.println("���ο� ������ �߰�");
		System.out.println("empCode : ");
		String empCode = sc.next();
		System.out.println("name : ");
		String name = sc.next();
		System.out.println("id : ");
		String id   = sc.next();
		System.out.println("offday : ");
		String offday = sc.next();
		System.out.println("DepartAirport : ");
		String departAirport = sc.next();
		System.out.println("arriveAirport : ");
		String arriveAirport = sc.next();
		System.out.println("startDate : ");
		String startDate = sc.next();
		
		EmployeeSchedule e = new EmployeeSchedule(empCode,name,id, offday,departAirport,arriveAirport,startDate);
		daoImpl.addEmpSchedule(e);
	}
		
	

	@Override
	public void deleteEmployeeSchedule(Scanner sc) {
		System.out.println("������ �������� empCode�� �Է��ϼ���");
		String e = sc.next();
		//daoImpl.deleteEmployeeSchedule(employeeSchedule);
		daoImpl.deleteEmployeeSchedule(e);
		
		
	}

	@Override
	public void excelRead(String path) {
		
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
						EmployeeSchedule e = new EmployeeSchedule();
						
						e.setEmpCode(cellList.get(0));
						e.setName(cellList.get(1));
						e.setId(cellList.get(2));
						e.setOffday(cellList.get(3));
						e.setDepartAirport(cellList.get(4));
						e.setArriveAirport(cellList.get(5));
						e.setStartDate(cellList.get(6));
						
						if(e !=null)							
							daoImpl.addEmpSchedule(e);
					}
				}
			}
			
			workbook.close();
			ArrayList<EmployeeSchedule> temp = new ArrayList<EmployeeSchedule>();
			temp = daoImpl.getAllEmployee();
			for(EmployeeSchedule e1:temp)
				System.out.println(e1);
			

		} catch (FileNotFoundException fn) {
			fn.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		System.out.println("Success");
		
		}
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

	@Override
	public void excelwrite(String path) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("NewEmp");
		XSSFRow row = null;
		          
		for(int i=0; i<daoImpl.getAllEmployee().size() ; i++) {
			
			row = sheet.createRow(i);// �ο� ����� 
			row.createCell(0).setCellValue(daoImpl.getAllEmployee().get(i).getEmpCode());
			row.createCell(1).setCellValue(daoImpl.getAllEmployee().get(i).getName());
			row.createCell(2).setCellValue(daoImpl.getAllEmployee().get(i).getId());
			row.createCell(3).setCellValue(daoImpl.getAllEmployee().get(i).getOffday());
			row.createCell(4).setCellValue(daoImpl.getAllEmployee().get(i).getDepartAirport());
			row.createCell(5).setCellValue(daoImpl.getAllEmployee().get(i).getArriveAirport());
			row.createCell(6).setCellValue(daoImpl.getAllEmployee().get(i).getStartDate());
		}
		try {
			FileOutputStream fo = new FileOutputStream(path);
			workbook.write(fo);
			System.out.println("���� ���� �Ϸ�");
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
		
	}

		
	

}

