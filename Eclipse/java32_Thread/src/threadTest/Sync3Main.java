package threadTest;

class Msg2 {//공유자원
	private String str = "default message";

	public void print() {
		System.out.println(str);
	}

	public void writeMsg(String str) {
		this.str = str;
	}
	
	public synchronized void job(String name, int i) {
		String msg = name + "message[" + i + "]";
		writeMsg(msg);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print();
	}
}
class Sync4 extends Thread {
	private Msg2 m;

	public Sync4(Msg2 m) {
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			m.job(getName(), i);
			
			try {
				sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class Sync3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Msg2 m = new Msg2();

		Sync4 thread1 = new Sync4(m);
		Sync4 thread2 = new Sync4(m);
		Sync4 thread3 = new Sync4(m);

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
