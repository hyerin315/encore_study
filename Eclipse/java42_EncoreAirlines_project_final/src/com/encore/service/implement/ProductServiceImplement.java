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
	//���ο� ��ǰ�� ��ǰDB�� �߰�
		System.out.println("���ο���ǰ���");
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
	//��ǰDB���� ��ǰ ����
		System.out.println("��ǰ ����");
		System.out.println("�����Ϸ��� ��ǰ�� ��ȣ�� �Է����ּ���:");
		double number = sc.nextDouble();
		dao.deleteProduct(number);
	}

	@Override
	public void inOutProduct(Scanner sc) {
	//��ǰ ����� ó��- ���Ͻ� Menu���� ��� ����Ǵ��� Ȯ���ʿ�!
		System.out.println("��ǰ��ȣ�� �Է����ּ���:");
		int pNumber = sc.nextInt(); 
		System.out.println("��ǰ ����� �������ּ���:");
		int choice = 0;
		double pAmount=0;
		//while��-���� ���������̸� �ٷ� �԰��ϱ� ���ؼ� ������ ���Ǿ� ����⳯�󰥼������ϱ�
		boolean flag = true;
		while(flag) {
			System.out.println("1. �԰�  2. ���   3.�ڷ�");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("�԰��� ������ �Է����ּ���:");
				pAmount = sc.nextDouble();
				dao.updateProduct(pNumber, pAmount);
				System.out.println("�԰�Ϸ�");
				flag=false;
				break;
			case 2:
				System.out.println("����� ������ �Է����ּ���:");
				pAmount = -sc.nextDouble();
				if(!dao.in_out(pNumber, pAmount)) {
					System.out.println("�ش� ��ǰ�� ������ �����Ͽ� ��� �Ұ��մϴ�.�԰����ּ���.");
				}
				else {
					dao.updateProduct(pNumber, pAmount);
					System.out.println("���Ϸ�");
					flag=false;
					break;
				}
			case 3:
				flag=false;
				break;
			}
		}
		return;//ȣ���Ѱ����� ���� Menu���� ��� ����Ǵ��� Ȯ���ʿ�!
	}

	@Override
	public void printAllProducts(Scanner sc) {
	//â�� ��ü ��ǰ ��� ��ȸ
		ArrayList<Product> temp = dao.getAllProducts();
		for(Product p: temp) {
			System.out.println(p);
		}		
	}
	
	@Override
	public void getByNum(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("��ȸ�Ϸ��� ��ǰ��ȣ�� �Է����ּ���:");
		double number= sc.nextDouble();
		if(dao.selectByNum(number)!=null)
			System.out.println(dao.selectByNum(number));
		else
			System.out.println("�ش� ��ǰ�� �����ϴ�.");
	}

	//Apache POI
	@Override
	public void saveWarehouse(String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow row = null;
		//XSSFCell cell = null;
	    //�ο� ����
		for(int i=0; i<dao.getAllProducts().size() ; i++) {
			
			row = sheet.createRow(i);// �ο� ����� 
			row.createCell(0).setCellValue(dao.getAllProducts().get(i).getProdNum());
			row.createCell(1).setCellValue(dao.getAllProducts().get(i).getProdName());//�� ����鼭 �� ����
			row.createCell(2).setCellValue(dao.getAllProducts().get(i).getPrice());
			row.createCell(3).setCellValue(dao.getAllProducts().get(i).getAmount());
			row.createCell(4).setCellValue(dao.getAllProducts().get(i).getSupplier());//�� ����鼭 �� ����
			row.createCell(5).setCellValue(dao.getAllProducts().get(i).getUnitPrice());
		}
		try {
			FileOutputStream fo = new FileOutputStream(path);
			workbook.write(fo);
			System.out.println("â�� ��ǰ ���� ���� �Ϸ�");
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

