package threadTest;

public class Sync2 extends Thread {
	private Data data;

	public Sync2(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			data.add(1);
		}
	}

}

class Sync3 extends Thread {
	private Data data;

	public Sync3(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			data.sub(1);
		}
	}

}
