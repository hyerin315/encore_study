package com.encore.encapsulation;
/*
 * Encapsulation 작성하는 패턴
 * 1. Field - private 지정
 * 2. setter() / getter() - public 지정
 * 3. setter() 메소드 구현부 첫라인에서(필드 초기화 하기 직전에) 제어문을 달아서 타당한 값만 할당 되도록 한다.
 */
public class MyDate {
	private int month;//13
	private int day;//33
	
	public int getMonth() {
		return month;
	}
	//값을 주입하는 기능...
	//void 가지고 나오는 값이 필요 없음 set 무슨 값을 주입하느냐가 뒤에 나옴
	//void setMonth(인자값)
	public void setMonth(int month) {//키보드로 입력한 값이 들어감 --> setMonth가 하는 일은 아래 구현부만 보면됨 (setMonth는 값을 찔러주니까
		//필드초기화 하기 직전에 인작밧으로 반은 값이 타당한지 여부를 검사하고 타당한 값만 필드에 할당
		if(month>=1 && month<=12) {//setMonth가 하는 일은 Test에서 받은 값이 1~12사이의 값이면 필드 초기화를 해주고
			this.month = month;//제어문으로 검증을 하고 month에 해당하는 맞는 값을 검열
		} else {//1~12에 해당하는 값이 아닐때는 아래 텍스트를 출력 --> 필드 초기화가 안됨을 의미 --> 기본값이 들어감을 의미 == 0이 할당되어 있다는 이야기
			System.out.println("월에 합당한 값이 아니다! (Invalid Month Value!!");//여기까지 가면 테스트로 돌아감
		}		
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {//void여야 하는 이유, String이 안되는 이유는 값이 주입되는 게 메인이기 때문에 void가 맞음
		switch(month) {//여기서의 month는 필드의 month를 가져오는 것 --> setMonth()를 통한 초기화가 이미 되어져 있는 상태 (로컬과 필드 이름이 동일할때 구분을 위해 this를 쓴다)
		//month에 기본값인 0이 들어오면 default를 만나게 됨
		case 2://month가 2월달인 경우
			if(day>=1 && day<=28) {
				this.day = day;
			}else {
				System.out.println("Invaild Day!");//이거 때문에 String을 쓰는 건 아님, 메인 값이 무엇인지 알아야함
				//return; 리턴하게 되면 원래 호출한 지점으로 리턴! -->다시 setDay로 가게 됨 --> 하지만 해결은 안됨
				//진보적인 해결 방법 --> 잘못된 값이 들어왔을 때 프로그램을 끝내버리는 것
				System.exit(0);//0이면 정상종료...-1(음수) 비정상 종료
			}
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			if(day>=1 && day<=30) {
				this.day = day;
			}else {
				System.out.println("Invaild Day!");
				//return;
				System.exit(0);
		
			}
		break;
		
		default:
			if(day>=1 && day<=31) {
				this.day = day;
			}else {
				System.out.println("Invaild Day!");
				//return
				System.exit(0);
			}
		}//switch	
	}//setDay
}//class
