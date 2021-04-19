package threadTest;

public class Data {
	private int num = 0;

	public synchronized void add(int x) {
		num += x;
		System.out.println("add에서 값 증가 실행, num=" + num);	
		if (num == 40) {
			notifyAll();//wait에 의해 대기 상태로 들어간 모든 쓰레드를 깨워줌
			try {
				System.out.println("증가 쓰레드 wait");
				wait();//스스로 wait상태 들어감
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void sub(int x) {
		num -= x;
		System.out.println("sub에서 감소 실행, num=" + num);
		if (num < 20) {
			notifyAll();
			try {
				System.out.println("sub감소 쓰레드 wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
