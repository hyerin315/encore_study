package exam.test;
//Static�� ����� ��ü���� �������� ����� �� �ִ�
//== Static�� ����� Ŭ�������� �δ� �������� �̹� �޸𸮰� �ö� �ִ�
//== Ŭ������.static�� ���

//��� Ŭ����
class Member{
	static String name = "������";//static V, class V, �������� (�� �� �ϳ��� �̸����� �θ�)
	static int age = 22;
	int count = 1;//filed, �������
	
	public static void getMember1() {//Static Method
		System.out.println("��/��/��/��/"+name);
	}
	
	public void getMember2() {//Non-Static Method
		System.out.println("��/��/��/��/");//error --> static���� �ȿö� �־ ����
	}
}

//��� �׽�Ʈ Ŭ����
public class StaticTest1 {
	public static void main(String[] args) {
		//Static�̱� ������ ��ü ���� ���� �ٷ� �ö󰡴ϱ� �̷��� �ص� �ٷ� ��� ����
		Member.getMember1();
		
		//Non-Static�̱� ������ ��ü �������� �޸𸮿� ���� �÷����� ����Ѵ�
		Member m = new Member();//��ü������ ���ÿ� �� ��������� ������ == �޸𸮿� �ö󰡱� ������
		m.getMember2();//���⼭ getMember2�� ����� �� ����

	}

}
