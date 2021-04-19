package com.encore.dao.implement;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.encore.dao.define.JoinDaoDefine;
import com.encore.vo.People;
import com.util.LoadConfig;

public class JoinDaoImplement implements JoinDaoDefine {
	
	ArrayList<People> arrPeople;
	ArrayList<String> arrTemp;
	FileInputStream fileInputStream;
	FileOutputStream fileOutputStream;
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow excelRow;
	XSSFCell excelCell;
	Properties property;
	
	
	People objPeople;
	private String path;
	
	public JoinDaoImplement() {
		LoadConfig loadConfig = new LoadConfig();
		loadConfig.getFilePath("Path_CustEmpList");
		
		path = loadConfig.getPath();
		
	}
	
	
	
	//get all List
	@Override
	public ArrayList<People> getAllList() {
		
		try {
			
			arrPeople = new ArrayList<People>();
			fileInputStream = new FileInputStream(path);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheetAt(0);
			
			//excel row read
			for(int i=0 ; i<sheet.getLastRowNum()+1 ; i++) {
				
				excelRow = sheet.getRow(i);
				
				if(excelRow != null) {
					
					arrTemp = new ArrayList<String>();
					
					for(int j=0 ; j<excelRow.getLastCellNum() ; j++) {
						
						excelCell = excelRow.getCell(j);
						
						if(excelCell != null) {
							arrTemp.add(cellReader(excelCell));
						}
					}
					
					if(i>0 && arrTemp != null) {
						objPeople = new People();
						//code, name, id, password, birth_date
						
						if(arrTemp.get(0) != "") {
							objPeople.setCode(Integer.parseInt(arrTemp.get(0)));
							objPeople.setName(arrTemp.get(1));
							objPeople.setId(arrTemp.get(2));
							objPeople.setPassword(arrTemp.get(3));
							objPeople.setBirthDate(arrTemp.get(4));
							
							//Add People arrayList 
							if(objPeople != null) {
								arrPeople.add(objPeople);
							}
						}
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
		return arrPeople;
	}
	
	
	//Join us.
	public boolean insertList(People p) {
		
		workbook = null;
		sheet = null;
		excelRow = null;
		excelCell = null;
		
		arrPeople = null;
		arrPeople = this.getAllList();
		
		arrPeople.add(p);
		
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sheet1");
		
		for(int i=0 ; i<arrPeople.size() ; i++) {
			excelRow = sheet.createRow(i);
			excelRow.createCell(0).setCellValue(arrPeople.get(i).getCode());
			excelRow.createCell(1).setCellValue(arrPeople.get(i).getName());
			excelRow.createCell(2).setCellValue(arrPeople.get(i).getId());
			excelRow.createCell(3).setCellValue(arrPeople.get(i).getPassword());
			excelRow.createCell(4).setCellValue(arrPeople.get(i).getBirthDate());
		}
		
		try {
			fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			workbook.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	//Show my info 
	public void getList(People p) {
		
		
		
	}
	//delete my info 
	public void deleteList(People p){
		arrPeople = null;
		arrPeople = this.getAllList();
		
		workbook = null;
		sheet = null;
		excelRow = null;
		excelCell = null;
		
		int idx = 0;
		arrPeople.remove(p);
		
		/*for(People temp : arrPeople) {
			if(temp == null)
				continue;
			
			if(temp.getId().equals(p.getId())) {
				arrPeople.remove(idx++);
			}
		}*/
		
		//People ppl = new People();
		//ppl.setId(p.getId());
		//arrPeople.remove(ppl);
		
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sheet1");
		
		for(int i=0 ; i<arrPeople.size() ; i++) {
			excelRow = sheet.createRow(i);
			excelRow.createCell(0).setCellValue(arrPeople.get(i).getCode());
			excelRow.createCell(1).setCellValue(arrPeople.get(i).getName());
			excelRow.createCell(2).setCellValue(arrPeople.get(i).getId());
			excelRow.createCell(3).setCellValue(arrPeople.get(i).getPassword());
			excelRow.createCell(4).setCellValue(arrPeople.get(i).getBirthDate());
		}
		
		try {
			fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	@SuppressWarnings("incomplete-switch")
	public String cellReader(XSSFCell cell) {
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
