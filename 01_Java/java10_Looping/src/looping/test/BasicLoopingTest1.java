package looping.test;
/*
 * for : 몇번 돌지 알때
 * while : 몇번 돌지 모를때
 */
public class BasicLoopingTest1 {

	public static void main(String[] args) {//1.모든 프로그램은 메인부터 시작
		System.out.println("======= for =======");//2.프린트 실행 
		for(int i=0; i<10; i++) { //초기식, 조건식, 증감식 
		//1. 초기식 : 로컬변수 -> 0으로 초기화가 됨, 
        //2.조건식 : 연산 수행한 결과가 true일때만 코드 블럭을 실행 (0이 10보다 작기 때문에 코드블럭 실행)
		//3. i 값은 1이 증가 (코드블럭에서 올아오면서 i는 1이 증가)
		//--> 4.2번과 3번을 반복   
		//5.2번에서 i가 10보다 크면 false가 뜨면 반복을 끝내고 빠져나오게 됨 
			System.out.println(i+".Hello....for Looping Test");//2.0이 10보다 작기 때문에 코드블럭 실행
		}
		
		System.out.println("======= for =======");
		for(int i=0, j=0; i<10 && j<10; i++, j++) {//여러개 쓸때 데이터 타입은 같아야함
			System.out.println(i+","+j+".Hello....for Looping Test");//해결 필요
		}
		
		
		//for문을 while로 바꿔보는 식
		System.out.println("\n======= whlie =======");//2.프린트 실행 (역슬러시 n : 한줄 띈다)
		int i=0;//1.초기화 (i라는 변수에 0이라는 값이 들어가 있음) 
		while(i<10) {//2.true면 코드블럭 실행
			System.out.println(i+".Hello....for Looping Test");
			i++;//3.1이 증가하는데 증가할 때는, 위에 올라가서 2번을 탈때 값이 증가 됨
			//4.2번과 3번을 반복 
			//5.올라가서 10이 되면 조건을 만족하지  못해 flase가 되면서 while을 빠져나오게 됨
		}
		
		System.out.println("\n======= do~whlie =======");
		int j=0;//i가 위에 있어서 같으면 오류발생하기 때문에 다른 걸로 씀
		do {
			//이 부분은 한 번 반드시 수행된다.(while문과의 차이점)
			System.out.println(j+"...Always Prints");//한 번은 수행되고 아래의 조건을 탄다
			j++;//증감식이 여기서 들어감
		}while(j<10);
	}
}
