package operator.test;
//자바에서 사용하는 기본적인 연산자를 알아보자
public class OperateTest1 {
	public static void main(String[] args) {
		Operator op1 = new Operator();//객체 생성은 식구가 메모리에 올라간다 --> 쓰려고 = 호출(접근)
		Operator op2 = new Operator();
		
		op1 = op2; //주소값이 같아진다...op2로
		System.out.println(op1==op2);//true
		
		System.out.println(op1);
		System.out.println(op2);

		//short Circuit
		System.out.println(op1.test1() || op1.test2());//true + false (뒤는 건너뛴다)
		System.out.println(op2.test2() && op1.test1());//false + true (뒤는 건너뛴다)
		
		//로컬변수를 선언과 동시에 초기화
		//i=변수(varriable) 5=값(value) : 선언되는 위치에 따라 변수와 필드는 나뉘어짐
		// = : 할당(assign) --> 오른쪽의 값이 왼쪽의 변수에 들어가는 게 할당
		int i=5;
		int j=3;
		
		//i와 j의 값이 같으면 true로 출력, 아니면 false로 출력
		System.out.println(i==j);//false
		System.out.println(i!=j);//true
		// ! == not (true의 반대, false의 반대
		System.out.println("연산자 % :: "+i % j);//2
		// % : 모듈러스 --> 나눴을 때의 나머지

		boolean flag = false;
		System.out.println(flag);//false
		System.out.println(!flag);//true
		
		int k = 10;
		System.out.println(k++);//++이 뒤에 있으면 다음번에 1을 증가시킨다 == 그래서 여기서는 10으로 출력됨 --> 그 다음라인에서 증가
		System.out.println(k);//11
		
		int m = 10;
		System.out.println(++m);//++이 앞에 있으면 1을 먼저 증가시킨다 == 그래서 여기서는 11으로 출력됨
		System.out.println(m);//11
	}

}
/*
 * 한 페이지에 여러개 클래스를 만들 수 있음
 * 1. 그런데 클래스 10개지만 이름은 하나로 저장해야하는데, 이때 mainMethod의 이름으로 저장되어야 함
// 2. 파일명과 동일한 메인메소드를 가지는 클래스는  앞에만 public을 붙여야 에러가 나지 않음 == 다른 클래스 이름 앞에는 public 붙이면 안됨
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