package com.encore.encapsulation.test;
import java.util.Scanner;

/* 
 * 1. Scanner 를 이용해서 month, day에 해당하는 값을 받는다.
 * 2. month에 해당하는 값은 1~12사이의 값만 받고 나머지는 에러 메세지를 출력 -> "이에 해당하는 월이 아닙니다."
 *    day는 
 *    1,3,5,7,8,10,12월은 1~31일
 *    4,6,9,11월은 1~30일
 *    2월은 1~28일까지의 값을 갖도록
 *    --> If, switch문을 둘 다 사용하세요
 * 3. "해당하는 월이 아닙니다."
 *    "해당하는 날짜가 아닙니다."
 *    --> 둘다 True일때만 출력
 *    "오늘은 1월 4일입니다."
 *    "오늘은 0월 4일입니다." --> X
 *    "오늘은 4월 0일입니다." --> X
 */
import com.encore.encapsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//키보드로 값을 받아들이겠다 (이건 Test 메인에만 쓰기)
		MyDate md = new MyDate();
		System.out.println("월입력>>");
		int month = sc.nextInt();//입력값을 month로 받는다
		System.out.println("날짜입력>>");
		int day = sc.nextInt();
		//md.setMonth(13);
		//md.setDay(33);
		//이 코드의 문제점? --> 하드코딩
		//Invalid한 값이 바로 필드에 주입된다. --> Direct Access = 잘못된 값이 주입되어도 막을 게 없음
		/*md.month = 13; =  13월 없음 --> public이 아니기 때문에 오류가 뜸, private이기 때문에 마음대로 접근 못함(있는데 안보이는 것)
		md.day = 33;  =  33일은 없음 */		
		
		// 값의 주입은 setter()로 한다.
		md.setMonth(month);//MyDate클래스에 있는 setMonth로 이동한다 (calling...인자값이 passing into)
		md.setDay(day);//setDay메소드 calling호출...인자값이 passing into
		
        //if(md.getMonth()!=0 && md.getDay()!=0)//0을 만나면 안돌아가게 입력
		System.out.println("오늘은 "+md.getMonth()+"월 "+md.getDay()+"일 입니다.");//0월 5일
	}
}
//코드를 스르륵 보면 끝까지 스르륵 보게 됨 --> 남는 게 없다
//코드를 92% 해결하라 그러면 2명이 