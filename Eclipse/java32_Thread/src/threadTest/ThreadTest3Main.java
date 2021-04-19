package threadTest;
class ThreadTest3 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 27; i++) {
			System.out.println("thread1: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
class ThreadTest4 implements Runnable{
	@Override
	public void run() {
		for (char i = 'a'; i <= 'z'; i++) {
			System.out.println("thread2: " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
public class ThreadTest3Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest3 r3 = new ThreadTest3();
		Thread th3 = new Thread(r3);
		th3.start();
		
		ThreadTest4 r4 = new ThreadTest4();
		Thread th4 = new Thread(r4);
		th4.start();

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
