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

		// ��� ���� ���� �� �ִ� ����Ʈ ����
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		//String filePath = "src/com/algo/test/excel/sample.xlsx";
		//Path = "src/com/algo/test/excel";
		//Name = "sample.xlsx";

		String filePath = path + "/" + name;

		try {

			// ��� �̰� ���ڰ����� �޾ƿ��� �ؾ� �� -> �������Ϸ�

			FileInputStream fi = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fi);
			XSSFSheet sheet = workbook.getSheetAt(0);
			//row �б�
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);

				if (row != null) {
					// ����Ʈ�� ����Ʈ ����
					ArrayList<String> cellList = new ArrayList<String>();

					//�� �б�
					for (int j = 0; j < row.getLastCellNum(); j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							cellList.add(cellReader(cell));
						}
					}
					//����Ʈ �߰� 
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
	 * ���� ����
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
