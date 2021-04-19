package threadTest;

class ThreadTest1 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 27; i++) {
			System.out.println("thread1: " + i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadTest2 extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (char i = 'a'; i <= 'z'; i++) {
			System.out.println("thread2: " + i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest1 th1 = new ThreadTest1();
		th1.start();//쓰레드 ready로 보냄
		ThreadTest2 th2 = new ThreadTest2();
		th2.start();

		for (char i = 'A'; i <= 'Z'; i++) {
			System.out.println("main: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

