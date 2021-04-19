package exam.test;
//Static한 변수는 생성된 객체들이 모두 공유한다

class Car{
	int serialNumber;
	static int counter;
	
	Car(){
		counter++;
		serialNumber = counter;//시리얼 넘버와 카운터 똑같게 만듦
	}
}

public class StaticTest2 {
	public static void main(String[] args) {
		Car car1 = new Car();//car1 == 참조 변수
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
		System.out.println(Car.counter);//3 --> 주로 이런 식으로 씀
		
		System.out.println("지금까지 생산된 총 차량의 숫자는"+Car.counter+"대 입니다.");
		
	}
}
