package warehouse;

import java.util.Scanner;

import product_order.Order;

//기능 구현

public class ServiceImpl implements Service {
	private Dao dao;//저장소 작업에서 사용하려 멤버 변수로 정의
	
	public ServiceImpl() {
		dao = new DaoImpl();
	}

	//1.상품등록
	@Override
	public void addProduct(Scanner sc) {//배열에 추가 --> 배열 객체 Dao 필요
		
		System.out.println("====제품등록====");
		System.out.print("name:");
		String name = sc.next();
		System.out.print("price:");
		int price = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();
		
		Product p = new Product(name, price, amount);
		dao.insert(p);
	}
	
	//2.번호 검색
	@Override
	public Product getByNum(int num) {
		return dao.selectByNum(num);
	}
	
	//_번호검색 출력
	@Override
	public void printProductByNum(Scanner sc) {
		System.out.println("====제품 번호로 검색====");
		System.out.println("검색할 제품번호 :");
		int num = sc.nextInt();
		Product p = dao.selectByNum(num);
		if(p == null) {
			System.out.println("없는 제품 번호");
	}else {
		System.out.println(p);
		}
	}

	//3.이름으로 검색
	@Override
	public void getByName(Scanner sc) {
		System.out.println("====제품 이름으로 검색====");
		System.out.print("검색할 제품명 :");
		String name = sc.next();
		Product[] arr = dao.selectByName(name);
		if(arr == null) {
			System.out.println("없는 제품입니다.");
		}else {
			for(Product p : arr) {
				System.out.println(p);
			}
		}
	}
	
	//4.가격수정 
	@Override
	public void editProduct(Scanner sc) {
		System.out.println("====제품 가격 수정====");
		System.out.print("수정할 제품번호 :");
		int num = sc.nextInt();
		System.out.print("수정할 가격 :");
		int price = sc.nextInt();
		dao.update(num, price);
	}
	
	//5.제품삭제
	@Override
	public void delProduct(Scanner sc) {
		System.out.println("====제품 삭제====");
		System.out.println("수정할 제품번호 :");
		int num = sc.nextInt();
		dao.delete(num);
	}
	
	//6.전체제품 출력 
	@Override
	public Product[] getAll()  {
		return dao.selectAll();
    }
	
	//__전체 제품 출력
	@Override
	public void printAll() {
		Product[] arr = dao.selectAll();
		for(Product p : arr) {
			System.out.println(p);
		}
	}
	
	//7.입고 & 8.출고
	//__입고
	@Override
	public void inProduct(Scanner sc) {
		System.out.println("=====제품 입고=====");
		System.out.println("입고하실 제품 번호를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.println("입고하실 수량을 입력해주세요 : ");
		int a= sc.nextInt();
		dao.in_out(num, a);
	}
	
	//__출고
	@Override
	public void outProduct(Order[] orders) {
		System.out.println("준비중...order와 함께 완성 예정");
		System.out.println("\n=====제품 출고=====");
		for(Order o : orders) {
			boolean flag = dao.in_out(o.getProd().getNum(), -o.getAmount());
			if(flag) {
				o.setOut_result(true);
				System.out.print("출고처리 완료 : ");
				System.out.println(o);
			}
		}
	}
}
