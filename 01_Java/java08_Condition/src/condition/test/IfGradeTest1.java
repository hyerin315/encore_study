package condition.test;
/*
 * 제어문이란?
 * 주어진 조건이 참일때만 해당 코드블락을 실행하는 문장
 * 조건을 주어서 문장의 흐름을 제어함으로써 좀 더 정교한 프로그램을 할 수 있도록 해준다
 * ::
 * <<Syntax
 * if(boolean_expression 조건식){
 *    //code block;//브레이스 안에 코드블락 스테이트먼트(System~ 이 부분)가 한 줄일때는 생략 가능
 * } else if(boolean_expression2 조건식){
 *    //code block;
 * } else{
 *    //code block;
 *    }//<--브레이스
 *    
 * 논리연산자 종류
 * 1. &(and)
 *    &&  -- Short Circuit (false일때 수행 안함)
 *    --> 결과는 괕은데 왜 이거를 쓰느냐 : &일때는 앞에도 하고 뒤에도 연산하지만, &&일때는 앞부분이 false면 뒤는 연산을 수행하지 않고 빠르게 false를 연산
 * 2. |(or)
 *    || (true일때 수행 안함)
 *    --> ||일때는 앞의 연산 수행 결과가 true면 뒤에 false가 나오건 true가 나오건 건너뛰고 빠르게 true를 도출 
 * --> 두개를 써서 우리가 얻는 이득은?
 *     뒷부분 연산을 건너뜀으로서 뒷부분에서 에러가 날 경우(발생할 수 있는 예외의 경우)를 건너뜀 --> 원하는 결과를 return하면서 오류를 건너뛰게 함
 *     (책에서 말하는 이점 : 속도가 빨라진다)
 */
public class IfGradeTest1 {
	
	public static void main(String[] args)  {
		int grade = 87; //오른쪽의 값이 왼쪽의 값에 할당된다는 의미
		
		if (grade>=90 && grade<=100) //87점이기 때문에 False여서 수행 안할 것
			System.out.println("A Grade...");//true
		else if(grade>=80 && grade<90)
			System.out.println("B Grade...");//false
	    else if(grade>=70 && grade<80)//&은 한 개나 &&이나 결과는 똑같음 --> 근데 2개 쓰는 이유 : &&일때는 앞부분이 false면 뒤는 수행을 안함
		    System.out.println("C Grade...");//true
	    else 
	    	System.out.println("Try again...");//true
	}
}
/*
 * 해당 코드의 문제점은?
 * 이 프로그램은 무조건 87인 경우에만 해당되는 코드로 작성되어야 한다.
 * (grade가 지정되어 있어서 점수가 나르면 계속해서 바꿔줘야함 --> 프로그램이 아님
 *  --> 프로그램이 안된다는 것은 코드에 실제값이 하드코딩 되어져 있으면 안된다.)
 *  
 *  프로그램이란?
 *  들어오는 입력값에 따라 결과값이 달라지는 것
 *  
 *  해결책
 *  실행할 때마다 실제 성적에 해당하는 겂을 받아서
 *  처리할 수 있도록 코드를 수정
 *  --> 실행할 때 값을 받아서 하려며는 Scanner 객체 사용가능해야함
 */