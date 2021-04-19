package com.encore.dao.define;

import java.util.ArrayList;

import com.encore.vo.Product;

public interface ProductDaoDefine {
	ArrayList<Product> getAllProducts();
	void addProduct(Product p);
	Product selectByNum(double pNum);
	void updateProduct(double pNumber, double pAmount);
	void deleteProduct(double pNumber);
	boolean in_out(double pNumber, double pAmount);
}
