package exam.test;
/*
 * �̱���
 * ::
 * �ϳ��� Ŭ�����κ��� ���� �� �ϳ��� ��ü�� �����ǵ��� �ۼ��ϴ� �ڵ�
 * ::
 * �ۼ����
 * 1. Ŭ���� �ȿ��� �ϴ� �ϳ��� ��ü�� ������ ���´� --> private static���� �����ؼ� ������
 * 2. �ٸ� Ŭ���������� ��ü������ ���ϵ��� ���Ƴ��´� --> private ������() 
 *    --> ��ü ������ �������� �Ѵ� == �� Ŭ���� ����� ��ü ���� ���Ѵ�
 * 3. �ϳ� �������� ��ü�� �������⼭ ������ ������ pubilc�� ����� ����� -- public ?
 */

class Service{
	private static Service service = new Service();
	private Service() {
		System.out.println("Server Instance Creating...Using SingleTone...");
	}
	public static Service getInstance() {//3. --> �̰� ��ü�� ���� Ÿ���� �Ǵ� ��
		return service;
	}
}

public class StaticSingleToneTest3 {
	public static void main(String[] args) {
  		//Service s1 = new Service(); �ٸ� Ŭ�������� ���� ����
		// ����� ���� ���� �޾Ƽ� ����ϴ� ����ۿ��� ���� --> ������ ����Ϸ��� �޸𸮿� �÷����� --> �װ� ������ ����
		//�׷��� �̱��� Ŭ���� ����Ÿ�Ը��� �� public static���� ����� �̸� �޸𸮿� �÷�������
		
		Service service1 = Service.getInstance();//��ü ���� ���� ������ �������� �� ģ������ ������ �� ����
		Service service2 = Service.getInstance();
		Service service3 = Service.getInstance();
		
		System.out.println(service1);//�̱� ������ ��� ���� �� ��ȯ
		System.out.println(service2);
		System.out.println(service3);
	}
}
