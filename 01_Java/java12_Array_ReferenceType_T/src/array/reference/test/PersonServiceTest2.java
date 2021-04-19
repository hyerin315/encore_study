package array.reference.test;
//1. ProductService ��ü�� ����
//2. ProductService�� ����� ȣ��...�̶� ���ڰ� �˾Ƽ� �� ��������!

import array.reference.service.ProductService;
import array.reference.vo.Product;

public class PersonServiceTest2 {
	public static void main(String[] args) {
		Product[ ] pros = {
				new Product("Hp", 120, 1),
				new Product("Samsung", 80, 2),
				new Product("Apple", 42, 3),
				new Product("Apple", 200, 2),
		};
		
		ProductService service = new ProductService();
		System.out.println("1. ��� ��ǰ�� �귣�� ���� ����մϴ�...");
		service.printAllBrand(pros);
		
		System.out.println("\n2. ��� ��ǰ�� �Ѱ����� ����մϴ�...");
		System.out.println(service.getTotalPrice(pros)+"����");//���ϵ� ���� ����ϱ� ���ؼ� sysout �������
		
		System.out.println("3. ��� ��ǰ�� ��հ����� ����մϴ�...");
		System.out.println(service.getAvgPrice(pros)+"����");//���ϵ� ���� ����ϱ� ���ؼ� sysout �������

		System.out.println("4. 100���� �̻��� ����ǰ�� ������ ����մϴ�...");
		service.printOverPrice(pros, 100);
		
		System.out.println("5. Ư���� ȸ�� ��ǰ�� ����մϴ�...");
		Product[ ] products = service.getCertainBrand(pros, "Apple");//Service���� �迭 ���ϵǸ�
		for(Product p : products) {
			if(p==null)continue;//������ ��ü�� �귣�带 ���������� ��ŵ�ϰ� �������� ����
			System.out.println(p.getDetails());//���⼭ ��½� null�� ������ �Ǹ� ������������ �����ϰ� ��
		}

	}
}
