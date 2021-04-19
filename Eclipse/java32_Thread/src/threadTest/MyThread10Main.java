package threadTest;

public class MyThread10Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Msg m = new Msg();
		MyThread10 thread1 = new MyThread10(m);
		MyThread10 thread2 = new MyThread10(m);
		MyThread10 thread3 = new MyThread10(m);

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
