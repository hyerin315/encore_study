package array.primitive.test;

class ArrayExam{//비교를 위해 만든 클래스
	String type="배열";
	public String type() {
		return "배열";
	}
}
public class BasicArrayTest1 {
	public static void main(String[] args) {
		//1. int타입의 배열을 생성...3칸짜리
		int[] arr = new int[3];
		System.out.println("배열의 주소값 출력 : "+arr);
		
		ArrayExam exam = new ArrayExam();
		System.out.println("ArrayExam의 주소값 출력 : "+exam);
		
		//2. 배열안에 있는 기본값 출력
		for(int i=0; i<arr.length; i++) //사이즈를 리턴하는 배열의 필드 --> length
			System.out.println(arr[i]+"  ");//+"  "을 하면 옆으로 뜸, 값은 0
		//스테이트먼트가 하나일때는 {} 이거 안써도 됨
		
		//3. 초기화
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]+"  ");//11,22,33
	}
}
/*
 * 배열의 주소값 출력 : [I@7852e922 
 * ArrayExam의 주소값 출력 : array.primitive.test.ArrayExam@4e25154f
 * --> 주소값 출력 형태가 다름 (객체라는 건 같은데 배열은 클래스가 뜨지 않음)
 *     = "배열은 클래스가 존재하지 않는 객체이다." = 멤버를 api를 통해서 확인할 수 없다 --> 특이한 지점
 */
