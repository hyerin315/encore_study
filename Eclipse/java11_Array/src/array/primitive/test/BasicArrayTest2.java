package array.primitive.test;
/*
 * 배열을 선언, 생성, 초기화 동시에...
 * 
 */

public class BasicArrayTest2 {
	public static void main(String[] args) {
		// 값이 6개라는 뜻은 사이즈가 6이란 것과 동일한 표현이다 
		int[ ] target = {1,2,3,4,5,6};//선언,생성,초기화 동시에 한 것 --> 배열은 생성시 사이즈 반드시 명시!!
		int[ ] source = {10,9,8,7,6,5,4,3,2,1};
		//target = {1,2,3,4,5,6,7,8,9,10}; 
		//--> 사이즈가 6칸 짜리 배열로 만들었는데 7,8,9,10을 넣기위해 사이즈를 늘려서 넣은 것
		//오류 --> 오직 처음에 잡힌 사이즈만 쓸 수 있다
		
		//배열은 한 번 지정한 사이즈를 수정할 수 없다...사이즈를 늘리고 싶다면 어떻게?
		//--> 10칸짜리 배열을 새로 생성, 이후에도 계속 사이즈를 늘리고 싶으면 새로 생성해야하므로 처음부터 넉넉하게 설정하는 것이 좋다
		//그런데 사이즈가 다른 배열의 요소를 copy해 올 수는 있다 --> System.arraycopy(카피할 것, 어디서부터 카피할 건지, 카피할 곳, 몇번째부터 시작할 것인지, 몇개를 할 것인지)

		//target 배열의 사이즈를 변경하지는 않을거지만 요소는 source의 내용을 카피해올것이다
		//System클래스의 arraycopy()를 사용해서 8,7,6,5,4,3으로 출력되도록 작성
		System.arraycopy(source, 2, target, 0, target.length);//마지막을 6으로 해도 되지만 저렇게...
		
		
		/*for(int i=0; i<target.length; i++)
			System.out.println(target[i]+" "); --> 이렇게 써도 되고 아래는 같은 표현 (알고리즘에서는 지금 for문이 나음 */
			
		//향상된 for문...(조금 더 효율성이 좋음)...forEach문 --> 알고리즘 말고 프로그램에서는 이 for문이 좋음
		//뭐가 어디에서 돌아가는가? 만 기억
		for(int i : target) System.out.print(i+" ");//target에 있는 하나하나의 값을 i에 집어 넣고 넣고 뽑고 진행됨
		//print는 옆으로 출력, println은 아래로 출력
		
	}

}
