package condition.test;

import java.util.Scanner;

public class SwitchGradeTest3 {

	public static void main(String[] args) {
		//로컬변수(local Vㅁriable) 메소드 안에 선언된 변수 = 기본값이 없다 = 값을 할당해야함
		//로컬변수는 메소드 밖에서 사용할 수 없다 (사용하면 에러)
		Scanner sc = new Scanner(System.in); //스캐너 타입의 변수 - 객체를 생성하게 되면 메모리에 식구가 올라감 = 식구가 올라간 위치가 할당됨
		//변수 밑에 노란줄은 warnig 표시
		
		System.out.println("당신의 이름을 입력하세요");
		String name=sc.nextLine(); //키보드에 입력한 값을 할당 받아야함 (이름) --> name이라는 변수
		
		System.out.println("당신의 등급을 입력하세요");
		String grade=sc.nextLine();//등급
		
		switch(grade) { //뭐에 따라서 제어할 건지 변수를 넣어주면 됨
		    case "A" :
		    	System.out.println(name+"님, 당신의 성적은 90~100점입니다.");
		    	break; //요것을 벗어나는 것을 brake
			case "B" :
			    System.out.println(name+"님, 당신의 성적은 80~89점입니다.");
			    break; //요것을 벗어나는 것을 brake
			case "C" :
			    System.out.println(name+"님, 당신의 성적은 70~79점입니다.");
			    break; //요것을 벗어나는 것을 brake
			default: //else와 같은 구실
				System.out.println(name+"님, Try Again!");
				break;
		}
	}

}
