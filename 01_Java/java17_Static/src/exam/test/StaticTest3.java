package exam.test;
//Static �� �ȿ��� this ��� ���� (��ü ������ ������ ���� ������ ����)
//Static Initialization Block (���� ���� ���)
public class StaticTest3 {
	static int size = 111;//�ʵ� 
	
	public static void main(String[] args) {//JVM
		System.out.println("1. main method static block..."+size);//�ʵ�� �޸𸮿� �ø��� ����� (static ���� ����)
		
	}

	static {//Static Initialization Block
		size = 333;
		System.out.println("2. Static Initialization Block"+size);//�갡 ���� ��µ�
	}
}