package com.encore.dao.implement;

import java.util.ArrayList;

import com.encore.dao.define.ProductDaoDefine;
import com.encore.vo.Product;

public class ProductDaoImplement implements ProductDaoDefine {

	private ArrayList<Product> products;
	//������
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
		//param1: pNumber-������ ��ǰ ��ȣ, param2: pAmount-â���� ���(-)/�԰���(+)����
		if(this.selectByNum(pNumber)!=null) {
			//System.out.println(this.selectByNum(pNumber).getAmount());
			double newAmount = this.selectByNum(pNumber).getAmount()+pAmount;
			this.selectByNum(pNumber).setAmount(newAmount);
		}
		else 
			System.out.println("�ش� ��ǰ�� �����ϴ�.");
	}


	@Override
	public void deleteProduct(double pNumber) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setProdNum(pNumber);
		boolean isFoundAndDeleted = products.remove(p);
		if(isFoundAndDeleted) System.out.println("��ǰ�����Ϸ�");
		else System.out.println("��ǰ��ȣ�� �����ϴ�.");
	}


	@Override
	public boolean in_out(double pNumber, double pAmount) {
		// false: ������������ â�����Ұ�, true: �����
		boolean out;
		if(this.selectByNum(pNumber).getAmount()+pAmount<0) {
			out = false;
		}
		else out=true;
		return out;
	}



}
