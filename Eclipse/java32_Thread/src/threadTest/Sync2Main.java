package threadTest;

public class Sync2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data = new Data();
		
		Sync2 s1 = new Sync2(data);
		Sync3 s2 = new Sync3(data);
		
		s1.start();
		s2.start();
	}

}
