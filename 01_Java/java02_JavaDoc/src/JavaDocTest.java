/*
 * 1. Java Documentation comment 사용법
 * 2. 리턴타입이 이는 메소드를 호출
 */
public class JavaDocTest {
	
	public static void name(String[] args) {
		//JavaDoc의 scoreSum()기능을 호출...
		JavaDoc doc = new JavaDoc();
		System.out.println("Total Sum : "+doc.scoreSum(90, 70)+" 점");//호출...
		
	}

}
