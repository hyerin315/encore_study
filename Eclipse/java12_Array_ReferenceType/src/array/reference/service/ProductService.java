package array.reference.service;
//1. ��� ��ǰ�� �귣�� ���� ����ϴ� ����� ���� (�޼ҵ带 ¥����)
//2. ��� ��ǰ�� �Ѱ����� �����ϴ� ����� ����
//3. ��� ��ǰ�� ��հ����� �����ϴ� ����� ����
//4. 100���� �̻��� ����ǰ�� ������ ����ϴ� ����� ����
//5. Ư���� ȸ�� ��ǰ�� �����ϴ� ����� ����
//���� �� �� : 1~5�������� ����� ���� (�����+������)

import array.reference.vo.Product;

public class ProductService {
	//hr.ũ�� �Ҵ� �� �ʱ�ȭ ���� �迭�� ���������� ����
	private Product[] product;
	//������ Ȥ�� setter�� ����
	public ProductService(Product[] p) {
		product = p;
	}
	//1. ��� ��ǰ�� �귣�� ���� ����ϴ� ����� ����
/*	public void getAllBrand() {
		System.out.println("[��� ��ǰ�� �귣��� ���]");
	} */
	
	//4. 100���� �̻��� ����ǰ�� ������ ����ϴ� ����� ����
	public int maxPriceProduct(Product product) {
		int max = 100;
		for(Product product : p.getPrice()) {
			if(product.getPrice() >= max) {
				max = product.getPrice();
			}
		}
		


}

	

}
