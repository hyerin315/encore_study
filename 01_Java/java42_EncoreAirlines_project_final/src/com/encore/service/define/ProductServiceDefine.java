package com.encore.service.define;

import java.util.Scanner;

public interface ProductServiceDefine {
	void registerProduct(Scanner sc);
	void removeProduct(Scanner sc);
	void inOutProduct(Scanner sc);
	void printAllProducts(Scanner sc);
	void getByNum(Scanner sc);
	void saveWarehouse(String path);
	void startWarehouse(String path);
}
