 package array.reference.service;

import array.reference.vo.Customer;
import array.reference.vo.Product;

/*
 * OuletStore���� ��ǰ�� �����ϴ� ���� ����� ��Ƴ��� ���� Ŭ����
 * �� Ŭ������ ���Ŀ� DAO Ŭ������ �𺧷� �� ���̴�.
 * 
 */
public class OutletStoreService {
	
	//�� 5���� ��� ����
	//1. Ư������ ������ ��ǰ��
	public String[ ] getAllBrand(Customer vo) {//Coustomer�� �˾ƾ� ������ ��ǰ�� ��ȯ ����
		Product[ ] pros = vo.getProducts();
		String[ ] temp = new String[pros.length];//temp ��þ��� ���� ���� ��
		
		int idx = 0;
		for(Product p : pros) temp[idx++] = p.getBrand();
		
		return temp;
	}
		
/*		if(vo.getProducts()!=null) {
			String[] brand = new String[vo.getProducts().length];
			int i = 0;
			for(Product p : vo.getProducts()) {
				brand[i++] = p.getBrand();
			}
			return brand;
		}
		return null;
		
	} */
	
	//2. �ƿ﷿ ��ü �� ���
	public Customer[ ] getAllCustomer(Customer[] custs) {
		Customer[ ] cs = new Customer[custs.length];
		int idx = 0;
		for(Customer c : custs) cs[idx++] = c;
		return cs;
	}//������ �������� Test���� ���� ��
	
	//3. Ư�� �� ��� ����
	public Customer getACustomer(Customer[] custs, int ssn) {//���� �� �߿� ssn���� ã�ڴ�
		Customer cust = null;
		for(Customer c : custs) {
			if(c.getSsn()==ssn) //int Ÿ���̱� ������ == ��� ����
				cust = c;
			}
			return cust;
		}

	//4.
	public int maxPriceProduct(Customer vo) {//���ڰ��� Customer�� �� Ư�� ���� �ְ��� �ϰڴ�
		int max = 0;
		Product[ ] pros=vo.getProducts();
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;

	}

	//5.
	public int getAvgPrice(Customer vo) {
		int total = 0;
		Product[] pros = vo.getProducts();
		for(Product p : pros) 
			total += p.getPrice();

			
		return total/pros.length;	
		
	}
	
	public Product[ ] getMoreAvgProduct(Customer vo) {
		Product[ ] pros=vo.getProducts();
		Product[ ] temp = new Product[pros.length];
		int idx = 0;
		for(Product p: pros) {
			if(p.getPrice()>=getAvgPrice(vo))
				temp[idx++] = p;
		}
		return temp;
	}
	
	//�߰������� �ʿ��� ����� �Բ� �����ϼ���
}
