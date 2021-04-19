package warehouse;

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
	
	//1.��ǰ���
	@Override
	public void insert(Product p) {
		if(cnt>=datas.length - 1) {
			System.out.println("�迭 â. ��� ���");
			return;
		}
		datas[cnt] = p;
		cnt++;
	}
	
	//2.��ȣ �˻�
	@Override
	public Product selectByNum(int num) {
		for(int i = 0; i < cnt; i++) {
			if(datas[i].getNum() == num) {
				return datas[i];
			}
		} 
		return null;//not found
	}
	
	//3.�̸����� �˻�
	@Override
	public Product[] selectByName(String name) {
		Product[] temp = new Product[cnt];//�̸��� ������ ��ǰ�� ���� �迭 (������ �𸣱� ������ �ִ� ������ cnt������ŭ ����
		Product[] temp2 = null;//���� ��ȯ�� �迭 - ���⼭�� ����
		int c = 0;//�̸��� ������ ���� ���� ��Ÿ���� ����
		
		for(int i = 0; i < cnt; i++) {
			if(datas[i].getName().equals(name)) {
				temp[c++] = datas[i];//�Ȱ��� ��ǰ�� ã���������� temp�� ����
			}
		}
		if(c != 0) {
			temp2 = new Product[c];//�ϳ��� ã�����ٸ� �迭�� ����
			System.arraycopy(temp, 0, temp2, 0, c);
		}
		temp = null;//G.C���� ������ �ֱ����� null�� �־���(���� �ʴ� ���� �� ��ȯ) --> �޸� ������ ����(�޸𸮸� ȿ�������� ����ϱ� ����)
		return temp2;
	}
	
	//4.���ݼ��� 
	@Override
	public void update(int num, int price) {
		Product p = selectByNum(num);//��ȣ�� ã�Ƽ� ��ü�� �Ҵ�
		if(p != null) {
			p.setPrice(price);
		}else {
			System.out.println("���� ��ǰ��ȣ�Դϴ�");
		}
	}

	//5.��ǰ����
	@Override
	public void delete(int num) {
		Product p = selectByNum(num);//��ȣ�� ã�Ƽ� ��ü�� �Ҵ�
		int i = 0;
		if(p != null) {
			for(i = 0; i < cnt; i++) {
				if(datas[i] == p) {
					break;
				}
			}
			for(int j = i; j < cnt-1; j++) {//������ ��ġ�� "i"
				datas[j] = datas[j+1];
			}
			cnt--;
		}else {
			System.out.println("���� ��ǰ��ȣ�Դϴ�");
		}
	}
	
	//6.��ü��ǰ ��� 
	@Override
	public Product[] selectAll() {
		Product[] temp = new Product[cnt];
		System.arraycopy(datas, 0, temp, 0, cnt);
		return temp;
	}

	//7.�԰� & 8.���
	@Override
	public boolean in_out(int num, int a) {//a:����, �԰�:���, ���:����
		boolean flag = false;
		Product p = selectByNum(num);//��ȣ�� ã�Ƽ� ��ü�� �Ҵ�
		if(p != null) {
			int sum = p.getAmount() + a;
			if(sum < 0) {//���� ��ǰ ������ ������ ��Ȳ
				System.out.println("��ǰ ������ �����Ͽ� ����� �� �����ϴ�.");
			} else
				p.setAmount(sum);//����� ó�� �Ϸ�
			    flag = true;
		}else {
			System.out.println("���� ��ǰ��ȣ�Դϴ�");
		}
		return flag;
	}
}