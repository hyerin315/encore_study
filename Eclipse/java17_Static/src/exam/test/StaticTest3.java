package exam.test;
//Static 블럭 안에서 this 사용 못함 (객체 생성과 관련이 없기 때문에 못씀)
//Static Initialization Block (가장 먼저 출력)
public class StaticTest3 {
	static int size = 111;//필드 
	
	public static void main(String[] args) {//JVM
		System.out.println("1. main method static block..."+size);//필드는 메모리에 올리고 써야함 (static 쓰면 가능)
		
	}

	static {//Static Initialization Block
		size = 333;
		System.out.println("2. Static Initialization Block"+size);//얘가 먼저 출력됨
	}
}