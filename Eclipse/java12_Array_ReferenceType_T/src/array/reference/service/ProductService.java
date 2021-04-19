package array.reference.service;

import array.reference.vo.Product;

//1. ��� ��ǰ�� �귣�� ���� ����ϴ� ����� ���� (�޼ҵ带 ¥����)
//2. ��� ��ǰ�� �Ѱ����� �����ϴ� ����� ����
//3. ��� ��ǰ�� ��հ����� �����ϴ� ����� ����
//4. 100���� �̻��� ����ǰ�� ������ ����ϴ� ����� ����
//5. Ư���� ȸ�� ��ǰ�� �����ϴ� ����� ����
//���� �� �� : 1~5�������� ����� ���� (�����+������)

public class ProductService {
	public void printAllBrand(Product[ ] pros) {//��� ��ǰ�� ���� �귣�� �̸��� ����ؾ��ϱ� ������ �迭�� ������ --> ���񽺿� ���δ�Ʈ�� ���ڰ����� Hasing
		for(Product p : pros) System.out.print(p.getBrand()+" ");
	}
	public int getTotalPrice(Product[ ] pros) {//����Ÿ���� ���� ���� �ݵ�� �����ϰ� �����ؾ���
		int total = 0;//�ʱ�ȭ �ݵ�� ù ���ο��� �ϰ� ������
		for(Product p : pros) total += p.getPrice();
		//�迭�̴ϱ� ��� ���鼭 ���� �׾ƾ��� --> pros�� ��ü �ϳ��ϳ��� Product p�� �ϳ��ϳ� ��ü�� ���ͼ� total += p.getPrice�� ���ư��� �� (p�� ���⼭ �����) / pros�� �׽�Ʈ���� �ҷ�����
		return total;//������ �ؾ������� ���� �ȳ��� 0���� �״ٰ� ���߿� total�� �ٲ���
	}//��ƼƼ �ݿ� �ȵǾ �ٽ� �ؾ���
	public int getAvgPrice(Product[ ] pros) {
		//��� ��ǰ�� �� ������ ���ϰ� �� ���� �ٽ� �迭�� ������� ���������� ������ --> �̷��� �� �ʿ䰡 ����
		return getTotalPrice(pros)/pros.length;//���� ���ǵ� ����� ���⼭ ����(�߿�)�Ѵ� --> �Ѱ��� ȣ�� �� pros�� ������� ������
	}
	public void printOverPrice(Product[ ] pros, int price) {
		for(Product p : pros) {
			if(p.getPrice()>=price)//price�� �� �־��ָ� �������� ��
				System.out.println(p.getBrand()+","+p.getPrice());
		}//for	
	}
	//String�� �ʿ䰡 ���� --> Product�� ���� �÷������� ���ϵǾ����
	public Product[ ] getCertainBrand(Product[ ] pros,String brand) {
		Product[ ] products= new Product[pros.length];//1. ��ü ��ǰ ������ ���� �������� �迭�� ������ (4ĭ --> null ���� �������)
		//��ü�� �� �ȿ� ����־���ϱ� ������ �����ϰ� ������ (�׸��� �迭�� ����� ����ϰ� �����ϴµ�, � �� ������ �� --> �׷��� pros.length
		//���� for���� �ƴ� --> ���߿� �ٲ����
	    /* for(int i=0; i<pros.length; i++) {
			if(pros[i].getBrand().equals(brand)) //�귣�� �̸��� ���� ��, ���� �ε����� ���� ����
			//equals�� ==�� ����
				products[i] = pros[i];
		}  */
		//���� for��
		int idx = 0;
		//���� for���� �ε����� ��� ���������� ���ư��� �ϳ��ϳ��� �̾� �� �� �ִµ�, 
		//�츮�� idx���� �ϴ� ���� �Ϻη� ��������� �ϳ��ϳ� �������� �ö� �� �ֱ� ������ ����ϰ� ����
		for(Product p : pros) {
			//2. ��ǰ�� �ϳ��ϳ��� �Ҵ�ȴ� (���⼭ pros�� 4ĭ¥�� �迭�ε� ��ǰ���� �� ������ --> �� ��ǰ �ϳ��ϳ��� Product p�� �ϳ��ϳ� �Ҵ� --> �׷��� 4�� ���鼭 ��ǰ�� �ϳ��ϳ� ������ ��)
			//3. ���� �̸��� ���� �� Apple�� ������ ���ϰ� �� --> ������ 1. null ���� Apple �귣�带 ���� ��ǰ�� �ְ� ��
			//4. ���� �귣��� ���� ���� �귣��� �޶� �ȵ��ٴ� �� �տ��� 1. �״�� null�� ����ְ� �ڿ� �ΰ��� Apple�� ��� ����
			if(p.getBrand().equals(brand))//false��� �� 4ĭ�� ���� ������� �ʴ´ٴ� ��, true��� ���� null ���� Apple ������ �ٲ�ٴ� ��
				products[idx++] = p;//���� for������ �ε����� ����. idx������ �� ���� for�� �տ��� �������ָ� ��
				//idx++�� �־���������� idx�� �ٽ� �ȿ� �־��൵ ��
				//���� for�������� �ڽ��� �˾Ƽ� ���� ������ i�� ���� ���ϴµ� idx������ �� ���� for�� �տ��� �������ָ� ��
		}
		return products;//�� Apple 2���� ���� ��
	}
}

