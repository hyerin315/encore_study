package com.encore.dao.implement;

import java.util.ArrayList;

import com.encore.dao.define.ProductDaoDefine;
import com.encore.vo.Product;

public class ProductDaoImplement implements ProductDaoDefine {

	private ArrayList<Product> products;
	//생성자
	public ProductDaoImplement() {
		products = new ArrayList<Product>();
	}
	
	@Override
	public ArrayList<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		products.add(p);
	}
	
	@Override
	public Product selectByNum(double pNum) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setProdNum(pNum);
		int idx = products.indexOf(p);
		if (idx < 0) {
			return null;
		} else {
			return products.get(idx);
		}
	}


	@Override
	public void updateProduct(double pNumber, double pAmount) {
		//param1: pNumber-변경할 제품 번호, param2: pAmount-창고에서 출고(-)/입고할(+)수량
		if(this.selectByNum(pNumber)!=null) {
			//System.out.println(this.selectByNum(pNumber).getAmount());
			double newAmount = this.selectByNum(pNumber).getAmount()+pAmount;
			this.selectByNum(pNumber).setAmount(newAmount);
		}
		else 
			System.out.println("해당 제품이 없습니다.");
	}


	@Override
	public void deleteProduct(double pNumber) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setProdNum(pNumber);
		boolean isFoundAndDeleted = products.remove(p);
		if(isFoundAndDeleted) System.out.println("제품삭제완료");
		else System.out.println("제품번호가 없습니다.");
	}


	@Override
	public boolean in_out(double pNumber, double pAmount) {
		// false: 수량부족으로 창고출고불가, true: 출고가능
		boolean out;
		if(this.selectByNum(pNumber).getAmount()+pAmount<0) {
			out = false;
		}
		else out=true;
		return out;
	}



}
