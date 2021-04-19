package threadTest;

public class MyThread10 extends Thread {
	private Msg m;

	public MyThread10(Msg m) {
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < 10; i++) {
				m.writeMsg(getName() + "message[" + i + "]");
				sleep(i);
				m.print();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Msg {//공유자원
	private String str = "default message";

	public void print() {
		System.out.println(str);
	}

	public void writeMsg(String str) {
		this.str = str;
	}
}