package threadTest;

public class Sync1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Msg m = new Msg();
		Sync1 thread1 = new Sync1(m);
		Sync1 thread2 = new Sync1(m);
		Sync1 thread3 = new Sync1(m);

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
