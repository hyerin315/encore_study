package com.encore.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	// xls -> hssf
	// xlsx -> xssf
	public ArrayList<ArrayList<String>> excelRead(String path, String name) {

		// 행과 열을 담을 수 있는 리스트 생성
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		//String filePath = "src/com/algo/test/excel/sample.xlsx";
		//Path = "src/com/algo/test/excel";
		//Name = "sample.xlsx";

		String filePath = path + "/" + name;

		try {

			// 경로 이거 인자값으로 받아오게 해야 함 -> 실행파일로

			FileInputStream fi = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fi);
			XSSFSheet sheet = workbook.getSheetAt(0);
			//row 읽기
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);

				if (row != null) {
					// 리스트의 리스트 선언
					ArrayList<String> cellList = new ArrayList<String>();

					//셀 읽기
					for (int j = 0; j < row.getLastCellNum(); j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							cellList.add(cellReader(cell));
						}
					}
					//리스트 추가 
					list.add(cellList);
				}
			}

			/*
			 * for(int i=0 ; i<list.size() ; i++) { for(int j=0 ; j<list.get(i).size(); j++)
			 * { System.out.print(list.get(i).get(j) + "\t"); } System.out.println(); }
			 */

			workbook.close();

		} catch (FileNotFoundException fn) {
			fn.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	/*
	 * 포맷 설정
	 */
	@SuppressWarnings("incomplete-switch")
	private String cellReader(XSSFCell cell) {
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
