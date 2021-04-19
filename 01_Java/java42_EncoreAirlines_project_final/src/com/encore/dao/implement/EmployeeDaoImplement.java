package com.encore.dao.implement;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.NetworkChannel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.encore.dao.define.EmployeeDaoDefine;
import com.encore.vo.EmployeeSchedule;

public class EmployeeDaoImplement implements EmployeeDaoDefine {
	//private ArrayList<EmployeeSchedule> schedules;
	ArrayList<EmployeeSchedule> empSchedule;
	
	//ArrayList<EmployeeSchedule> arrEmp;
	private String path;
	public EmployeeDaoImplement() {
		this. path = "src/EmpSchedule.xlsx";
		empSchedule = new ArrayList<EmployeeSchedule>();
	}

	@Override
	public ArrayList<EmployeeSchedule> getAllEmployee() {
		
		return empSchedule;
	}

	@Override
	public  ArrayList<EmployeeSchedule> addEmpSchedule(EmployeeSchedule e) {
		
		//arrEmp = excelRead();
		empSchedule.add(e);
		//excelwrite(arrEmp);
		return empSchedule;
	}

	@Override
	public EmployeeSchedule searchSchedule(String empCode) {
		 EmployeeSchedule em = new EmployeeSchedule();
		// arrEmp = excelRead();
		 em.setEmpCode(empCode);
		int idx = empSchedule.indexOf(em);
		if (idx<0) {
			return null;
		}else {
			return empSchedule.get(idx);
		}
			
		
	}


	@Override
	public void updateSchdule(String empCode, String offday) {
		EmployeeSchedule em = searchSchedule(empCode);
		//arrEmp = excelRead();
		if(em == null) {
			System.out.println("없는직원입니다.");
		}else {
			em.setOffday(offday);
			//excelwrite(arrEmp);
		}
		
	}

	@Override
	public void deleteEmployeeSchedule(String empCode) {
		EmployeeSchedule e = new EmployeeSchedule();
		empSchedule=getAllEmployee();
		boolean del ; 
		for(EmployeeSchedule em : empSchedule) {
			//if(em == null)
				//continue;
			if(em.getEmpCode().equals(empCode)) {
				//return em;
				del = empSchedule.remove(em);
				System.out.println("delete complete ");
				break;
			}
		}
		
				//empSchedule.remove(e);
		//excelwrite(arrEmp);
		

		
		
		
		
		
	}		

	@Override
	public EmployeeSchedule selectByEmpCode(String eNum) {
		EmployeeSchedule e = new EmployeeSchedule();
		empSchedule=getAllEmployee();
		
		/*e.setEmpCode(eNum);
		int idx = empSchedule.indexOf(e);
		if (idx <0) {
			return null;
		}else {
			return empSchedule.get(idx);
		}
		*/
		
		
		for(EmployeeSchedule em : empSchedule) {
			if(em == null)
				continue;
			if(em.getEmpCode().equals(eNum)) {
				//return em;
				e = em;
			}
		}
		
		return e;
	}

	

/*public void excelwrite(ArrayList<EmployeeSchedule> tempArray) {
		
		arrEmp = new ArrayList<EmployeeSchedule>();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow row = null;
		//XSSFCell cell = null;
	    //로우 생성
		for(int i=0; i<tempArray.size() ; i++) {
			
			row = sheet.createRow(i);// 로우 만들고 
			row.createCell(0).setCellValue(tempArray.get(i).getEmpCode());
			row.createCell(1).setCellValue(tempArray.get(i).getName());
			row.createCell(2).setCellValue(tempArray.get(i).getId());
			row.createCell(3).setCellValue(tempArray.get(i).getOffday());
			row.createCell(4).setCellValue(tempArray.get(i).getDepartAirport());
			row.createCell(5).setCellValue(tempArray.get(i).getArriveAirport());
			row.createCell(6).setCellValue(tempArray.get(i).getStartDate());
		}
		try {
			FileOutputStream fo = new FileOutputStream(path);
			workbook.write(fo);
			System.out.println("파일 생성 완료");
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<EmployeeSchedule> excelRead() {
		
		ArrayList<EmployeeSchedule> arryEmpSchedule = new ArrayList<EmployeeSchedule>();
		try {
			
			FileInputStream fi = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fi);//엑셀파일
			XSSFSheet sheet = workbook.getSheetAt(0);//아래 Sheet 탭
			
			// row 읽기
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);

				if (row != null) {
					// 리스트의 리스트 선언
					ArrayList<String> cellList = new ArrayList<String>();
					
					// 셀 읽기
					for (int j = 0; j < row.getLastCellNum(); j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							cellList.add(cellReader(cell));
						}
					}
					
					if(i>0 && cellList !=null) {
						EmployeeSchedule empScuedule = new EmployeeSchedule();
						
						empScuedule.setEmpCode(cellList.get(0));
						empScuedule.setName(cellList.get(1));
						empScuedule.setId(cellList.get(2));
						empScuedule.setOffday(cellList.get(0));
						empScuedule.setDepartAirport(cellList.get(1));
						empScuedule.setArriveAirport(cellList.get(2));
						empScuedule.setStartDate(cellList.get(2));
						
						if(empScuedule !=null)							
							arryEmpSchedule.add(empScuedule);
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
		System.out.println("Success");
		
		for(Employee e: dao.getAllEmployee())
			System.out.println(e);
		return arryEmpSchedule;
	}
	
	
	 * 포맷 설정
	 
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
	}*/
}
