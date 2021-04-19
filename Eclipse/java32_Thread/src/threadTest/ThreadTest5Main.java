package threadTest;
class ThreadTest5 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(getName()+" 시작:");
		System.out.println(getName()+" 우선순위:"+this.getPriority());

		for(int i=0; i<100;i++) {
			System.out.println(getName()+": "+i);
			try {
				sleep(100);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println(getName()+" 종료");

	}
	
}
public class ThreadTest5Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Thread.MIN_PRIORITY==1
//		Thread.NORM_PRIORITY==5
//		Thread.MAX_PRIORITY==10
		for(int i = 1; i<=10; i++) {
			ThreadTest5 th = new ThreadTest5();
			th.setPriority(i);
			th.start();
		}
	}

}
