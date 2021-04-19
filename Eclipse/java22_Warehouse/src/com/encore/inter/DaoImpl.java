package com.encore.inter;
import com.encore.vo.Product;

//�迭�� �߰�, ����, ����...�۾� ���� 
//--> ���߿� �����ϱ� ���϶�� �������̽� ����

public class DaoImpl implements Dao {
	
	private Product[] datas;//�����
	private int cnt;//�迭�� ����� ������ ����
	
	public DaoImpl() {
		datas = new Product[30];
		//�迭�� ���� : ������ ũ�� ����, ũ�� ����, �迭�� ũ��� ����� �������� ������ �ٸ�
		//data.length : ���� ������ ��Ÿ���� �������� ������ ��Ÿ���� �ʴ´�, ������ �߰� ������ �������� ������ ���� ����
	}

	@Override
	public void insert(Product p) {
		if(cnt>=datas.length - 1) {
			System.out.println("�迭 â. ��� ���");
			return;
		}
		datas[cnt] = p;
		cnt++;
	}
	//������ : 
	@Override
	public Product selectByNum(int num) {
		Product temp = new Product();
		for(Product p : datas) {
			if(p.getNum() == num) {
				temp = p;
			System.out.println(p.toString());
			}else
				break;
		}
		return temp;
	}
	
	//������ :
	@Override
	public Product[] selectByName(String name) {
		Product[]temp = new Product[cnt];
		for(Product p: datas) {
			if(p.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}
	
	//�¿��� : 
	@Override
	public Product[] selectAll() {
		Product[] all = new Product[datas.length];
		int idx = 0;
		for(Product p: datas) all[idx++]=p;
		return all;
	}
	
	//�¿��� : ���ݼ���
	@Override
	public void update(int num, int price) {
		Product product = null;
		for (Product p : datas) {
			if(p.getNum()==num) p.setPrice(price);
		}
	}

	//������ : ���� 
	@Override
	public void delete(int num) {
		int lastIndex=cnt-1;
		for(int i=0; i<=lastIndex; i++) {
			if(i+1==num) {
				for (int j=i+1; j<=lastIndex;j++) {
					datas[j]=datas[j+1];
				}
				datas[lastIndex]=null;
				cnt--;
			}
		}
	}

	//����
	@Override
	public void in_out(int num, int a) {
		int new_amount=0;
		int lastIndex=cnt-1;
		for(int i=0; i<=lastIndex; i++) {
			if(i+1==num) {
				new_amount=datas[i].getAmount()+a;
				if(new_amount<0) {
					datas[i].setAmount(0);
					continue;
				}
				datas[i].setAmount(new_amount);
				}
			}
		}
}