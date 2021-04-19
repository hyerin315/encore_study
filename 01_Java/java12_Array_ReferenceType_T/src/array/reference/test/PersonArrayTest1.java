package array.reference.test;

import array.reference.vo.Product;

public class PersonArrayTest1 {
	public static void main(String[] args) {
		/*
		 * Product ��ü�� 3�� ����
		 * ������ 3���� ��ü�� �迭�� ���� �ִ´�
		 * (Product �迭 �ȿ��� Product Ÿ���� ��ü�� ��)
		 */
/*		Product pro1 = new Product("Hp", 120, 1);
		Product pro2 = new Product("Samsung", 80, 2);
		Product pro3 = new Product("Apple", 42, 3);
		
		Product[ ] pros = new Product[3]; */
		
		Product[ ] pros = {
				new Product("Hp", 120, 1),
				new Product("Samsung", 80, 2),
				new Product("Apple", 42, 3),
				new Product("Apple", 200, 2),
		};//���� ����� �Ȱ���
		
		
		System.out.println("�迭�� �ּҰ�: "+pros);
		System.out.println("===============�迭�� ��ü�� �����ϴ� �ּҰ�===========");
		for(int i=0; i<pros.length; i++) 
			System.out.println(pros[i].getDetails());
		
		//���� ����� �Ȱ���
		System.out.println("===============�迭�� ��ü�� �����ϴ� �ּҰ� :: ���� for���� ���===========");
		for(Product p:pros) System.out.println(p.getDetails());
		
		
		/* 
		 * 1) pros �迭 �ȿ� �ִ� �� ��ǰ���� �귣�� �� ����ϼ���
		 * 2) pros �迭 �ȿ� �ִ� ��ǰ�� �߿��� 100������ �Ѵ� ���� ��ǰ�� �̸��� ������ ����ϼ���
		 * 3) pros �迭 �ȿ� �ִ� ��ǰ���� �� ������ ����ϼ���
		 * 4) pros �迭 �ȿ� �ִ� ��ǰ���� ��հ����� ����ϼ���
		 */
		
		
		//ȣ��� ���ÿ� ����� «�͵Ǿ� ���� (�̰� ���� ���� vo�ε� ��� «���� �Ǿ� ���� x) 
		//--> �׷��� ��ɸ� ������ �ִ� Ŭ������ ���� ����� = ������� ���� ~ Service��� �̸��� ���� / ~ Manager�� ������ ��쵵 ���� == ����� �ڵ鸵�ϰ� �ֱ���
		//1) pros �迭 �ȿ� �ִ� �� ��ǰ���� �귣�� �� ����ϼ���
		System.out.println("�� ��ǰ�� �귣�� �̸��Դϴ�...");
		for(Product p : pros) System.out.print(p.getBrand());
		
		//2) pros �迭 �ȿ� �ִ� ��ǰ�� �߿��� 100������ �Ѵ� ���� ��ǰ�� �̸��� ������ ����ϼ���
		System.out.println("100���� �̻� ������ ��ǰ�Դϴ�...");
		for(Product p : pros) {
			if (p.getPrice()>=100) System.out.println(p.getBrand()+","+p.getPrice());
		}
		
		//3) pros �迭 �ȿ� �ִ� ��ǰ���� �� ������ ����ϼ���
		int total = 0;
		for (Product p : pros) total += p.getPrice();
		System.out.println("��ǰ�� �� �����Դϴ�....."+total+" ����");
		
		//4) pros �迭 �ȿ� �ִ� ��ǰ���� ��հ����� ����ϼ���
		
		
	}
}
