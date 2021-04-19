package warehouse;
import java.util.Scanner;

//기능 명세

public interface Service {
	void addProduct(Scanner sc);//등록
	Product getByNum(int num);//번호로 검색
	void printProductByNum(Scanner sc);
	void getByName(Scanner sc);//이름으로 검색
	void editProduct(Scanner sc);//가격 수정
	void delProduct(Scanner sc);//삭제
	Product[] getAll();//전체검색
	void printAll();
	void inProduct(Scanner sc);//입고
	void outProduct(Scanner sc);//출고
	
}
