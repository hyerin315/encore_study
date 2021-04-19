package warehouse;

import java.util.Scanner;

import order.Order;


//기능 구현
public class ServiceImpl implements Service {

	private Dao dao;// 저장소 작업에서 사용하려 멤버 변수로 정의

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addProduct(Scanner sc) {//배열 추가. 등록: 이름, 가격, 수량 입력받아서 저장
		System.out.println("==== 제품 등록 =========");
		System.out.print("name:");
		String name = sc.next();
		System.out.print("price:");
		int price = sc.nextInt();
		System.out.print("amount:");
		int amount = sc.nextInt();

		Product p = new Product(name, price, amount);
		dao.insert(p);
	}

	@Override
	public Product getByNum(int num) {//주문쪽에서 결제금액 단가*수량
		return dao.selectByNum(num);
	}

	@Override
	public void getByName(Scanner sc) {
		System.out.println("==== 제품 이름으로 검색 =========");
		System.out.print("검색할 제품명:");
		String name = sc.next();
		Product[] arr = dao.selectByName(name);
		if (arr == null) {
			System.out.println("없는 제품 명");
		} else {
			for (Product p : arr) {
				System.out.println(p);
			}
		}
	}

	@Override
	public void editProduct(Scanner sc) {
		System.out.println("==== 제품 가격 수정 =========");
		System.out.print("수정할 제품 번호:");
		int num = sc.nextInt();
		System.out.print("new price:");
		int price = sc.nextInt();
		dao.update(num, price);
	}

	@Override
	public void delProduct(Scanner sc) {
		System.out.println("==== 제품 삭제 =========");
		System.out.print("삭제할 제품 번호:");
		int num = sc.nextInt();
		dao.delete(num);
	}

	@Override
	public Product[] getAll() {
		return dao.selectAll();
	}

	@Override
	public void inProduct(Scanner sc) {
		System.out.println("==== 제품 입고 =========");
		System.out.print("입고할 제품 번호:");
		int num = sc.nextInt();
		System.out.print("입고 수량:");
		int a = sc.nextInt();
		dao.in_out(num, a);
	}

	@Override
	public void outProduct(Order[] orders) {
		System.out.println("==== 제품 출고 =========");
		if (orders == null) {
			return;
		}
		for (Order o : orders) {
			boolean flag = dao.in_out(o.getProd().getNum(), -o.getAmount());
			if (flag) {
				o.setOut_result(true);
				System.out.print("출고처리완료: ");
				System.out.println(o);
			}
		}
	}

	@Override
	public void printProductByNum(Scanner sc) {
		System.out.println("==== 제품 번호로 검색 =========");
		System.out.print("검색할 제품 번호:");
		int num = sc.nextInt();
		Product p = dao.selectByNum(num);
		if (p == null) {
			System.out.println("없는 제품 번호");
		} else {
			System.out.println(p);
		}
	}

	@Override
	public void printAll() {
		Product[] arr = dao.selectAll();
		for (Product p : arr) {
			System.out.println(p);
		}
	}

}
