package exam.test;
//Static�� ������ ������ ��ü���� ��� �����Ѵ�

class Car{
	int serialNumber;
	static int counter;
	
	Car(){
		counter++;
		serialNumber = counter;//�ø��� �ѹ��� ī���� �Ȱ��� ����
	}
}

public class StaticTest2 {
	public static void main(String[] args) {
		Car car1 = new Car();//car1 == ���� ����
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("====field====");
		System.out.println(car1.serialNumber);//1
		System.out.println(car2.serialNumber);//2
		System.out.println(car3.serialNumber);//3
		
		System.out.println("====static V====");
		System.out.println(car1.counter);//3
		System.out.println(car2.counter);//3
		System.out.println(car3.counter);//3
		System.out.println(Car.counter);//3 --> �ַ� �̷� ������ ��
		
		System.out.println("���ݱ��� ����� �� ������ ���ڴ�"+Car.counter+"�� �Դϴ�.");
		
	}
}
