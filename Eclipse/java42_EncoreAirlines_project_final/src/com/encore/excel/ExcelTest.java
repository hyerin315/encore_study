package com.encore.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;


//클래스 만들어서 테스트 get 으로 

class Date{
	private int year;
	private int month;
	private int day;
	private int hh;//시
	private int mm;//분
	
	Date(){
		
		Calendar cal = Calendar.getInstance();
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH+1);
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		this.hh = cal.get(Calendar.HOUR);
		this.mm = cal.get(Calendar.MINUTE);
		
		
	}

	public int getHh() {
		return hh;
	}

	public void setHh(int hh) {
		this.hh = hh;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}
	
	
}

class EmpSchedule{
	private int empCode;
	private String name;
	private String id;
	private String offDay;
	private String TicketNum;
	private String subAirlines;//항공사
	
	private String flightNum; //편명
	private String departAirport;//출발공항
	private String arriveAirport;//도착공항 
	
	private Date departTime;//출발시간
	private Date arriveTime;//도착시간 
	
	private String operatingDay;//운항요일
	
	private Date startDate;//시작일자
	private Date endDate;//종료일자
	private String flightKind;//기종
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOffDay() {
		return offDay;
	}
	public void setOffDay(String offDay) {
		this.offDay = offDay;
	}
	public String getTicketNum() {
		return TicketNum;
	}
	public void setTicketNum(String ticketNum) {
		TicketNum = ticketNum;
	}
	public String getSubAirlines() {
		return subAirlines;
	}
	public void setSubAirlines(String subAirlines) {
		this.subAirlines = subAirlines;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public String getDepartAirport() {
		return departAirport;
	}
	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}
	public String getArriveAirport() {
		return arriveAirport;
	}
	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	public int getDepartTime() {
		return departTime.getHh() + departTime.getMm();
	}
	public void setDepartTime(int hh, int mm) {
		this.departTime.setHh(hh);
		this.departTime.setMm(mm);
	}
	public int getArriveTime() {
		return arriveTime.getHh() + arriveTime.getMm();
	}
	public void setArriveTime(int hh, int mm) {
		this.arriveTime.setHh(hh);
		this.arriveTime.setMm(mm);
	}
	public String getOperatingDay() {
		return operatingDay;
	}
	public void setOperatingDay(String operatingDay) {
		this.operatingDay = operatingDay;
	}
	public int getStartDate() {
		return endDate.getYear() + endDate.getMonth() + endDate.getDay();
	}
	public void setStartDate(int year, int month, int day) {
		this.startDate.setYear(year);
		this.startDate.setMonth(month);
		this.startDate.setDay(day);
	}
	public int getEndDate() {
		return endDate.getYear() + endDate.getMonth() + endDate.getDay();
	}
	public void setEndDate(int year, int month, int day) {
		this.endDate.setYear(year);
		this.endDate.setMonth(month);
		this.endDate.setDay(day);
	}
	public String getFlightKind() {
		return flightKind;
	}
	public void setFlightKind(String flightKind) {
		this.flightKind = flightKind;
	}
}



public class ExcelTest {

	public static void main(String[] args) {
	
		ArrayList<EmpSchedule> empList2 = new ArrayList<EmpSchedule>();
		
		String filePath = "src/com/algo/test/excel/sample4.xlsx";

		try {

			// 경로 이거 인자값으로 받아오게 해야 함 -> 실행파일로

			FileInputStream fi = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fi);//엑셀파일
			XSSFSheet sheet = workbook.getSheetAt(0);//아래 Sheet 탭
			
			// row 읽기
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
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
					
					if(i>0) {
						EmpSchedule empSchedule = new EmpSchedule();
						
						empSchedule.setEmpCode(Integer.parseInt(cellList.get(0)));
						empSchedule.setName(cellList.get(1));
						empSchedule.setId(cellList.get(2));
						empList2.add(empSchedule);
					
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
		
		excelWrite(excelUpdate(empList2, 20001), "src/com/algo/test/excel", "sample.xlsx");

	}
	
	//update 리스트 
	// 
/*	public static <T> ArrayList<ArrayList<T>> excelUpdate(ArrayList<ArrayList<T>> originArr){
		//해당 코드를 검색해서 row 리스트 전체 update;
		//어떤 타입이라도 받아올 수 있다 
		
		for(int i=0 ; i<originArr.size() ; i++) {
			
		}
		
		originArr.
		
		//그 클래스의 getter를 가지고 와야하는데 음........ 
		
		
		
		
		return null;
	}*/
	
	public static ArrayList<EmpSchedule> excelUpdate(ArrayList<EmpSchedule> originArr, int empCode){
		
		for(int i=0 ; i<originArr.size() ; i++) {
			if(originArr.get(i).getEmpCode() == 20001) {
				originArr.get(i).setName("정찬식");
			}
		}
		return originArr;
	}
	
	//write test
	public static void excelWrite(ArrayList<EmpSchedule> arrList, String path, String name) {
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow row = null;
		XSSFCell cell = null;
	    //로우 생성
		for(int i=0; i<arrList.size() ; i++) {
			
			row = sheet.createRow(i);// 로우 만들고 
			row.createCell(0).setCellValue(arrList.get(i).getEmpCode());//셀 만들면서 값 대입
			row.createCell(1).setCellValue(arrList.get(i).getName());//셀 만들면서 값 대입
			
		}
		

		
		
		
		
		try {
			FileOutputStream fo = new FileOutputStream(path + "/1" + name);
			workbook.write(fo);
			System.out.println("파일 생성 완료");
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	/*
	 * 포맷 설정
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
				value = (int)cell.getNumericCellValue() + "";
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
