package operator.test;
//�ڹٿ��� ����ϴ� �⺻���� �����ڸ� �˾ƺ���
public class OperateTest1 {
	public static void main(String[] args) {
		Operator op1 = new Operator();//��ü ������ �ı��� �޸𸮿� �ö󰣴� --> ������ = ȣ��(����)
		Operator op2 = new Operator();
		
		op1 = op2; //�ּҰ��� ��������...op2��
		System.out.println(op1==op2);//true
		
		System.out.println(op1);
		System.out.println(op2);

		//short Circuit
		System.out.println(op1.test1() || op1.test2());//true + false (�ڴ� �ǳʶڴ�)
		System.out.println(op2.test2() && op1.test1());//false + true (�ڴ� �ǳʶڴ�)
		
		//���ú����� ����� ���ÿ� �ʱ�ȭ
		//i=����(varriable) 5=��(value) : ����Ǵ� ��ġ�� ���� ������ �ʵ�� ��������
		// = : �Ҵ�(assign) --> �������� ���� ������ ������ ���� �� �Ҵ�
		int i=5;
		int j=3;
		
		//i�� j�� ���� ������ true�� ���, �ƴϸ� false�� ���
		System.out.println(i==j);//false
		System.out.println(i!=j);//true
		// ! == not (true�� �ݴ�, false�� �ݴ�
		System.out.println("������ % :: "+i % j);//2
		// % : ��ⷯ�� --> ������ ���� ������

		boolean flag = false;
		System.out.println(flag);//false
		System.out.println(!flag);//true
		
		int k = 10;
		System.out.println(k++);//++�� �ڿ� ������ �������� 1�� ������Ų�� == �׷��� ���⼭�� 10���� ��µ� --> �� �������ο��� ����
		System.out.println(k);//11
		
		int m = 10;
		System.out.println(++m);//++�� �տ� ������ 1�� ���� ������Ų�� == �׷��� ���⼭�� 11���� ��µ�
		System.out.println(m);//11
	}

}
/*
 * �� �������� ������ Ŭ������ ���� �� ����
 * 1. �׷��� Ŭ���� 10������ �̸��� �ϳ��� �����ؾ��ϴµ�, �̶� mainMethod�� �̸����� ����Ǿ�� ��
// 2. ���ϸ�� ������ ���θ޼ҵ带 ������ Ŭ������  �տ��� public�� �ٿ��� ������ ���� ���� == �ٸ� Ŭ���� �̸� �տ��� public ���̸� �ȵ�
 */

class Operator{
	public boolean test1() {
		System.out.println("test1() calling...");
		return true;
	}
	public boolean test2() {
		System.out.println("test2() calling...");
		return false;
	}
}