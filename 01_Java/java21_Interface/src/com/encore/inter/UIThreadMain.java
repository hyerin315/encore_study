package com.encore.inter;
import java.awt.Frame;
//자바의 상속 - 단일 상속, 다중 상속 불가 - 인터페이스에서는 가능

//Frame이면서 쓰레드임 -- Frame을 상속받으면서 쓰레드(Runnable) 상속도 받음
//Runnable : Thread 대용 인터페이스, 쓰레드를 만들기 위해 상속받는 인터페이스 
//           (다중 상속에서 사용, 단일 상속이라면 extends Thread 사용)

//채팅  - 다른 사람 메세지 서버로부터 받아서 화면에 출력
//    - 내가 입력한 메세지를 서버로 전송
//    --> 동시에 2가지 일이 벌어지고 있음 == 동시에 2가지 일을 수행해야함

class Test extends Frame implements Runnable{//쓰레드는 동시성 프로그램을 짤 때 쓰는 것
//implements 다음을 인터페이스라 함 --> 인터페이스를 상속받는 키워드는 implements == 다중상속 가능
//extends 다음은 클래스 이름

	@Override
	public void run() {
        for (int i=0; i<10; i++) {
        	this.setTitle("쓰레드 출력: "+i);
        	try {
        		Thread.sleep(1000);
        	} catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        }
	}
}

public class UIThreadMain {
	public static void main(String[] args) {
		Test t = new Test();
		t.setSize(500, 200);//Frame 창의 가로, 세로 크기 지정
		t.setVisible(true);//화면에 보일꺼냐?
		Thread th = new Thread(t);
		th.start();
	}
}
