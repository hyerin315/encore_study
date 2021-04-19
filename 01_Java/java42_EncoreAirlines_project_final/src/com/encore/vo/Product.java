package com.encore.vo;

public class Product {
	
	private double prodNum;
	private String prodName; 
	private double price; 
	private double amount;
	private String supplier;
	private double unitPrice; 
	
	
	public Product() {}
	
	public Product(double prodNum, String prodName, double price, double amount, String supplier, double unitPrice) {
		//super();
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.price = price;
		this.amount = amount;
		this.supplier = supplier;
		this.unitPrice = unitPrice;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof Product) {
			if(prodNum == ((Product)obj).prodNum) {
				return true;
			}
		}
		return super.equals(obj);
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdNum() {
		return prodNum;
	}

	public void setProdNum(double prodNum) {
		this.prodNum = prodNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Product [prodNum=" + prodNum + ", prodName=" + prodName + ", price=" + price + ", amount=" + amount
				+ ", Supplier=" + supplier + ", unitPrice=" + unitPrice + "]";
	}


	
}
