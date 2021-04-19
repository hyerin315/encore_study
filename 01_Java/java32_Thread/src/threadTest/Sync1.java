package threadTest;

public class Sync1 extends Thread {
	private Msg m;

	public Sync1(Msg m) {
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			processMsg(i);
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void processMsg(int i) {
		synchronized (m) {//synchronized 블록. 괄호 안에 동기화 처리 할 공유자원을 할당. 
						  //이 블록이 다 실행될 떄까지 이 자원을 다른 쓰레드가 사용할 수 없도록 잠금
			try {
				m.writeMsg(getName() + "message[" + i + "]");
				sleep(1);
				m.print();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

