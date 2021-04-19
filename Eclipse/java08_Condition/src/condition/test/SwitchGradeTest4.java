package condition.test;

import java.util.Scanner;

public class SwitchGradeTest4 {

	public static void main(String[] args) {//1. Start <-- JVM
		Scanner sc = new Scanner(System.in);//2. 객체를 생성하게 되면 메모리에 식구가 올라감 = 식구가 올라간 위치가 할당됨
		System.out.println("당신의 이름을 입력하세요");
		String name=sc.nextLine();//입력한 값을 받아서 String으로 반환
		
		System.out.println("당신의 등급을 입력하세요");
		String grade=sc.nextLine();//입력한 값을 받아서 String으로 반환
		
		
		//추가...선언된 위치가 메소드 안에 있기 때문에, 로컬변수
		String message="";//초기화 (입력할 값이 없어도 값을 줘야함)
		switch(grade) {
		    case "A" :
		    	message = name+"님, 당신의 성적은 90~100점입니다.";
		    	break;//break를 만나면 해당하는 case문 빠져나온다--> switch를 빠져나옴 
		    	// == switch에 입력된 값에 맞는 케이스를 만나고 이후 브레이크를 통해 스위치를 빠져나와 --> System.out.println(message);를 만나게 됨
		    	// == 케이스 하나만 만나는 것 
			case "B" :
				message = name+"님, 당신의 성적은 80~89점입니다.";
			    break; 
			case "C" :
				message = name+"님, 당신의 성적은 70~79점입니다.";
			    break;
			default:
				message = name+"님, Try Again!";
				break;//모두 브레이크가 없으면 케이스 여러개를 만난뒤 default값으로 출력
		}
		System.out.println(message);
	}

}
