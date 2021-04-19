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

import com.encore.dao.implement.ProductDaoImplement;
import com.encore.service.define.ProductServiceDefine;
import com.encore.vo.Product;

public class ProductServiceImplement implements ProductServiceDefine {
	private ProductDaoImplement dao;
	
	public ProductServiceImplement() {
		dao = new ProductDaoImplement();
	}
	
	@Override
	public void registerProduct(Scanner sc) {
	//새로운 제품을 제품DB에 추가
		System.out.println("새로운제품등록");
		System.out.print("Product Number:");
		double prodNum = sc.nextDouble(); 
		System.out.print("Product Name:");
		String prodName = sc.next(); 
		System.out.print("Price:");
		double price =sc.nextDouble(); 
		System.out.print("Amount:");
		double amount = sc.nextDouble(); 
		System.out.print("Supplier:");
		String supplier = sc.next();
		System.out.print("UnitPrice:");
		double unitPrice = sc.nextDouble();
		
		Product p = new Product(prodNum, prodName, price, amount, supplier, unitPrice);
		dao.addProduct(p);
	}

	@Override
	public void removeProduct(Scanner sc) {
	//제품DB에서 제품 삭제
		System.out.println("제품 삭제");
		System.out.println("삭제하려는 제품의 번호를 입력해주세요:");
		double number = sc.nextDouble();
		dao.deleteProduct(number);
	}

	@Override
	public void inOutProduct(Scanner sc) {
	//제품 입출고 처리- 리턴시 Menu에서 어떻게 연결되는지 확인필요!
		System.out.println("제품번호를 입력해주세요:");
		int pNumber = sc.nextInt(); 
		System.out.println("제품 입출고 선택해주세요:");
		int choice = 0;
		double pAmount=0;
		//while문-출고시 수량부족이면 바로 입고하기 위해서 비행기로 출고되야 비행기날라갈수있으니까
		boolean flag = true;
		while(flag) {
			System.out.println("1. 입고  2. 출고   3.뒤로");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("입고할 수량을 입력해주세요:");
				pAmount = sc.nextDouble();
				dao.updateProduct(pNumber, pAmount);
				System.out.println("입고완료");
				flag=false;
				break;
			case 2:
				System.out.println("출고할 수량을 입력해주세요:");
				pAmount = -sc.nextDouble();
				if(!dao.in_out(pNumber, pAmount)) {
					System.out.println("해당 제품은 수량이 부족하여 출고 불가합니다.입고해주세요.");
				}
				else {
					dao.updateProduct(pNumber, pAmount);
					System.out.println("출고완료");
					flag=false;
					break;
				}
			case 3:
				flag=false;
				break;
			}
		}
		return;//호출한곳으로 리턴 Menu에서 어떻게 연결되는지 확인필요!
	}

	@Override
	public void printAllProducts(Scanner sc) {
	//창고 전체 제품 목록 조회
		ArrayList<Product> temp = dao.getAllProducts();
		for(Product p: temp) {
			System.out.println(p);
		}		
	}
	
	@Override
	public void getByNum(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("조회하려는 제품번호을 입력해주세요:");
		double number= sc.nextDouble();
		if(dao.selectByNum(number)!=null)
			System.out.println(dao.selectByNum(number));
		else
			System.out.println("해당 제품이 없습니다.");
	}

	//Apache POI
	@Override
	public void saveWarehouse(String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow row = null;
		//XSSFCell cell = null;
	    //로우 생성
		for(int i=0; i<dao.getAllProducts().size() ; i++) {
			
			row = sheet.createRow(i);// 로우 만들고 
			row.createCell(0).setCellValue(dao.getAllProducts().get(i).getProdNum());
			row.createCell(1).setCellValue(dao.getAllProducts().get(i).getProdName());//셀 만들면서 값 대입
			row.createCell(2).setCellValue(dao.getAllProducts().get(i).getPrice());
			row.createCell(3).setCellValue(dao.getAllProducts().get(i).getAmount());
			row.createCell(4).setCellValue(dao.getAllProducts().get(i).getSupplier());//셀 만들면서 값 대입
			row.createCell(5).setCellValue(dao.getAllProducts().get(i).getUnitPrice());
		}
		try {
			FileOutputStream fo = new FileOutputStream(path);
			workbook.write(fo);
			System.out.println("창고 물품 파일 생성 완료");
			workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void startWarehouse(String path) {
		try {
			//ArrayList<Product> prodList = new ArrayList<Product>();
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
						Product product = new Product();
						product.setProdNum(Double.parseDouble(cellList.get(0)));
						product.setProdName(cellList.get(1));
						product.setPrice(Double.parseDouble(cellList.get(2)));
						product.setAmount(Double.parseDouble(cellList.get(3)));
						product.setSupplier(cellList.get(4));
						product.setUnitPrice(Double.parseDouble(cellList.get(5)));
						
						if(product !=null)
							//prodList.add(product);
							dao.addProduct(product);
					
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

		//for(Product p: dao.getAllProducts())
		//	System.out.println(p);
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

