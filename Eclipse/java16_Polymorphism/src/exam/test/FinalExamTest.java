package exam.test;
/*
 * final Ű���忡 ���ؼ� �˾ƺ���
 * final "���� ������ ~~�̾�"��� ���� Ű����
 * 
 * final ���� - "���� ������ ������" --> �������̴ϱ� ��ġ�� �ȵȴ� - ��� ����
 * final �޼ҵ� - "���� ������ �޼ҵ��" --> �ڽĵ�� ��ġ���� - �������̵� ����
 * final Ŭ���� - "���� ������ Ŭ������" --> ���� ������ Ŭ�����ϱ� �ڽ� �ȵѰž� - ��ӱ���
 */

//1. final ����
class A{
	//��� final ����
	final static int BASE_SALARY = 800;//�� ������ �ȵǴ��� Ȯ��
	//�޼ҵ� final ����
	public final String test() {
		return "Overriding ����";//�������̵� �ȵǴ��� Ȯ��
	}
}
//Ŭ���� final ����
final class B{ //����� ����
}

//2. ���� Ȯ��

//���, �޼ҵ� �������̵� x
class D extends A{
//	BASE_SALARY = 1000;//����� ���� ����!
//	public final String test() {//�������̵� �ƿ� �ȵǴϱ� ������
	
}

//Ŭ���� x
//class C extends B{//�� �� ��� ���޴´� ���� �������̷�
//}

public class FinalExamTest {
	public static void main(String[] args) {
		//��� ���浵 x
		D d = new D();
		//D.BASE_SALARY = 1000;//���Ӱ� �Ҵ��� �� ����
		System.out.println("�⺻�� : "+d.BASE_SALARY);


	}

}
